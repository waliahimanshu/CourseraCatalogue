package com.waliahimanshu.courseracatalogue.ui.home;

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
 * Created by waliahimanshu.
 */

public class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView courseLogo;
    private HttpURLConnection urlcon;
    private InputStream in;

    public DownloadImageTask(ImageView courseLogo) {
        this.courseLogo = courseLogo;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setDoInput(true);
            urlcon.connect();
            in = urlcon.getInputStream();
            Bitmap mIcon = BitmapFactory.decodeStream(in);
            return mIcon;
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
            return null;
        }
        finally {
            urlcon.disconnect();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        courseLogo.setImageBitmap(bitmap);
    }
}
