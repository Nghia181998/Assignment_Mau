package com.khieuthichien.lab2.ui;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.khieuthichien.lab2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class HomeActivity extends AppCompatActivity {

    private TextView tvName;
    private TextView tvThucdon;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvName = findViewById(R.id.tvName);
        tvThucdon = findViewById(R.id.tvThucdon);
        btnExit = findViewById(R.id.btnExit);

        String success = getIntent().getStringExtra("success");
        String name = getIntent().getStringExtra("name");
        tvName.setText(success);


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        MyAsynctack myAsynctack = new MyAsynctack();

        myAsynctack.execute("http://113.190.232.235:30100/idocNet.Test.Logistic.WMS/Services/Login?username=wms.csc&password=0StFbim5pSrmBncQU0RpnA");

    }


    public class MyAsynctack extends AsyncTask<String, Long, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = httpURLConnection.getInputStream();

                Scanner scanner = new Scanner(inputStream);

                String data = "";
                while (scanner.hasNext()){
                    data = data + scanner.nextLine();
                }

                return data;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.e("data", s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                boolean ss = jsonObject.getBoolean("Success");
                int itemcount = jsonObject.getInt("ItemCount");
                Log.e("Itemcount",String.valueOf(itemcount) );
                JSONArray data = jsonObject.getJSONArray("Data");
                Log.e("data2",data.length()+"");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}
