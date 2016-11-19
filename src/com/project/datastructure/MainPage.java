package com.project.datastructure;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainPage extends Activity implements Runnable
{
	ImageView i1;
	ImageView i2;
	public static ImageView imgAnim;
	public static int i=0;
	WebView wbSplash;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main_page);
		/*wbSplash=(WebView)findViewById(R.id.webViewSplash);
		wbSplash.setVerticalScrollBarEnabled(false);
		wbSplash.setHorizontalScrollBarEnabled(false);
		wbSplash.getSettings().setJavaScriptEnabled(true);
		wbSplash.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
            public boolean onTouch(View v, MotionEvent event) {
              return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
          });
        String URL="splash.gif";
        String html = "<html><body><img src=\"" + URL + "\" width=\"100%\" height=\"100%\"\"/></body></html>";
        wbSplash.loadDataWithBaseURL("file:///android_asset/",html, "text/html","utf-8", null);
        
        wbSplash.setBackgroundResource(R.drawable.back);
        wbSplash.setBackgroundColor(0);*/
        new Thread(this).start();
	}
	@Override
	public void run()
	{
		try
		{
			Thread.sleep(4000);
			i=1;
			Intent replyIntent =new Intent(this, DisplayMain.class);
    		startActivityForResult(replyIntent, 0);
		}
		catch(Exception e){return;}
		
	}
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item)
    {
		if(item.getItemId()==R.id.itemDisplay)
		{
			Intent replyIntent =new Intent(this, DisplayMain.class);
			startActivityForResult(replyIntent, 0);
		}
		return true;
    }
}