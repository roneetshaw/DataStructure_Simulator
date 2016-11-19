package com.project.datastructure;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class QuickSort extends Activity {

	TextView num1,num2,num3,num4,num5,sortnum1,sortnum2,sortnum3,sortnum4,sortnum5;
	TextView img,s1,s2,s3,s4,s5,f1,f2,f3,f4,f5,t1,t2,t3,t4,t5,txtpiv,txtcmp,pivtxt,textdesc;
	ImageView imgpiv;
	int a[]=new int[5];
	int left,right,piv;
	Button btnNext;
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		left=right=0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_sort);
		btnNext=(Button)findViewById(R.id.btnNext);
		textdesc=(TextView)findViewById(R.id.textdesc);
		img=(TextView)findViewById(R.id.tvimg);
		imgpiv=(ImageView)findViewById(R.id.imgpiv);
		pivtxt=(TextView)findViewById(R.id.pivtxt);
		s1=(TextView)findViewById(R.id.s1);
		s2=(TextView)findViewById(R.id.s2);
		s3=(TextView)findViewById(R.id.s3);
		s4=(TextView)findViewById(R.id.s4);
		s5=(TextView)findViewById(R.id.s5);
		f1=(TextView)findViewById(R.id.f1);
		f2=(TextView)findViewById(R.id.f2);
		f3=(TextView)findViewById(R.id.f3);
		f4=(TextView)findViewById(R.id.f4);
		f5=(TextView)findViewById(R.id.f5);
		t1=(TextView)findViewById(R.id.t1);
		t2=(TextView)findViewById(R.id.t2);
		t3=(TextView)findViewById(R.id.t3);
		t4=(TextView)findViewById(R.id.t4);
		t5=(TextView)findViewById(R.id.t5);
		num1=(TextView)findViewById(R.id.num1);
		num2=(TextView)findViewById(R.id.num2);
		num3=(TextView)findViewById(R.id.num3);
		num4=(TextView)findViewById(R.id.num4);
		num5=(TextView)findViewById(R.id.num5);
		sortnum1=(TextView)findViewById(R.id.sortnum1);
		sortnum2=(TextView)findViewById(R.id.sortnum2);
		sortnum3=(TextView)findViewById(R.id.sortnum3);
		sortnum4=(TextView)findViewById(R.id.sortnum4);
		sortnum5=(TextView)findViewById(R.id.sortnum5);
		txtpiv=(TextView)findViewById(R.id.txtpiv);
		txtcmp=(TextView)findViewById(R.id.txtcmp);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enter the 5 numbers : ");
        
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		
		final TextView t1=new TextView(this);
		t1.setText("Enter 1st element :");
		layout.addView(t1);
		final EditText e1 = new EditText(this);
		layout.addView(e1);
		
		num1.setVisibility(View.VISIBLE);
		num2.setVisibility(View.VISIBLE);
		num3.setVisibility(View.VISIBLE);
		num4.setVisibility(View.VISIBLE);
		num5.setVisibility(View.VISIBLE);
		sortnum1.setVisibility(View.VISIBLE);
		sortnum2.setVisibility(View.VISIBLE);
		sortnum3.setVisibility(View.VISIBLE);
		sortnum4.setVisibility(View.VISIBLE);
		sortnum5.setVisibility(View.VISIBLE);
		
		final TextView t2=new TextView(this);
		t2.setText("Enter 2nd element :");
		layout.addView(t2);
		final EditText e2 = new EditText(this);
		layout.addView(e2);
				
		final EditText e3 = new EditText(this);
		final EditText e4 = new EditText(this);
		final EditText e5 = new EditText(this);
		
		final TextView t3=new TextView(this);
    	t3.setText("Enter 3rd element :");
		layout.addView(t3);
		layout.addView(e3);
		final TextView t4=new TextView(this);
		t4.setText("Enter 4th element :");
		layout.addView(t4);
		layout.addView(e4);
		final TextView t5=new TextView(this);
		t5.setText("Enter 5th element :");
		layout.addView(t5);
		layout.addView(e5);
		
		dialog.setView(layout);
		dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				try{
				a[0]=Integer.parseInt(e1.getText().toString());
				num1.setText(e1.getText().toString());
				a[1]=Integer.parseInt(e2.getText().toString());
				num2.setText(e2.getText().toString());
				num3.setText(e3.getText().toString());
				a[2]=Integer.parseInt(e3.getText().toString());
				num4.setText(e4.getText().toString());
				a[3]=Integer.parseInt(e4.getText().toString());
				num5.setText(e5.getText().toString());
				a[4]=Integer.parseInt(e5.getText().toString());
				}
				catch(NumberFormatException e)
				{
					Toast.makeText(QuickSort.this,"Invalid Input", Toast.LENGTH_LONG).show();
					go();
				}
			}
		});
		dialog.show();
		
	}
	
	public void next(View v)
	{
		count++;
		switch (count) {
		case 1:
			s1.setVisibility(View.VISIBLE);
			s2.setVisibility(View.VISIBLE);
			s3.setVisibility(View.VISIBLE);
			s4.setVisibility(View.VISIBLE);
			s5.setVisibility(View.VISIBLE);
			
			s1.setText(Integer.toString(a[0]));
			s2.setText(Integer.toString(a[1]));
			s3.setText(Integer.toString(a[2]));
			s4.setText(Integer.toString(a[3]));
			s5.setText(Integer.toString(a[4]));
			break;
		case 2:
			s1.setVisibility(View.INVISIBLE);
			txtpiv.setVisibility(View.VISIBLE);
			txtpiv.setText(Integer.toString(a[0]));
			imgpiv.setVisibility(View.VISIBLE);
			pivtxt.setVisibility(View.VISIBLE);
			textdesc.setVisibility(View.VISIBLE);
			textdesc.setText("We randomly select an element as the pivot. Here, we have chosen the 1st element.");
			break;
		case 3:
			txtcmp.setVisibility(View.VISIBLE);
			txtcmp.setText(Integer.toString(a[1]));
			textdesc.setVisibility(View.VISIBLE);
			textdesc.setText("We go through each of the other elements and compare them to the pivot.");
			if(a[1]<a[0])
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is less than");				
			}
			else
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is greater than");
			}
			break;
		case 4:
			textdesc.setVisibility(View.VISIBLE);
			textdesc.setText("Each element greater than the pivot is placed in one group and each element lesser than the pivot is placed in another group.");
			if(a[1]<a[0])
			{
				f1.setVisibility(View.VISIBLE);
				f1.setText(Integer.toString(a[1]));
				left=1;
			}
			else
			{
				f5.setVisibility(View.VISIBLE);
				f5.setText(Integer.toString(a[1]));
				right=1;
			}
			s2.setVisibility(View.INVISIBLE);
			break;
		case 5:
			txtcmp.setText(Integer.toString(a[2]));
			if(a[2]<a[0])
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is less than");				
			}
			else
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is greater than");
			}
			break;
		case 6:
			if(a[2]<a[0])
			{
				if(left==1)
				{
					f2.setVisibility(View.VISIBLE);
					f2.setText(Integer.toString(a[2]));
					left=2;
				}
				else
				{
					f1.setVisibility(View.VISIBLE);
					f1.setText(Integer.toString(a[2]));
					left=1;
				}
			}
			else
			{
				if(right==1)
				{
					f4.setVisibility(View.VISIBLE);
					f4.setText(f5.getText());
					f5.setText(Integer.toString(a[2]));
					right=2;
				}
				else
				{
					f5.setVisibility(View.VISIBLE);
					f5.setText(Integer.toString(a[2]));
					right=1;
				}
			}
			s3.setVisibility(View.INVISIBLE);
			break;
		case 7:
			
			txtcmp.setText(Integer.toString(a[3]));
			if(a[3]<a[0])
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is less than");				
			}
			else
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is greater than");
			}
			break;
		case 8:
			if(a[3]<a[0])
			{
				if(left==2)
				{
					f3.setVisibility(View.VISIBLE);
					f3.setText(Integer.toString(a[3]));
					left=3;
				}
				else
				{
					if(left==1)
					{
						f2.setVisibility(View.VISIBLE);
						f2.setText(Integer.toString(a[3]));
						left=2;
					}
					else
					{
						f1.setVisibility(View.VISIBLE);
						f1.setText(Integer.toString(a[3]));
						left=1;
					}
				}
			}
			else
			{
				if(right==2)
				{
					f3.setVisibility(View.VISIBLE);
					f3.setText(f4.getText());
					f4.setText(f5.getText());
					f5.setText(Integer.toString(a[3]));
					right=3;
				}
				else
				{
					if(right==1)
					{
						f4.setVisibility(View.VISIBLE);
						f4.setText(f5.getText());
						f5.setText(Integer.toString(a[3]));
						right=2;
					}
					else
					{
						f5.setVisibility(View.VISIBLE);
						f5.setText(Integer.toString(a[3]));
						right=1;
					}
					
				}
					
				
			}
			s4.setVisibility(View.INVISIBLE);
			break;
		case 9:
			
			txtcmp.setText(Integer.toString(a[4]));
			if(a[4]<a[0])
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is less than");				
			}
			else
			{
				img.setVisibility(View.VISIBLE);
				img.setText("is greater than");
			}
			break;
		case 10:
			if(a[4]<a[0])
			{
				switch(left)
				{
				case 3:
					f4.setVisibility(View.VISIBLE);
					f4.setText(Integer.toString(a[4]));
					left=4;
					break;
				case 2:
					f3.setVisibility(View.VISIBLE);
					f3.setText(Integer.toString(a[4]));
					left=3;
					break;
				case 1:
					f2.setVisibility(View.VISIBLE);
					f2.setText(Integer.toString(a[4]));
					left=2;
					break;
				case 0:
					f1.setVisibility(View.VISIBLE);
					f1.setText(Integer.toString(a[4]));
					left=1;
					break;
				default:break;
				}
				
			}
			else
			{
				switch(right)
				{
				case 3:
					f2.setVisibility(View.VISIBLE);
					f3.setVisibility(View.VISIBLE);
					f2.setText(f3.getText());
					f3.setText(f4.getText());
					f4.setText(f5.getText());
					f5.setText(Integer.toString(a[4]));
					right=4;
					break;
				case 2:
					f3.setVisibility(View.VISIBLE);
					f3.setText(f4.getText());
					f4.setText(f5.getText());
					f5.setText(Integer.toString(a[4]));
					right=3;
					break;
				case 1:
					f5.setVisibility(View.VISIBLE);
					f5.setText(Integer.toString(a[4]));
					right=2;
					break;
				case 0:
					f5.setVisibility(View.VISIBLE);
					f5.setText(Integer.toString(a[4]));
					right=1;
					break;
				default:break;
				}
				
			}
			
			s5.setVisibility(View.INVISIBLE);
			break;
		case 11:
			txtcmp.setVisibility(View.INVISIBLE);
			img.setVisibility(View.INVISIBLE);
			break;
		case 12:
			
			switch(left)
			{
			case 0:
				f1.setVisibility(View.VISIBLE);
				f1.setText(Integer.toString(a[0]));
				f1.setBackgroundColor(R.drawable.array_node);
				s1.setBackgroundColor(R.drawable.array_node);
				piv=1;
				break;
			case 1:
				f2.setVisibility(View.VISIBLE);
				f2.setText(Integer.toString(a[0]));
				f2.setBackgroundColor(R.drawable.array_node);
				s2.setBackgroundColor(R.drawable.array_node);
				piv=2;
				break;
			case 2:
				f3.setVisibility(View.VISIBLE);
				f3.setText(Integer.toString(a[0]));
				f3.setBackgroundColor(R.drawable.array_node);
				s3.setBackgroundColor(R.drawable.array_node);
				piv=3;
				break;
			case 3:
				f4.setVisibility(View.VISIBLE);
				f4.setText(Integer.toString(a[0]));
				f4.setBackgroundColor(R.drawable.array_node);
				s4.setBackgroundColor(R.drawable.array_node);
				piv=4;
				break;
			case 4:
				f5.setVisibility(View.VISIBLE);
				f5.setText(Integer.toString(a[0]));
				f5.setBackgroundColor(R.drawable.array_node);
				s5.setBackgroundColor(R.drawable.array_node);
				piv=5;
				break;
			default:
					
			}
			textdesc.setVisibility(View.VISIBLE);
			textdesc.setText("Once we have partitioned the list, we have the list consisting of elements smaller than the pivot, followed by the pivot, followed by elements greater than the pivot.");
			break;
			
		case 13:
			txtpiv.setVisibility(View.INVISIBLE);
			pivtxt.setVisibility(View.INVISIBLE);
			imgpiv.setVisibility(View.INVISIBLE);
			break;
		case 14:
			a[0]=Integer.parseInt(f1.getText().toString());
			a[1]=Integer.parseInt(f2.getText().toString());
			a[2]=Integer.parseInt(f3.getText().toString());
			a[3]=Integer.parseInt(f4.getText().toString());
			a[4]=Integer.parseInt(f5.getText().toString());
			s1.setVisibility(View.VISIBLE);
			s1.setText(Integer.toString(a[0]));
			s2.setVisibility(View.VISIBLE);
			s2.setText(Integer.toString(a[1]));
			s3.setVisibility(View.VISIBLE);
			s3.setText(Integer.toString(a[2]));
			s4.setVisibility(View.VISIBLE);
			s4.setText(Integer.toString(a[3]));
			s5.setVisibility(View.VISIBLE);
			s5.setText(Integer.toString(a[4]));
			switch(piv)
			{
			case 1:
				sortnum1.setText(Integer.toString(a[0]));
				break;
			case 2:
				sortnum2.setText(Integer.toString(a[1]));
				break;
			case 3:
				sortnum3.setText(Integer.toString(a[2]));
				break;
			case 4:
				sortnum4.setText(Integer.toString(a[3]));
				break;
			case 5:
				sortnum5.setText(Integer.toString(a[4]));
				break;
				default:
			}
			f1.setVisibility(View.INVISIBLE);
			f2.setVisibility(View.INVISIBLE);
			f3.setVisibility(View.INVISIBLE);
			f4.setVisibility(View.INVISIBLE);
			f5.setVisibility(View.INVISIBLE);
			textdesc.setVisibility(View.VISIBLE);
			textdesc.setText("Position of pivot element is found.");
			break;
			
		case 15:
			t1.setVisibility(View.VISIBLE);
			t1.setText(Integer.toString(a[0]));
			t2.setVisibility(View.VISIBLE);
			t2.setText(Integer.toString(a[1]));
			t3.setVisibility(View.VISIBLE);
			t3.setText(Integer.toString(a[2]));
			t4.setVisibility(View.VISIBLE);
			t4.setText(Integer.toString(a[3]));
			t5.setVisibility(View.VISIBLE);
			t5.setText(Integer.toString(a[4]));
			f1.setVisibility(View.INVISIBLE);
			f2.setVisibility(View.INVISIBLE);
			f3.setVisibility(View.INVISIBLE);
			f4.setVisibility(View.INVISIBLE);
			f5.setVisibility(View.INVISIBLE);
			switch(piv)
			{
			case 1:
				t1.setVisibility(View.INVISIBLE);
				
				break;
			case 2:
				t2.setVisibility(View.INVISIBLE);
				
				break;
			case 3:
				t3.setVisibility(View.INVISIBLE);
				
				break;
			case 4:
				t4.setVisibility(View.INVISIBLE);
				
				break;
			case 5:
				t5.setVisibility(View.INVISIBLE);
				
				break;
				default:
			}
			
			textdesc.setVisibility(View.VISIBLE);
			textdesc.setText("We then execute quick sort recursively in the sub-lists to finish sorting the list");
			break;
			
		case 16:
			int swap;
			for (int c = 0; c < 4; c++) {
			      for (int d = 0; d < 5 - c - 1; d++) {
			        if (a[d] > a[d+1]) /* For descending order use < */
			        {
			          swap       = a[d];
			          a[d]   = a[d+1];
			          a[d+1] = swap;
			        }
			      }
			    }
			
			sortnum1.setText(Integer.toString(a[0]));
			sortnum2.setText(Integer.toString(a[1]));
			sortnum3.setText(Integer.toString(a[2]));
			sortnum4.setText(Integer.toString(a[3]));
			sortnum5.setText(Integer.toString(a[4]));
			s1.setVisibility(View.INVISIBLE);
			s2.setVisibility(View.INVISIBLE);
			s3.setVisibility(View.INVISIBLE);
			s4.setVisibility(View.INVISIBLE);
			s5.setVisibility(View.INVISIBLE);
			f1.setVisibility(View.INVISIBLE);
			f2.setVisibility(View.INVISIBLE);
			f3.setVisibility(View.INVISIBLE);
			f4.setVisibility(View.INVISIBLE);
			f5.setVisibility(View.INVISIBLE);
			
			textdesc.setVisibility(View.INVISIBLE);
			btnNext.setEnabled(false);
			Toast.makeText(QuickSort.this,"List Sorted", Toast.LENGTH_LONG).show();
			Toast.makeText(QuickSort.this,"Press BACK button to continue", Toast.LENGTH_LONG).show();
			break;
		default:
			break;
		}
		
			
	}
	
	public void go()
	{
	Intent replyIntent =new Intent(this, Quick1.class);
		startActivityForResult(replyIntent, 0);
	}

	

}
