package com.lf.minhalivraria.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * GET AS IMAGE
 */
// Uses AsyncTask to create a task away from the main UI thread. This task takes a
// URL string and uses it to create an HttpUrlConnection. Once the connection
// has been established, the AsyncTask downloads the contents of the webpage as
// an InputStream. Finally, the InputStream is converted into a string, which is
// displayed in the UI by the AsyncTask's onPostExecute method.

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    private NetworkImageCallback callback;

    public DownloadImageTask(NetworkImageCallback callback) {
        this.callback = callback;
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

        callback.process(result);

    }

}
