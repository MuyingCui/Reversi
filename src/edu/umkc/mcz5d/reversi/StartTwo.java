package edu.umkc.mcz5d.reversi;


import java.io.File;

import android.app.Activity;
import android.graphics.Bitmap;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;



public class StartTwo extends Activity{
	private static final String TAG = "Reversi";
	private GameViewTwo two;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
		
		Display display = getWindowManager().getDefaultDisplay();
		GameViewTwo.init(this, display.getWidth(), display.getHeight());
		two = GameViewTwo.getInstance();

		
		
		setContentView(two);

		two.requestFocus();
	}
	

	@Override
	protected void onDestroy(){
		
		super.onDestroy();	
		Log.d(TAG, "Two Activity:onDestroy");

	}

}
