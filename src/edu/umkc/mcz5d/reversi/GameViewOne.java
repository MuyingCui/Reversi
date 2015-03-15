package edu.umkc.mcz5d.reversi;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.*;

public class GameViewOne extends SurfaceView implements SurfaceHolder.Callback,Runnable
		{


	// draw
	SurfaceHolder mySurfaceHolder = null;
	public static Paint paintBoard = null;
	float width = getWidth();
	float height = getHeight();
	float gridsize;
	Bitmap backpic = null;
	Bitmap dBlack = null;
	Bitmap dWhite = null;
	Bitmap restart = null;
	Bitmap quit = null;

	// Control
	public int[][] map = new int[8][8];
	static GameViewOne instance = null;
	int turn = 1;
	int color = 1;
	int selX;
	int selY;
	int gameOver = 0;
	boolean startover = false;
	Thread t;
	Context context;
	private static int countWhite = 0;
	private static int countBlack = 0;
	View restartButton = findViewById(R.id.button_restart);


	
	
	LogicForOne logic = new LogicForOne();


	
	int frameCount = 0;


	public GameViewOne(Activity a, float screenWidth, float screenHeight) {
		super(a);
		context = a;
		width = screenWidth;
		height = screenHeight;
		mySurfaceHolder = this.getHolder();
		mySurfaceHolder.addCallback(this);

		setFocusable(true);
		setFocusableInTouchMode(true);
		
		//test
		map[3][3]=2;
		map[4][4]=2;
		map[3][4]=1;
		map[4][3]=1;
		

	}

	public static GameViewOne getInstance() {
		return instance;
	}

	public static void init(Activity myA, int screenWidth, int screenHeight) {
		instance = new GameViewOne(myA, screenWidth, screenHeight);
	}

	@Override
	public void draw(Canvas canvas) {
		dBlack = BitmapFactory.decodeResource(getResources(),
				R.drawable.black);
		dWhite = BitmapFactory.decodeResource(getResources(),
				R.drawable.white);

		gridsize = getWidth() / 9;

		//Draw the background pic on canvas
		backpic = BitmapFactory.decodeResource(getResources(),R.drawable.wood);
		backpic = Bitmap.createScaledBitmap(backpic, (int) width, (int) height,true);
		
		//Draw the board
		paintBoard = new Paint();
		paintBoard.setColor(getResources().getColor(R.color.black));
		paintBoard.setStyle(Paint.Style.FILL_AND_STROKE);
		paintBoard.setTextSize(gridsize*0.7f);
		paintBoard.setTextScaleX(width / height);
		paintBoard.setTextAlign(Paint.Align.LEFT);
		canvas.drawBitmap(backpic, 0, 0, paintBoard);
		
		//Draw the textview
		canvas.drawText("Turn:",gridsize,gridsize,paintBoard);
		canvas.drawText("Mode:",4*gridsize,gridsize,paintBoard);
		canvas.drawText("One Player",5.5f*gridsize,gridsize,paintBoard);
		canvas.drawText("Check Availability", 4*gridsize,3*gridsize,paintBoard);
		if(color==1)
		{
			canvas.drawBitmap(dBlack,2.2f*gridsize,0.6f*gridsize,paintBoard);
		}
		else if(color ==2)
		{
			canvas.drawBitmap(dWhite,2.2f*gridsize,0.6f*gridsize,paintBoard);
		}
		
	
	
		for (int i = 0; i < 8; i++) {
			canvas.drawLine(gridsize, (i * gridsize + height / 4),(8 * gridsize), (i * gridsize + height / 4), paintBoard);
			canvas.drawLine(gridsize * (i + 1), height / 4, gridsize* (i + 1), 7 * gridsize + height / 4, paintBoard);
		}
		
		//Draw all the disks
		countBlack=0;
		countWhite=0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (map[i][j] == 1)
				{
					
					countBlack++;
					drawPiece(canvas,i, j, 1);
				}	
				else if (map[i][j] == 2)
				{
					
					drawPiece(canvas,i, j, 2);
					countWhite++;
				}
			}

		}
		
		canvas.drawText("Black:",gridsize,2*gridsize,paintBoard);
		canvas.drawText(" "+countBlack+" ",2.2f*gridsize,2*gridsize,paintBoard);
		canvas.drawText("White:",4*gridsize,2*gridsize,paintBoard);
		canvas.drawText(" "+countWhite+" ",5.2f*gridsize,2*gridsize,paintBoard);
		

	}

	private void drawPiece(Canvas canvas,float x, float y, int color)
	{
		
		float pieceWidth;
		float pieceHeight;
		
		

		pieceWidth=dBlack.getWidth();
		pieceHeight=dBlack.getHeight();
		Paint paint = new Paint();
		if(color==1)
		{
			canvas.drawBitmap(dBlack,(1+x)*gridsize-pieceWidth/2,height/4+y*gridsize-pieceHeight/2,paint);
		}
		else if(color ==2)
		{
			canvas.drawBitmap(dWhite,(1+x)*gridsize-pieceWidth/2,height/4+y*gridsize-pieceHeight/2,paint);
		}
	}	
	
	protected boolean checkAvailability(int[][] map, int color){
		boolean result = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (map[i][j] == 0)
				{
					if(logic.validMove(map, i , j , color)){
						result = true;
					}
				
				}
			}

		}
		return result;
	}


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() != MotionEvent.ACTION_DOWN)
			return super.onTouchEvent(event);
		if(event.getX()>3.9f*gridsize&&event.getX()<7.5f*gridsize&&event.getY()>2*gridsize&&event.getY()<3*gridsize)
		{
				if(checkAvailability(map, color)){
					AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
					alert.setTitle("Check Availability");
					alert.setMessage("There is a valid move!")
					.setCancelable(false)
					.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int id){

						}
					});
					
					
					AlertDialog alertDialog = alert.create();
					
					alertDialog.show();
				}
				else{
					AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
					alert.setTitle("Check Availability");
					alert.setMessage("There is no possible position")
					.setCancelable(false)
					.setPositiveButton("Skip your turn", new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int id){
//							if(color==1)
//								color=2;
//							else if(color==2)
//								color=1;
						}
					});
					
					
					AlertDialog alertDialog = alert.create();
					
					alertDialog.show();
				}
		}
		if(event.getX()>gridsize/2&&event.getX()<9.1f*gridsize&&event.getY()>(height/4-gridsize/2)&&event.getY()<height/4+8.1f*gridsize)
		{
			
			selX=Math.round((event.getX()-gridsize)/gridsize);
			selY=Math.round((event.getY()-height/4)/gridsize);
			//check the move is valid or not
			if(logic.validMoveToColor(map, selX, selY,1)&&map[selX][selY]==0)
			{
					
				map[selX][selY]=1;

				int whiteDisk = 0;
				for(int i = 0;i<8;i++){
					for(int j = 0; j < 8; j++){
						
						if(whiteDisk == 0){
							if(logic.validMoveToColor(map, i, j,2)&&map[i][j] == 0){
								map[i][j] = 2;
								whiteDisk++;
								color = 1;
							
							}
						}
					}
				}
				if(logic.gameOver(map)){
					AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
					alert.setTitle("Game Over");
					alert.setMessage("Game Over!")
					.setCancelable(true)
					.setPositiveButton("Save this score", new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int id){

							//save to image
							String mPath = Environment.getExternalStorageDirectory().toString() + "/" + "test.jpg";   
							Bitmap bitmap;
							setDrawingCacheEnabled(true);
							bitmap = Bitmap.createBitmap(getDrawingCache());
							setDrawingCacheEnabled(false);
							OutputStream fout = null;
							File imageFile = new File(mPath);

							try {
							    fout = new FileOutputStream(imageFile);
							    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fout);
							    fout.flush();
							    fout.close();

							} catch (FileNotFoundException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
							} catch (IOException e) {
							    // TODO Auto-generated catch block
							    e.printStackTrace();
							}
							
						}
					})
					.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
						public void onClick(DialogInterface dialog, int id){
							//nothing to do
						}
					});
					
					AlertDialog alertDialog = alert.create();
					
					alertDialog.show();
				}
				
				
			}
			//the move is not valid...
			else
			{
				AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
				alert.setTitle("Invalid Move");
				alert.setMessage("Choose another position to place your disk")
				.setCancelable(false)
				.setPositiveButton("OK", new DialogInterface.OnClickListener(){
					public void onClick(DialogInterface dialog, int id){
						//nothing to do
					}
				});
				
				AlertDialog alertDialog = alert.create();
				
				alertDialog.show();
				
			}
			
			
		}
			
			
		Canvas canvas = mySurfaceHolder.lockCanvas();			
		draw(canvas);
		mySurfaceHolder.unlockCanvasAndPost(canvas);	

		
		
		return true;
			

	
	}
	
	

	@Override
	public void run() {

				synchronized (mySurfaceHolder) {
					Canvas canvas = mySurfaceHolder.lockCanvas();
					
					draw(canvas);
					mySurfaceHolder.unlockCanvasAndPost(canvas);
				}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

	}
	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		t = new Thread(this);
		t.start();
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {

		Thread dummy = t;

		t = null;
		dummy.interrupt();
	}
}

