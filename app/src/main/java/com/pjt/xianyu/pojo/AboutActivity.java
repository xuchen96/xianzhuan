package com.pjt.xianyu.pojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pjt.xianyu.R;

public class AboutActivity extends AppCompatActivity {

    ImageView about_back = null;
    RelativeLayout relativeLayout132 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        about_back = (ImageView) findViewById(R.id.about_back);
        relativeLayout132 = (RelativeLayout)findViewById(R.id.relativeLayout132);
        about_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.this.finish();
            }
        });
        relativeLayout132.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutActivity.this,"已经是最新版本了~",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
