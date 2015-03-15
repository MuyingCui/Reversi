package edu.umkc.mcz5d.reversi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		View button_single = findViewById(R.id.button_one);
		button_single.setOnClickListener(this);
		View button_two = findViewById(R.id.button_two);
		button_two.setOnClickListener(this);
		View button_risk = findViewById(R.id.button_menu);
		button_risk.setOnClickListener(this);
		View button_setting = findViewById(R.id.button_how);
		button_setting.setOnClickListener(this);

	}

	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.button_two:
			Intent i = new Intent(this, StartTwo.class);
			startActivity(i);
			break;
		 case R.id.button_one:
		 Intent j = new Intent(this, StartOne.class);
		 startActivity(j);
		 break;
		 case R.id.button_menu:
		 Intent k = new Intent(this, Menu.class);
		 startActivity(k);
		 break;
		 case R.id.button_how:
		 Intent h = new Intent(this, HowTo.class);
		 startActivity(h);
		 break;

		}
	}

}
