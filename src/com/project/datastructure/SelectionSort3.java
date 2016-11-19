package com.project.datastructure;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SelectionSort3 extends Activity {
	public static String[] s2=new String[7];
	 
	int i,len=0,count=0,count1=0,count2=0,k;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection_sort3);
		
	}
	
	public void EN_ELEMENT(View btnenter1)
	{
		final TextView tv1=(TextView)findViewById(R.id.txtview1);
		final TextView tv2=(TextView)findViewById(R.id.txtview2);
		final TextView tv3=(TextView)findViewById(R.id.txtview3);
		final TextView tv4=(TextView)findViewById(R.id.txtview4);
		Button bt1=(Button)findViewById(R.id.btnenter1);
		Button bt2=(Button)findViewById(R.id.btnstartsort1);
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
						k=check11(value.getText().toString());
						if(k==3)
						{
							s2=value.getText().toString().split(",");
							if(isInteger(s2[0]))
							{
								count2++;
								
							}
							else
							{
								new check3().execute(s2[0]);
							}
							
							if(isInteger(s2[1]))
							{
								count2++;
								
							}
							else
							{
								new check3().execute(s2[1]);
							}
							
							if(isInteger(s2[2]))
							{
								count2++;
								
							}
							else
							{
								new check3().execute(s2[2]);
							}
							
							if(isInteger(s2[3]))
							{
								count2++;
							}
							else
							{
								new check3().execute(s2[3]);
							}
							
							if(count2==4)
							{
								tv1.setText(s2[0]+"");
								tv2.setText(s2[1]+"");
								tv3.setText(s2[2]+"");
								tv4.setText(s2[3]+"");
							}
						}
					}
					else
					{
						len=value.getText().toString().length();
						new check2().execute("len");
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
	
	}

	public void sort(View btnstartsort1)
	{
		Intent i=new Intent(btnstartsort1.getContext(),SelectionSort2.class);
		startActivity(i);
	}
	
	public void CLEAR(View btnclr1)
	{
		Intent replyIntent =new Intent(this, SelectionSort3.class);		
		startActivityForResult(replyIntent, 0);	
	}
	public int check11(String input)
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
	
	
	class check2 extends AsyncTask<String, Void ,String>
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
				Toast.makeText(SelectionSort3.this,"ERROR in LENTH OF INPUT", Toast.LENGTH_LONG).show();
			
			
		}
	}
	
	class check3 extends AsyncTask<String, Void ,String>
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
			Toast.makeText(SelectionSort3.this,"NOT AN INTEGER", Toast.LENGTH_LONG).show();
			
			
		}
	}


}
