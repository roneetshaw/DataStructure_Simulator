package com.project.datastructure;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BubbleSort3 extends Activity {

	public static String[] s1=new String[7];
	 
	int i,len=0,count=0,count1=0,count2=0,k=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bubble_sort3);
		
	}
	
	public void EN_ELEMENT(View btnenter)
	{
		final TextView tv1=(TextView)findViewById(R.id.txview1);
		final TextView tv2=(TextView)findViewById(R.id.txview2);
		final TextView tv3=(TextView)findViewById(R.id.txview3);
		final TextView tv4=(TextView)findViewById(R.id.txview4);
		Button bt1=(Button)findViewById(R.id.btnenter);
		Button bt2=(Button)findViewById(R.id.btnstartsort);
		AlertDialog.Builder s=new AlertDialog.Builder(this);
		s.setTitle("ARRAY ELEMENTS").setMessage("Enter 4 numbers(separated by commas) ");
		final EditText value=new EditText(this);
		s.setView(value);
		
		s.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
					if(value.getText().toString().length()!=0)
					{
						s1=value.getText().toString().split(",");
						
						k=check10(value.getText().toString());
						if(k==3)
						{
							if(isInteger(s1[0]))
							{
								
								count2++;
								
							}
							else
							{
								new check1().execute(s1[0]);
								//return;
								/*Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
								startActivityForResult(reply, 0);*/
								
							}
							
							if(isInteger(s1[1]))
							{
								
								count2++;
							}
							else
							{
								new check1().execute(s1[1]);
								
								/*Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
								startActivityForResult(reply, 0);*/
							}
							
							if(isInteger(s1[2]))
							{
								
								count2++;
							}
							else
							{
								new check1().execute(s1[2]);
								
								/*Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
								startActivityForResult(reply, 0);*/	
							}
							
							if(isInteger(s1[3]))
							{
								
								count2++;
							}
							else
							{
								new check1().execute(s1[3]);
								/*Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
								startActivityForResult(reply, 0);	*/
							}
							
							if(count2==4)
							{
								tv1.setText(s1[0]+"");
								tv2.setText(s1[1]+"");
								tv3.setText(s1[2]+"");
								tv4.setText(s1[3]+"");
							}
						}
						
						else
						{
							len=value.getText().toString().length();
							new check().execute("len");
						}
					}
					else
					{
						Log.i("Bubble sort", "EN_Element else");
						len=value.getText().toString().length();
						new check().execute("len");
					}

			}
		});
		s.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				return;
			}
		});
		s.show();
		
		/*k=check(value.getText().toString());
		if(k==3)
		{
			if(isInteger(s1[0]))
			{
				tv1.setText(s1[0]+"");
				
			}
			else
			{
				new check1().execute(s1[0]);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
				startActivityForResult(reply, 0);	
				
			}
			
			if(isInteger(s1[1]))
			{
				tv2.setText(s1[1]+"");
				
			}
			else
			{
				new check1().execute(s1[1]);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
				startActivityForResult(reply, 0);	
			}
			
			if(isInteger(s1[2]))
			{
				tv3.setText(s1[2]+"");
				
			}
			else
			{
				new check1().execute(s1[2]);
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
				startActivityForResult(reply, 0);	
			}
			
			if(isInteger(s1[3]))
			{
				tv4.setText(s1[3]+"");
			}
			else
			{
				new check1().execute(s1[3]);
				Intent reply =new Intent(BubbleSort3.this, BubbleSort3.class);		
				startActivityForResult(reply, 0);	
			}
			
			
		}
		
		else
		{
			len=value.getText().toString().length();
			Log.i("BubbleSort", "inside ,");
			new check().execute("len");
		}*/
	
	}

	public void sort(View btnstartsort)
	{
		Intent i=new Intent(btnstartsort.getContext(),BubbleSort2.class);
		startActivity(i);
	}
	
	public void CLEAR(View btnclr)
	{
		Intent replyIntent =new Intent(this, BubbleSort3.class);		
		startActivityForResult(replyIntent, 0);	
	}
	public int check10(String input)
	{
		for(i=0;i<input.length();i++)
		{
			if(input.charAt(i)==',')
			{
				count1++;
			}
		}
		return count1;
	}
	public boolean isInteger(String input)  
	{  
	   try  
	   {  
	      Integer.parseInt( input );  
	      return true;  
	   }  
	   catch(Exception e )  
	   {  
	      return false;  
	   }  
	}  
	
	class check extends AsyncTask<String, Void ,String>
	{

		@Override
		protected String doInBackground(String... arg0) 
		{
			return arg0[0];
		}

		@Override
		protected void onPostExecute(String result) 
		{
			super.onPostExecute(result);
			if(result=="0" || result!="4")
				Toast.makeText(BubbleSort3.this,"ERROR in LENTH OF INPUT", Toast.LENGTH_LONG).show();
			
			
		}
	}
	
	class check1 extends AsyncTask<String, Void ,String>
	{

		@Override
		protected String doInBackground(String... arg0) 
		{
			return arg0[0];
		}

		@Override
		protected void onPostExecute(String result) 
		{
			super.onPostExecute(result);
			Toast.makeText(BubbleSort3.this,"NOT AN INTEGER", Toast.LENGTH_LONG).show();
			
			
		}
	}

}
