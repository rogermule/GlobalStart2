package com.gcme.globalstart.Learn;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.gcme.globalstart.R;

public class Learn_How_To_Learn extends AppCompatActivity {
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

        String title = "How to Learn .. ";
        String content = "Jesus modeled the importance of knowing the real issues in the lives of those He ministered to and we must do the same. With the youth culture changing so rapidly we must constantly observe and ask questions to know how we can minister effectively. We must ASK, LOOK and LISTEN. " +
                "\n\n• Ask good questions: \\nWhat do teenagers think about?  What are their beliefs and values? How do they get their needs met? What are their goals in life? What are their greatest fears" +
                "\n\n• Look and observe: \\nHow and where do they spend their time?  What do they do for fun? How do they act around their peers, their parents or authority?  How do they dress?";

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
