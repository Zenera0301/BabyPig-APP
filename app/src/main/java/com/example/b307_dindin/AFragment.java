package com.example.b307_dindin;


import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment implements View.OnClickListener {

	private ViewFlipper viewFlipper;
	private List<View> mDotList;
	private final static int NUM = 4;
	private static final int AUTO = 0x01;
	private static final int PREVIOUS = 0x02;
	private static final int NEXT = 0x03;
	private float x,y;
	private int w,h;
	private RecyclerView recyclerView;
	private HKitemAdapter adapter;
	private List<HKitem> hkitemList = new ArrayList<>();
	private TextView tv_41,tv_42,tv_43,tv_44;
	private ImageView iv_41,iv_42,iv_43,iv_44;

	public AFragment(){
		// Required empty public constructor
	}
	public static AFragment newInstance(String title){
		AFragment fragment = new AFragment();
		Bundle bundle = new Bundle();
		bundle.putString("title",title);
		fragment.setArguments(bundle);
		return fragment;
	}
	//每隔一段时间切换图片
	private Handler mHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what){
				case AUTO:
					showNext();
					sendMsg();
					break;
				case PREVIOUS:
					mHandler.removeMessages(AUTO);
					showPre();
					sendMsg();
					break;
				case NEXT:
					mHandler.removeMessages(AUTO);
					showNext();
					sendMsg();
					break;
				default:
					break;
			}
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_a, container, false);
		Display display = getActivity().getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		w = size.x;
		h = size.y;
		init(view);
		return view;
	}

	private void init(View view) {
		tv_41 = (TextView)view.findViewById(R.id.tv_btn41);
		tv_42 = (TextView)view.findViewById(R.id.tv_btn42);
		tv_43 = (TextView)view.findViewById(R.id.tv_btn43);
		tv_44 = (TextView)view.findViewById(R.id.tv_btn44);
		iv_41 = (ImageView)view.findViewById(R.id.iv_btn41);
		iv_42 = (ImageView)view.findViewById(R.id.iv_btn42);
		iv_43 = (ImageView)view.findViewById(R.id.iv_btn43);
		iv_44 = (ImageView)view.findViewById(R.id.iv_btn44);
		tv_41.setOnClickListener(this);
		tv_42.setOnClickListener(this);
		tv_43.setOnClickListener(this);
		tv_44.setOnClickListener(this);
		iv_41.setOnClickListener(this);
		iv_42.setOnClickListener(this);
		iv_43.setOnClickListener(this);
		iv_44.setOnClickListener(this);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initItems();
		viewFlipper = (ViewFlipper)view.findViewById(R.id.vf_a);//图片切换窗口
		//recyclerview的初始化
		recyclerView = (RecyclerView)view.findViewById(R.id.rv_a);
		LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
		adapter = new HKitemAdapter(hkitemList);
		recyclerView.setAdapter(adapter);
		//圆点的初始化
		mDotList = new ArrayList<>();
		mDotList.add(view.findViewById(R.id.dot1));
		mDotList.add(view.findViewById(R.id.dot2));
		mDotList.add(view.findViewById(R.id.dot3));
		mDotList.add(view.findViewById(R.id.dot4));
		setEvent();
		sendMsg();
	}


	private void initItems() {
		hkitemList.add(new HKitem("苏淮猪生产管理平台-南京农业大学",
				"本系统通过海康摄像头监测记录母猪行为，进而监测母猪分娩。通过节点对猪舍环境进行监测，进而实现对母猪养殖的智能化管控。",
				"2019-01-05",
				R.drawable.gate1));
		hkitemList.add(new HKitem("中国养猪网",
				"中国养猪网是知名养猪行业门户网站,专业提供养猪行情走势分析及预测,今日最新生猪价格,养猪信息资讯,养猪技术,养猪补贴政策及养猪视频,养猪资料下载等优质服务!",
				"2019-01-05",
				R.drawable.gate1));
		hkitemList.add(new HKitem("中国养殖网-养猪",
				"养猪技术分享交流平台 ,最新养猪种猪仔猪苗猪养猪技术猪肉行情猪价格猪肉价格中国养殖网养猪频道中国养殖网。",
				"2019-01-05",
				R.drawable.gate1));
		hkitemList.add(new HKitem("养猪网",
				"专业养猪门户，交流养猪心得，提供养猪技术资讯设备视频，以及养猪行情和论坛展会推广。",
				"2019-1-5",
				R.drawable.gate1));
		hkitemList.add(new HKitem("养猪-新牧网",
				"新牧养猪网是中国最专业的养猪技术网,每日最新养猪行情,图文并茂的猪病大全、猪病防治措施,全国各地生猪品种介绍,现代化养猪场建设方案、养猪技术资料免费下载！",
				"2019-1-5",
				R.drawable.gate1));
		hkitemList.add(new HKitem("新技术养猪",
				"养猪新技术，企业应用的养猪软件，生猪养殖软件，家禽养殖软件，屠宰及加工软件等及其移动平台邀你体验！",
				"2019-1-5",
				R.drawable.gate1));
		hkitemList.add(new HKitem("猪友之家",
				"猪友之家为养猪户提供养猪新闻、生猪价格、最新猪价、全国猪价、猪肉价格、仔猪价格、养猪技术、养猪视频、猪场管理、猪病防治等综合养猪行业门户网站。",
				"2019-1-5",
				R.drawable.gate1));
		hkitemList.add(new HKitem("养猪技术视频",
				"养猪技术视频频道，隶属于中国养猪技术网，给养猪户免费提供专业养猪技术信息视频，养猪技术视频栏目针对猪病进行预防治疗，建设养猪场，利用微生态发酵床养猪。",
				"2019-1-5",
				R.drawable.gate1));
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
	//发送内容 并设置延迟切换图片的时间
	private void sendMsg(){
		Message mags = new Message();
		mags.what = AUTO;
		mHandler.sendMessageDelayed(mags,2000);
	}
	//设置事件 手动翻看图片
	private void setEvent(){
		viewFlipper.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()){
					case MotionEvent.ACTION_DOWN:
						x = event.getX();
						break;
					case MotionEvent.ACTION_UP:
						y = event.getX();
						if (y > x){
							mHandler.sendEmptyMessage(PREVIOUS);
						}else if (x == y){

						}else {
							mHandler.sendEmptyMessage(NEXT);
						}
						break;
				}
				return true;
			}
		});
	}
	//显示下一张图
	private void showNext(){
		viewFlipper.showNext();
		int current = viewFlipper.getDisplayedChild();
		if (current == 0){
			mDotList.get(NUM-1).setBackgroundResource(R.drawable.dot_normal);
		}else {
			mDotList.get(current-1).setBackgroundResource(R.drawable.dot_normal);
		}
		mDotList.get(current).setBackgroundResource(R.drawable.dot_focused);
	}
	//显示前一张图
	private void showPre(){
		viewFlipper.showPrevious();
		int current = viewFlipper.getDisplayedChild();
		if (current == NUM-1){
			mDotList.get(0).setBackgroundResource(R.drawable.dot_normal);
		}else {
			mDotList.get(current+1).setBackgroundResource(R.drawable.dot_normal);
		}
		mDotList.get(current).setBackgroundResource(R.drawable.dot_focused);
	}
	//处理点击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.iv_btn41://新手指导imageview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.iv_btn42://团队介绍imageview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.iv_btn43://知识天地imageview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.iv_btn44://我要反馈imageview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.tv_btn41://新手指导textview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.tv_btn42://团队介绍textview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.tv_btn43://知识天地textview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
			case R.id.tv_btn44://我要反馈textview
				intentBundle(getContext(),ActivityWebView.class,"URLMessage","https://www.sohu.com/a/203860940_696809");
				break;
		}
	}
	/**
	 * 对跳转到ActivityWebView，并携带指定网址的这个intent进行了封装
	 * @param context 当前的上下文
	 * @param mclass  要跳到的地方
	 * @param key   关键字
	 * @param urlMessage 指定的网址，要求ActivityWebView显示
	 */
	public void intentBundle(Context context,Class mclass,String key,String urlMessage){
		Intent intent = new Intent(context,mclass);
		Bundle bundle = new Bundle();               //创建Bundle对象
		bundle.putString(key, urlMessage);//装入数据
		intent.putExtras(bundle);                   //把Bundle塞入Intent里面
		context.startActivity(intent);
	}
}
