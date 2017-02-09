package com.gcme.globalstart.News_Feed;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gcme.globalstart.Global_Start;
import com.gcme.globalstart.R;


/**
 * Created by BENGEOS on 4/16/16.
 */
public class NewsFeedDetail extends AppCompatActivity {
    private String news_id;
    private NewsFeed newsFeed;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView NewsImage;
    private TextView Title,Content,PubDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.news_feed_detail_toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String image_path = getIntent().getExtras().getString("news_image_path");
        String news_content = getIntent().getExtras().getString("news_content");
        String pub_date = getIntent().getExtras().getString("news_pub_date");
        String news_title = getIntent().getExtras().getString("news_title");

        NewsImage = (ImageView) findViewById(R.id.news_feed_detail_image);
        Title = (TextView) findViewById(R.id.news_feed_detail_title);
        Content = (TextView) findViewById(R.id.news_feed_detail_content);
        PubDate = (TextView) findViewById(R.id.news_feed_detail_date);

        //collapsing toolbar
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.news_feed_detail_collapsing_toolbar);
        news_id = getIntent().getExtras().getString("news_id");
        newsFeed = Global_Start.myDatabase.get_NewsFeed_by_NewsID(news_id);
        collapsingToolbarLayout.setTitle(news_title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        //Toast.makeText(this, "Image Path:\n" + news_id, Toast.LENGTH_LONG).show();

        Glide.with(this).load(image_path).into(NewsImage);
//        if(newsFeed != null){
//            Title.setText(""+newsFeed.getTitle());
//            Content.setText(""+newsFeed.getContent());
//            PubDate.setText(""+newsFeed.getCreated());
//        }

        Title.setText(news_title);
        Content.setText(news_content);
        PubDate.setText(pub_date);

    }
}
