package com.project.datastructure;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.project.datastructure.Stack_dr.push_b;

import android.R.color;
import android.net.Uri;
import android.os.AsyncTask;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class DualStack extends Activity {
	
	String x[]=new String[13];int count=0,size=0,g=1;
	final String s1=" ";String output;
	Button btnPush1;Button btnPop1;Button btnPeek1;Button btnSize1;
	ImageView arr11;ImageView arr12;ImageView arr13;
	ImageView arr14;ImageView arr15;ImageView arr16;
	ImageView arr17;ImageView arr18;ImageView arr19;
	ImageView arr20;ImageView arr21;ImageView arr22;
	Resources resources;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dual_stack);
		btnPush1=(Button)findViewById(R.id.btnPush1);btnPush1.setEnabled(false);
		btnPop1=(Button)findViewById(R.id.btnPop1);btnPop1.setEnabled(false);
		btnPeek1=(Button)findViewById(R.id.btnPeek1);btnPeek1.setEnabled(false);
		btnSize1=(Button)findViewById(R.id.btnSize1);btnSize1.setEnabled(true);
		AlertDialog.Builder s=new AlertDialog.Builder(this);
		s.setTitle("SIZE").setMessage("Enter size (MAX=6*2) ");
		final EditText value=new EditText(this);
		s.setView(value);
		s.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				if(g==1)
				{
					try
					{
						if(value.getText().toString().length()!=0 && Integer.parseInt(value.getText().toString())<=12)
						{
							size=Integer.parseInt(value.getText().toString());
							btnPush1.setEnabled(true);
							btnPop1.setEnabled(true);
							btnPeek1.setEnabled(true);
							btnSize1.setEnabled(false);
						}
						else
							new push_b().execute("size");
					}catch(Exception e){}
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
	public int increase()
	{
		if(count<size)
		{
			count++;
			return 1;
		}
		else
		{
			Toast.makeText(DualStack.this,"STACK FULL : OVERFULL", Toast.LENGTH_LONG).show();
			return 0;
		}
	}
	public void decrease()
	{
		if(count>0)
		{
			Toast.makeText(this,"POPPED : "+x[count], Toast.LENGTH_LONG).show();
			count--;
		}
		else
			Toast.makeText(DualStack.this,"STACK EMPTY : UNDERFLOW", Toast.LENGTH_LONG).show();
	}
	public void DOCS(View btnDocs)
	{	
		AlertDialog.Builder link_doc=new AlertDialog.Builder(this);
		link_doc.setTitle("Documentation").setMessage("Choose a type ");
		final RadioGroup Qrg=new RadioGroup(this);
		final RadioButton hi=new RadioButton(this);
		hi.setText("Hindi");
		final RadioButton en=new RadioButton(this);
		en.setText("English");
		Qrg.addView(hi);Qrg.addView(en);
		link_doc.setView(Qrg);
		link_doc.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(hi.isChecked())
				{
					CopyReadAssets("Stack_hi.pdf");
				}
				else if(en.isChecked())
				{
					CopyReadAssets("Stack_en.pdf");
				}
			}
		});
		link_doc.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				return;
			}
		});
		link_doc.show();
	}
	private void CopyReadAssets(String x)
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), x);
        try
        {
            in = assetManager.open(x);
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } 
        catch (Exception e){}
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/"+x),"application/pdf");
        startActivity(intent);
    }
	private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }
	public void SIZE(View btnS)
	{
		AlertDialog.Builder s=new AlertDialog.Builder(this);
		s.setTitle("SIZE").setMessage("Enter size (MAX=6) ");
		final EditText value=new EditText(this);
		s.setView(value);
		s.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				if(g==1)
				{
					try
					{
						if(value.getText().toString().length()!=0 && Integer.parseInt(value.getText().toString())<=6)
						{
							size=Integer.parseInt(value.getText().toString());
							btnPush1.setEnabled(true);
							btnPop1.setEnabled(true);
							btnPeek1.setEnabled(true);
							btnSize1.setEnabled(false);
						}
						else
							new push_b().execute("size");
					}catch(Exception e){}
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
	public void CLEAR(View btnC)
	{
		Intent replyIntent =new Intent(this, Stack_dr.class);		
		startActivityForResult(replyIntent, 0);	
	}
	public void POP(View btnPop)
	{
		TextView node11=(TextView)findViewById(R.id.Snode11);
		TextView node12=(TextView)findViewById(R.id.Snode12);
		TextView node13=(TextView)findViewById(R.id.Snode13);
		TextView node14=(TextView)findViewById(R.id.Snode14);
		TextView node15=(TextView)findViewById(R.id.Snode15);
		TextView node16=(TextView)findViewById(R.id.Snode16);
		TextView node17=(TextView)findViewById(R.id.Snode17);
		TextView node18=(TextView)findViewById(R.id.Snode18);
		TextView node19=(TextView)findViewById(R.id.Snode19);
		TextView node20=(TextView)findViewById(R.id.Snode20);
		TextView node21=(TextView)findViewById(R.id.Snode21);
		TextView node22=(TextView)findViewById(R.id.Snode22);
		arr11=(ImageView)findViewById(R.id.arr11);arr12=(ImageView)findViewById(R.id.arr12);
		arr13=(ImageView)findViewById(R.id.arr13);arr14=(ImageView)findViewById(R.id.arr14);
		arr15=(ImageView)findViewById(R.id.arr15);arr16=(ImageView)findViewById(R.id.arr16);
		arr17=(ImageView)findViewById(R.id.arr17);arr18=(ImageView)findViewById(R.id.arr18);
		arr19=(ImageView)findViewById(R.id.arr19);arr20=(ImageView)findViewById(R.id.arr20);
		arr21=(ImageView)findViewById(R.id.arr21);arr22=(ImageView)findViewById(R.id.arr22);
		node11.setVisibility(View.INVISIBLE);node12.setVisibility(View.INVISIBLE);
		node13.setVisibility(View.INVISIBLE);node14.setVisibility(View.INVISIBLE);
		node15.setVisibility(View.INVISIBLE);node16.setVisibility(View.INVISIBLE);
		node17.setVisibility(View.INVISIBLE);node18.setVisibility(View.INVISIBLE);
		node19.setVisibility(View.INVISIBLE);node20.setVisibility(View.INVISIBLE);
		node21.setVisibility(View.INVISIBLE);node22.setVisibility(View.INVISIBLE);
		arr11.setVisibility(View.INVISIBLE);arr12.setVisibility(View.INVISIBLE);
		arr13.setVisibility(View.INVISIBLE);arr14.setVisibility(View.INVISIBLE);
		arr15.setVisibility(View.INVISIBLE);arr16.setVisibility(View.INVISIBLE);
		arr17.setVisibility(View.INVISIBLE);arr18.setVisibility(View.INVISIBLE);
		arr19.setVisibility(View.INVISIBLE);arr20.setVisibility(View.INVISIBLE);
		arr21.setVisibility(View.INVISIBLE);arr22.setVisibility(View.INVISIBLE);
		decrease();
		if(count==0)
		{
			//CLEAR(b);
		}
		else if(count==1)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);
			arr11.setVisibility(View.VISIBLE);
		}
		else if(count==2)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);
			arr12.setVisibility(View.VISIBLE);
		}
		else if(count==3)
		{
			
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);
			arr13.setVisibility(View.VISIBLE);
		}
		else if(count==4)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);
			arr14.setVisibility(View.VISIBLE);
			
		}
		else if(count==5)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			arr15.setVisibility(View.VISIBLE);
			
		}
		else if(count==6)
		{
			Toast.makeText(DualStack.this,"STACK 2 EMPTY :ELEMENTS WILL BE REMOVED FROM STACK 1", Toast.LENGTH_LONG).show();
			
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			arr16.setVisibility(View.VISIBLE);
			
		}
		else if(count==7)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.VISIBLE);
			
		}
		else if(count==8)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			arr18.setVisibility(View.VISIBLE);
			
		}
		else if(count==9)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			arr19.setVisibility(View.VISIBLE);
			
		}
		else if(count==10)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			
			node20.setText(x[10]+" ");
			node20.setVisibility(View.VISIBLE);
			arr20.setVisibility(View.VISIBLE);
			
		}
		else if(count==11)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			
			node20.setText(x[10]+" ");
			node20.setVisibility(View.VISIBLE);
			
			node21.setText(x[11]+" ");
			node21.setVisibility(View.VISIBLE);
			arr21.setVisibility(View.VISIBLE);
			
		}
		else if(count==12)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			
			node20.setText(x[10]+" ");
			node20.setVisibility(View.VISIBLE);
			
			node21.setText(x[11]+" ");
			node21.setVisibility(View.VISIBLE);
			
			node22.setText(x[12]+" ");
			node22.setVisibility(View.VISIBLE);
			arr22.setVisibility(View.VISIBLE);
			
		}
	}
	public void PEEK(View btnPeek)
	{
		
		
		if(count>6)
		{
			AlertDialog.Builder in=new AlertDialog.Builder(this);
			in.setTitle("PEEK").setMessage("TOP OF WHICH STACK(choose an option)");
			final RadioGroup Qrg1=new RadioGroup(this);
			final RadioButton s1=new RadioButton(this);
			s1.setText("STACK 1");
			final RadioButton s2=new RadioButton(this);
			s2.setText("STACK 2");
			Qrg1.addView(s1);Qrg1.addView(s2);
			in.setView(Qrg1);
			
			in.setPositiveButton("OK",new DialogInterface.OnClickListener()
			{
				
				
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					
					if(s1.isChecked())
					{
						Toast.makeText(DualStack.this,"TOP OF STACK 1:"+x[6], Toast.LENGTH_LONG).show();
					}
					else if(s2.isChecked())
					{
						Toast.makeText(DualStack.this,"TOP OF STACK 2:"+x[count], Toast.LENGTH_LONG).show();
					}
				}
			});
			in.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
			{
				@Override
				public void onClick(DialogInterface dialog, int which) 
				{
					
					return;
				}
			});
			in.show();
		}
		else if(count>0)
		{
			Toast.makeText(DualStack.this,"TOP OF STACK 1:"+x[count], Toast.LENGTH_LONG).show();
		}
					
		else
			Toast.makeText(DualStack.this,"STACK EMPTY : UNDERFLOW", Toast.LENGTH_LONG).show();
		
		
	}
	public void PUSH(View btnP)
	{
		AlertDialog.Builder input=new AlertDialog.Builder(this);
		input.setTitle("PUSH").setMessage("Enter a number");
		final EditText value=new EditText(this);
		input.setView(value);
		input.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(value.getText().toString().length()!=0 && increase()==1)
					try{
						x[count]=value.getText().toString();
						Draw_Push();
						new push_b().execute(x[count]);
					}catch(Exception e){}
			}
		});
		input.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				return;
			}
		});
		input.show();
		
	}
	public void Draw_Push()
	{
		TextView node11=(TextView)findViewById(R.id.Snode11);
		TextView node12=(TextView)findViewById(R.id.Snode12);
		TextView node13=(TextView)findViewById(R.id.Snode13);
		TextView node14=(TextView)findViewById(R.id.Snode14);
		TextView node15=(TextView)findViewById(R.id.Snode15);
		TextView node16=(TextView)findViewById(R.id.Snode16);
		TextView node17=(TextView)findViewById(R.id.Snode17);
		TextView node18=(TextView)findViewById(R.id.Snode18);
		TextView node19=(TextView)findViewById(R.id.Snode19);
		TextView node20=(TextView)findViewById(R.id.Snode20);
		TextView node21=(TextView)findViewById(R.id.Snode21);
		TextView node22=(TextView)findViewById(R.id.Snode22);
		arr11=(ImageView)findViewById(R.id.arr11);arr12=(ImageView)findViewById(R.id.arr12);
		arr13=(ImageView)findViewById(R.id.arr13);arr14=(ImageView)findViewById(R.id.arr14);
		arr15=(ImageView)findViewById(R.id.arr15);arr16=(ImageView)findViewById(R.id.arr16);
		arr17=(ImageView)findViewById(R.id.arr17);arr18=(ImageView)findViewById(R.id.arr18);
		arr19=(ImageView)findViewById(R.id.arr19);arr20=(ImageView)findViewById(R.id.arr20);
		arr21=(ImageView)findViewById(R.id.arr21);arr22=(ImageView)findViewById(R.id.arr22);
		if(count==1)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);
			arr11.setVisibility(View.VISIBLE);
		}
		else if(count==2)
		{
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);
			arr11.setVisibility(View.INVISIBLE);
			
			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);
			arr12.setVisibility(View.VISIBLE);
		}
		else if(count==3)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);
			arr13.setVisibility(View.VISIBLE);
		}
		
		else if(count==4)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);

			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);
			arr14.setVisibility(View.VISIBLE);
		}
		else if(count==5)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);

			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			arr15.setVisibility(View.VISIBLE);
		}
		else if(count==6)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);

			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			arr16.setVisibility(View.VISIBLE);
			
			Toast.makeText(DualStack.this,"STACK 1 FULL:ELEMENT WILL NOW BE INSERTED IN STACK 2", Toast.LENGTH_LONG).show();
			
		}
		else if(count==7)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);
			arr16.setVisibility(View.VISIBLE);
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.VISIBLE);
		}
		else if(count==8)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);
			arr16.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.INVISIBLE);
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			arr18.setVisibility(View.VISIBLE);
		}
		else if(count==9)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);
			arr16.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.INVISIBLE);
			arr18.setVisibility(View.INVISIBLE);
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			arr19.setVisibility(View.VISIBLE);
		}
		else if(count==10)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);
			arr16.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.INVISIBLE);
			arr18.setVisibility(View.INVISIBLE);
			arr19.setVisibility(View.INVISIBLE);
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			
			node20.setText(x[10]+" ");
			node20.setVisibility(View.VISIBLE);
			arr20.setVisibility(View.VISIBLE);
		}
		else if(count==11)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);
			arr16.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.INVISIBLE);
			arr18.setVisibility(View.INVISIBLE);
			arr19.setVisibility(View.INVISIBLE);
			arr20.setVisibility(View.INVISIBLE);
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			
			node20.setText(x[10]+" ");
			node20.setVisibility(View.VISIBLE);
			
			node21.setText(x[11]+" ");
			node21.setVisibility(View.VISIBLE);
			arr21.setVisibility(View.VISIBLE);
		}
		else if(count==12)
		{
			arr11.setVisibility(View.INVISIBLE);
			arr12.setVisibility(View.INVISIBLE);
			arr13.setVisibility(View.INVISIBLE);
			arr14.setVisibility(View.INVISIBLE);
			arr15.setVisibility(View.INVISIBLE);
			arr16.setVisibility(View.VISIBLE);
			arr17.setVisibility(View.INVISIBLE);
			arr18.setVisibility(View.INVISIBLE);
			arr19.setVisibility(View.INVISIBLE);
			arr20.setVisibility(View.INVISIBLE);
			arr21.setVisibility(View.INVISIBLE);
			node11.setText(x[1]+" ");
			node11.setVisibility(View.VISIBLE);

			node12.setText(x[2]+" ");
			node12.setVisibility(View.VISIBLE);

			node13.setText(x[3]+" ");
			node13.setVisibility(View.VISIBLE);

			node14.setText(x[4]+" ");
			node14.setVisibility(View.VISIBLE);

			node15.setText(x[5]+" ");
			node15.setVisibility(View.VISIBLE);
			
			node16.setText(x[6]+" ");
			node16.setVisibility(View.VISIBLE);
			
			node17.setText(x[7]+" ");
			node17.setVisibility(View.VISIBLE);
			
			node18.setText(x[8]+" ");
			node18.setVisibility(View.VISIBLE);
			
			node19.setText(x[9]+" ");
			node19.setVisibility(View.VISIBLE);
			
			node20.setText(x[10]+" ");
			node20.setVisibility(View.VISIBLE);
			
			node21.setText(x[11]+" ");
			node21.setVisibility(View.VISIBLE);
			
			node22.setText(x[12]+" ");
			node22.setVisibility(View.VISIBLE);
			arr22.setVisibility(View.VISIBLE);
		}
		
	}
	class push_b extends AsyncTask<String, Void ,String>
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
			if(result.compareTo("size")==0)
				Toast.makeText(DualStack.this,"ERROR in SIZE", Toast.LENGTH_LONG).show();
			else if(result.compareTo("size")==-1)
				Toast.makeText(DualStack.this," PUSHED : "+result, Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		getMenuInflater().inflate(R.menu.stack_dr, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item)
    {
		switch (item.getItemId()) 
		{
			case R.id.itemTree:
				callTree();
			break;
			
			case R.id.itemSearch:
				callSearch();	
				break;
			case R.id.itemLink:
				callLink();
				break;
			case R.id.itemQueue:
				callQueue();
				break;
			case R.id.itemSort:
				callSort();
				break;

			default:
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
			break;
		}
		return true;
    }
	public void callLink()
	{
		AlertDialog.Builder inputLink=new AlertDialog.Builder(this);
		inputLink.setTitle("LINK LIST TYPE ").setMessage("Choose a type ");
		final RadioGroup Qrg=new RadioGroup(this);
		final RadioButton sll=new RadioButton(this);
		sll.setText("Single Link List");
		final RadioButton dll=new RadioButton(this);
		dll.setText("Doubly Link List");
		Qrg.addView(sll);Qrg.addView(dll);
		inputLink.setView(Qrg);
		inputLink.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(sll.isChecked())
				{
					Intent replyIntent =new Intent(DualStack.this, LinkList_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dll.isChecked())
				{
					Intent replyIntent1 =new Intent(DualStack.this, DoubleLink.class);
					startActivityForResult(replyIntent1, 0);
				}
			}
		});
		inputLink.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				return;
			}
		});
		inputLink.show();
	}
	public void callQueue()
	{
		AlertDialog.Builder inputQueue=new AlertDialog.Builder(this);
		inputQueue.setTitle("QUEUE TYPE ").setMessage("Choose a type ");
		final RadioGroup Qrg=new RadioGroup(this);
		final RadioButton fifo=new RadioButton(this);
		fifo.setText("FIFO    QUEUE");
		final RadioButton Cqu=new RadioButton(this);
		Cqu.setText("CIRCULAR QUEUE");
		Qrg.addView(fifo);Qrg.addView(Cqu);
		inputQueue.setView(Qrg);
		inputQueue.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(fifo.isChecked())
				{
					Intent replyIntent =new Intent(DualStack.this, FifoQueue_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(Cqu.isChecked())
				{
					Intent replyIntent1 =new Intent(DualStack.this, CircularQueue_dr.class);
					startActivityForResult(replyIntent1, 0);
				}
			}
		});
		inputQueue.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				return;
			}
		});
		inputQueue.show();
	}
	public void callSearch()
	{
		AlertDialog.Builder impSearch=new AlertDialog.Builder(this);
		impSearch.setTitle("Searching ").setMessage("Linear Search ");
		impSearch.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				Intent i=new Intent(DualStack.this,LinearSearch.class);
				startActivity(i);
			}
		});
		impSearch.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				return;
			}
		});
		impSearch.show();
	}
	public void callSort()
	{
		AlertDialog.Builder inputQueue=new AlertDialog.Builder(this);
		inputQueue.setTitle("SORTING METHODs ").setMessage("Choose a Method ");
		final RadioGroup Qrg=new RadioGroup(this);
		final RadioButton sortB=new RadioButton(this);
		sortB.setText("Bubble Sort");
		final RadioButton sortS=new RadioButton(this);
		sortS.setText("Selection Sort");
		final RadioButton sortI=new RadioButton(this);
		sortI.setText("Insertion Sort");
		final RadioButton sortQ=new RadioButton(this);
		sortQ.setText("Quick Sort");
		final RadioButton sortM=new RadioButton(this);
		sortM.setText("Merge Sort");
		Qrg.addView(sortB);Qrg.addView(sortS);Qrg.addView(sortI);Qrg.addView(sortQ);Qrg.addView(sortM);
		inputQueue.setView(Qrg);
		inputQueue.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(sortB.isChecked())
				{
					Intent replyIntent =new Intent(DualStack.this, BubbleSort1.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(sortS.isChecked())
				{
					Intent replyIntent1 =new Intent(DualStack.this, SelectionSort1.class);
					startActivityForResult(replyIntent1, 0);
				}
				else if(sortQ.isChecked())
				{
					Intent replyIntent2 =new Intent(DualStack.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortM.isChecked())
				{
					Intent replyIntent2 =new Intent(DualStack.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortI.isChecked())
				{
					Intent replyIntent2 =new Intent(DualStack.this, InsertionActivity.class);
					startActivityForResult(replyIntent2, 0);
				}
			}
		});
		inputQueue.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				return;
			}
		});
		inputQueue.show();
	}
	public void callTree()
	{
		AlertDialog.Builder inputTree=new AlertDialog.Builder(this);
		inputTree.setTitle("Tree ").setMessage("Choose a type ");
		final RadioGroup Qrg=new RadioGroup(this);
		final RadioButton bst=new RadioButton(this);
		bst.setText("Binary Search Tree(BST)");
		final RadioButton avl=new RadioButton(this);
		avl.setText("Adelson Velskii Landis Tree(AVL)");
		Qrg.addView(bst);Qrg.addView(avl);
		inputTree.setView(Qrg);
		inputTree.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(bst.isChecked())
				{
					Intent replyIntent =new Intent(DualStack.this, Tree_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(avl.isChecked())
				{
					Intent replyIntent1 =new Intent(DualStack.this, AvlTree1.class);
					startActivityForResult(replyIntent1, 0);
				}
			}
		});
		inputTree.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				return;
			}
		});
		inputTree.show();
	}
	


}


	
