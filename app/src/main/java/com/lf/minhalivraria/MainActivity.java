package com.lf.minhalivraria;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lf.minhalivraria.model.buscape.Result;
import com.lf.minhalivraria.network.DownloadImageTask;
import com.lf.minhalivraria.network.NetworkImageCallback;
import com.lf.minhalivraria.network.NetworkStringCallback;
import com.lf.minhalivraria.network.NetworkStringTask;
import com.lf.minhalivraria.network.NetworkUtil;

import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Bind(R.id.txtBarcode)
    TextView txtBarcode;

    @Bind(R.id.btnReadBarcode)
    Button btnReadBarcode;

    @Bind(R.id.btnGetInfo)
    Button btnGetInfo;

    @Bind(R.id.btnGetImage)
    Button btnGetImage;

    @Bind(R.id.btnshowDetails)
    Button btnDetails;

    @Bind(R.id.txtInfo)
    TextView txtInfo;

    @Bind(R.id.bookImageView)
    ImageView bookImageView;

    public ProgressDialog dialog ;

    public static final String DEBUG_TAG = "MinhaLivraria";

    private static final String URL_BASE = "http://lfrbcorrea.esy.es/minhaLivraria.php?action=";
    private static final String URL_BUSCAPE = URL_BASE + "buscape&isbn=%s";

    private Result result;
    private Bitmap image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dialog = new ProgressDialog(MainActivity.this);

    }

    private void showMessage(String message) {
        txtInfo.append("\n\n" + message);
        showLongToast(message);
    }

    @OnClick(R.id.btnGetImage)
    public void getImage() {

        String message = "";

        if (result != null) {

//            String imageUrl = "";//result.getThumbnailUrl();
            String imageUrl = result.getThumbnailUrl();

            if (!imageUrl.equals("")) {

                imageUrl = imageUrl.replace("\\/", "/");
                startLoading();
                NetworkImageCallback callback = new NetworkImageCallback() {
                    @Override
                    public void process(Bitmap bitmapImage) {
                        image = bitmapImage;
                        bookImageView.setImageBitmap(image);
                        endLoading();
                    }
                };

                new DownloadImageTask(callback).execute(imageUrl);

                message = "URL:" + imageUrl;

            } else {

                message = "There is no thumbnail image url available";

            }

        } else {

            message = "There is no result";

        }

        showMessage(message);

    }

    @OnClick(R.id.btnshowDetails)
    public void showDetails() {
        Intent intent = new Intent(this, DetailsActivity.class);

        intent.putExtra("result", result);
        intent.putExtra("image", image);

        startActivity(intent);
    }


    @OnClick(R.id.btnReadBarcode)
    public void readBarcode() {
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

    @OnClick(R.id.btnGetInfo)
    public void getBookInfo() {

        // Gets the URL from the UI's text field.
        String barCode = txtBarcode.getText().toString();
        String stringUrl = String.format(URL_BUSCAPE, barCode);
        Log.d(DEBUG_TAG, "URL:" + stringUrl);


//        NetworkJSONCallback callback = new NetworkJSONCallback() {
        NetworkStringCallback callback = new NetworkStringCallback() {
            @Override
//            public void process(JSONObject jsonObject) {
            public void process(String data) {
                try {

                    data = data.replace("\\n", "")
                            .replace("\\r", "")
                            .replace("\\\"", "\"")
                            .replace("\\/", "/")
                            .replace("\"{", "{")
                            .replace("}\"", "}");

                    JSONObject jsonObject = new JSONObject(data);
                    data = jsonObject.toString(2);

//                    data = data.replace("\"{", "{")
//                            .replace("}\"", "}");

                    //result = new Result(jsonObject);
                    Gson gson = new Gson();
                    result = gson.fromJson(data, Result.class);
                    txtInfo.append(result.toString());

                    getImage();

                } catch (Exception e) {

                    e.printStackTrace();
                    txtInfo.append("Error while parsing result.");
                    txtInfo.append(e.getMessage());

                }
                endLoading();

            }
        };

        if (NetworkUtil.isConnected(getApplicationContext())) {
            startLoading();
//            new NetworkJSONTask(callback).execute(stringUrl);
            new NetworkStringTask(callback).execute(stringUrl);

        } else {

            txtInfo.append("\n\nNo network connection available.");

        }

    }

    public void showLongToast(String text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void startLoading() {
        this.dialog.setMessage("Please wait");
        this.dialog.show();
    }

    public void endLoading() {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}