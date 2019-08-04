package com.example.b307_dindin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.b307_dindin.util.HttpUtil;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CFragment extends Fragment {

    private ImageView takePhoto_image,chooseFromAlbum_image,bingPicImg;
    private TextView takePhoto_text,chooseFromAlbum_text;

    public static final int TAKE_PHOTO = 1;
    public static final int CHOOSE_PHOTO = 2;
    private ImageView picture;
    private Uri imageUri;



	public CFragment() {
		// Required empty public constructor
	}

	public static CFragment newInstance(String title){
		CFragment fragment = new CFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",title);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment4choice, container, false);//xiugai
		return view;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		//初始化
        takePhoto_image = view.findViewById(R.id.imageView2_camera);//相机图标
        chooseFromAlbum_image = view.findViewById(R.id.imageView3_album);//相册图标
        takePhoto_text = view.findViewById(R.id.textView1_takephoto);//拍照字样
        chooseFromAlbum_text = view.findViewById(R.id.textView2_albumselect);//相册字样
		bingPicImg = view.findViewById(R.id.imageView1_bg4);//在fragment中使用findViewById必须在前面加上view. ,这个view是前面View view =  inflater.inflate(R.layout.fragment4choice, container, false);中的view
        //背景图选用bing每日更新的图片
        bingPicImg.setAlpha(0.8f);//设置透明度数值from 0 to 1
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String bingPic = prefs.getString("bing_pic",null);
        if (bingPic != null) {
            //Glide.with(this).load(bingPic).into(bingPicImg);
            loadBingPic();
        } else {
            loadBingPic();
        }

        //若点击拍照图标，启动Activity4Procession.java,并调用拍照功能
        takePhoto_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_takephoto1 = new Intent(getActivity(),Activity4Procession.class);
                intent_takephoto1.putExtra("extra_data","please_takePhoto");
                getActivity().startActivity(intent_takephoto1);
            }
        });
        //若点击拍照字样，启动Activity4Procession.java,也调用拍照功能
        takePhoto_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_takephoto2 = new Intent(getActivity(),Activity4Procession.class);
                intent_takephoto2.putExtra("extra_data","please_takePhoto");
                getActivity().startActivity(intent_takephoto2);
            }
        });
        //若点击相册图标，启动Activity4Procession.java,调用打开相册功能
        chooseFromAlbum_image.setOnClickListener(new View.OnClickListener() {//选择相册中的图片
            @Override
            public void onClick(View v) {
                Intent intent_openalbum1 = new Intent(getActivity(),Activity4Procession.class);
                intent_openalbum1.putExtra("extra_data","please_openAlbum");
                getActivity().startActivity(intent_openalbum1);
            }
        });
        //若点击相册选择字样，启动Activity4Procession.java,也调用打开相册功能
        chooseFromAlbum_text.setOnClickListener(new View.OnClickListener() {//选择相册中的图片
            @Override
            public void onClick(View v) {
                Intent intent_openalbum2 = new Intent(getActivity(),Activity4Procession.class);
                intent_openalbum2.putExtra("extra_data","please_openAlbum");
                getActivity().startActivity(intent_openalbum2);
            }
        });
	}



	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//取消异步任务
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
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(getActivity()).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                getActivity().runOnUiThread(new Runnable() { //在fragment中使用runOnUiThread，前面必须得加上getActivity(). 否则报错
                    @Override
                    public void run() {
						if (getActivity()!=null){
							Glide.with(getActivity()).load(bingPic).into(bingPicImg);
						}
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
