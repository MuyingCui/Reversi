package edu.umkc.mcz5d.reversi;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.os.Build;

public class HowTo extends YouTubeBaseActivity implements OnInitializedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_how_to);
//		View btnvideo = findViewById(R.id.button_one);
		YouTubePlayerView youTubeView = (YouTubePlayerView) 
                findViewById(R.id.videoView1);
		youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
		
		
	}


	public class DeveloperKey {
	       /**
	       * Please replace this with a valid API key which is enabled for the 
	       * YouTube Data API v3 service. Go to the 
	       * <a href=”https://code.google.com/apis/console/“>Google APIs Console</a> to
	       * register a new developer key.
	       */
	       public static final String DEVELOPER_KEY = "AIzaSyBMbprQjao3eD2fe9P73BUbF-nLS3zjB2U"; 
	}
	
	@Override
	public void onInitializationSuccess(YouTubePlayer.Provider provider, 
	             YouTubePlayer player, boolean wasRestored) {
	         if (!wasRestored){
	        	 player.cueVideo("Ol3Id7xYsY4"); // the video to play
	         }
	}
	
	@Override
	public void onInitializationFailure(Provider arg0, 
	            YouTubeInitializationResult arg1){
		
		Toast.makeText(getApplicationContext(), "onInitiaizationFaliure()"+" "+arg1.toString() + " ",Toast.LENGTH_LONG).show();
	}
	
	
}
