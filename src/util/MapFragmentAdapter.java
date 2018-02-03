package util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MapFragmentAdapter extends FragmentPagerAdapter{

	public MapFragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return new MapFragment();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
}
