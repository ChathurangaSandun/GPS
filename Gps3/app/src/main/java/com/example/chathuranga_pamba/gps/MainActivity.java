package com.example.chathuranga_pamba.gps;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

import java.io.IOException;

import java.io.*;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.*;


public class MainActivity extends ActionBarActivity {


    Button btnShowLocation;
    TextView textDeviceID;
    TextView latitudeText;
    TextView longitudeText;
    TextView dateText;
    TextView timeText;


    String imeiNumber;
    double latitude;
    double longitude;
    String date;
    String time;



    GpsTracker gps;
    InputStream content = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textDeviceID = (TextView)findViewById(R.id.deviceid);
        latitudeText = (TextView)findViewById(R.id.latitudeText);
        longitudeText = (TextView)findViewById(R.id.longitudeText);
        dateText = (TextView)findViewById(R.id.dateText);
        timeText = (TextView)findViewById(R.id.timeText);



        //get data

        //imei number
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        AndroidTelephonyManager androidTelephonyManager = new AndroidTelephonyManager();
        imeiNumber= androidTelephonyManager.getDeviceID(telephonyManager);

        // imri numnber to text
        textDeviceID.setText(imeiNumber);

        btnShowLocation = (Button) findViewById(R.id.show_location);



        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GpsTracker(MainActivity.this);

                if(gps.CanGetLocation()){
                    //codinates
                    latitude = gps.getLatitide();
                   longitude = gps.getLongtitude();

                    //date and time
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    date = dateFormat.format(getInstance().getTime());
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    time = timeFormat.format(getInstance().getTime());

                    //codinates to text
                    latitudeText.setText(String.valueOf(latitude));
                    longitudeText.setText(String.valueOf(longitude));

                    //date and time to text
                    dateText.setText(date);
                    timeText.setText(time);









                    Toast.makeText(getApplicationContext(),"Your Location--\nLat : "+latitude+"\nLon : "+ longitude,Toast.LENGTH_LONG).show();

                    

                }else {
                    gps.showSettingsAlerts();
                }








            }


        });
    }












}
