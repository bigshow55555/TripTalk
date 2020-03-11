package com.example.newsapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity
{

        private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;
        private String[] myDataset = {"1","2"};
        RequestQueue queue ;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_news);
            recyclerView = findViewById(R.id.my_recycler_view);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            recyclerView.setHasFixedSize(true);

            // use a linear layout manager
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);



            queue = Volley.newRequestQueue(this);
            getNews();

        }

        public void getNews()
        {

            String url ="http://newsapi.org/v2/top-headlines?country=kr&apiKey=7a87fe7481f74495b2256de6371b83cd";

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            //Log.d("NEWS",response);

                            try {
                                JSONObject jsonObj = new JSONObject(response);

                                JSONArray arrayArticles = jsonObj.getJSONArray("articles");

                                List<NewsData> news = new ArrayList<>();

                                for(int i=0, j = arrayArticles.length(); i<j;  i++)
                                {
                                    JSONObject obj = arrayArticles.getJSONObject(i);

                                    Log.d("NEWS",obj.toString());

                                    NewsData newsData = new NewsData();
                                    newsData.setTitle(obj.getString("title"));
                                    newsData.setUrltoImage(obj.getString("urlToImage"));
                                    newsData.setContent(obj.getString("content"));
                                    news.add(newsData);

                                }

                                // specify an adapter (see also next example)
                                mAdapter = new MyAdapter(news, NewsActivity.this);
                                recyclerView.setAdapter(mAdapter);


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                            //response ->> newsData Class에서 분류

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });

            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }

}
