package totoo.touhou.creature;

import android.graphics.Bitmap;

public class Things_MoveAble {
	public int slowXinScreen = 0;
	public int slowYinScreen = 0;
	public Bitmap Img = null;
	public int type = 0;
	public boolean moveFlag=true;
	public boolean showFlag=true;

	public final int move_step = 2;

	public int[] move() {
		return null;
	};

	public boolean Xcontact() {
		return false;
	};

	public boolean Ycontact() {
		return false;
	};

}
