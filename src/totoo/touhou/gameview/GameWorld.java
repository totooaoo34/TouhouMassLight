package totoo.touhou.gameview;

import totoo.touhou.creature.Hero;
import totoo.touhou.creature.Magic;
import totoo.touhou.creature.SuperShow;
import totoo.touhou.creature.Things_MoveAble;
import util.Constrant;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import com.totoo.touhou.R;

public class GameWorld extends View {
	static Bitmap PlayerImage;
	static Bitmap BossImage;
	static Bitmap bgPic;
	static Bitmap bigMagicPicA;
	static Bitmap bigMagicPicB;
	static Bitmap littleMagicPicA;
	static Bitmap littleMagicPicB;
	Canvas CMain = null;
	Bitmap bMap = null;
	Bitmap bSCmap = null;
	Paint paint=new Paint();

	public GameWorld(Context context, AttributeSet attrs) {
		// TODO Auto-generated constructor stub
		super(context, attrs); // {// �d���[��DƬ
		GameWorld.bgPic = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.map)).getBitmap();
		GameWorld.PlayerImage = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.pa)).getBitmap();
		GameWorld.BossImage = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.pb)).getBitmap();
		bigMagicPicA = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.viewab)).getBitmap();
		littleMagicPicA = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.viewa)).getBitmap();
		bigMagicPicB = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.viewbb)).getBitmap();
		littleMagicPicB = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.viewb)).getBitmap();

		Constrant.molisha = new Hero(40, 400, PlayerImage);
		Constrant.reimei = new Hero(320, 420, BossImage);
		Constrant.creatrues = new Things_MoveAble[] { null, null, null, null,
				null, null, null, null };
		Constrant.creatrues[0] = Constrant.molisha;
		Constrant.creatrues[0].type = -1;
		Constrant.creatrues[1] = Constrant.reimei;
		Constrant.creatrues[1].type = -2;
		Constrant.creatrues[2] = new Magic(0, 30, bigMagicPicA);// �����player2�Ĵ���
		Constrant.creatrues[2].type = 0;
