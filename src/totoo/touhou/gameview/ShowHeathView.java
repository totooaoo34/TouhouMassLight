package totoo.touhou.gameview;

import util.Constrant;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ShowHeathView extends View {

	Paint p;

	public ShowHeathView(Context context, AttributeSet attrs) {
		super(context, attrs);
		p = new Paint();
		// TODO Auto-generated constructor stub
	}

	int ShowLine = 0;

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		ShowLine = (int) ((100 - Constrant.playerHeath) * Constrant.SH * 0.01);
		drawContorl(canvas);
	}

	public void drawContorl(Canvas canvas) {// ���ӽ����L�u
		Paint p = new Paint();
		p.setColor(Color.WHITE);
		p.setAntiAlias(true);
		p.setStyle(Paint.Style.STROKE);
		p.setAlpha(60);
		p.setTextSize(30);
		// canvas.drawText("���?��A", VH.RightDivede + Tip_Text_Padding,
		// VH.MiddleDivede + Tip_Text_Padding, p);
		canvas.drawLine(Constrant.LeftDivede, 0, Constrant.LeftDivede,
				Constrant.SH, p);
		// canvas.drawText("�����SS", 0 + Tip_Text_Padding, 0 + Tip_Text_Padding,
		// p);
		canvas.drawLine(Constrant.RightDivede, 0, Constrant.RightDivede,
				Constrant.SH, p);
		// canvas.drawText("�����WS", 0 + Tip_Text_Padding, VH.HighDivede
		// + Tip_Text_Padding, p);
		canvas.drawLine(0, Constrant.HighDivede, Constrant.LeftDivede,
				Constrant.HighDivede, p);
		// canvas.drawText("�w��F", 0 + Tip_Text_Padding, VH.MiddleDivede
		// + Tip_Text_Padding, p);
		canvas.drawLine(Constrant.RightDivede, Constrant.HighDivede,
				Constrant.SW, Constrant.HighDivede, p);
		// canvas.drawText("L����", 0, VH.LowDivede + Tip_Text_Padding, p);
		canvas.drawLine(0, Constrant.MiddleDivede, Constrant.LeftDivede,
				Constrant.MiddleDivede, p);
		// canvas.drawText("U����", VH.LeftDivede + Tip_Text_Padding,
		// 0 + Tip_Text_Padding, p);
		canvas.drawLine(Constrant.RightDivede, Constrant.MiddleDivede,
				Constrant.SW, Constrant.MiddleDivede, p);
		// canvas.drawText("D����", VH.LeftDivede + Tip_Text_Padding, VH.Center
		// + Tip_Text_Padding, p);
		canvas.drawLine(0, Constrant.LowDivede, Constrant.LeftDivede,
				Constrant.LowDivede, p);
		// canvas.drawText("�ҡ�R", 80 + VH.RightDivede + Tip_Text_Padding,
		// VH.LowDivede + Tip_Text_Padding, p);
		canvas.drawLine(Constrant.RightDivede, Constrant.LowDivede,
				Constrant.SW, Constrant.LowDivede, p);
		// canvas.drawText("��oSC1", VH.RightDivede + Tip_Text_Padding,
		// 0 + Tip_Text_Padding, p);
		canvas.drawLine(Constrant.LeftDivede, Constrant.Center,
				Constrant.RightDivede, Constrant.Center, p);
		// canvas.drawText("��pSC2", VH.RightDivede + Tip_Text_Padding,
		// VH.HighDivede + Tip_Text_Padding, p);
		// p.setColor(Color.RED);
		// p.setStrokeWidth(20);
		// p.setAlpha(80);
		// canvas.drawRect(VH.startBarDivedeX, ShowLine, VH.SW
		// - VH.startBarDivedeX, VH.SH, p);
		// p.setColor(Color.GRAY);
		// p.setStrokeWidth(20);
		// p.setAlpha(80);
		// canvas.drawRect(VH.startBarDivedeX, 0, VH.SW - VH.startBarDivedeX,
		// ShowLine, p);
//		ShowLine = (int) (Constrant.SH * 0.5);
		ShowLine = (int) ((100 - Constrant.playerHeath) * Constrant.SH * 0.01);
		p = new Paint();
		p.setColor(Color.WHITE);// ����ɫ
		 p.setStrokeWidth(20);
		 p.setAlpha(60);
		canvas.drawRect(0, 0, Constrant.SW, ShowLine, p);
		p.setColor(Color.RED);
		 p.setStrokeWidth(90);
		 p.setAlpha(90);
		canvas.drawRect(0, ShowLine, Constrant.SW, Constrant.SH
				* (1 - ShowLine), p);

	}

}
