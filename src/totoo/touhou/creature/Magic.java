package totoo.touhou.creature;

import totoo.touhou.FullscreenActivity;
import util.Constrant;
import android.graphics.Bitmap;
import android.widget.Toast;

public class Magic extends Things_MoveAble {
	public Magic(int x, int y, Bitmap Image) {
		slowXinScreen = x;
		slowYinScreen = y;
		Img = Image;
		showFlag = false;
		// TODO Auto-generated constructor stub
	}

	//
	// String ID;
	// String Name;
	// Long Time;
	Long Strenth;
	private int XgetDescription;
	private int YgetDescription;
	// int SpeedInX;
	// int SpeedInY;
	// int XinMap;
	// int YinMap;
	Hero moveAble;

	@Override
	public int[] move() {
		// TODO Auto-generated method stub xTotal = VH.SW - 100;
		if (this.type == 3 || this.type == 4 || this.type == 5)
			moveAble = Constrant.reimei;
		else if (this.type == 0 || this.type == 1 || this.type == 2)
			moveAble = Constrant.molisha;
		// if (FullscreenActivity.goStreet)
		// move_step = 10;
		// else
		// move_step = 20;
		if (null != moveAble) {
			if (slowXinScreen < moveAble.slowXinScreen)
				XgetDescription = 1;
			else
				XgetDescription = -1;
			// if (Xcontact())
			if (slowYinScreen < moveAble.slowYinScreen)
				YgetDescription = 1;
			else
				YgetDescription = -1;
			// if (Ycontact())
			slowXinScreen += 2.0 * move_step * XgetDescription;
			slowYinScreen += 2.0 * move_step * YgetDescription;
			//

			// count++;
			// if(count>20){
			// count=0;
			if (Xcontact())
				Constrant.playerHeath -= 1;
			// Toast.makeText(FullscreenActivity.mContext, "碰撞", 0).show();
			// }
		}
		return null;
	}

	int count = 0;
	double picWidth;
	double picHeight;

	@Override
	public boolean Xcontact() {
		// TODO Auto-generated method stub
		if (this.type == 3 || this.type == 4 || this.type == 5)
			moveAble = Constrant.reimei;

		else if (this.type == 0 || this.type == 1 || this.type == 2)

			moveAble = Constrant.molisha;
		picWidth = moveAble.Img.getWidth();
		picHeight = moveAble.Img.getHeight();
		if (null != moveAble) {
			if (slowXinScreen+Img.getWidth() > moveAble.slowXinScreen+picWidth&&slowXinScreen < moveAble.slowXinScreen + picWidth) {
				if (slowYinScreen+Img.getHeight() > moveAble.slowYinScreen+picHeight&&slowYinScreen < moveAble.slowYinScreen + picHeight) {
					return true;
				} else if (slowYinScreen < moveAble.slowYinScreen &&slowYinScreen+Img.getHeight() > moveAble.slowYinScreen ) {
					return true;
				}
			}else if(slowXinScreen<moveAble.slowXinScreen&&slowXinScreen+Img.getWidth() > moveAble.slowXinScreen ){
				if (slowYinScreen+Img.getHeight() > moveAble.slowYinScreen+picHeight&&slowYinScreen < moveAble.slowYinScreen + picHeight) {
					return true;
				} else if (slowYinScreen < moveAble.slowYinScreen &&slowYinScreen+Img.getHeight() > moveAble.slowYinScreen ) {
					return true;
				}
			}
			
		}
		return false;
	}

	@Override
	public boolean Ycontact() {
		// TODO Auto-generated method stub
		return super.Ycontact();
	}
}
