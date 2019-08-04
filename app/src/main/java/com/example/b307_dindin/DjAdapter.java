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


public class DjAdapter extends RecyclerView.Adapter<DjAdapter.ViewHolder>{

	private Context mContext;

	private List<HKitem> mDjitemList;

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

	public DjAdapter(List<HKitem> hkList) {
		mDjitemList = hkList;
	}

	@NonNull
	@Override
	public DjAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
		if (mContext == null){
			mContext = parent.getContext();
		}
		View view = LayoutInflater.from(mContext).inflate(R.layout.a_item,parent,false);
		final ViewHolder holder = new ViewHolder(view);
		holder.cardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int position = holder.getAdapterPosition();
				HKitem hkitem = mDjitemList.get(position);
				Log.d("onClick","我点击了一个cardview");
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
					case 4:
						Intent intent5 = new Intent(mContext,Activity2LogIn.class);
						mContext.startActivity(intent5);
						break;
				}
//				Intent intent = new Intent(mContext,Cactivity.class);
//				intent.putExtra(Cactivity.C_NAME,hkitem.getTitle());
//				intent.putExtra(Cactivity.C_POSITION,position);
//				mContext.startActivity(intent);
			}
		});
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull DjAdapter.ViewHolder viewHolder, int position) {
		HKitem hkitem = mDjitemList.get(position);
		viewHolder.tv_date.setText(hkitem.getDate());
		viewHolder.tv_content.setText(hkitem.getContent());
		viewHolder.tv_title.setText(hkitem.getTitle());
		Glide.with(mContext).load(hkitem.getImgID()).into(viewHolder.imageView);
	}

	@Override
	public int getItemCount() {
		return mDjitemList.size();
	}
}
