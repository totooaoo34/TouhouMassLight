package totoo.touhou.creature;

public class SuperShow {
	public static final int SlowLenth = 4;
	int dscr;
	int xSlow;
	int ySlow;
	int StepLength;
	int tagetX;
	int tagetY;
	int FlagSpell;
	public int XMoveMark;
	public int YMoveMark;
	int[] tagetXY;

	public SuperShow(Hero h, int stp, int bdX, int bdY) {
		StepLength = stp;
		// xSlow = h.getXinMap() * StepLength;
		// ySlow = h.getYinMap() * StepLength;
		tagetXY = new int[] { 0, 0 };
	}

	//
	// public int[] slowMove(Hero h) {
	//
	// dscr = h.getDescription();
	// if (-1 != dscr)
	// switch (dscr) {
	// case 0:
	// xSlow += SlowLenth;// ����
	// break;
	// case 1:
	// ySlow += SlowLenth;// ����
	// break;
	// case 2:
	// xSlow -= SlowLenth;// ����
	// break;
	// case 3:
	// ySlow -= SlowLenth;// ����
	// break;
	// }
	// XMoveMark = xSlow - h.getXinMap() * SlowLenth;
	// YMoveMark = ySlow - h.getYinMap() * SlowLenth;
	//
	// if (0 < XMoveMark)
	// FlagSpell = -1;
	// else
	// FlagSpell = 1;
	//
	// if (XMoveMark > StepLength || XMoveMark < -StepLength)
	// tagetX = h.getXinMap() + FlagSpell;
	//
	// if (0 < YMoveMark)
	// FlagSpell = -1;
	// else
	// FlagSpell = 1;
	//
	// if (YMoveMark > SlowLenth || YMoveMark < StepLength)
	// tagetY = h.getYinMap() + (-1) ^ YMoveMark;
	// tagetXY[0] = tagetX;
	// tagetXY[1] = tagetY;
	// // if (0 < XMoveMark) {
	// // if (0 < YMoveMark) {// ���·�
	// //
	// // } else if (0 == YMoveMark) {// ���ҷ�
	// //
	// // } else {// ���Ϸ�
	// //
	// // }
	// // } else if (0 == XMoveMark) {
	// // if (0 < YMoveMark) {// ���Ϸ�
	// //
	// // } else if (0 == YMoveMark) {// �oֹ
	// //
	// // } else {// ���·�
	// //
	// // }
	// // } else {
	// // if (0 < YMoveMark) {// ���·�
	// //
	// // } else if (0 == YMoveMark) {// ����
	// //
	// // } else {// ���Ϸ�
	// //
	// // }
	// // }
	// return tagetXY;
	// }

	public int getxSlow() {
		return xSlow;
	}

	public void setxSlow(int xSlow) {
		this.xSlow = xSlow;
	}

	public int getySlow() {
		return ySlow;
	}

	public void setySlow(int ySlow) {
		this.ySlow = ySlow;
	}

	public int getDscr() {
		return dscr;
	}

	public void setDscr(int dscr) {
		this.dscr = dscr;
	}

	public int getTagetX() {
		return tagetX;
	}

	public void setTagetX(int tagetX) {
		this.tagetX = tagetX;
	}

	public int getTagetY(){
		return tagetY;
	}

	public void setTagetY(int tagetY) {
		this.tagetY = tagetY;
	}

}
