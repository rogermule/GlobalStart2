package com.gcme.globalstart;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.gcme.globalstart.News_Feed.NewsFeedAdapter;

/**
 * Created by bengeos on 6/29/16.
 */

public class NewsFeed extends AppCompatActivity {
    private RecyclerView myRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.newsfeed_toolbar);
        toolbar.setTitle("News");

        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new NewsFeedAdapter(this,Global_Start.myDatabase.get_All_News());
        myRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
