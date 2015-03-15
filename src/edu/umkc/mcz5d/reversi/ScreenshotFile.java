package edu.umkc.mcz5d.reversi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;

public class ScreenshotFile {
	
	public void saveScreenshot(Bitmap bitmap, String path){
		OutputStream fout = null;
		File imageFile = new File(path);
		//The try-catch block is to handle FileNotFoundException & IOException when saving the image into file system

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
	
	public static Bitmap getScreenshot(Context context, View v) {
	    DisplayMetrics dm = context.getResources().getDisplayMetrics(); 
	    v.measure(MeasureSpec.makeMeasureSpec(dm.widthPixels, MeasureSpec.EXACTLY),
	            MeasureSpec.makeMeasureSpec(dm.heightPixels, MeasureSpec.EXACTLY));
	    v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
	    Bitmap returnedBitmap = Bitmap.createBitmap(v.getMeasuredWidth(),
	            v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
	    Canvas c = new Canvas(returnedBitmap);
	    v.draw(c);

	    return returnedBitmap;
	}

}
