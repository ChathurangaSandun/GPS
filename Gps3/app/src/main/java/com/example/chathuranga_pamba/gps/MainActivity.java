package com.example.chathuranga_pamba.gps;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    Button btnShowLocation;

    GpsTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnShowLocation = (Button) findViewById(R.id.show_location);

        btnShowLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new GpsTracker(MainActivity.this);

                if(gps.CanGetLocation()){
                    double latitude = gps.getLatitide();
                    double longtitude = gps.getLongtitude();

                    Toast.makeText(getApplicationContext(),"Your Location--\nLat : "+latitude+"\nLon : "+ longtitude,Toast.LENGTH_LONG).show();

                }else {
                    gps.showSettingsAlerts();
                }


            }
        });



    }






}
