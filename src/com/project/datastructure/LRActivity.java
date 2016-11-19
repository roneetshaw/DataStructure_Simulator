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

public class LRActivity extends Activity 
{
	TextView t1_1,t1_2,t1_3,t2_1,t2_2,t2_3,tLRRot1,tLRRot2;
	ImageView i1_1,i1_2,i2_1,i2_2,img1,img2;
	Button bLR;
	ProgressBar b1,b2;
	int progressStatus = 0;
	int progressStatus1 = 0;
	Handler handler = new Handler();Handler handler1 = new Handler();
	int c=2;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lr);
		t1_1=(TextView)findViewById(R.id.textViewLR1_1);t1_2=(TextView)findViewById(R.id.textViewLR1_2);
		t1_3=(TextView)findViewById(R.id.textViewLR1_3);t2_1=(TextView)findViewById(R.id.textViewLR2_1);
		t2_2=(TextView)findViewById(R.id.textView2_2);t2_3=(TextView)findViewById(R.id.textView2_3);
		i1_1=(ImageView)findViewById(R.id.imageViewLR1_1);i1_2=(ImageView)findViewById(R.id.imageView1_2);
		i2_1=(ImageView)findViewById(R.id.imageView2_1);i2_2=(ImageView)findViewById(R.id.imageView2_2);
		img1=(ImageView)findViewById(R.id.imageViewLR1);img2=(ImageView)findViewById(R.id.imageViewLR2);
		b1=(ProgressBar)findViewById(R.id.progressBarLR1);b2=(ProgressBar)findViewById(R.id.progressBarLR2);
		t1_1.setVisibility(View.INVISIBLE);t1_2.setVisibility(View.INVISIBLE);t1_3.setVisibility(View.INVISIBLE);
		t2_1.setVisibility(View.INVISIBLE);t2_2.setVisibility(View.INVISIBLE);t2_3.setVisibility(View.INVISIBLE);
		i1_1.setVisibility(View.INVISIBLE);i1_2.setVisibility(View.INVISIBLE);
		i2_1.setVisibility(View.INVISIBLE);i2_2.setVisibility(View.INVISIBLE);
		img1.setVisibility(View.INVISIBLE);img2.setVisibility(View.INVISIBLE);
		b1.setVisibility(View.INVISIBLE);b2.setVisibility(View.INVISIBLE);
		bLR=(Button)findViewById(R.id.btnLR);
		bLR.setText("Rotate("+c+")");
		tLRRot1=(TextView)findViewById(R.id.textViewLRROT1);
		tLRRot2=(TextView)findViewById(R.id.textViewLRROT2);
		tLRRot1.setVisibility(View.INVISIBLE);
		tLRRot2.setVisibility(View.INVISIBLE);
	}
	public void onClickLR(View v)
	{
		if(c==0)
		{
			Toast.makeText(this, "No more Rotations Possible", Toast.LENGTH_LONG).show();
		}
		else if(c==2)
		{
			c--;
			b1.setVisibility(View.VISIBLE);
			img1.setVisibility(View.VISIBLE);
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
			        		   b1.setProgress(progressStatus);
			        		   if(progressStatus==100)
			        		   {
			        			   b1.setVisibility(View.INVISIBLE);
			        			   i1_1.setVisibility(View.VISIBLE);i1_2.setVisibility(View.VISIBLE);
			        			   t1_1.setVisibility(View.VISIBLE);t1_2.setVisibility(View.VISIBLE);
			        			   t1_3.setVisibility(View.VISIBLE);tLRRot1.setVisibility(View.VISIBLE);
			        			   bLR.setText("Rotate("+c+")");
			        			   Toast.makeText(LRActivity.this, "Right Rotation around 42", Toast.LENGTH_LONG).show();
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
		else if(c==1)
		{
			c--;
			b2.setVisibility(View.VISIBLE);
			img2.setVisibility(View.VISIBLE);
			new Thread(new Runnable() 
			{
			    public void run() 
			    {
			        while (progressStatus1 < 100) 
			        {
			           progressStatus1 += 10;
			           handler1.post(new Runnable() 
			           {
			        	   public void run() 
			        	   {
			        		   b2.setProgress(progressStatus1);
			        		   if(progressStatus1==100)
			        		   {
			        			   b2.setVisibility(View.INVISIBLE);
			        			   i2_1.setVisibility(View.VISIBLE);i2_2.setVisibility(View.VISIBLE);
			        			   t2_1.setVisibility(View.VISIBLE);t2_2.setVisibility(View.VISIBLE);
			        			   t2_3.setVisibility(View.VISIBLE);tLRRot2.setVisibility(View.VISIBLE);
			        			   bLR.setText("Rotate("+c+")");
			        			   Toast.makeText(LRActivity.this, "Left Rotation around 41", Toast.LENGTH_LONG).show();
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
