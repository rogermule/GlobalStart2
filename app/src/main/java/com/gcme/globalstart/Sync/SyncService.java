package com.gcme.globalstart.Sync;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;
import android.util.Pair;

import com.gcme.globalstart.Global_Start;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.Response;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bengeos on 6/30/16.
 */

@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class SyncService extends JobService {
    private static final String TAG = "SyncService";
    public static final String[] Sync_Tasks = {"Send_Log", "Send_Disciples","Remove_Disciple","Update_Disciple","Send_Schedule","Send_Report","Send_Testimony"};
    private List<Object> Param;
    private Gson myParser;
    private List<kotlin.Pair<String,String>> Send_Param;
    private FileManager myFileManager;
    private String SyncParam;

    public SyncService(){
        Param = new ArrayList<Object>();
        myParser = new Gson();
        myFileManager = new FileManager(this);
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i("JobService", "The Job scheduler started");
        Send_Param = new ArrayList<kotlin.Pair<String,String>>();

        Send_Param.add(new kotlin.Pair<String, String>("Service",getService()));
        Send_Param.add(new kotlin.Pair<String, String>("Param",SyncParam));

        Fuel.post(Global_Start.API_URL, Send_Param).responseString(new Handler<String>() {
            @Override
            public void success(@NotNull Request request, @NotNull Response response, String s) {
                Log.i(TAG, "Request: \n" + request);
                Log.i(TAG, "Response: \n" + s);
                Gson myGson = new Gson();
                try {
                    JSONObject myObject = (JSONObject) new JSONTokener(s).nextValue();
                    Log.i(TAG, "Server Response -> \n" + myObject.toString());
                    if (!myObject.isNull("Response")) {
                        JSONObject json_response = myObject.getJSONObject("Response");
                        Log.i(TAG, "Server  Response JSON OBJECT -> \n" + json_response.toString() + "---->" + !json_response.isNull("Confirmed_Logs"));
                        if (!json_response.isNull("Disciples")) {
                            JSONArray json_Disciples = json_response.getJSONArray("Disciples");
                          //  Add_Disciple(json_Disciples);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failure(@NotNull Request request, @NotNull Response response, @NotNull FuelError fuelError) {

            }
        });

        return false;
    }

    private String getService() {
        return "";
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
