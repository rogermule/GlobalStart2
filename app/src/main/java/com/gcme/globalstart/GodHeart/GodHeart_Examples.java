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

public class GodHeart_Examples extends AppCompatActivity {
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView image,detail_image;
    TextView tv_title, tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);
        image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.pic2);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detail_image = (ImageView) findViewById(R.id.detail_image);
        tv_title = (TextView) findViewById(R.id.txt_news_detail_title);
        tv_content = (TextView) findViewById(R.id.txt_news_detail_content);

        String title = "Biblical Examples ";
        String content = "As a youth, God called Josiah to turn an evil and idolatrous nation to one who sought after God" +
                "\n\nMary was chosen as a young girl to give birth to the Savior of the world! " +
                "\n\n David, a teenage shepherd boy, was called to fight a powerful nation and defeat it to establish the kingdom of Israel." +
                "\n\n God called Joseph, Samuel, Esther, Timothy, the disciples and many other teenagers to become great leaders. It is obvious that He sees teenagers as strategic and essential to His heart and His ministry. In fact, 1 Timothy 4:12 says, “Don’t let anyone look down on you because you are young, but set an example for the believers in speech, in conduct, in love, in faith and in purity.\n";
//        String title = getIntent().getExtras().getString("title");
//        String content = getIntent().getExtras().getString("desc");

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(title);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        detail_image.setImageResource(R.drawable.pic);
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
