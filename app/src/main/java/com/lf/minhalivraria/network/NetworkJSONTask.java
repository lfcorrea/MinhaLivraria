package com.lf.minhalivraria.network;

/**
 * Created by luizfernando on 8/8/15.
 */

import android.os.AsyncTask;
import android.util.Log;

import com.lf.minhalivraria.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * GET AS JSON OBJECT
 */
public final class NetworkJSONTask extends AsyncTask<String, Object, JSONObject> {

    private NetworkJSONCallback callback;

    public NetworkJSONTask(NetworkJSONCallback callback) {

        this.callback = callback;

    }

    @Override
    protected JSONObject doInBackground(String... args) {

        // params comes from the execute() call: params[0] is the url.
        JSONObject result = null;

        try {

            String data = NetworkUtil.downloadUrl(args[0]);

            data = data.replace("\\n", "")
                    .replace("\\r", "")
                    .replace("\\\"", "\"")
                    .replace("\\/", "/")
                    .replace("\"{", "{")
                    .replace("}\"", "}");

            result = new JSONObject(data);

        } catch (JSONException je) {

            je.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return result;

    }

    @Override
    protected void onPostExecute(JSONObject result) {

        callback.process(result);

    }



}
