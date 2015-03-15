package edu.umkc.mcz5d.reversi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class DrawScore extends SurfaceView implements SurfaceHolder.Callback,
		Runnable {

	SurfaceHolder mySurfaceHolder = null;
	float width = getWidth();
	float height = getHeight();
	static DrawScore instance = null;
	Thread t;
	Context context;
	private ScreenshotFile sf;

	public DrawScore(Activity a, float screenWidth, float screenHeight) {
		super(a);
		context = a;
		width = screenWidth;
		height = screenHeight;
		mySurfaceHolder = this.getHolder();
		mySurfaceHolder.addCallback(this);

		setFocusable(true);
		setFocusableInTouchMode(true);

	}

	public static DrawScore getInstance() {
		return instance;
	}

	public static void init(Activity myA, int screenWidth, int screenHeight) {
		instance = new DrawScore(myA, screenWidth, screenHeight);
	}

	public void draw(View v) {
		// Draw the board
		Paint paintBoard;
		paintBoard = new Paint();
		paintBoard.setColor(getResources().getColor(R.color.black));
		paintBoard.setStyle(Paint.Style.FILL_AND_STROKE);

		Canvas c = new Canvas();
		Bitmap b;
		b = sf.getScreenshot(context, v);
		c.drawBitmap(b, 0, 0, paintBoard);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (mySurfaceHolder) {
			Canvas canvas = mySurfaceHolder.lockCanvas();

			draw(canvas);
			mySurfaceHolder.unlockCanvasAndPost(canvas);
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

	}
}
