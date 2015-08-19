package com.lf.minhalivraria;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.lf.minhalivraria.model.buscape_old.Result;
import com.lf.minhalivraria.network.DownloadImageTask;
import com.lf.minhalivraria.network.NetworkImageCallback;
import com.lf.minhalivraria.network.NetworkJSONCallback;
import com.lf.minhalivraria.network.NetworkJSONTask;
import com.lf.minhalivraria.network.NetworkUtil;

import org.json.JSONException;
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

    @Bind(R.id.txtInfo)
    TextView txtInfo;

    @Bind(R.id.bookImageView)
    ImageView bookImageView;

    public static final String DEBUG_TAG = "MinhaLivraria";

    private static final String URL_BASE = "http://lfrbcorrea.esy.es/minhaLivraria.php?action=";
    private static final String URL_BUSCAPE = URL_BASE + "buscape&isbn=%s";

    private Result result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    private void showMessage(String message) {
        txtInfo.append("\n\n" + message);
    }

    @OnClick(R.id.btnGetImage)
    public void getImage() {

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

}