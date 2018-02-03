package util;

import java.util.List;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;

public class MapImgAdp extends BaseAdapter {
	Context context;
	List<Bitmap> list;

	public MapImgAdp(Context context, List<Bitmap> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@TargetApi(Build.VERSION_CODES.FROYO)
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		// LayoutParams params2 = new LayoutParams()
		// LayoutParams params = new
		// LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		// params.width = 40;
		// params.height = 40;
		// params.MATCH_PARENT;
		// params.
		ImageView view = new ImageView(context);
		// view.setLayoutParams(params);
		Bitmap bitmap = list.get(arg0);
		view.setImageBitmap(bitmap);
		// view.setImageMatrix(bitmap.get);
		return view;
	}

}
