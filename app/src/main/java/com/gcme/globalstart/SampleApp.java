package com.gcme.globalstart;

import android.app.Application;
import android.graphics.Color;

import com.goka.blurredgridmenu.BlurredGridMenuConfig;

/**
 * Created by katsuyagoto on 15/06/25.
 */
public class SampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        BlurredGridMenuConfig
                .build(new BlurredGridMenuConfig.Builder()
                        .radius(1)
                        .downsample(1)
                        .overlayColor(Color.parseColor("#AA000000")));

    }

}
