package totoo.touhou.creature;

import totoo.touhou.FullscreenActivity;
import util.Constrant;
import android.graphics.Bitmap;

public class Hero extends Things_MoveAble {
	public static int XgetDescription = 1;
	public static int YgetDescription = 1;
	// String ID;
	// String Name;
	// Long Heath;
	// Long Strenth;
	static boolean godMode;

	public Hero(int x, int y, Bitmap Image) {
		slowXinScreen = x;
		slowYinScreen = y;
		Img = Image;
	}

	int targetX;
	int targetY;
//	private double times;

	@Override
	public int[] move() {
		// TODO Auto-generated method stub xUse = h.slowXinScreen;

		if (this.type == -1) {
		} else if (this.type == -2) {
			moveFlag = false;
		}
		xTotal = Constrant.SW - 100;
		yTotal = Constrant.SH - 100;
		targetX = (int) (slowXinScreen + move_step * Constrant.XmoveDes);
		targetY = (int) (slowYinScreen + move_step * Constrant.YmoveDes);
//		if ((targetX > -1) && (targetX <= xTotal)) {
//			if ((targetY > -1) && (targetY <= yTotal)) {
//				// if (Hero.this == Constrant.molisha) {
//				//
//				// this.moveFlag = true;
//				// } else {
//				// }
//			}
//
//		} else {
			if ((targetX < -50) || (targetX >= Constrant.SW)) {
				if ((targetY < -50) || (targetY >= Constrant.SH)) {
					// if (Hero.this == Constrant.molisha) {
					//
					// this.moveFlag = true;
					// } else {
					// }
					slowXinScreen = (int) (Constrant.SW / 2.0);
					slowYinScreen = (int) (Constrant.SH / 2.0);
				}

			} else {
				if (slowYinScreen < 0) {
					// if (targetY > 0) moveFlag = true;
					Constrant.YmoveDes = 1;
				}
				if (slowYinScreen > yTotal) {
					// if (targetY < yTotal) moveFlag = true;
					Constrant.YmoveDes = -1;
				}
				if (slowXinScreen < 0) {
					// if (targetX > 0) moveFlag = true;
					Constrant.XmoveDes = 1;
				}
				if (slowXinScreen > xTotal) {
					// if (targetX < xTotal) moveFlag = true;
					Constrant.XmoveDes = -1;
				}

				// moveFlag = false;

			}
//		}
		if (!FullscreenActivity.goStreet)
			Constrant.SpeedTimes = 2.5;
//		else
//			Constrant.SpeedTimes = 2;
		if (moveFlag) {
			slowXinScreen += Constrant.SpeedTimes * move_step * Constrant.XmoveDes;
			slowYinScreen += Constrant.SpeedTimes * move_step * Constrant.YmoveDes;

		}
		return null;
	}

	public int xTotal;
	public int yTotal;

	public Hero() {
	}

	public void attack() {
	}

	public void hurt() {
	}

	public int[][] moveRight(int[][] map, int bdx, int bdy) {
		// move(XinMap + 1, YinMap, bdx, bdy, map);
		return map;

	}

	public int[][] moveLeft(int[][] map, int bdx, int bdy) {
		// move(XinMap - 1, YinMap, bdx, bdy, map);
		return map;
	}

	public int[][] moveUp(int[][] map, int bdx, int bdy) {
		// move(XinMap, YinMap - 1, bdx, bdy, map);
		return map;
	}

	public int[][] moveDown(int[][] map, int bdx, int bdy) {

		// move(XinMap, YinMap + 1, bdx, bdy, map);
		return map;
	}

	public void useMagic(int[][] map) {
	}

	public boolean checkLocAva(int x, int y, int bodderX, int bodderY) {
		if (bodderX > x) {
			if (bodderY > y) {
				if (x > 0) {
					if (y > 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	boolean Contact(int[][] map, int tagetX, int tagetY) {
		if (0 == tagetX) {
			if (0 == tagetY)
				return true;
		}
		return false;
	}

	// public boolean move(int x, int y, int bdx, int bdy, int[][] map) {
	// flashInMap(map, x, y, bdx, bdy);
	// return godMode;
	//
	// }

	public int[][] flashInMap(int[][] map, int x, int y, int bdx, int bdy) {
		if (checkLocAva(x, y, bdx, bdy)) {
			if (!Contact(map, x, y)) {
				// map[XinMap][YinMap] = 0;// ����
				// map[XinMap][YinMap - 1] = 0;// ͷ
				// map[XinMap][YinMap + 1] = 0;// ����
				// map[XinMap - 1][YinMap] = 0;// ���
				// map[XinMap + 1][YinMap] = 0;// �Ҽ�
				// map[XinMap - 1][YinMap + 1] = 0;// ����
				// map[XinMap + 1][YinMap + 1] = 0;// ����
				//
				// map[XinMap - 1][YinMap + 2] = 0;// ���
				// map[XinMap + 1][YinMap + 2] = 0;// �ҽ�
				//
				// map[x][y] = 2;// ����
				// map[x][y - 1] = 1;// ͷ
				// map[x][y + 1] = 1;// ����
				// map[x - 1][y] = 1;// ���
				// map[x + 1][y] = 1;// �Ҽ�
				// map[x - 1][y + 1] = 1;// ����
				// map[x + 1][y + 1] = 1;// ����
				//
				// map[x - 1][y + 2] = 1;// ���
				// map[x + 1][y + 2] = 1;// �ҽ�
				// XinMap = x;
				// YinMap = y;
			}
		}
		return map;
	}

}