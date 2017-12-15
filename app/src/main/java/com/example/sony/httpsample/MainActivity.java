package com.example.sony.httpsample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.toString();

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);

        if(NetworkManager.getInstance().isConnectedToInternet()) {
            try {
                String s = new GetRepo().execute().get();
                Log.d(TAG, s.toString() + "aaaaaaaa");
                tv.setText(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
                Log.d(TAG, e.toString());
            }
        }
    }

    class GetRepo extends AsyncTask<String, String, String> {
        HttpURLConnection conn;


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
            StringBuilder result1 = new StringBuilder();
            String r = null;

            try {
                URL url = new URL("https://api.github.com/users/nguyentrungduc/repos");
                conn = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(conn.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    result.append("\n");
                }

                JSONArray jsonArray = new JSONArray(result.toString());
                Log.d(TAG, "aaa" + jsonArray.toString());
                for(int  i = 0 ; i < jsonArray.length(); i ++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    Log.d(TAG, jsonObject.opt("name").toString());
                    result1.append(jsonObject.opt("name").toString());
                    result1.append("\n");
                }



            }catch( Exception e) {
                e.printStackTrace();
            }
            finally {
                conn.disconnect();
            }


            return result1.toString();
        }
    }

}
