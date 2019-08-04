package com.example.b307_dindin;

import android.content.Context;
import android.content.Intent;
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

public class BitemAdapter extends RecyclerView.Adapter<BitemAdapter.ViewHolder>{

	private Context mContext;

	private List<HKitem> mBitemList;

	private int flag;
	public static int axiba ;

	static class ViewHolder extends RecyclerView.ViewHolder{
		CardView cardView;
		TextView tv_title;
		ImageView iv_preview;

		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			cardView = (CardView)itemView;
			iv_preview = (ImageView)itemView.findViewById(R.id.iv_a_preview);//xiugai
			tv_title = (TextView)itemView.findViewById(R.id.tv_a_title);//xiugai
		}
	}

	public BitemAdapter(){

	}

	public void setFlag(int temp){
		flag = temp;
		Log.d("setFlag",Integer.toString(flag));
	}

	public BitemAdapter(List<HKitem> hkList) {
		mBitemList = hkList;
	}

	@NonNull
	@Override
	public BitemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
		if (mContext == null){
			mContext = parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.a_item,parent,false);//xiugai
		final BitemAdapter.ViewHolder holder = new BitemAdapter.ViewHolder(view);
		holder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getAdapterPosition();
				HKitem hkitem = mBitemList.get(position);
				Log.d("onClick","我点击了一个cardview");
				if (axiba == 0){
					switch (position){
						case 0:
							Intent intent1 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent1);
							break;
						case 1:
							Intent intent2 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent2);
							break;
						case 2:
							Intent intent3 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent3);
							break;
						case 3:
							Intent intent4 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent4);
							break;
					}
				}else if (axiba == 1){
					switch (position){
						case 0:
							Intent intent4 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent4);
							break;
						case 1:
							Intent intent5 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent5);
							break;
					}
				}else if (axiba == 2){
					switch (position){
						case 0:
							Intent intent6 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent6);
							break;
						case 1:
							Intent intent7 = new Intent(mContext,Activity2LogIn.class);
							mContext.startActivity(intent7);
							break;
					}
				}
//				Intent intent = new Intent(mContext,Bactivity.class);
//				intent.putExtra(Bactivity.B_NAME,hkitem.getTitle());
//				mContext.startActivity(intent);
			}
		});
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull BitemAdapter.ViewHolder viewHolder, int position) {
		HKitem hkitem = mBitemList.get(position);
		viewHolder.tv_title.setText(hkitem.getTitle());
		Glide.with(mContext).load(hkitem.getImgID()).into(viewHolder.iv_preview);
	}

	@Override
	public int getItemCount() {
		return mBitemList.size();
	}


}
