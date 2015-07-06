package com.lf.minhalivraria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends Activity implements View.OnClickListener {

    private TextView txtBarcode;
    private Button btnReadBarcode;
    private Button btnGetInfo;
    private TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBarcode = (TextView) findViewById(R.id.txtBarcode);
        btnReadBarcode = (Button) findViewById(R.id.btnReadBarcode);
        btnGetInfo = (Button) findViewById(R.id.btnGetInfo);
        txtInfo = (TextView) findViewById(R.id.txtInfo);

        btnReadBarcode.setOnClickListener(this);
        btnGetInfo.setOnClickListener(this);

    }


    private void readBarcode() {
        IntentIntegrator integrator = new IntentIntegrator(this);
//        integrator.putExtra("SCAN_MODE", "ISBN");
        integrator.initiateScan();

//        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
//        intent.putExtra("SCAN_MODE", "ISBN");
//        startActivityForResult(intent, 0);
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
        }
    }
}
