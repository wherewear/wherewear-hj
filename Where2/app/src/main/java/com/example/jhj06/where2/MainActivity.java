package com.example.jhj06.where2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btnVoice, btnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.etText);
        btnText=(Button)findViewById(R.id.btnText);
        btnVoice=(Button)findViewById(R.id.btnVoice);
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,MapActivity.class);
                intent.putExtra("dest",et.getText().toString());
                startActivityForResult(intent,111);
            }
        });
    }
}
