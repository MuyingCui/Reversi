package edu.umkc.mcz5d.reversi;


import java.io.File;

import android.app.Activity;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;



public class StartOne extends Activity{
	private static final String TAG = "Reversi";
	private GameViewOne one;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		
		Display display = getWindowManager().getDefaultDisplay();
		GameViewOne.init(this, display.getWidth(), display.getHeight());
		one = GameViewOne.getInstance();

		
		
		setContentView(one);

		one.requestFocus();
	}
	

	@Override
	protected void onDestroy(){
		
		super.onDestroy();	
		Log.d(TAG, "Two Activity:onDestroy");

	}

}
