package totoo.touhou;

import totoo.touhou.gameview.ContorlView;
import totoo.touhou.gameview.FunctionButtonView;
import totoo.touhou.gameview.GameWorld;
import totoo.touhou.gameview.ShowHeathView;
import util.Constrant;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.totoo.touhou.R;

public class FullscreenActivity extends Activity implements OnGestureListener,
		View.OnClickListener {
	// static Button b_up, b_down, b_left, b_right, b_ss, b_ws, b_f, b_a,
	// b_sc1,b_sc2;
	// static Canvas GameCan = null;
	static int TouchX = -1;
	static int TouchY = -1;
	// public static int SW = 480;
	// public static int SH = 768;
	// public static final Double UITpersent = 0.25;
	// public static final Double UIpersent2 = 0.2;
	// public static final int StepLength = 34;
	// public static int EarthLine = (int) (SH * 0.62);
	// static int TouchArceH = (int) (SH * UITpersent);
	// static int TouchArceW = (int) (SW * UITpersent);
	// static int LeftDivede = (int) (SW * UITpersent);
	// static int RightDivede = (int) (SW * UITpersent * 3);
	// static int HighDivede = (int) (SH * UIpersent2);
	// static int MiddleDivede = (int) (SH * UIpersent2 * 2);
	// static int Center = (int) (SH * 0.8);
	// static int LowDivede = (int) (SH * UIpersent2 * 3);
	DisplayMetrics dm;
	static GameWorld gv = null;
	static ShowHeathView shv = null;
	ContorlView cv;
	Button viewFight, viewFly, viewS1, viewS2, viewSS, viewSW;

	int count = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initGameSource();
		// gv = new GameView(this);

		setContentView(R.layout.activity_fullscreen);
		viewFight = (Button) findViewById(R.id.attack_functionButtonView);
		viewFly = (Button) findViewById(R.id.fly_functionButtonView);
		viewS1 = (Button) findViewById(R.id.spellWeek_functionButtonView);
		viewS2 = (Button) findViewById(R.id.spellStrong_functionButtonView);
		viewSS = (Button) findViewById(R.id.shoot_functionButtonView);
		viewSW = (Button) findViewById(R.id.weekShoot_functionButtonView);
		viewFight.setOnClickListener(this);
		viewFly.setOnClickListener(this);
		viewS1.setOnClickListener(this);
		viewS2.setOnClickListener(this);
		viewSS.setOnClickListener(this);
		viewSW.setOnClickListener(this);

		// b_up = (Button) findViewById(R.id.bUP);
		// b_down = (Button) findViewById(R.id.bDown);
		// b_left = (Button) findViewById(R.id.bLeft);
		// b_right = (Button) findViewById(R.id.bRight);
		// b_ss = (Button) findViewById(R.id.bS);
		// b_ws = (Button) findViewById(R.id.bW);
		// b_f = (Button) findViewById(R.id.bF);
		// b_a = (Button) findViewById(R.id.bA);
		// b_sc1 = (Button) findViewById(R.id.bSC);
		// b_sc2 = (Button) findViewById(R.id.bSC2);
		// b_up.setOnClickListener(this);
		// b_down.setOnClickListener(this);
		// b_left.setOnClickListener(this);
		// b_right.setOnClickListener(this);
		// b_ss.setOnClickListener(this);
		// b_ws.setOnClickListener(this);
		// b_f.setOnClickListener(this);
		// b_a.setOnClickListener(this);
		// b_sc1.setOnClickListener(this);
		// b_sc2.setOnClickListener(this);
		// initUI();
		mContext = this;
		exitFlag = true;
		gv = (GameWorld) findViewById(R.id.gameView1);
		shv = (ShowHeathView) findViewById(R.id.showHeathView1);
		cv = (ContorlView) findViewById(R.id.contorlView1);
		new Thread(new Runnable() {

			public void run() {// ͼ�񾀳�
				while (exitFlag) {
					try {
						if (Constrant.playerHeath > 100)
							Constrant.playerHeath = 0;
						else if (Constrant.playerHeath < 0) {
							count--;
							if (count < 1) {
								handler.sendEmptyMessage(0);
								exitFlag = false;
							}
							Constrant.playerHeath = 100;
						}
						// Constrant.playerHeath++;
						Thread.sleep(50);
					} catch (Exception e) {
						Thread.currentThread().interrupt();
					}
					gv.postInvalidate();
					shv.postInvalidate();
					cv.postInvalidate();
					viewFight.postInvalidate();
					viewFly.postInvalidate();
					viewS1.postInvalidate();
					viewS2.postInvalidate();
					viewSS.postInvalidate();
					viewSW.postInvalidate();
				}
			}
		}).start();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		exitFlag = false;
		super.onDestroy();
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			Builder builder = new Builder(FullscreenActivity.this);
			builder.setTitle("游戏结束");
			builder.setMessage("躲避失败，练习到此为止");
			builder.setPositiveButton("鸣金",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface arg0, int arg1) {
							// TODO Auto-generated method stub
							finish();
						}
					});
			builder.show();
		};
	};

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		// if (arg0.getId() == R.id.bUP || arg0.getId() == R.id.bDown
		// || arg0.getId() == R.id.bLeft || arg0.getId() == R.id.bRight) {
		// if (goStreet)
		// goStreet = false;
		// else
		// goStreet = true;
		// }
		if (((FunctionButtonView) arg0).countTime > 99) {
			// ((FunctionButtonView)arg0).flashFlag=true;
		}

		((FunctionButtonView) arg0).countTime = 0;
		switch (arg0.getId()) {

		case R.id.attack_functionButtonView:

			break;
		case R.id.fly_functionButtonView:
			Constrant.SpeedTimes = 40;
			break;
		case R.id.shoot_functionButtonView:

			break;
		case R.id.spellStrong_functionButtonView:

			break;
		case R.id.spellWeek_functionButtonView:

			break;
		case R.id.weekShoot_functionButtonView:

			break;
		// case R.id.bUP:
		// Ymove = -1;
		// Xmove = 0;
		// break;
		//
		// case R.id.bDown:
		// Ymove = 1;
		// Xmove = 0;
		// break;
		//
		// case R.id.bLeft:
		// Ymove = 0;
		// Xmove = -1;
		// break;
		//
		// case R.id.bRight:
		// Ymove = 0;
		// Xmove = 1;
		// break;

		// case R.id.bS:
		//
		// break;
		//
		// case R.id.bW:
		//
		// break;
		//
		// case R.id.bF:
		//
		// break;
		//
		// case R.id.bA:
		//
		// break;
		//
		// case R.id.bSC:
		//
		// break;
		//
		// case R.id.bSC2:
		//
		// break;

		default:
			break;
		}
	}

	// private void initUI() {// ����ϵ�y
	// handler.post(thread);
	// }

	// boolean TouchArce() {// �օ^��׽ϵ�y
	//
	// }
	//
	// return false;
	// }

	private void A() {

	}

	private void SC2() {

	}

	private void SC1() {

	}

	private void PU() {
		// molisha.setDescription(3);// ����
		// mapCache = molisha.moveUp(WorldMap, MapBodderX, MapBodderY);
		// comfrimMap();
		Constrant.YmoveDes = -1;
		if (goStreet)
			Constrant.XmoveDes = 0;
	}

	private void PD() {
		// molisha.setDescription(1);// ����
		// mapCache = molisha.moveDown(WorldMap, MapBodderX, MapBodderY);
		// comfrimMap();
		Constrant.YmoveDes = 1;
		if (goStreet)
			Constrant.XmoveDes = 0;
	}

	private void PL() {
		// molisha.setDescription(2);// ����
		//
		// mapCache = molisha.moveLeft(WorldMap, MapBodderX, MapBodderY);
		// comfrimMap();
		Constrant.XmoveDes = -1;
		if (goStreet)
			Constrant.YmoveDes = 0;
	}

	private void PR() {
		// molisha.setDescription(0);// ����
		// mapCache = molisha.moveRight(WorldMap, MapBodderX, MapBodderY);
		// comfrimMap();

		Constrant.XmoveDes = 1;
		if (goStreet)
			Constrant.YmoveDes = 0;
	}

	private void PF() {

	}

	private void WSA() {

	}

	private void SSA() {

	}

	static boolean exitFlag;
	public static boolean goStreet = false;
	public static Context mContext;

	private void initGameSource() {// ��ʼ���[���YԴ
		dm = new DisplayMetrics();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		Constrant.SH = dm.heightPixels;
		Constrant.SW = dm.widthPixels;
		Constrant.EarthLine = (int) (Constrant.SH * 0.62);
		Constrant.Center = (int) (Constrant.SH * 0.7);
		Constrant.TouchArceH = (int) (Constrant.SH * Constrant.UITpersent);
		Constrant.TouchArceW = (int) (Constrant.SW * Constrant.UITpersent);
		Constrant.LeftDivede = (int) (Constrant.SW * Constrant.UITpersent2 * 4);
		Constrant.RightDivede = (int) (Constrant.SW * Constrant.UITpersent2 * 6);
		Constrant.HighDivede = (int) (Constrant.SH * Constrant.UIpersent2);
		Constrant.MiddleDivede = (int) (Constrant.SH * Constrant.UIpersent2 * 2);
		Constrant.Center = (int) (Constrant.SH * 0.8);
		Constrant.LowDivede = (int) (Constrant.SH * Constrant.UIpersent2 * 3);
		// MapBodderX = (int) SW / 4;
		// MapBodderY = (int) SH / 4;
		// WorldMap = new int[MapBodderX][MapBodderY];
		Constrant.drawSome = new Paint();
		Constrant.drawSome.setColor(Color.RED);
		Constrant.drawSome.setTextSize(59);
		// tagetXY=new int[]{0,0};
		Constrant.startBarDivedeX = (int) (Constrant.SW * 0.5 - Constrant.SW
				* Constrant.startBarDivedeX_Weight * 0.5 * 0.01);
	}

	// void comfrimMap() {// ���µ؈D���
	// if (null != mapCache) {
	// WorldMap = mapCache;
	// }
	// }

	// boolean PressKey(int x, int y) {// ���I푑�
	//
	// // handler.removeCallbacks(thread);
	// // handler.post(thread);
	// return false;
	// }

	private void tz(String str) {
		Constrant.AlretString = str;
		Constrant.drawSome.setColor(Color.WHITE);
	}

	public boolean onDown(MotionEvent e) {
		return false;
	}

	void ShootTip(String str) {
		Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		return false;
	}

	public void onLongPress(MotionEvent e) {
	}

	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		return false;
	}

	public void onShowPress(MotionEvent e) {

	}

	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}

	public boolean onTouchEvent(MotionEvent event) {// ���²�׽
		// int ia = event.getAction();
		// try {
		// Thread.sleep(20);
		// } catch (Exception e) {
		// }
		Constrant.SpeedTimes = 3;
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			goStreet = true;
			// Constrant.XmoveDes = 0;
			// Constrant.YmoveDes = 0;
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			Constrant.creatrues[0].moveFlag = false;
			break;
		case MotionEvent.ACTION_POINTER_UP:
			Constrant.creatrues[0].moveFlag = true;

			break;
		default:
			goStreet = false;
			break;
		}
		TouchX = (int) event.getX();
		TouchY = (int) event.getY();
		if (TouchX < Constrant.LeftDivede) {// �ұ�
			if (TouchY < Constrant.HighDivede) {// �����
				tz("�����");
				SSA();
			} else if (TouchY < Constrant.MiddleDivede) {// �����
				tz("�����");
				WSA();
			} else if (TouchY < Constrant.LowDivede) {// �w���I
				tz("�w���I");
				PF();
			} else {// ����
				tz("����");
				PL();
			}
		} else if (TouchX < Constrant.RightDivede) {// �м�
			if (TouchY > Constrant.Center) {// ����
				tz("����");
				PD();
			} else {// ����
				tz("����");
				PU();
			}
		} else {// ���

			if (TouchY < Constrant.HighDivede) {// ��1
				tz("��1");
				SC1();
			} else if (TouchY < Constrant.MiddleDivede) {// ��2
				tz("��2");
				SC2();
			} else if (TouchY < Constrant.LowDivede) {// ����
				tz("����");
				A();
			} else {// ����
				tz("����");
				PR();
			}
		}
		return super.onTouchEvent(event);
	}

	// static Handler handler = new Handler();
	// static Thread thread =
}
