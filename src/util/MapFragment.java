package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import totoo.touhou.MainActivity;

import com.totoo.touhou.R;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MapFragment extends Fragment {
	ViewPager viewPager;
	View view;
	GridView gridView;

	public MapFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	view =inflater.inflate(R.layout.fragment_choces, null);
//	viewPager=MainActivity.
	gridView=(GridView) view.findViewById(R.id.gridView1);
//	ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1);
//	arrayAdapter.add("cao");
//	arrayAdapter.add("cao");
//	arrayAdapter.add("cao");
//	arrayAdapter.add("cao");
//	gridView.setAdapter(arrayAdapter );
	List<Bitmap> list=new ArrayList<Bitmap>();
	list.add(((BitmapDrawable)getActivity().getResources().getDrawable(R.drawable.map)).getBitmap());
	list.add(((BitmapDrawable)getActivity().getResources().getDrawable(R.drawable.map2)).getBitmap());
	list.add(((BitmapDrawable)getActivity().getResources().getDrawable(R.drawable.map3)).getBitmap());
	list.add(((BitmapDrawable)getActivity().getResources().getDrawable(R.drawable.map1)).getBitmap());
	MapImgAdp arrayAdapter=new MapImgAdp(getActivity(), list);
	gridView.setAdapter(arrayAdapter);
	return view;
}
}
