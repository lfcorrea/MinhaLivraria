package com.lf.minhalivraria;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lf.minhalivraria.model.buscape.Result;
import com.lf.minhalivraria.network.DownloadImageTask;
import com.lf.minhalivraria.network.NetworkImageCallback;
import com.lf.minhalivraria.network.NetworkJSONCallback;
import com.lf.minhalivraria.network.NetworkJSONTask;
import com.lf.minhalivraria.network.NetworkUtil;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity implements View.OnClickListener {

    private TextView txtBarcode;
    private Button btnReadBarcode;
    private Button btnGetInfo;
    private Button btnGetImage;
    private TextView txtInfo;
    private ImageView bookImageView;

    public static final String DEBUG_TAG = "MinhaLivraria";

    private static final String URL_BASE = "http://lfrbcorrea.esy.es/minhaLivraria.php?action=";
    private static final String URL_BUSCAPE = URL_BASE + "buscape&isbn=%s";

    private Result result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBarcode = (TextView) findViewById(R.id.txtBarcode);
        btnReadBarcode = (Button) findViewById(R.id.btnReadBarcode);
        btnGetInfo = (Button) findViewById(R.id.btnGetInfo);
        btnGetImage = (Button) findViewById(R.id.btnGetImage);
        txtInfo = (TextView) findViewById(R.id.txtInfo);
        bookImageView = (ImageView) findViewById(R.id.bookImageView);

        btnReadBarcode.setOnClickListener(this);
        btnGetInfo.setOnClickListener(this);
        btnGetImage.setOnClickListener(this);

    }

    private void showMessage(String message) {
        txtInfo.append("\n\n" + message);
    }

    private void getImage() {

        String message = "";

        if (result != null) {

            String imageUrl = result.getThumbnailUrl();

            if (!imageUrl.equals("")) {

                imageUrl = imageUrl.replace("\\/", "/");
                NetworkImageCallback callback = new NetworkImageCallback() {
                    @Override
                    public void process(Bitmap bitmapImage) {
                        bookImageView.setImageBitmap(bitmapImage);
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
        String stringUrl = String.format(URL_BUSCAPE, barCode);
        Log.d(DEBUG_TAG, "URL:" + stringUrl);


        NetworkJSONCallback callback = new NetworkJSONCallback() {
            @Override
            public void process(JSONObject jsonObject) {
                try {

                    result = new Result(jsonObject);
                    txtInfo.append(result.toString());

                } catch (JSONException e) {

                    e.printStackTrace();
                    txtInfo.append("Error while parsing result.");
                    txtInfo.append(e.getMessage());

                }

            }
        };

        if (NetworkUtil.isConnected(getApplicationContext())) {

            new NetworkJSONTask(callback).execute(stringUrl);

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

            case R.id.btnGetImage:
                getImage();
                break;

        }

    }

}