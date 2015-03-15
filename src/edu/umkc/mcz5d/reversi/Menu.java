package edu.umkc.mcz5d.reversi;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class Menu extends ActionBarActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		View button_single = findViewById(R.id.button_viewScore);
		button_single.setOnClickListener(this);
		View button_setting = findViewById(R.id.button_share);
		button_setting.setOnClickListener(this);
	}

	

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		 case R.id.button_viewScore:
			 Intent h = new Intent(this, ViewScore.class);
			 startActivity(h);
		 break;
		 case R.id.button_share:
			 shareIt();
		 break;

		}
		
	}
	
	private void shareIt(){
		Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
		sharingIntent.setType("text/plain");
		String shareBody = "Here is the share content body";
		startActivity(Intent.createChooser(sharingIntent, "Share via"));
	}
}
