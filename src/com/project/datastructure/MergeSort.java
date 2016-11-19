package com.project.datastructure;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MergeSort extends Activity {

	Button btnNext;
	Bundle b;
	int size=0;
	int click=0;
	int a[]=new int[4];
	int flag=0;
	TextView n1,n2,n3,n4,sn1,sn2,sn3,sn4,d,c;
	TextView l0_1,l0_2,l0_3,l0_4,l1_1,l1_2,l1_3,l1_4,l2_1,l2_2,l2_3,l2_4;
	TextView u0_1,u0_2,u0_3,u0_4,u1_1,u1_2,u1_3,u1_4,u2_1,u2_2,u2_3,u2_4;
	ImageView sw_0_1,sw_1_1,sw_1_2,se_0_1,se_1_1,se_1_2,arr;
	ImageView nw_0_1,nw_1_1,nw_1_2,ne_0_1,ne_1_1,ne_1_2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_merge_sort);
		d=(TextView)findViewById(R.id.tvDiv);
		c=(TextView)findViewById(R.id.tvCon);
		btnNext=(Button)findViewById(R.id.btnNext);
		n1=(TextView)findViewById(R.id.num1);
		n2=(TextView)findViewById(R.id.num2);
		n3=(TextView)findViewById(R.id.num3);
		n4=(TextView)findViewById(R.id.num4);
		sn1=(TextView)findViewById(R.id.sortnum1);
		sn2=(TextView)findViewById(R.id.sortnum2);
		sn3=(TextView)findViewById(R.id.sortnum3);
		sn4=(TextView)findViewById(R.id.sortnum4);
		l0_1=(TextView)findViewById(R.id.show_num1);
		l0_2=(TextView)findViewById(R.id.show_num2);
		l0_3=(TextView)findViewById(R.id.show_num3);
		l0_4=(TextView)findViewById(R.id.show_num4);
		l1_1=(TextView)findViewById(R.id.show_num_1_1);
		l1_2=(TextView)findViewById(R.id.show_num_1_2);
		l1_3=(TextView)findViewById(R.id.show_num_1_3);
		l1_4=(TextView)findViewById(R.id.show_num_1_4);
		l2_1=(TextView)findViewById(R.id.show_num_2_1);
		l2_2=(TextView)findViewById(R.id.show_num_2_2);
		l2_3=(TextView)findViewById(R.id.show_num_2_3);
		l2_4=(TextView)findViewById(R.id.show_num_2_4);
		sw_0_1=(ImageView)findViewById(R.id.sw_0_1);
		sw_1_1=(ImageView)findViewById(R.id.sw_1_1);
		sw_1_2=(ImageView)findViewById(R.id.sw_1_2);
		se_0_1=(ImageView)findViewById(R.id.se_0_1);
		se_1_1=(ImageView)findViewById(R.id.se_1_1);
		se_1_2=(ImageView)findViewById(R.id.se_1_2);
		arr=(ImageView)findViewById(R.id.arr);
		nw_0_1=(ImageView)findViewById(R.id.nw_0_1);
		nw_1_1=(ImageView)findViewById(R.id.nw_1_1);
		nw_1_2=(ImageView)findViewById(R.id.nw_1_2);
		ne_0_1=(ImageView)findViewById(R.id.ne_0_1);
		ne_1_1=(ImageView)findViewById(R.id.ne_1_1);
		ne_1_2=(ImageView)findViewById(R.id.ne_1_2);
		u0_1=(TextView)findViewById(R.id.con_show_num1);
		u0_2=(TextView)findViewById(R.id.con_show_num2);
		u0_3=(TextView)findViewById(R.id.con_show_num3);
		u0_4=(TextView)findViewById(R.id.con_show_num4);
		u1_1=(TextView)findViewById(R.id.ce_1_1);
		u1_2=(TextView)findViewById(R.id.ce_1_2);
		u1_3=(TextView)findViewById(R.id.ce_1_3);
		u1_4=(TextView)findViewById(R.id.ce_1_4);
		u2_1=(TextView)findViewById(R.id.ce_2_1);
		u2_2=(TextView)findViewById(R.id.ce_2_2);
		u2_3=(TextView)findViewById(R.id.ce_2_3);
		u2_4=(TextView)findViewById(R.id.ce_2_4);
		AlertDialog.Builder s=new AlertDialog.Builder(this);
		s.setTitle("SIZE").setMessage("Enter number of elements to sort (MAX = 4) ");
		final EditText value=new EditText(this);
		s.setView(value);
		s.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{ 
				
					try
					{
						
						if(Integer.parseInt(value.getText().toString())>0 && Integer.parseInt(value.getText().toString())<=4)
						{
							
							size=Integer.parseInt(value.getText().toString());
							
							if(size==1)
								openDialog1();
							if(size>1 && size<=4)
								openDialog2();
							
						}
						else
						{
							Toast.makeText(MergeSort.this,"ERROR in SIZE", Toast.LENGTH_LONG).show();
							onCreate(b);
						}
					}catch(Exception e)
					{
						
						Toast.makeText(MergeSort.this,"Invalid Input", Toast.LENGTH_LONG).show();
						go();
					}
				
			}
		});
		
		s.show();
		
	}

	private void openDialog1()
	{
		AlertDialog.Builder s=new AlertDialog.Builder(this);
		s.setTitle("Enter the elements (numbers only) : ");
		s.setMessage("Enter 1st element :");
		final EditText value=new EditText(this);
		s.setView(value);
		s.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{ 
				try{
				n1.setVisibility(View.VISIBLE);
				n1.setText(value.getText().toString());
				}
				catch(Exception e)
				{
					
					Toast.makeText(MergeSort.this,"Invalid Input", Toast.LENGTH_LONG).show();
					go();
				}
			}
		});
		
		s.show();
	}
	
	private void openDialog2()
	{
		//if(size>1 && size<=4)
		{
			AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Enter the elements (numbers only) : ");
            
			LinearLayout layout = new LinearLayout(this);
			layout.setOrientation(LinearLayout.VERTICAL);
			
			final TextView t1=new TextView(this);
    		t1.setText("Enter 1st element :");
			layout.addView(t1);
			final EditText e1 = new EditText(this);
			layout.addView(e1);
			
			n1.setVisibility(View.VISIBLE);
			sn3.setVisibility(View.VISIBLE);
			
			final TextView t2=new TextView(this);
    		t2.setText("Enter 2nd element :");
    		layout.addView(t2);
			final EditText e2 = new EditText(this);
			layout.addView(e2);
			
			n2.setVisibility(View.VISIBLE);
			sn4.setVisibility(View.VISIBLE);
			
			final EditText e3 = new EditText(this);
			final EditText e4 = new EditText(this);
			
			if(size>=3)
			{
				final TextView t3=new TextView(this);
	    		t3.setText("Enter 3rd element :");
	    		layout.addView(t3);
				layout.addView(e3);
				n3.setVisibility(View.VISIBLE);
				sn2.setVisibility(View.VISIBLE);
			}
			
			if(size==4)
			{
				final TextView t4=new TextView(this);
	    		t4.setText("Enter 4th element :");
	    		layout.addView(t4);
				layout.addView(e4);
				n4.setVisibility(View.VISIBLE);
				sn1.setVisibility(View.VISIBLE);
			}	
			

			dialog.setView(layout);
			dialog.setPositiveButton("OK",new DialogInterface.OnClickListener() 
			{
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					try{
						a[0]=Integer.parseInt(e1.getText().toString());
						n1.setText(e1.getText().toString());
						a[1]=Integer.parseInt(e2.getText().toString());
						n2.setText(e2.getText().toString());
						if(size>=3)
						{
							n3.setText(e3.getText().toString());
							a[2]=Integer.parseInt(e3.getText().toString());
						}
						if(size==4)
						{
							n4.setText(e4.getText().toString());
							a[3]=Integer.parseInt(e4.getText().toString());
						}
					}
					catch(Exception e)
					{
						
						Toast.makeText(MergeSort.this,"Invalid Input", Toast.LENGTH_LONG).show();
						go();
					}
					
				}
			});
			dialog.show();
			d.setVisibility(View.VISIBLE);
			c.setVisibility(View.VISIBLE);
		}
	}
	
	public void go()
	{
	Intent replyIntent =new Intent(this, Merge1.class);
		startActivityForResult(replyIntent, 0);
	}
	
	public void next(View v)
	{
		click++;
		switch(size)
		{
		case 1:
			
			sn4.setVisibility(View.VISIBLE);
			sn4.setText(n1.getText().toString());
			Toast.makeText(MergeSort.this,"List already sorted", Toast.LENGTH_LONG).show();
			Toast.makeText(MergeSort.this,"Press BACK button to continue", Toast.LENGTH_LONG).show();
			btnNext.setEnabled(false);
			break;
			
		case 2:
			switch(click)
			{
				case 1:
					l1_1.setVisibility(View.VISIBLE);
					l1_2.setVisibility(View.VISIBLE);
					l1_1.setText(Integer.toString(a[0]));
					l1_2.setText(Integer.toString(a[1]));
					break;
				case 2:
					l2_1.setVisibility(View.VISIBLE);
					l2_1.setText(Integer.toString(a[0]));
					sw_1_1.setVisibility(View.VISIBLE);
					break;
				case 3:
					l2_2.setVisibility(View.VISIBLE);
					l2_2.setText(Integer.toString(a[1]));
					se_1_1.setVisibility(View.VISIBLE);
					break;
				case 4:
					arr.setVisibility(View.VISIBLE);
					break;
				case 5:
					u2_3.setVisibility(View.VISIBLE);
					u2_4.setVisibility(View.VISIBLE);
					u2_3.setText(Integer.toString(a[0]));
					u2_4.setText(Integer.toString(a[1]));
					break;
				case 6:
					
					u1_3.setVisibility(View.VISIBLE);
					
					//sort the array by swapping
					if(a[1]<a[0])
					{
						int t=a[0];
						a[0]=a[1];
						a[1]=t;
						flag=1;
					}
					u1_3.setText(Integer.toString(a[0]));
					if(flag==1)
						nw_1_2.setVisibility(View.VISIBLE);
					else
						ne_1_2.setVisibility(View.VISIBLE);
					
					break;
				case 7:
					u1_4.setVisibility(View.VISIBLE);
					u1_4.setText(Integer.toString(a[1]));
					if(flag==0)
						nw_1_2.setVisibility(View.VISIBLE);
					else
						ne_1_2.setVisibility(View.VISIBLE);
					break;
				case 8:
					sn3.setText(Integer.toString(a[0]));
					sn4.setText(Integer.toString(a[1]));
					btnNext.setEnabled(false);
					Toast.makeText(MergeSort.this,"List Sorted", Toast.LENGTH_LONG).show();
					Toast.makeText(MergeSort.this,"Press BACK button to continue", Toast.LENGTH_LONG).show();
					break;
				default:
			}
			break;
			
		case 3:
			switch(click)
			{
			case 1:
				l0_1.setVisibility(View.VISIBLE);
				l0_2.setVisibility(View.VISIBLE);
				l0_3.setVisibility(View.VISIBLE);
				
				l0_1.setText(Integer.toString(a[0]));
				l0_2.setText(Integer.toString(a[1]));
				l0_3.setText(Integer.toString(a[2]));
				
				break;
			case 2:
				l1_1.setVisibility(View.VISIBLE);
				l1_2.setVisibility(View.VISIBLE);
				l1_1.setText(Integer.toString(a[0]));
				l1_2.setText(Integer.toString(a[1]));
				sw_0_1.setVisibility(View.VISIBLE);
				
				break;
			case 3:
				l1_3.setVisibility(View.VISIBLE);
				l1_3.setText(Integer.toString(a[2]));
				se_0_1.setVisibility(View.VISIBLE);
				
				break;
			case 4:
				l2_1.setVisibility(View.VISIBLE);
				sw_1_1.setVisibility(View.VISIBLE);
				l2_1.setText(Integer.toString(a[0]));
				
				break;
				
			case 5:
				l2_2.setVisibility(View.VISIBLE);
				l2_2.setText(Integer.toString(a[1]));
				se_1_1.setVisibility(View.VISIBLE);
							
				break;
			case 6:
				l2_3.setVisibility(View.VISIBLE);
				l2_3.setText(Integer.toString(a[2]));
				sw_1_2.setVisibility(View.VISIBLE);
				
				break;
			case 7:
				arr.setVisibility(View.VISIBLE);
				break;
			case 8:
				u2_1.setVisibility(View.VISIBLE);
				u2_2.setVisibility(View.VISIBLE);
				u2_3.setVisibility(View.VISIBLE);
				u2_1.setText(Integer.toString(a[0]));
				u2_2.setText(Integer.toString(a[1]));
				u2_3.setText(Integer.toString(a[2]));
				break;
			case 9:
				u1_1.setVisibility(View.VISIBLE);
				
				//sort the array by swapping
				if(a[1]<a[0])
				{
					int t=a[0];
					a[0]=a[1];
					a[1]=t;
					flag=1;
				}
				u1_1.setText(Integer.toString(a[0]));
				if(flag==1)
					nw_1_1.setVisibility(View.VISIBLE);
				else
					ne_1_1.setVisibility(View.VISIBLE);
				
				break;
			case 10:
				u1_2.setVisibility(View.VISIBLE);
				u1_2.setText(Integer.toString(a[1]));
				if(flag==0)
					nw_1_1.setVisibility(View.VISIBLE);
				else
					ne_1_1.setVisibility(View.VISIBLE);
				flag=0;
				break;
			case 11:
				u1_3.setVisibility(View.VISIBLE);
				u1_3.setText(Integer.toString(a[2]));
				ne_1_2.setVisibility(View.VISIBLE);
				break;
			case 12:
				if(a[2]<a[0])
				{
					int t=a[0];
					a[0]=a[2];
					a[2]=a[1];
					a[1]=t;
					flag=1;
					
				}
				u0_1.setVisibility(View.VISIBLE);
				u0_1.setText(Integer.toString(a[0]));
				if(flag==1)
					nw_0_1.setVisibility(View.VISIBLE);
				else
					ne_0_1.setVisibility(View.VISIBLE);
				
				break;
			case 13:
				if(flag!=1){
					if(a[2]<a[1])
					{
						int t=a[1];
						a[1]=a[2];
						a[2]=t;
						flag=2;
						
					}
					
					if(flag==2)
					{
						nw_0_1.setVisibility(View.VISIBLE);
						ne_0_1.setVisibility(View.INVISIBLE);
					}		
				}
				else
				{
					ne_0_1.setVisibility(View.VISIBLE);
				}
				u0_2.setVisibility(View.VISIBLE);
				u0_2.setText(Integer.toString(a[1]));
				break;
			case 14:
				u0_3.setVisibility(View.VISIBLE);
				u0_3.setText(Integer.toString(a[2]));
				if(flag==0)
					nw_0_1.setVisibility(View.VISIBLE);
				else
					ne_0_1.setVisibility(View.VISIBLE);
				break;
			case 15:
				sn2.setText(Integer.toString(a[0]));
				sn3.setText(Integer.toString(a[1]));
				sn4.setText(Integer.toString(a[2]));
				btnNext.setEnabled(false);
				Toast.makeText(MergeSort.this,"List Sorted", Toast.LENGTH_LONG).show();
				Toast.makeText(MergeSort.this,"Press BACK button to continue", Toast.LENGTH_LONG).show();
			default:
			}
			break;
			
		case 4:
			switch(click)
			{
				case 1:
					l0_1.setVisibility(View.VISIBLE);
					l0_2.setVisibility(View.VISIBLE);
					l0_3.setVisibility(View.VISIBLE);
					l0_4.setVisibility(View.VISIBLE);
					l0_1.setText(Integer.toString(a[0]));
					l0_2.setText(Integer.toString(a[1]));
					l0_3.setText(Integer.toString(a[2]));
					l0_4.setText(Integer.toString(a[3]));
					break;
				case 2:
					l1_1.setVisibility(View.VISIBLE);
					l1_2.setVisibility(View.VISIBLE);
					l1_1.setText(Integer.toString(a[0]));
					l1_2.setText(Integer.toString(a[1]));
					sw_0_1.setVisibility(View.VISIBLE);
					
					break;
				case 3:
					l1_3.setVisibility(View.VISIBLE);
					l1_4.setVisibility(View.VISIBLE);
					l1_3.setText(Integer.toString(a[2]));
					l1_4.setText(Integer.toString(a[3]));
					se_0_1.setVisibility(View.VISIBLE);
					
					break;
				case 4:
					l2_1.setVisibility(View.VISIBLE);
					l2_1.setText(Integer.toString(a[0]));
					sw_1_1.setVisibility(View.VISIBLE);
					
					break;
				case 5:
					l2_2.setVisibility(View.VISIBLE);
					l2_2.setText(Integer.toString(a[1]));
					se_1_1.setVisibility(View.VISIBLE);
					
					break;
				case 6:
					l2_3.setVisibility(View.VISIBLE);
					l2_3.setText(Integer.toString(a[2]));
					sw_1_2.setVisibility(View.VISIBLE);
					
					break;
				case 7:
					l2_4.setVisibility(View.VISIBLE);
					l2_4.setText(Integer.toString(a[3]));
					se_1_2.setVisibility(View.VISIBLE);
					
					break;
				case 8:
					arr.setVisibility(View.VISIBLE);
					break;
				case 9:
					u2_1.setVisibility(View.VISIBLE);
					u2_2.setVisibility(View.VISIBLE);
					u2_3.setVisibility(View.VISIBLE);
					u2_4.setVisibility(View.VISIBLE);
					u2_1.setText(Integer.toString(a[0]));
					u2_2.setText(Integer.toString(a[1]));
					u2_3.setText(Integer.toString(a[2]));
					u2_4.setText(Integer.toString(a[3]));
					break;
				case 10:
					u1_1.setVisibility(View.VISIBLE);
					
					//sort the array by swapping
					if(a[1]<a[0])
					{
						int t=a[0];
						a[0]=a[1];
						a[1]=t;
						flag=1;
					}
					u1_1.setText(Integer.toString(a[0]));
					if(flag==1)
						nw_1_1.setVisibility(View.VISIBLE);
					else
						ne_1_1.setVisibility(View.VISIBLE);
					
					break;
				case 11:
					u1_2.setVisibility(View.VISIBLE);
					u1_2.setText(Integer.toString(a[1]));
					if(flag==0)
						nw_1_1.setVisibility(View.VISIBLE);
					else
						ne_1_1.setVisibility(View.VISIBLE);
					flag=0;
					break;
				case 12:
					u1_3.setVisibility(View.VISIBLE);
					
					//sort the array by swapping
					if(a[3]<a[2])
					{
						int t=a[2];
						a[2]=a[3];
						a[3]=t;
						flag=1;
					}
					u1_3.setText(Integer.toString(a[2]));
					if(flag==1)
						nw_1_2.setVisibility(View.VISIBLE);
					else
						ne_1_2.setVisibility(View.VISIBLE);
					
					break;
				case 13:
					u1_4.setVisibility(View.VISIBLE);
					u1_4.setText(Integer.toString(a[3]));
					if(flag==0)
						nw_1_2.setVisibility(View.VISIBLE);
					else
						ne_1_2.setVisibility(View.VISIBLE);
					flag=0;
					break;
				case 14:
					u0_1.setVisibility(View.VISIBLE);
					//sort the array by swapping
					if(a[2]<a[0])
					{
						int t=a[2];
						a[2]=a[1];
						a[1]=a[0];
						a[0]=t;
						flag=1;
					}
					u0_1.setText(Integer.toString(a[0]));
					if(flag==1)
						nw_0_1.setVisibility(View.VISIBLE);
					else
						ne_0_1.setVisibility(View.VISIBLE);
					
					break;
				case 15:
					u0_2.setVisibility(View.VISIBLE);
					if(flag==0)
					{
						if(a[2]<a[1])
						{
							int t=a[2];
							a[2]=a[1];
							a[1]=t;
							flag=2;
						}
						
						if(flag==2)
						{
							nw_0_1.setVisibility(View.VISIBLE);
							ne_0_1.setVisibility(View.INVISIBLE);
						}	
						
					}
					else
					{
						if(a[3]<a[1])
						{
							int t=a[3];
							a[3]=a[2];
							a[2]=a[1];
							a[1]=t;
							flag=3;
						}
						
						if(flag==1)
						{
							nw_0_1.setVisibility(View.INVISIBLE);
							ne_0_1.setVisibility(View.VISIBLE);
						}	
					}
					u0_2.setText(Integer.toString(a[1]));
					break;
				case 16:
					u0_3.setVisibility(View.VISIBLE);
					if(flag==0)
					{
						nw_0_1.setVisibility(View.VISIBLE);
					}
					if(flag==1)
					{
						if(a[3]<a[2])
						{
							int t=a[3];
							a[3]=a[2];
							a[2]=t;
							flag=4;
						}
						
						if(flag==4)
						{
							nw_0_1.setVisibility(View.VISIBLE);
							ne_0_1.setVisibility(View.INVISIBLE);
						}
					}
					if(flag==2)
					{
						if(a[3]<a[2])
						{
							int t=a[3];
							a[3]=a[2];
							a[2]=t;
							flag=5;
						}
						
						if(flag==2)
						{
							nw_0_1.setVisibility(View.INVISIBLE);
							ne_0_1.setVisibility(View.VISIBLE);
						}
					}
					if(flag==3)
					{
						ne_0_1.setVisibility(View.VISIBLE);
					}
					u0_3.setText(Integer.toString(a[2]));
					break;
				case 17:
					u0_4.setVisibility(View.VISIBLE);
					if(flag==1)
					{
						nw_0_1.setVisibility(View.VISIBLE);
					}
					if(flag==2)
					{
						nw_0_1.setVisibility(View.VISIBLE);
					}
					if(flag==4)
					{
						ne_0_1.setVisibility(View.VISIBLE);
					}
					if(flag==5)
					{
						ne_0_1.setVisibility(View.VISIBLE);
					}
					u0_4.setText(Integer.toString(a[3]));
					break;
				case 18:
					sn1.setText(Integer.toString(a[0]));
					sn2.setText(Integer.toString(a[1]));
					sn3.setText(Integer.toString(a[2]));
					sn4.setText(Integer.toString(a[3]));
					btnNext.setEnabled(false);
					Toast.makeText(MergeSort.this,"List Sorted", Toast.LENGTH_LONG).show();
					Toast.makeText(MergeSort.this,"Press BACK button to continue", Toast.LENGTH_LONG).show();
				default:
			}
			break;
			
		default: Toast.makeText(MergeSort.this,"Error Occured. Try again", Toast.LENGTH_LONG).show();
			Intent replyIntent =new Intent(this, MergeSort.class);
			startActivityForResult(replyIntent, 0);
		}
		
		
		
	}
	
	

}
