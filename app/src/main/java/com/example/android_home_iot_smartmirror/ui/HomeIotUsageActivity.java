package com.example.android_home_iot_smartmirror.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.android_home_iot_smartmirror.R;

public class HomeIotUsageActivity extends AppCompatActivity {
    String urlStr;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_iot_usage);
        Intent intent = getIntent();
        urlStr = intent.getStringExtra("thingUsageURL");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(""); //타이틀 없음
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김

        // 실내등 로그 조회
        Button lightLogBtn = findViewById(R.id.lightLogBtn);
        lightLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urlstr = urlStr.concat("/MyMKR2");
                //String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR2/log";
                String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR2/firstlightlog";
                if (urlstr == null || urlstr.equals("")) {
                    Toast.makeText(HomeIotUsageActivity.this, "실내등 로그 조회 API URI 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(HomeIotUsageActivity.this, HomeLightLogActivity.class);
                intent.putExtra("getLightLogsURL", urlstr);
                startActivity(intent);
            }
        });

        // 실내등 사용량 조회
        Button lightUsageBtn = findViewById(R.id.lightUsageBtn);
        lightUsageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urlstr = urlStr.concat("/MyMKR2");
                //String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR2/log";
                String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR2/firstlightlog";
                if (urlstr == null || urlstr.equals("")) {
                    Toast.makeText(HomeIotUsageActivity.this, "실내등 로그 조회 API URI 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(HomeIotUsageActivity.this, HomeLightUsageActivity.class);
                intent.putExtra("getLightLogsURL", urlstr);
                startActivity(intent);
            }
        });

        // 2번 실내등 로그 조회
        Button secondLightLogBtn = findViewById(R.id.secondLightLogBtn);
        secondLightLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urlstr = urlStr.concat("/MyMKR2");
                //String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR3/log";
                String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR3/secondlightlog";
                if (urlstr == null || urlstr.equals("")) {
                    Toast.makeText(HomeIotUsageActivity.this, "실내등 로그 조회 API URI 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(HomeIotUsageActivity.this, HomeSecondLightLogActivity.class);
                intent.putExtra("getSecondLightLogsURL", urlstr);
                startActivity(intent);
            }
        });

        // 2번 실내등 사용량 조회
        Button secondLightUsageBtn = findViewById(R.id.secondLightUsageBtn);
        secondLightUsageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urlstr = urlStr.concat("/MyMKR2");
                //String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR3/log";
                String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR3/secondlightlog";
                if (urlstr == null || urlstr.equals("")) {
                    Toast.makeText(HomeIotUsageActivity.this, "실내등 로그 조회 API URI 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(HomeIotUsageActivity.this, HomeSecondLightUsageActivity.class);
                intent.putExtra("getSecondLightLogsURL", urlstr);
                startActivity(intent);
            }
        });

        // 가스 로그 조회
        Button gasLogBtn = findViewById(R.id.gasLogBtn);
        gasLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urlstr = urlStr.concat("/MyMKR2");
                //String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR1/log";
                String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR1/gasvalvelog";
                if (urlstr == null || urlstr.equals("")) {
                    Toast.makeText(HomeIotUsageActivity.this, "가스밸브 로그 조회 API URI 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(HomeIotUsageActivity.this, HomeGasLogActivity.class);
                intent.putExtra("getGasLogsURL", urlstr);
                startActivity(intent);
            }
        });

        // 가스 사용량 조회
        Button gasUsageBtn = findViewById(R.id.gasUsageBtn);
        gasUsageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String urlstr = urlStr.concat("/MyMKR2");
                //String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR1/log";
                String urlstr = "https://peaypv7rkd.execute-api.ap-northeast-2.amazonaws.com/homeIoT/devices/MyMKR1/gasvalvelog";
                if (urlstr == null || urlstr.equals("")) {
                    Toast.makeText(HomeIotUsageActivity.this, "가스밸브 로그 조회 API URI 입력이 필요합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(HomeIotUsageActivity.this, HomeGasUsageActivity.class);
                intent.putExtra("getGasLogsURL", urlstr);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings1:
                Toast.makeText(getApplicationContext(), "Test", Toast.LENGTH_LONG).show();
                return true;
            case android.R.id.home: //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
