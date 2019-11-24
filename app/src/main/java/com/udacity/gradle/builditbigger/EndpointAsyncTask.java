package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.addison.libjoketellingandroid.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {

    private static MyApi mMyApi = null;

    private Context mContext;

    public EndpointAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if (mMyApi == null) {
            MyApi.Builder builder = new MyApi.Builder(
                    AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.my_api_url));
            mMyApi = builder.build();
        }

        try {
            return mMyApi.sayAJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);

        if (mContext != null) {
            Intent intent = new Intent(mContext, JokeActivity.class);
            intent.putExtra(JokeActivity.INTENT_JOKE, joke);
            mContext.startActivity(intent);
        }
    }
}
