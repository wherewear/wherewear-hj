package com.example.jhj06.where;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    Button btnText,btnVoice;
    EditText etSearch;

    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    TextView tvF2;
    String dest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragment1=new Fragment1();
        fragment2=new Fragment2();
        fragment3=new Fragment3();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

        TabLayout tabs=(TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("search"));
        tabs.addTab(tabs.newTab().setText("map"));
        tabs.addTab(tabs.newTab().setText("myPage"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position =tab.getPosition();
                Log.d("MainActivity","선택된 탭"+position);

                Fragment selected=null;

                if(position==0){
                    selected=fragment1;
                }else if(position==1){
                    selected=fragment2;
                }else{
                    selected=fragment3;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container,selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tvF2=(TextView)findViewById(R.id.tvFragment2);
        btnText=(Button)findViewById(R.id.btnText);
        btnVoice=(Button)findViewById(R.id.btnVoice);
        etSearch=(EditText)findViewById(R.id.edtSearch);
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest=etSearch.getText().toString();
                tvF2.setText(dest);
            }
        });

        btnVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest="";
            }
        });
    }

}
