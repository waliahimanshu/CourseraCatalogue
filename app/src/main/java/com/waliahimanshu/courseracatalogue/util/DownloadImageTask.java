package com.waliahimanshu.courseracatalogue.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This is opening a url socket on background thread,
 * but this holds reference to view which holds context
 * which may cause memory leak.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView courseLogo;
    private HttpURLConnection urlIcon;
    private InputStream in;

    public DownloadImageTask(ImageView courseLogo) {
        this.courseLogo = courseLogo;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            urlIcon = (HttpURLConnection) url.openConnection();
            urlIcon.setDoInput(true);
            urlIcon.connect();
            in = urlIcon.getInputStream();
            return BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        } finally {
            urlIcon.disconnect();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        courseLogo.setImageBitmap(bitmap);
    }
}
