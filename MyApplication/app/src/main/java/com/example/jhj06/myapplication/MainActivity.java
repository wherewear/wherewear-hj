package com.example.jhj06.myapplication;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.skp.Tmap.TMapView;

public class MainActivity extends AppCompatActivity implements LocationListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        RelativeLayout relativeLayout=new RelativeLayout(this);
        TMapView tmapView=new TMapView(this);
        tmapView.setSKPMapApiKey("2d662269-193b-3f0d-8c35-fde796e55dbf");

     //   LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
     //   locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 6000, 10, this);
    //    String locationProvider = locationManager.getBestProvider(new Criteria(), true);
      //  Location cur_location = locationManager.getLastKnownLocation(locationProvider);
  //      tmapView.setCenterPoint(cur_location.getLongitude(), cur_location.getLatitude());

        tmapView.setCenterPoint(127.016160,37.651445);
        relativeLayout.addView(tmapView);
        setContentView(relativeLayout);
    }

    @Override
    public void onLocationChanged(Location arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }
}
