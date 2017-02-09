package com.gcme.globalstart;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Color;
import android.telephony.TelephonyManager;

import com.gcme.globalstart.Database.MyDatabase;
import com.gcme.globalstart.Sync.FileManager;
import com.gcme.globalstart.Sync.SyncService;
import com.goka.blurredgridmenu.BlurredGridMenuConfig;

import me.tatarka.support.job.JobInfo;
import me.tatarka.support.job.JobScheduler;

/**
 * Created by BENGEOS on 3/17/16.
 */
public class Global_Start extends Application {

    public static MyDatabase myDatabase;
    public static int DOWNLOAD_STATUS;
    public static String API_URL = "http://192.168.173.1/GlobalStart/Public/MobAPI.php";
    public static FileManager myFileManager;
    private JobScheduler myJobScheduler;
    public static TelephonyManager Tel;

    @Override
    public void onCreate() {
        super.onCreate();
        myDatabase = new MyDatabase(this);
        myFileManager = new FileManager(this);
        myJobScheduler  = JobScheduler.getInstance(this);
        Tel = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        //Intent intent = new Intent(this,Sync_Service.class);
        //startService(intent);
        //Toast.makeText(this,"Service Started:",Toast.LENGTH_LONG).show();

        BlurredGridMenuConfig
                .build(new BlurredGridMenuConfig.Builder()
                        .radius(1)
                        .downsample(1)
//                        .overlayColor(Color.parseColor("#AA000000")));
                        .overlayColor(Color.parseColor("#4888c6")));
        JobConstr();
    }
    public void JobConstr(){
        JobInfo.Builder builder = new JobInfo.Builder(12, new ComponentName(this,SyncService.class));
        builder.setPeriodic(10000);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        myJobScheduler.schedule(builder.build());
    }
}
