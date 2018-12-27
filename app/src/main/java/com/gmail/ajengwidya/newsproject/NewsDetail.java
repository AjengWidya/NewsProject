package com.gmail.ajengwidya.newsproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsDetail extends AppCompatActivity {
    TextView det_title, det_date, det_body;
    ImageView det_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        det_img = (ImageView) findViewById(R.id.det_img);
        det_title = (TextView) findViewById(R.id.det_title);
        det_date = (TextView) findViewById(R.id.det_date);
        det_body = (TextView) findViewById(R.id.det_body);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String open_id = bundle.getString("id");
        String open_title = bundle.getString("title");
        String open_date = bundle.getString("date");

        if(open_id.equals("5")) {
            det_img.setImageResource(R.drawable.media1);
            det_body.setText("STMIK Akakom Yogyakarta mengadakan kuliah umum dengan tema “Big Data " +
                    "dan Smart City” sebagai rangkaian kegiatan International Seminar on Research of" +
                    " Information Technology and Intelligent System (ISRITI). Kuliah umum yang " +
                    "diselenggarakan pada Kamis (22/11/2018), membahas tentang “Computational " +
                    "Thinking and Data Science” yang dibawakan oleh Prof. Chuan-Ming Liu, Ph.D dari " +
                    "Department of Computer Science and Information Engineering – National Taipei " +
                    "University of Technology. Kegiatan yang berlangsung pukul 09.00 – 12.00 WIB ini " +
                    "diadakan di Ruang Presentasi STMIK Akakom Yogyakarta.");
        } else if(open_id.equals("4")) {
            det_img.setImageResource(R.drawable.media2);
            det_body.setText("Facebook Developer Circle berkolaborasi dengan JogjaJS mengadakan " +
                    "acara dengan tema “Skill Up to Modern Web Development” di STMIK Akakom " +
                    "Yogyakarta pada Sabtu (24/11/2018). Acara yang diselenggarakan secara gratis " +
                    "ini diikuti oleh lebih dari 50 peserta yang berasal dari berbagai kalangan. " +
                    "Rangkaian kegiatan dalam acara ini yaitu talk show dan workshop yang dibawakan " +
                    "oleh pemateri dan fasilitator yang andal di bidang pengembangan web.");
        } else {
            det_img.setImageResource(R.drawable.media3);
            det_body.setText("Tahun ini, STMIK AKAKOM Yogyakarta telah menyelenggarakan Seminar " +
                    "2018 International Seminar on Research of Information Technology and " +
                    "Intelligent Systems (ISRITI). Seminar ini berlangsung dari 21-22 November 2018 " +
                    "di Grand Zuri Malioboro Hotel, Yogyakarta, Indonesia. Tujuan dari seminar ini " +
                    "adalah untuk menyediakan platform bagi para akademisi, praktisi, peneliti, dan " +
                    "pemerintah untuk mengidentifikasi dan mengeksplorasi isu, peluang, dan solusi " +
                    "yang mempromosikan teknologi informasi dan konvergensi sistem cerdas, perkembangan " +
                    "dan menemukan bisnis baru, teknologi, dan nilai kemasyarakatan dari teknologi " +
                    "informasi dan sistem cerdas.");
        }

        det_title.setText(open_title);
        det_date.setText(open_date);


    }
}
