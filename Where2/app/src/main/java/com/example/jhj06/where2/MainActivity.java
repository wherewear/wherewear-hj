package com.example.jhj06.where2;

import android.location.Address;
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

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnVoice, btnText;
    RelativeLayout container;
    TMapView tMapView;

    TMapPoint startPoint=new TMapPoint(37.651445,127.016160);
    TMapPoint destPoint=new TMapPoint(37.637696,127.024636);

    TMapData tmapdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        tmapdata=new TMapData();

        et=(EditText)findViewById(R.id.etText);//시


        btnText=(Button)findViewById(R.id.btnText);
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TMapPoint map=translatePoint("삼양로144길 19-7");
                et.setText(map.getLongitude()+", "+map.getLatitude());
            }
        });
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
    //주소->좌표로 변환해 반환
    public TMapPoint translatePoint(String address){
        TMapPoint tmap=null;
        List<Address> list=null;
        Geocoder geocoder=new Geocoder(getApplication());
        try{
            list=geocoder.getFromLocationName(address,10);
        }catch (IOException e){
            e.printStackTrace();
        }
        if(list!=null){
            if(list.size()==0) {
                Toast.makeText(getApplicationContext(), "해당주소정보없음", Toast.LENGTH_LONG).show();
            }else{
                Address addr=list.get(0);
                double lat = addr.getLatitude();
                double lon = addr.getLongitude();

                tmap=new TMapPoint(lon,lat);
            }
        }

        return  tmap;
    }


}