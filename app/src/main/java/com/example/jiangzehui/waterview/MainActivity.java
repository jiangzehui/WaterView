package com.example.jiangzehui.waterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    WaterView waterView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        waterView = (WaterView) findViewById(R.id.waterView);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(waterView.isStart()){
                    waterView.stop();
                }else{
                    waterView.start();
                }
            }
        });

    }


}
