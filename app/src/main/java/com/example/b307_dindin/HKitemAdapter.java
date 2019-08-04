package com.example.b307_dindin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class HKitemAdapter extends RecyclerView.Adapter<HKitemAdapter.ViewHolder> {

	private Context mContext;

	private List<HKitem> mHkitemList;

	static class ViewHolder extends RecyclerView.ViewHolder{
		CardView cardView;
		ImageView imageView;
		TextView tv_title,tv_content,tv_date;

		public ViewHolder(View itemView){
			super(itemView);
			cardView = (CardView)itemView;
			imageView = (ImageView)itemView.findViewById(R.id.iv_a_preview);
			tv_content = (TextView)itemView.findViewById(R.id.tv_a_content);
			tv_title = (TextView)itemView.findViewById(R.id.tv_a_title);
			tv_date = (TextView)itemView.findViewById(R.id.tv_a_date);
		}
	}

	public HKitemAdapter(List<HKitem> hkList) {
		mHkitemList = hkList;
	}

	@NonNull
	@Override
	public HKitemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		if (mContext == null){
			mContext = parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.a_item,parent,false);
		final ViewHolder holder = new ViewHolder(view);
		holder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getAdapterPosition();
				HKitem hkitem = mHkitemList.get(position);
				Log.d("onClick","我点击了一个cardview");
				switch (position){
					case 0:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","http://121.196.198.106:8080/huaian/");//南京农业大学 苏淮猪生产管理平台
						break;
					case 1:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","https://www.zhuwang.cc/");//中国养猪网
						break;
					case 2:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","http://www.chinabreed.com/pig/");//中国养殖网-养猪
						break;
					case 3:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","http://www.yangzhu.com/");//养猪网
						break;
					case 4:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","http://pig.xinm123.com/");//养猪-新牧网
						break;
					case 5:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","https://www.ajiaxi.com/");//新技术养猪
						break;
					case 6:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","http://www.pig66.com/");//猪友之家
						break;
					case 7:
						intentBundle(mContext,ActivityWebView.class,"URLMessage","https://www.zhuwang.cc/list-88-1.html");//养猪技术视频
						break;
				}
			}
		});
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull HKitemAdapter.ViewHolder viewHolder, int position) {
		HKitem hkitem = mHkitemList.get(position);
		viewHolder.tv_date.setText(hkitem.getDate());
		viewHolder.tv_content.setText(hkitem.getContent());
		viewHolder.tv_title.setText(hkitem.getTitle());
		Glide.with(mContext).load(hkitem.getImgID()).into(viewHolder.imageView);
	}

	@Override
	public int getItemCount() {
		return mHkitemList.size();
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
