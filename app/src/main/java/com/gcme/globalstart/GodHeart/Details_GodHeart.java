package com.gcme.globalstart.GodHeart;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.gcme.globalstart.R;

public class Details_GodHeart extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView image;
    TextView tv_title, tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.pic2);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        String title = "Global start has been Launched";
        String content = "The highly anticipated mobile based system has been officially released. The app is believed to change the " +
                "way teenager evangelism is accomplished and helps to equip the youth, church and every one to do a strong teenager " +
                "evangelism. \n \n The highly anticipated mobile based system has been officially released. The app is believed to change the way " +
                "teenager evangelism is accomplished and helps to equip the youth, church and every one to do a strong teenager evangelism." +
                "The highly anticipated mobile based system has been officially released. The app is believed to change the way teenager evangelism " +
                "is accomplished and helps to equip the youth, church and every one to do a strong teenager evangelism." +
                "\n" +
                " \n" +
                " The highly anticipated mobile based system has been officially released. The app is believed to change the way" +
                "teenager evangelism is accomplished and helps to equip the youth, church and every one to do a strong teenager evangelism." +
                "The highly anticipated mobile based system has been officially released. The app is believed to change the way teenager evangelism" +
                "is accomplished and helps to equip the youth, church and every one to do a strong teenager evangelism.";

//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        tv_title.setText(title);
        tv_content.setText(content);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }


}
