package com.example.b307_dindin;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class NewPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<String> titleList;
	private ArrayList<Fragment> fragmentsList;

	public NewPagerAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentsList){
		super(fm);
		this.titleList = titleList;
		this.fragmentsList = fragmentsList;
	}

	@Override
	public int getCount() {
		return fragmentsList.size();
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		return titleList.get(position);
	}

	@Override
	public Fragment getItem(int position) {
		return fragmentsList.get(position);
	}

//	@Override
//	public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
//		return arg0 == arg1;
//	}



//	@NonNull
//	@Override
//	public Object instantiateItem(@NonNull ViewGroup container, int position) {
//		View view = View.inflate(context,R.layout.fragment_b,null);
//		TextView tv = (TextView)view.findViewById(R.id.tv_test_b);
//		tv.setText(str.get(position));
//		container.addView(view);
//		return view;
//	}
//
//	@Override
//	public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//		container.removeView((View)object);
//	}
}
