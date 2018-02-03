package totoo.touhou.gameview;

import util.Constrant;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ContorlView extends View {
	int CircleCenter = 120;
	double TouchX;
	double TouchY;

	public ContorlView(Context context, AttributeSet attrs) {
		super(context, attrs);
		p = new Paint();
		// TODO Auto-generated constructor stub
	}

	private Paint p;
	private int targetX;
	private int targetY;
	int pointX;
	int pointY;
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub

		super.onDraw(canvas);
		CircleCenter = ContorlView.this.getWidth() / 2;
		pointX=(int) (TouchX + CircleCenter);
		pointY=(int) (TouchY + CircleCenter);
		p.setColor(Color.YELLOW);
		p.setAlpha(100);
		p.setStrokeWidth(20);
		canvas.drawCircle(CircleCenter, CircleCenter, 120, p);
		// canvas.drawCircle(CircleCenter, CircleCenter, 70, p);
		p.setColor(Color.BLACK);
		p.setAlpha(80);
		p.setStrokeWidth(20);
		canvas.drawCircle(CircleCenter, CircleCenter, 100, p);
		p.setColor(Color.WHITE);
		// p.setAlpha(100);
		// p.setStrokeWidth(20);
		canvas.drawCircle(CircleCenter, CircleCenter, 50, p);
		p.setColor(Color.BLACK);
		p.setAlpha(100);
		p.setStrokeWidth(5);
		canvas.drawLine(CircleCenter, CircleCenter - 10, CircleCenter,
				CircleCenter + 10, p);
		canvas.drawLine(CircleCenter - 10, CircleCenter, CircleCenter + 10,
				CircleCenter, p);

		// ��������ʾ
		p.setColor(Color.RED);
		// p.setAlpha(30);
		// p.setStrokeWidth(20);
		canvas.drawCircle(pointX, pointY, 40, p);
		//
		p.setColor(Color.BLACK);
		// p.setAlpha(90);
		// p.setStrokeWidth(20);
		canvas.drawCircle(pointX,pointY, 30, p);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub

		TouchX = event.getX() - CircleCenter;
		TouchY = event.getY() - CircleCenter;
		Constrant.XmoveDes= 3.0*TouchX /CircleCenter;
		Constrant.YmoveDes  =3.0* TouchY /CircleCenter;

		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:
			// goStreet = true;
			Constrant.XmoveDes = 0;
			Constrant.YmoveDes = 0;
			TouchX = 0;
			TouchY = 0;
			

			break;
//		case MotionEvent.ACTION_DOWN:
//			Constrant.creatrues[0].moveFlag = true;
//			break;
//		case MotionEvent.ACTION_POINTER_UP:
//			Constrant.creatrues[0].moveFlag = false;
//			break;
		default:
			// goStreet = false;
			break;
		}
		return true;// super.onTouchEvent(event);
	}
}
