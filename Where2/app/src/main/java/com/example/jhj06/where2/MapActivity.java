package com.example.jhj06.where2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.skp.Tmap.TMapView;

public class MapActivity extends AppCompatActivity {

    TMapView container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //도착지
        Intent intent=getIntent();
        String dest=intent.getStringExtra("dest");

        //선언
        RelativeLayout relativeLayout=new RelativeLayout(this);
        TMapView tMapView=new TMapView(this);
        container=(TMapView)findViewById(R.id.container);

        //키값
        tMapView.setSKPMapApiKey("5c4d5cd3-917f-3c85-985a-5ed8869d72f3");
        tMapView.setCompassMode(true);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(20);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);

        relativeLayout.addView(tMapView);
    }
}
