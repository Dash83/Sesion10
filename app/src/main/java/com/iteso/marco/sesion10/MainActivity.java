package com.iteso.marco.sesion10;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    protected Button buttonStart;
    protected ProgressBar progressBarMain;
    protected TextView txtPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button)findViewById(R.id.buttonStart);
        progressBarMain = (ProgressBar)findViewById(R.id.progbMain);
        txtPercentage = (TextView)findViewById(R.id.txtPercentage);

        buttonStart.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View v) {
             buttonStart.setClickable(false);
             new UpdateProgress().execute();
           }
       });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class UpdateProgress extends AsyncTask<Void, Integer, Void>
    {
        private int progress = 0;

        @Override
        protected Void doInBackground(Void... params)
        {
            while(progress < 100)
            {
                progress++;
                publishProgress(progress);
                SystemClock.sleep(100);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            buttonStart.setClickable(true);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress = 0;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBarMain.setProgress(values[0]);
            txtPercentage.setText(values[0] + "%");
        }
    }
}



