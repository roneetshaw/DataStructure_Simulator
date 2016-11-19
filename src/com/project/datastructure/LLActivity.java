package com.project.datastructure;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class LLActivity extends Activity
{
	Button btnRot;
	ImageView imgLeft;ImageView imgRight;ImageView imgSArrow;
	TextView txtn1;TextView txtn2;TextView txtn3,tll1;
	ProgressBar progressBar;
	int progressStatus = 0;
	Handler handler = new Handler();
	int c=1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ll);
		btnRot=(Button)findViewById(R.id.btnLLrot);
		imgLeft=(ImageView)findViewById(R.id.imgLeft);imgRight=(ImageView)findViewById(R.id.imgRight);
		imgSArrow=(ImageView)findViewById(R.id.imgnextArrow);
		txtn1=(TextView)findViewById(R.id.txtLLroot);
		txtn2=(TextView)findViewById(R.id.txtLLrootL);
		txtn3=(TextView)findViewById(R.id.txtLLrootR);
		progressBar=(ProgressBar)findViewById(R.id.progressBarLL);
		btnRot.setText("Rotate("+c+")");
		progressBar.setVisibility(View.INVISIBLE);imgLeft.setVisibility(View.INVISIBLE);
		imgSArrow.setVisibility(View.INVISIBLE);imgRight.setVisibility(View.INVISIBLE);
		txtn1.setVisibility(View.INVISIBLE);txtn2.setVisibility(View.INVISIBLE);
		txtn3.setVisibility(View.INVISIBLE);
		tll1=(TextView)findViewById(R.id.textViewLL1);
		tll1.setVisibility(View.INVISIBLE);
	}
	public void onClickLL(View v)
	{
		
		if(c==0)
		{
			Toast.makeText(this, "No more Rotations Possible", Toast.LENGTH_LONG).show();
		}
		else
		{
		c--;
		progressBar.setVisibility(View.VISIBLE);
		imgSArrow.setVisibility(View.VISIBLE);
		new Thread(new Runnable() 
		{
		    public void run() 
		    {
		        while (progressStatus < 100) 
		        {
		           progressStatus += 10;
		           handler.post(new Runnable() 
		           {
		        	   public void run() 
		        	   {
		        		   progressBar.setProgress(progressStatus);
		        		   if(progressStatus==100)
		        		   {
		        			   progressBar.setVisibility(View.INVISIBLE);
		        			   tll1.setVisibility(View.VISIBLE);
		        				imgLeft.setVisibility(View.VISIBLE);imgRight.setVisibility(View.VISIBLE);
		        				txtn1.setVisibility(View.VISIBLE);txtn2.setVisibility(View.VISIBLE);
		        				txtn3.setVisibility(View.VISIBLE);
		        				btnRot.setText("Rotate("+c+")");
		        				Toast.makeText(LLActivity.this, "Left Rotation (LL)", Toast.LENGTH_LONG).show();
		        			}
		        	   }
		           });
		           try 
		           {
		        	   Thread.sleep(500);
		           } 
		           catch (InterruptedException e)
		           {
		        	   e.printStackTrace();
		           }
		        }
		     }
		  }).start();
		}
		
		
	}

}
