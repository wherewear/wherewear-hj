package com.example.jhj06.where2;

import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    TMapPoint startPoint=new TMapPoint(37.651445,127.016160);
    TMapPoint destPoint=new TMapPoint(37.637696,127.024636);

    TMapData tmapdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        tmapdata=new TMapData();

        et=(EditText)findViewById(R.id.etText);
        btnText=(Button)findViewById(R.id.btnText);
        btnVoice=(Button)findViewById(R.id.btnVoice);

        container=(RelativeLayout) findViewById(R.id.container);
        //선언
        tMapView=new TMapView(this);

        initTMapView();

        Geocoder geocoder=new Geocoder(getApplicationContext());

        btnVoice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"333333333333333",Toast.LENGTH_LONG).show();


                tmapdata.findPathData(startPoint, destPoint, new TMapData.FindPathDataListenerCallback() {
                    @Override
                    public void onFindPathData(TMapPolyLine tMapPolyLine) {

                        tMapPolyLine.setLineWidth(10);
                        tMapView.addTMapPath(tMapPolyLine);
                    }
                });

                Toast.makeText(getApplicationContext(),"11111111111111",Toast.LENGTH_LONG).show();

            }
        });
        container.addView(tMapView);
    }
    public void initTMapView(){
        //키값
        tMapView.setSKPMapApiKey("2d662269-193b-3f0d-8c35-fde796e55dbf");

       tMapView.setCenterPoint(127.016160,37.651445);

        tMapView.setOnApiKeyListener(new TMapView.OnApiKeyListenerCallback() {
            @Override
            public void SKPMapApikeySucceed() {
                Log.d("map auth","success");
            }

            @Override
            public void SKPMapApikeyFailed(String s) {
                Log.d("Map Auth",s);
            }
        });


    }

}