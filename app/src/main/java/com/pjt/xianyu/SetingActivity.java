package com.pjt.xianyu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pjt.xianyu.pojo.AboutActivity;
import com.pjt.xianyu.pojo.BlackListActivity;
import com.pjt.xianyu.pojo.CommunityTextActivity;
import com.pjt.xianyu.pojo.PersonDataSettingActivity;

public class SetingActivity extends AppCompatActivity {

    Button btn_logout=null;
    RelativeLayout relativeLayout32 = null;
    RelativeLayout relativeLayout33 = null;
    RelativeLayout relativeLayout42 = null;
    RelativeLayout relativeLayout43 = null;
    ImageView setting_back = null;
    SharedPreferences sp=null;
    //private int[]setids=new int[]{R.id.relativeLayout32,R.id.relativeLayout33,R.id.relativeLayout42,R.id.relativeLayout43};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seting);
        btn_logout= (Button) findViewById(R.id.btn_logout);
        relativeLayout32 = (RelativeLayout)findViewById(R.id.relativeLayout32);
        relativeLayout33 = (RelativeLayout)findViewById(R.id.relativeLayout33);
        relativeLayout42 = (RelativeLayout)findViewById(R.id.relativeLayout42);
        relativeLayout43 = (RelativeLayout)findViewById(R.id.relativeLayout43);
        setting_back = (ImageView) findViewById(R.id.setting_back);
        sp=Util.getSp(getApplicationContext());
        ButtonListener buttonListener=new ButtonListener();
        btn_logout.setOnClickListener(buttonListener);
        relativeLayout32.setOnClickListener(buttonListener);
        relativeLayout33.setOnClickListener(buttonListener);
        relativeLayout42.setOnClickListener(buttonListener);
        relativeLayout43.setOnClickListener(buttonListener);
        setting_back.setOnClickListener(buttonListener);
    }

    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_logout:
                    SharedPreferences.Editor editor=sp.edit();
                    editor.remove("user_id");
                    editor.commit();
                    for(Context context:Util.ContextArray){
                        ((Activity)context).finish();
                    }
                    Intent intent=new Intent(SetingActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                case R.id.relativeLayout42:
                    Intent intent1 = new Intent(SetingActivity.this,AboutActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.relativeLayout33:
                    Intent intent2 = new Intent(SetingActivity.this,BlackListActivity.class);
                    startActivity(intent2);
                    break;

                case R.id.relativeLayout32:
                    Intent intent3 = new Intent(SetingActivity.this,PersonDataSettingActivity.class);
                    startActivity(intent3);
                    break;

                case R.id.relativeLayout43:
                    Intent intent4 = new Intent(SetingActivity.this,CommunityTextActivity.class);
                    startActivity(intent4);
                    break;

                case R.id.setting_back:
                    finish();
                    break;
            }
        }
    }
}
