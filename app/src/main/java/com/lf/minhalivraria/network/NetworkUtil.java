package com.lf.minhalivraria.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.lf.minhalivraria.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by luizfernando on 8/8/15.
 */
public class NetworkUtil {

    //Return a connection already connected
    public static HttpURLConnection getConnection(String _url) throws IOException {

        URL url = new URL(_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(10000 /* milliseconds */);
        conn.setConnectTimeout(15000 /* milliseconds */);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        // Starts the query
        conn.connect();

        return conn;
    }

    // Given a URL, establishes an HttpUrlConnection and retrieves
    // the web page content as a InputStream, which it returns as
    // a string.
    public static String downloadUrl(String myurl) throws IOException {

        InputStream is = null;

        String contentAsString = "";

        try {

            HttpURLConnection conn = NetworkUtil.getConnection(myurl);

            int response = conn.getResponseCode();
            Log.d(MainActivity.DEBUG_TAG, "The response is: " + response);
            is = conn.getInputStream();

            // Convert the InputStream into a string
            contentAsString = NetworkUtil.readIt(is);

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
    public static String readIt(InputStream stream) throws IOException {

        Reader reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[500];

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

    public static boolean isConnected(Context context) {

        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        return (networkInfo != null && networkInfo.isConnected());

    }

}
