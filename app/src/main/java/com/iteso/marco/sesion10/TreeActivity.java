package com.iteso.marco.sesion10;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.gson.Gson;
import com.iteso.marco.sesion10.beans.DatoResponse;
import com.iteso.marco.sesion10.beans.Tree;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by marco on 4/8/15.
 */
public class TreeActivity extends ActionBarActivity
{
    private EditText editNID;
    private EditText editLatitud;
    private EditText editLongitud;
    private EditText editTaxonomia;
    private EditText editJardin;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        editNID = (EditText)findViewById(R.id.txtNID);
        editLatitud = (EditText)findViewById(R.id.txtLatitud);
        editLongitud = (EditText)findViewById(R.id.txtLongitud);
        editTaxonomia = (EditText)findViewById(R.id.txtTaxonomia);
        editJardin = (EditText)findViewById(R.id.txtJardin);

        this.retrieveTrees();
    }

    private void retrieveTrees()
    {
        dialog = ProgressDialog.show(this, "Please wait...", "Retrieving data...", true, true);
        TreeAsyncTask task = new TreeAsyncTask();
        task.execute();
        dialog.setOnCancelListener(new CancelListener(task));
    }

    class TreeAsyncTask extends AsyncTask<Void, Void, Void>
    {
        private DatoResponse response;

        @Override
        protected Void doInBackground(Void... params)
        {
            String url = "http://papvidadigital.com/risi/?nid=83&format=json";
            HttpGet getRequest = new HttpGet(url);

            try
            {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpResponse getResponse = httpClient.execute(getRequest);
                final int statusCode = getResponse.getStatusLine().getStatusCode();

                if(statusCode != HttpStatus.SC_OK)
                {
                    Log.w(getClass().getSimpleName(), "Error " + statusCode + " for URL" + url);
                    return null;
                }

                HttpEntity getResponseEntity = getResponse.getEntity();
                InputStream httpResponseStream = getResponseEntity.getContent();

                Reader inputStreamReader = new InputStreamReader(httpResponseStream);

                Gson gson = new Gson();
                this.response = gson.fromJson(inputStreamReader, DatoResponse.class);

            }

            catch(IOException ex)
            {
                getRequest.abort();
                Log.w(getClass().getSimpleName(), "Error for URL " + url, ex);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid)
        {
            super.onPostExecute(aVoid);

            StringBuilder builder = new StringBuilder();
            for(Tree tree : this.response.getDato())
            {
                editNID.setText(tree.getNID());
                editLatitud.setText(tree.getLatitud());
                editLongitud.setText(tree.getLongitud());
                editTaxonomia.setText(tree.getTaxonomia());
                editJardin.setText(tree.getJardin());
            }

            dialog.cancel();
        }
    }

    private class CancelListener implements DialogInterface.OnCancelListener
    {
        private AsyncTask<?,?,?> cancellableTask;

        @Override
        public void onCancel(DialogInterface dialog)
        {
            cancellableTask.cancel(true);
        }

        public CancelListener(AsyncTask<?,?,?> task)
        {
            cancellableTask = task;
        }
    }
}
