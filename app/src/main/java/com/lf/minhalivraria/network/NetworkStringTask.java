package com.lf.minhalivraria.network;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by luizfernando on 8/8/15.
 */
public class NetworkStringTask {

    private NetworkStringCallback callback;

    public NetworkStringTask(NetworkStringCallback callback) {

        this.callback = callback;

    }

    protected String doInBackground(String... args) {

        // params comes from the execute() call: params[0] is the url.
        String result = "";

        try {

            result = NetworkUtil.downloadUrl(args[0]);

        } catch (IOException e) {

            e.printStackTrace();

        }

        return result;

    }

    protected void onPostExecute(String result) {

        callback.process(result);

    }

}
