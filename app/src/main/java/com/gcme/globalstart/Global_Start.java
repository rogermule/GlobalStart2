package com.gcme.globalstart;

import android.app.Application;
import android.content.ContentValues;
import android.graphics.Color;
import android.util.Log;

import com.gcme.globalstart.Database.MyDatabase;
import com.gcme.globalstart.News_Feed.NewsFeed_Fragment;
import com.goka.blurredgridmenu.BlurredGridMenuConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class Global_Start extends Application {

    public static MyDatabase myDatabase;
    public static int DOWNLOAD_STATUS;
    public static String API_URL = "www.google.com";


    @Override
    public void onCreate() {
        super.onCreate();
        myDatabase = new MyDatabase(this);
        //Intent intent = new Intent(this,Sync_Service.class);
        //startService(intent);
        //Toast.makeText(this,"Service Started:",Toast.LENGTH_LONG).show();

        BlurredGridMenuConfig
                .build(new BlurredGridMenuConfig.Builder()
                        .radius(1)
                        .downsample(1)
                        .overlayColor(Color.parseColor("#AA000000")));
    }

    public static void addNew_NewsFeed(JSONArray NOTIS) throws JSONException {
        boolean is_added = false;
        if (NOTIS.length() > 0) {
            for (int i = 0; i < NOTIS.length(); i++) {
                JSONObject obj = NOTIS.getJSONObject(i);
                ContentValues sch_vals = new ContentValues();
                Log.i("Sync_Service", "News Feed Count: " + myDatabase.count(MyDatabase.Table_NewsFeed));
                sch_vals.put(MyDatabase.NewsFeed_FIELDS[0], obj.getString(MyDatabase.NewsFeed_FIELDS[0]));
                sch_vals.put(MyDatabase.NewsFeed_FIELDS[1], obj.getString(MyDatabase.NewsFeed_FIELDS[1]));
                sch_vals.put(MyDatabase.NewsFeed_FIELDS[2], obj.getString(MyDatabase.NewsFeed_FIELDS[2]));
                sch_vals.put(MyDatabase.NewsFeed_FIELDS[3], obj.getString(MyDatabase.NewsFeed_FIELDS[3]));
                sch_vals.put(MyDatabase.NewsFeed_FIELDS[4], obj.getString(MyDatabase.NewsFeed_FIELDS[4]));
                long val = myDatabase.insert(MyDatabase.Table_NewsFeed, sch_vals);
                if(val>0){
                    ContentValues cv = new ContentValues();
                    cv.put(MyDatabase.NewsFeedLog_FIELDS[0],obj.getString(MyDatabase.NewsFeed_FIELDS[0]));
                    cv.put(MyDatabase.NewsFeedLog_FIELDS[0],obj.getString(MyDatabase.NewsFeed_FIELDS[0]));
                    long log_val = myDatabase.insert(MyDatabase.Table_NewsFeed_Log, cv);
                    is_added = true;
                    Log.i("Sync_Service", "News Feed Log Added: ");
                }
                Log.i("Sync_Service", "Adding new NewsFeed:-> "+val);
            }
        }
        if(is_added){
            NewsFeed_Fragment.update_view();
        }
    }
    public static void confirmLog(JSONArray NOTIS) throws JSONException {
        if (NOTIS.length() > 0) {
            for (int i = 0; i < NOTIS.length(); i++) {
                JSONObject obj = NOTIS.getJSONObject(i);
                long state = myDatabase.remove_news_log(obj.getString("News_ID"));
                Log.i("Sync_Service", "Adding News_Log:-> "+state);
            }
        }
    }
}
