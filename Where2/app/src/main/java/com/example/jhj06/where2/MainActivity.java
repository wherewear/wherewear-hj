package com.example.jhj06.where2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.skp.Tmap.TMapData;
import com.skp.Tmap.TMapPoint;
import com.skp.Tmap.TMapPolyLine;
import com.skp.Tmap.TMapView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnVoice, btnText;
    RelativeLayout container;
    TMapView tMapView;
    //출발지 초기화 수유역
    TMapPoint startPoint;
    //목적지 초기화 덕성여대
    TMapPoint destPoint;
    TMapData tmapdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        startPoint=new TMapPoint(127.016160,37.651445);
        destPoint=new TMapPoint( 127.024690,37.637101);
        tmapdata=new TMapData();

        et=(EditText)findViewById(R.id.etText);
        btnText=(Button)findViewById(R.id.btnText);
        btnVoice=(Button)findViewById(R.id.btnVoice);

        container=(RelativeLayout) findViewById(R.id.container);
        //선언
        tMapView=new TMapView(this);

        initTMapView();

        btnVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tmapdata.findPathData(startPoint, destPoint, new TMapData.FindPathDataListenerCallback() {
                    @Override
                    public void onFindPathData(TMapPolyLine tMapPolyLine) {
                        Toast.makeText(getApplicationContext(),"333333333333333",Toast.LENGTH_LONG).show();

                        tMapView.addTMapPath(tMapPolyLine);
                    }
                });
                //   drawPathPolyLine();
                Toast.makeText(getApplicationContext(),"11111111111111",Toast.LENGTH_LONG).show();
                //tMapView.refreshMap();
            }
        });
        container.addView(tMapView);
    }
    public void initTMapView(){
        //키값
        tMapView.setSKPMapApiKey("2d662269-193b-3f0d-8c35-fde796e55dbf");
//        tMapView.setCompassMode(true);
//        tMapView.setIconVisibility(true);
//        tMapView.setZoomLevel(20);
        //tMapView.setCenterPoint(startPoint.getLongitude(),startPoint.getLatitude());
        tMapView.setCenterPoint(127.016160,37.651445);
       // tMapView.setLocationPoint(127.016160,37.651445);

//        tMapView.setTrackingMode(true);
//        tMapView.setSightVisible(true);

    }
//    void drawPathPolyLine(){
//
//
//        Toast.makeText(getApplicationContext(),"22222222222222",Toast.LENGTH_LONG).show();
//
////        //출발지-도착지 경로
//        TMapPolyLine polyline=null;
//
//            tmapdata.findPathData(startPoint, destPoint, new TMapData.FindPathDataListenerCallback() {
//                @Override
//                public void onFindPathData(TMapPolyLine tMapPolyLine) {
//                    Toast.makeText(getApplicationContext(),"333333333333333",Toast.LENGTH_LONG).show();
//
//                    tMapView.addTMapPath(tMapPolyLine);
//                }
//            });
//
//
//    }
}
