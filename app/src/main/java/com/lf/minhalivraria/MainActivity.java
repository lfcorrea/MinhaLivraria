package com.lf.minhalivraria;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lf.minhalivraria.model.Book;
import com.lf.minhalivraria.model.ImageLinks;
import com.lf.minhalivraria.model.Item;
import com.lf.minhalivraria.model.VolumeInfo;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity implements View.OnClickListener {

    private TextView txtBarcode;
    private Button btnReadBarcode;
    private Button btnGetInfo;
    private Button btnGetPrices;
    private Button btnGetImage;
    private TextView txtInfo;
    private ImageView bookImageView;

    private static final String DEBUG_TAG = "MinhaLivraria";

    private static final String URL_BASE = "http://lfrbcorrea.esy.es/minhaLivraria.php?action=";
    private static final String URL_GET_INFO = URL_BASE + "bookInfo&isbn=%s";
    private static final String URL_PRICES = URL_BASE + "prices&isbn=%s";

    private Book book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBarcode = (TextView) findViewById(R.id.txtBarcode);
        btnReadBarcode = (Button) findViewById(R.id.btnReadBarcode);
        btnGetInfo = (Button) findViewById(R.id.btnGetInfo);
        btnGetPrices = (Button) findViewById(R.id.btnGetPrices);
        btnGetImage = (Button) findViewById(R.id.btnGetImage);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        bookImageView = (ImageView) findViewById(R.id.bookImageView);

        btnReadBarcode.setOnClickListener(this);
        btnGetInfo.setOnClickListener(this);
        btnGetPrices.setOnClickListener(this);
        btnGetImage.setOnClickListener(this);

    }

    private void setBook(Book book) {
        this.book = book;

    }

    private void showMessage(String message) {
        txtInfo.append("\n\n" + message);
    }

    private void getImage() {

        String message = "";
        if (book != null) {
            if (book.hasItems()) {
                Item item = book.getItems()[0];
                VolumeInfo volumeInfo = item.getVolumeInfo();
                if (volumeInfo != null) {

                    ImageLinks imageLinks = volumeInfo.getImageLinks();
                    if (imageLinks != null) {
                        String imageUrl = null;
                        if (imageLinks.getSmallThumbnail() != null) {
                            imageUrl = imageLinks.getSmallThumbnail();
                        } else if (imageLinks.getThumbnail() != null) {
                            imageUrl = imageLinks.getThumbnail();
                        }
                        if (imageUrl != null) {
                            imageUrl = imageUrl.replace("\\/", "/");
                            new DownloadImageTask(bookImageView).execute(imageUrl);
                            message = "URL:" + imageUrl;
                        } else {
                            message = "There is no image for the selected book.";
                        }
                    }
                } else {
                    message = "There is no information for the selected book";
                }

            } else {
                message = "There is no Item on book";
            }
        } else {
            message = "Book is Null";
        }
        showMessage(message);

    }


    private void readBarcode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            // handle scan result
            txtBarcode.setText(scanResult.getContents());
            txtInfo.setText(scanResult.toString());
        }

    }

    private void getBookInfo() {
// Gets the URL from the UI's text field.
        String barCode = txtBarcode.getText().toString();
        String stringUrl = String.format(URL_GET_INFO, barCode);
        Log.d(DEBUG_TAG, "URL:" + stringUrl);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected()) {
//            new DownloadWebpageTask().execute(stringUrl);
//        } else {
//            txtInfo.append("\n\nNo network connection available.");
//        }

        if (networkInfo != null && networkInfo.isConnected()) {
            new NetworkJSONTask().execute(stringUrl);
        } else {
            txtInfo.append("\n\nNo network connection available.");
        }

    }

    private void getBookPrices() {
// Gets the URL from the UI's text field.
        String barCode = txtBarcode.getText().toString();
        String stringUrl = String.format(URL_PRICES, barCode);
        Log.d(DEBUG_TAG, "URL:" + stringUrl);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new NetworkJSONTask().execute(stringUrl);
        } else {
            txtInfo.append("\n\nNo network connection available.");
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnReadBarcode:
                readBarcode();
                break;
            case R.id.btnGetInfo:
                getBookInfo();
                break;
            case R.id.btnGetPrices:
                getBookPrices();
                break;
            case R.id.btnGetImage:
                getImage();
                break;
        }
    }

    /**
     * GET AS STRING
     */
    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            txtInfo.append("\n\n" + result);
        }

        // Given a URL, establishes an HttpUrlConnection and retrieves
        // the web page content as a InputStream, which it returns as
        // a string.
        private String downloadUrl(String myurl) throws IOException {
            InputStream is = null;
            // Only display the first 500 characters of the retrieved
            // web page content.
            int len = 500;

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(DEBUG_TAG, "The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                String contentAsString = readIt(is, len);
                return contentAsString;

                // Makes sure that the InputStream is closed after the app is
                // finished using it.
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }

        // Reads an InputStream and converts it to a String.
        public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[len];
            reader.read(buffer);
            return new String(buffer);
        }
    }

    /**
     * GET AS IMAGE
     */
    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    /**
     * GET AS JSON OBJECT
     */
    private final class NetworkJSONTask extends AsyncTask<String, Object, JSONObject> {

        @Override
        protected JSONObject doInBackground(String... args) {
            // params comes from the execute() call: params[0] is the url.
            JSONObject result = null;
            try {
                String data = downloadUrl(args[0]);
                data = data.replace("\\n", "")
                        .replace("\\r", "")
                        .replace("\\\"", "\"")
                        .replace("\\/", "/")
                        .replace("\"{", "{")
                        .replace("}\"", "}");
                result = new JSONObject(data);
//                return result;
            } catch (JSONException je) {
                je.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(JSONObject result) {

            if (result == null) {
                txtInfo.append("\n\nResult is NULL");
            } else {
                txtInfo.append("\n\n" + result.toString());
                try {
                    Book book = new Book();
                    book.loadFromJSON(result);
                    setBook(book);
                    txtInfo.append("\n\n" + book.toString());
                } catch (JSONException je) {
                    txtInfo.append("\n\n ERROR while converting object:\n" + je.getMessage());
                }

            }

        }

        // Given a URL, establishes an HttpUrlConnection and retrieves
        // the web page content as a InputStream, which it returns as
        // a string.
        private String downloadUrl(String myurl) throws IOException {
            InputStream is = null;
            // Only display the first 500 characters of the retrieved
            // web page content.
            int len = 500;

            String contentAsString = "";

            try {
                URL url = new URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d(DEBUG_TAG, "The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                contentAsString = readIt(is, len);

                // Makes sure that the InputStream is closed after the app is
                // finished using it.
            } finally {
                if (is != null) {
                    is.close();
                }
            }

            return contentAsString;
        }

        // Reads an InputStream and converts it to a String.
        public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[len];

            StringBuilder stringBuilder = new StringBuilder();
            for (; ; ) {
                int data = reader.read(buffer, 0, buffer.length);
                if (data < 0) {
                    break;
                }
                stringBuilder.append(buffer, 0, data);
            }
            return stringBuilder.toString();
        }


    }
}
