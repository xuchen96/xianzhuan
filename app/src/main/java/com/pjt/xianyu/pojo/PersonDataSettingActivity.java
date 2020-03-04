package com.pjt.xianyu.pojo;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.pjt.xianyu.CircleImageView;
import com.pjt.xianyu.PersonCenterActivity;
import com.pjt.xianyu.PersonFragment;
import com.pjt.xianyu.R;
import com.pjt.xianyu.Util;

public class PersonDataSettingActivity extends AppCompatActivity {

    ImageView my_back = null;
    TextView set_name = null;
    private Context context=null;
    SharedPreferences sp=null;
    StringRequest stringRequest=null;
    RequestQueue requestQueue=null;
    Gson gson=null;
    ImageLoader loader=null;
    long user_id=0;
    private CircleImageView person_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_data_setting);
        context=PersonDataSettingActivity.this;
        sp=Util.getSp(context);
        requestQueue= Volley.newRequestQueue(context);
        gson=new Gson();
        loader=new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            private LruCache<String,Bitmap> lruCache=new LruCache<>(1024*1024*3);

            @Override
            public Bitmap getBitmap(String s) {
                return lruCache.get(s);
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {
                lruCache.put(s,bitmap);
            }
        });
        my_back = (ImageView)findViewById(R.id.my_back);
        set_name = (TextView)findViewById(R.id.set_name);
        person_img= (CircleImageView) findViewById(R.id.person_img);
        set_name.setText(PersonFragment.name);
        ButtonListener buttonListener = new ButtonListener();
        my_back.setOnClickListener(buttonListener);
        user_id=sp.getLong("user_id", 0);
        findUser();
    }

    private void findUser() {
        stringRequest=new StringRequest(Util.URL + "UserServlet?action=findUser&type=android" +
                "&user_id="+user_id,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        if(s.trim().length()>0){
                            User user=gson.fromJson(s, User.class);

                            ImageLoader.ImageListener imageListener=
                                    loader.getImageListener(person_img, R.drawable.loading_failed_big_icon,
                                            R.drawable.loading_failed_big_icon);
                            loader.get(Util.URL+"user/"+user.getImg(),imageListener);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        requestQueue.add(stringRequest);

    }


    public class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.my_back:
                    PersonDataSettingActivity.this.finish();
                    break;
            }
        }
    }
}
