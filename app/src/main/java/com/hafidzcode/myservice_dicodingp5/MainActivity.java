package com.hafidzcode.myservice_dicodingp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//todo 1 implementasi listener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //todo 2 deklarasi
    private Button btnStartService;
    private Button btnstartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //todo 3 inisialisasi & event click
        btnStartService = (Button)findViewById(R.id.btn_start_service);
        btnStartService.setOnClickListener(this);

        btnstartIntentService = (Button) findViewById(R.id.btn_start_intent_servie);
        btnstartIntentService.setOnClickListener(this);

    }
    //hasil implementasi
    @Override
    public void onClick(View view) {
        //todo 4
        switch (view.getId()){
            case R.id.btn_start_service:
                //todo 9
                Intent mStartServiceIntent = new Intent(MainActivity.this, OriginService.class);
                startService(mStartServiceIntent);
                break;
            case R.id.btn_start_intent_servie:
                //todo 3 (intent service)
                Intent mStartIntentService = new Intent(MainActivity.this, DicodingIntentService.class);
                mStartIntentService.putExtra(DicodingIntentService.EXTRA_DURATION, 5000);
                startService(mStartIntentService);
                break;
        }

    }
}
