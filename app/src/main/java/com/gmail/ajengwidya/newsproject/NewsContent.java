package com.gmail.ajengwidya.newsproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NewsContent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        Button button = (Button) findViewById(R.id.button);

//        //TODO: Menyiapkan event onClick pada button Detail
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(NewsContent.this, NewsDetail.class);
//                startActivity(intent);
//            }
//        });
    }
}
