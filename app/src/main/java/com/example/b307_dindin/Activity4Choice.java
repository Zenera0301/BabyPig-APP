package com.example.b307_dindin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.b307_dindin.util.HttpUtil;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Activity4Choice extends AppCompatActivity {
    private ImageView bingPicImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4choice);
        //实例控件
        ImageView takePhoto_image =  findViewById(R.id.imageView2_camera);
        TextView takePhoto_text = findViewById(R.id.textView1_takephoto);
        ImageView chooseFromAlbum_image = findViewById(R.id.imageView3_album);
        TextView chooseFromAlbum_text = findViewById(R.id.textView2_albumselect);
        //毕加索图片框架
        // ImageView iv=findViewById(R.id.imagetest1);
        // Picasso.with(Activity2LogIn.this).load("http://cn.bing.com/az/hprichbg/rb/NLNorway_ZH-CN3295729777_1920x1080.jpg").into(iv);
        //背景图选用bing每日更新的图片
        bingPicImg = findViewById(R.id.imageView1_bg4);
        bingPicImg.setAlpha(0.5f);//设置透明度数值from 0 to 1
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String bingPic = prefs.getString("bing_pic",null);
        if (bingPic != null) {
            Glide.with(this).load(bingPic).into(bingPicImg);
        } else {
            loadBingPic();
        }
        //若点击拍照图标，启动Activity4Procession.java,并调用拍照功能
        takePhoto_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_takephoto1 = new Intent(Activity4Choice.this,Activity4Procession.class);
                intent_takephoto1.putExtra("extra_data","please_takePhoto");
                startActivity(intent_takephoto1);
                finish();

            }
        });
        //若点击拍照字样，启动Activity4Procession.java,也调用拍照功能
        takePhoto_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_takephoto2 = new Intent(Activity4Choice.this,Activity4Procession.class);
                intent_takephoto2.putExtra("extra_data","please_takePhoto");
                startActivity(intent_takephoto2);
                finish();
            }
        });
        //若点击相册图标，启动Activity4Procession.java,调用打开相册功能
        chooseFromAlbum_image.setOnClickListener(new View.OnClickListener() {//选择相册中的图片
            @Override
            public void onClick(View v) {
                Intent intent_openalbum1 = new Intent(Activity4Choice.this,Activity4Procession.class);
                intent_openalbum1.putExtra("extra_data","please_openAlbum");
                startActivity(intent_openalbum1);
                finish();
            }
        });
        //若点击相册选择字样，启动Activity4Procession.java,也调用打开相册功能
        chooseFromAlbum_text.setOnClickListener(new View.OnClickListener() {//选择相册中的图片
            @Override
            public void onClick(View v) {
                Intent intent_openalbum2 = new Intent(Activity4Choice.this,Activity4Procession.class);
                intent_openalbum2.putExtra("extra_data","please_openAlbum");
                startActivity(intent_openalbum2);
                finish();
            }
        });
    }
    /**
     * 加载必应每日一图
     */
    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(Activity4Choice.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(Activity4Choice.this).load(bingPic).into(bingPicImg);
                    }
                });
            }
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
        });
    }


}
