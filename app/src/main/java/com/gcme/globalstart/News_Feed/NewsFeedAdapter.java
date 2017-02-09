package com.gcme.globalstart.News_Feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcme.globalstart.R;
import com.gcme.globalstart.Sync.FileManager;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


/**
 * Created by BENGEOS-PC on 4/15/2016.
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.DataObjectHolder>  {

    private static String LOG_TAG = "NewsFeedAdapter";
    private ArrayList<NewsFeed> NewsFeeds;
    private static MyClickListener myClickListener;
    private static Context myContext;
    private FileManager myFileManager;

    public NewsFeedAdapter(Context context, ArrayList<NewsFeed> newsFeeds) {
        myContext = context;
        NewsFeeds = newsFeeds;
        myFileManager = new FileManager(myContext);
    }

    public static class DataObjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView Title,Content,pub_date;
        ImageView NewsImage;
        String news_id,image_path,news_content,news_pub_date,news_title;

        public DataObjectHolder(View itemView) {
            super(itemView);
            Title = (TextView) itemView.findViewById(R.id.news_feed_title);
            Content = (TextView) itemView.findViewById(R.id.news_feed_content);
            pub_date = (TextView) itemView.findViewById(R.id.news_pubdate);
            NewsImage = (ImageView) itemView.findViewById(R.id.news_feed_image);
            news_id = "0";
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(myContext,NewsFeedDetail.class);
            Bundle b = new Bundle();
            b.putString("news_id",news_id);
            b.putString("news_image_path",image_path);
            b.putString("news_content",news_content);
            b.putString("news_pub_date",news_pub_date);
            b.putString("news_title",news_title);
            intent.putExtras(b);
            myContext.startActivity(intent);
        }

        @Override
        public boolean onLongClick(View v) {
          return true;
        }
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_feed_item, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        holder.Title.setText((NewsFeeds.get(position).getTitle()));
        holder.Content.setText(NewsFeeds.get(position).getContent());
        holder.pub_date.setText(NewsFeeds.get(position).getCreated());
        //File imageFile = myFileManager.getFileAt("images", NewsFeeds.get(position).getImagePath());
        File imageFile = myFileManager.getFileAt("images", "News"+NewsFeeds.get(position).getNews_ID()+".png");
        Log.i("Global Start:->", imageFile.getAbsolutePath());
        //Toast.makeText(myContext,"Image Path: "+String.valueOf(imageFile.isFile()),Toast.LENGTH_LONG).show();

        FileInputStream stream = null;
        try{
            stream = new FileInputStream(imageFile);
        }catch (Exception e){
        }
        //holder.NewsImage.setImageBitmap(BitmapFactory.decodeStream(stream));
        Glide.with(myContext).load(imageFile.getAbsolutePath()).into(holder.NewsImage);
        holder.image_path = imageFile.getAbsolutePath();
        holder.news_content = NewsFeeds.get(position).getContent();
        holder.news_pub_date = NewsFeeds.get(position).getCreated();
        holder.news_id = NewsFeeds.get(position).getId();
        holder.news_title = NewsFeeds.get(position).getTitle();

    }

    @Override
    public int getItemCount() {
        return NewsFeeds.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
