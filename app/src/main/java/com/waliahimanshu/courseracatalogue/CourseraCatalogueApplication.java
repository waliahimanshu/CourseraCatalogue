package com.waliahimanshu.courseracatalogue;

import android.app.Application;
import android.os.StrictMode;

import com.facebook.stetho.Stetho;

public class CourseraCatalogueApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG)

            Stetho.initializeWithDefaults(this);
        // Tell Android what thread issues you want to detect and what to do when found.
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .penaltyDialog()
                .build());

        // Tell Android what VM issues you want to detect and what to do when found.
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                //enable death penalty when bug https://github.com/square/okhttp/issues/3174 is closed
                //.penaltyDeath()
                .build());
    }
}
