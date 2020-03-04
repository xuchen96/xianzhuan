package com.pjt.xianyu.pojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pjt.xianyu.R;

public class CommunityTextActivity extends AppCompatActivity {

    ImageView comm_back = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_text);
        comm_back = (ImageView)findViewById(R.id.comm_back);
        comm_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommunityTextActivity.this.finish();
            }
        });
    }
}
