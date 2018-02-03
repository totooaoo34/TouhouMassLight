package util;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicPlayer extends Service {
	private MediaPlayer MP;

	@Override
	public IBinder onBind(Intent arg0) {

		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		MP = MediaPlayer.create(this, null);
		MP.start();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
	}
}
