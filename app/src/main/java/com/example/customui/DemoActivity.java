package com.example.customui;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SeekBar;

import java.util.ArrayList;

public class DemoActivity extends Activity {

    CustomProgressBar mProgressBar;

    int progress;

    int TIME_TO_UPDATE = 100;

    SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (CustomProgressBar) findViewById(R.id.myProgressBar);
        mProgressBar.setColor(Color.GREEN);
        mProgressBar.setRadius(300);
        ArrayList<Float> data = new ArrayList<Float>();
        data.add((float) 10);
        data.add((float) 25);
        data.add((float) 65);
        data.add((float) 37);
        data.add((float) 89);
        data.add((float) 25);
        data.add((float) 90);
        data.add((float) 25);
        data.add((float) 109);
        data.add((float) 57);
        data.add((float) 25);
        data.add((float) 43);
        data.add((float) 25);
        data.add((float) 73);
        data.add((float) 18);
        data.add((float) 25);
        mProgressBar.setDiagramParams(data);
        //new SomeDownloader().execute();

    }

    private class SomeDownloader extends AsyncTask<Integer, Integer, Void> {
        @Override
        public Void doInBackground(Integer... params) {
            while (true) {
                try {
                    Thread.sleep(TIME_TO_UPDATE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(progress > 100 ? progress = 0 : progress++);
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mProgressBar.setProgress(values[0]);
            super.onProgressUpdate(values);
        }
    }
}
