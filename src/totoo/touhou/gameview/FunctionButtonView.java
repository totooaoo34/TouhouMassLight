package totoo.touhou.gameview;

import com.totoo.touhou.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class FunctionButtonView extends Button {
	private Bitmap bitmap;
	Paint paint;
	public int countTime = 0;
	String[] functions = { "attack", "fly", "spell", "__spell", "shoot",
			"__shoot" };
	private float width;
	private float height;
	public boolean flashFlag = true;
	static Bitmap[] buttonIcon = {};

	public FunctionButtonView(Context context, AttributeSet attrs) {
		super(context, attrs);
		buttonIcon = new Bitmap[] {

				((BitmapDrawable) getResources().getDrawable(R.drawable.ba))
						.getBitmap(),
				((BitmapDrawable) getResources().getDrawable(R.drawable.bf))
						.getBitmap(),
				((BitmapDrawable) getResources().getDrawable(R.drawable.bw))
						.getBitmap(),
				((BitmapDrawable) getResources().getDrawable(R.drawable.bs))
						.getBitmap(),
				((BitmapDrawable) getResources().getDrawable(R.drawable.bss))
						.getBitmap(),
				((BitmapDrawable) getResources().getDrawable(R.drawable.bws))
						.getBitmap() };
		String attributeValue = attrs.getAttributeValue(null, "functionID");

		bitmap = buttonIcon[0];
		int count = 0;
		for (String word : functions) {
			if (word.equals(attributeValue))
				bitmap = buttonIcon[count];
			count++;
		}
		paint = new Paint();
		paint.setStrokeWidth(20);
		// width = FunctionButtonView.this.getWidth();
		// height = FunctionButtonView.this.getHeight();
		// TODO Auto-generated constructor stub
	}

	public FunctionButtonView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		paint.setColor(Color.WHITE);
		paint.setAlpha(90);
		paint.setStrokeWidth(20);
		canvas.drawRect(0, 0, FunctionButtonView.this.getWidth(),
				FunctionButtonView.this.getHeight(), paint);
		paint.setColor(Color.BLACK);
		paint.setAlpha(100);
		paint.setStrokeWidth(20);
		canvas.drawRect(10, 10, FunctionButtonView.this.getWidth() - 10,
				FunctionButtonView.this.getHeight() - 10, paint);
		canvas.drawBitmap(bitmap, FunctionButtonView.this.getWidth() / 2
				- bitmap.getWidth() / 2, FunctionButtonView.this.getHeight()
				/ 2 - bitmap.getHeight() / 2, paint);

		if (countTime < 100) {
			if(!flashFlag )
			flashFlag = true;
			countTime += 2;
		} else
			flashFlag = false;
		paint.setColor(Color.YELLOW);
		paint.setAlpha(80);
		canvas.drawRect(10, 10, FunctionButtonView.this.getWidth() - 10,
				(float) (0.01 * countTime * (FunctionButtonView.this
						.getHeight() - 10)), paint);
	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		// TODO Auto-generated method stub
//
//		return true;
//	}
}
