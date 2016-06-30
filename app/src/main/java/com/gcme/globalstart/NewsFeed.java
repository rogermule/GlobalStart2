package com.gcme.globalstart;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import com.gcme.globalstart.Database.MyDatabase;
import com.gcme.globalstart.News_Feed.NewsFeed_Adapter;
import com.gcme.globalstart.News_Feed.NewsFeed_Object;

import java.util.ArrayList;

/**
 * Created by bengeos on 6/29/16.
 */

public class NewsFeed extends AppCompatActivity {
    private static RecyclerView myRecyclerView;
    private static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static MyDatabase myDatabase;
    private static Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfeed_page);
        myDatabase = new MyDatabase(this);
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);
        ArrayList<NewsFeed_Object> bb = new ArrayList<>();
        bb.add(new NewsFeed_Object());
        bb.add(new NewsFeed_Object());
        bb.add(new NewsFeed_Object());
        bb.add(new NewsFeed_Object());
        Toast.makeText(this,"There are: "+bb.size(),Toast.LENGTH_LONG).show();

        mAdapter = new NewsFeed_Adapter(this,bb);
        myRecyclerView.setAdapter(mAdapter);
        myContext = this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

    }
}
