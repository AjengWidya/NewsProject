package com.gmail.ajengwidya.newsproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncLogin().execute();
    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, NewsDetail.class);
        startActivity(intent);
    }

    private class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                url = new URL("http://belajar-unggah.000webhostapp.com/test/berita.json");
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return e.toString();
            }

            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            }

            try {
                int response_code = conn.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    return (result.toString());
                } else {
                    return ("Unsuccesful!");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();
            List<ListData> data = new ArrayList<>();

            pdLoading.dismiss();

            try {
                JSONArray jsonArray = new JSONArray(result);

                //TODO: Mengambil data JSON dari setiap indeks
                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    ListData newsData = new ListData();
                    newsData.nid = jsonObject.getString("id");
                    newsData.ntitle = jsonObject.getString("judul_berita");
                    newsData.ndate = jsonObject.getString("tanggal_posting");
                    newsData.nbody = jsonObject.getString("isi_berita");
                    newsData.nphoto = jsonObject.getString("foto");
                    data.add(newsData);
                }
                //TODO: Mempersiapkan format tampilan di MainActivity
                recyclerView = (RecyclerView) findViewById(R.id.news_list);
                adapter = new NewsAdapter(MainActivity.this, data);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
