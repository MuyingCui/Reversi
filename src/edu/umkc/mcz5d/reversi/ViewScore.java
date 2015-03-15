package edu.umkc.mcz5d.reversi;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

public class ViewScore extends ActionBarActivity {
	ScreenshotFile sf;
	DrawScore ds;
	private static final String TAG = "Reversi";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_score);
		Log.d(TAG, "onCreate");
		
		Display display = getWindowManager().getDefaultDisplay();
		DrawScore.init(this, display.getWidth(), display.getHeight());
		ds = DrawScore.getInstance();

		
		
		setContentView(ds);

		ds.requestFocus();
	}

	@Override
	protected void onDestroy(){
		
		super.onDestroy();	
		Log.d(TAG, "Two Activity:onDestroy");

	}
}
