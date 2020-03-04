package com.pjt.xianyu.pojo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.pjt.xianyu.R;

public class BlackListActivity extends AppCompatActivity {

    ImageView blacklist_back = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backlist);
        blacklist_back = (ImageView)findViewById(R.id.blacklist_back);
        blacklist_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlackListActivity.this.finish();
            }
        });
    }
}
