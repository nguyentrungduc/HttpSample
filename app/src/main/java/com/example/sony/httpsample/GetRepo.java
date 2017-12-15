package com.example.sony.httpsample;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sony on 12/15/2017.
 */

public class GetRepo extends AsyncTask<String, String, String> {
    HttpURLConnection conn;

    public static final String TAG = GetRepo.class.toString();
    public GetRepo() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected String doInBackground(String... strings) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL("https://api.github.com/users/nguyentrungduc/repos");
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(conn.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }


        }catch( Exception e) {
            e.printStackTrace();
        }
        finally {
            conn.disconnect();
        }


        return result.toString();
    }
}