//		Constrant.creatrues[2].showFlag=true;
		Constrant.creatrues[3] = new Magic(0, 100, littleMagicPicA);
		Constrant.creatrues[3].type = 1;
		Constrant.creatrues[3].showFlag=true;
		Constrant.creatrues[4] = new Magic(0, 300, littleMagicPicA);
		Constrant.creatrues[4].type = 2;
		Constrant.creatrues[5] = new Magic(350, 30, bigMagicPicB);// �����player1�Ĵ���
		Constrant.creatrues[5].type = 3;
		Constrant.creatrues[6] = new Magic(350, 100, littleMagicPicB);
		Constrant.creatrues[6].type = 4;
		Constrant.creatrues[7] = new Magic(350, 300, littleMagicPicB);
		Constrant.creatrues[7].type = 5;
		// Constrant.MSS = new SuperShow(Constrant.molisha,
		// Constrant.StepLength,
		// Constrant.MapBodderX, Constrant.MapBodderY);
		// Constrant.RSS = new SuperShow(Constrant.reimei, Constrant.StepLength,
		// Constrant.MapBodderX, Constrant.MapBodderY);
	}

	public GameWorld(Context context) {// ��ʼ�D���YԴ
		super(context);// private void initContorlUIPic()

		// VH.molisha.flashInMap(VH.WorldMap, VH.molisha.getXinMap() + 1,
		// VH.molisha.getYinMap() + 1, VH.MapBodderX, VH.MapBodderY);
		// VH.reimei.flashInMap(VH.WorldMap, VH.reimei.getXinMap() + 1,
		// VH.reimei.getYinMap() + 1, VH.MapBodderX, VH.MapBodderY);

	}

	int x;
	int y;

	private void drawCreatrues(Things_MoveAble moveAble, Canvas c) {
		// TODO Auto-generated method stub
		// switch (key) {
		// case value:
		//
		// break;
		//
		// default:
		// break;
		// }
		if (moveAble.showFlag) {
			moveAble.move();
			drawImage(c, moveAble.Img, moveAble.slowXinScreen,
					moveAble.slowYinScreen);
		}
		// drawImage(c, Img, x - VH.StepLength / 2, y);
//		Paint p = new Paint();
//		p.setColor(Color.WHITE);
//		p.setTextSize(15);
//		x = moveAble.slowXinScreen - Tip_Text_Padding;
//		y = moveAble.slowYinScreen - Tip_Text_Padding;
		// c.drawText("x: " + moveAble.slowXinScreen + " y: "
		// + moveAble.slowYinScreen, x, y, p);

	}

	@Override
	protected void onDraw(Canvas canvas) {// ��Ҫ����
		drawBG(canvas);

		paint.setColor(Color.YELLOW);
		canvas.drawRect(
				Constrant.creatrues[0].slowXinScreen, Constrant.creatrues[0].slowYinScreen
				,Constrant.creatrues[0].slowXinScreen+Constrant.creatrues[0].Img.getWidth()
				,Constrant.creatrues[0].slowYinScreen+Constrant.creatrues[0].Img.getHeight()
				,paint);
		paint.setColor(Color.RED);
		canvas.drawRect(
				Constrant.creatrues[1].slowXinScreen, Constrant.creatrues[1].slowYinScreen
				,Constrant.creatrues[1].slowXinScreen+Constrant.creatrues[1].Img.getWidth()
				,Constrant.creatrues[1].slowYinScreen+Constrant.creatrues[1].Img.getHeight()
				,paint);
		for (int i = Constrant.creatrues.length; i > 0; i--)

			drawCreatrues(Constrant.creatrues[i - 1], canvas);

		//
		// drawPlayer(canvas, VH.molisha, PlayerImage, VH.MSS);
		// // drawPlayer(canvas, VH.reimei, BossImage, VH.RSS);
		// drawBoss(canvas, VH.reimei, BossImage);
		// // drawMap(canvas);

	}

	// boolean drawMap(Canvas canvas) {// �[���=��L�u
	// // GameCan = canvas;
	// for (int i = 0; i < MapBodderX; i++) {
	// for (int j = 0; j < MapBodderY; j++) {
	// if (0 != WorldMap[i][j])
	// canvas.drawText("" + WorldMap[i][j], i * StepLength, j
	// * StepLength, drawSome);
	// }
	// }
	// return false;
	// }

	// public void drawPlayer(Canvas c, Hero h, Bitmap Img, SuperShow SS) {
	// // ���ݔ��
	//
	// drawImage(c, Img, h.slowXinScreen, h.slowYinScreen);
	// // drawImage(c, Img, x - VH.StepLength / 2, y);
	// Paint p = new Paint();
	// p.setColor(Color.WHITE);
	// p.setTextSize(15);
	// x = h.slowXinScreen - Tip_Text_Padding;
	// y = h.slowYinScreen - Tip_Text_Padding;
	// c.drawText("x: " + h.slowXinScreen + " y: " + h.slowYinScreen, x, y, p);
	//
	// }
	//
	// private void drawBoss(Canvas canvas, Hero reimei, Bitmap bossImage2) {
	// // TODO Auto-generated method stub
	// drawImage(canvas, bossImage2, reimei.slowXinScreen,
	// reimei.slowYinScreen);
	// }

	final int Tip_Text_Padding = 30;

	void drawImage(Canvas c, Bitmap b, int x, int y) {
		c.drawBitmap(b, x, y, null);
	}

	boolean drawBG(Canvas canvas) {// ���Ӿ��L�u
		canvas.drawColor(Color.DKGRAY);
		drawImage(canvas, bgPic, 0, 0);
		// if (null != Constrant.AlretString)
		//
		// canvas.drawText(Constrant.AlretString, Constrant.SW / 2 - 60, 400,
		// Constrant.drawSome);
		return false;
	}
}