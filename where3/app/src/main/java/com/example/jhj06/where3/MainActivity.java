package com.example.jhj06.where3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnVoice, btnText;
    RelativeLayout container;
    TMapView tMapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText)findViewById(R.id.etText);
        btnText=(Button)findViewById(R.id.btnText);
        btnVoice=(Button)findViewById(R.id.btnVoice);

    }
    public void initTMapView(){
        //키값
        tMapView.setSKPMapApiKey("5c4d5cd3-917f-3c85-985a-5ed8869d72f3");
        tMapView.setCompassMode(true);
        tMapView.setIconVisibility(true);
        tMapView.setZoomLevel(20);
        tMapView.setCenterPoint(37.545944, 126.964771);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);

    }
    void drawPathPolyLine(){

        //출발지 초기화 수유역
        TMapPoint startPoint=new TMapPoint(37.545944, 126.964771);
        //목적지 초기화 덕성여대
        TMapPoint destPoint=new TMapPoint(37.544257, 126.969354);

        TMapData tmapdata=new TMapData();
        //       TMapData.TMapPathType type= TMapData.TMapPathType.PEDESTRIAN_PATH;
        //출발지-도착지 경로
        final TMapPolyLine polyline=null;
        try {
            tMapView.addTMapPath(tmapdata.findPathData(startPoint, destPoint));
            Toast.makeText(getApplication(),"VVVVVVVVVVVVVVVVVVVVVV",Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
