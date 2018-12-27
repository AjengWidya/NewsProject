package com.gmail.ajengwidya.newsproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<ListData> data = Collections.emptyList();

    public NewsAdapter(Context context, List<ListData> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.news_content, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Holder myholder = (Holder) holder;
        final ListData current = data.get(position);
        final String textId = current.nid;
        myholder.textTitle.setText(current.ntitle);
        myholder.textDate.setText("Date: "+ current.ndate);
        myholder.textBody.setText(current.nbody);

        Glide.with(context).load("http://belajar-unggah.000webhostapp.com/test/images/" + current.nphoto)
                .placeholder(R.drawable.ic_android_black)
                .error(R.drawable.ic_android_black)
                .into(myholder.imgNews);

        myholder.butDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsDetail.class);
                Bundle bundle = new Bundle();
                bundle.putString("id", textId);
                bundle.putString("title", myholder.textTitle.getText().toString());
                bundle.putString("date", myholder.textDate.getText().toString());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return data.size(); }

    public class Holder extends RecyclerView.ViewHolder {
        //TextView textId;
        TextView textTitle;
        ImageView imgNews;
        TextView textDate;
        TextView textBody;
        Button butDet;

        public Holder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.news_title);
            imgNews = (ImageView) itemView.findViewById(R.id.news_img);
            textDate = (TextView) itemView.findViewById(R.id.news_date);
            textBody = (TextView) itemView.findViewById(R.id.news_body);
            butDet = (Button) itemView.findViewById(R.id.button);
        }

    }
}
