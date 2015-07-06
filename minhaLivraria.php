<?php
    error_reporting(E_ERROR);

    abstract class Actions {
        const GET_BOOK_INFO = "bookInfo";
        const GET_THUMBNAIL = "thumbnail";
        const GET_SMALL_THUMBNAIL = "smallThumbnail";
        const GET_PRICES = "prices";
    }

    abstract class GoogleBooksURIs {
        const GET_BOOK_INFO = "https://www.googleapis.com/books/v1/volumes?q=isbn:%s";
    }

    abstract class StoresURIs {
        const GOOGLE_SHOPPING = "https://www.google.com.br/search?output=search&tbm=shop&q=%s&oq=%s";
    }

    class BooksController {
        /**
         * Parameters:
         *  - ISBN
         *  - Action:
         *      + BOOK_INFO: Get Book Info
         *      + GET_IMAGE: Get Image
         *          + THUMBAIL: Get Small Thumbnail
         *          + SMAL_THUMBAIL: Get Small Thumbnail
         *      + PRICES: Get Prices
         * books/minhaLivraria.php?action=bookInfo&isbn=9781452140483
         * books/minhaLivraria.php?action=prices&isbn=9781452140483
         * http://buscando.extra.com.br/search?w=9788571642775
         */
        public function processRequest() {

            $result = "";

            $action = $_REQUEST["action"];

            switch ($action) {
                case Actions::GET_BOOK_INFO:
                    //call get book info function
                    $result = $this->getBookInfo();
                    break;
                case Actions::GET_THUMBNAIL:
                    //call get thumbnail function
                case Actions::GET_SMALL_THUMBNAIL:
                    //call get small thumbnail function
                    $result = $this->getImage();
                    break;
                case Actions::GET_PRICES:
                    //call get prices function
                    $result = $this->getPrices();
                    break;
                default:
                    $result = "INVALID ACTION";
            }

            return json_encode($result);
        }

        private function getBookInfo() {

            $isbn = $_REQUEST["isbn"];
            $uri = sprintf(GoogleBooksURIs::GET_BOOK_INFO, $isbn);

            $result = $this->getURIContents($uri);

            return $result;

        }

        private function getImage() {

            $uri = $_REQUEST["imageURI"];
            $result = $this->getURIContents($uri);

            return $result;

        }

        private function getPrices() {
            $isbn = $_REQUEST["isbn"];

            $prices = $this->getGoogleShoppingPrices($isbn);

            return $prices;

        }

        private function getGoogleShoppingPrices($isbn){
            $results = array();

            $uri = sprintf(StoresURIs::GOOGLE_SHOPPING,$isbn, $isbn);

            $html = $this->getURIContents($uri);

            $xPathStore = "//li[@class='g']"; // Store Item

            $xPathPriceInfo = ".//div[@class='_OA']/div/b";
            $xPathStoreName = ".//div[@class='_OA']/div[2]";

            $xPathUrl = ".//div[@class='_AT']/h3/a";


            /*** a new dom object ***/
            $dom = new domDocument;

            /*** load the html into the object ***/
            $dom->loadHTML($html);

            /*** discard white space ***/
            $dom->preserveWhiteSpace = FALSE;

            /*** the table by its tag name ***/
            $body = $dom->getElementsByTagName('body')->item(0);

            $xp = new DOMXpath($dom);

            foreach ($xp->query($xPathStore, $body) as $foundStore) {
                $priceElement = $xp->query($xPathPriceInfo, $foundStore)->item(0);
                $storeNameElement = $xp->query($xPathStoreName, $foundStore)->item(0);
                $urlElement = $xp->query($xPathUrl, $foundStore)->item(0);

                $price = $priceElement->nodeValue;
                $storeName = $storeNameElement->nodeValue;
                $storeUrl = $urlElement->getAttribute("href");
                $storeUrl = substr($storeUrl,strrpos($storeUrl,"http"));

                $item = array("store" => $storeName, "uri" => $storeUrl, "price" => $price);
                array_push($results, $item);

            }


            return $results;
        }

        private function getURIContents($URI) {

            $result = file_get_contents($URI);

            return $result;

        }

    }

    $booksController = new BooksController();

    $result = $booksController->processRequest();

    echo $result;