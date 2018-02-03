package totoo.touhou;

import util.Constrant;
import util.MapFragment;
import util.MapFragmentAdapter;

import com.totoo.touhou.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	Intent mi;
	Button b;
	Button bokA;
	Button bcA;
	Button bokB;
	Button bcB;
	GridView gridView;
	ViewPager viewPager;
	HorizontalScrollView hsv;
	RadioButton rb0;

	TextView line;
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_main);
		 bokA = (Button) findViewById(R.id.buttonA);
		 bcA = (Button) findViewById(R.id.CancelA);
		 bokB = (Button) findViewById(R.id.buttonB);
		 bcB = (Button) findViewById(R.id.CancelB);
		b = (Button) findViewById(R.id.button1);
		gridView= (GridView) findViewById(R.id.gridView1);
		rb0= (RadioButton) findViewById(R.id.radioButton0);
		viewPager= (ViewPager) findViewById(R.id.map_choces_ViewPager);
//		LinearLayout layout= (LinearLayout) findViewById(R.id.fragment_LinearLayout);
//		FragmentManager manager=getSupportFragmentManager();
//		FragmentTransaction beginTransaction = manager.beginTransaction();
//		beginTransaction.add(new MapFragment(), "fragment_LinearLayout");
//		beginTransaction.commit();
		mi = new Intent();
		Constrant.Count = 100;
		mi.setClass(MainActivity.this, FullscreenActivity.class);

		b.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				tz();
				startActivity(mi);
//				MainActivity.this.finish();
			}
		});
		bokA.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				chooseA();
			}
		});
		bcA.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				exitA();
			}
		});
		bokB.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				chooseB();
			}
		});
		bcB.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				exitB();
			}
		});

		MapFragmentAdapter adapter = new MapFragmentAdapter(
				MainActivity.this.getSupportFragmentManager());
		viewPager.setAdapter(adapter);
//
//		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
//
//			@Override
//			public void onPageSelected(int arg0) {
//				// TODO Auto-generated method stub
//
//			}
//
//			//
//			@Override
//			public void onPageScrolled(int arg0, //
//					float arg1, //
//					int arg2) {
//				int total = (int) ((arg0 + arg1) * rb0.getWidth());//
//				int green = (viewPager.getWidth() - rb0.getWidth()) / 2;//
//				int scroll = total - green;//
//				hsv.scrollTo(scroll, 0);//
//				tvMoveTo(arg0, arg1);
//			}
//
//			@Override
//			public void onPageScrollStateChanged(int index) {
//
//			}
//
//		});
	}

	protected void chooseA() {
		bokA.setText("完畢！");
	}

	protected void chooseB() {
		bokB.setText("完畢！");
	}

	protected void exitB() {
		bokB.setText("選擇B");

	}

	protected void exitA() {
		bokA.setText("選擇A");
	}

@SuppressLint("ShowToast")
	protected void tz() {
//		Toast.makeText(this, "通知已经弹射", 1).show();
	}
float fromX = 0;

private void tvMoveTo(int index, float f) {
	// TODO Auto-generated method stub
	float location = rb0.getWidth() * ((float) index + f);
	TranslateAnimation animation = new TranslateAnimation(fromX, location,
			0, 0);

	animation.setDuration(50);
	animation.setFillAfter(true);
	fromX = location;
	line.startAnimation(animation);
}

public void onCheckedChanged(RadioGroup arg0, int checkedId) {
	// TODO Auto-generated method stub
	switch (checkedId) {
	case R.id.radioButton0:
		viewPager.setCurrentItem(0);
		//
		break;

	case R.id.radioButton1:
		viewPager.setCurrentItem(1);
		//
		break;
	default:
		break;
	}
}

//	String adj = null;
//	if (VH.Count == VH.CountValueMax) {
//		adj = " 滿滿的 ";
//	} else if ((int) (VH.CountValueMax / 2) > VH.Count) {
//		adj = "幹勁十足的";
//	} else {
//		adj = "十分努力的";
//	}
}
