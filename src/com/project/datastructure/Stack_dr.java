package com.project.datastructure;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.R.color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.Gravity;
import android.view.Menu;
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

public class Stack_dr extends Activity
{
	String x[]=new String[7];int count=0,size=0,g=1;
	final String s1=" ";String output;
	Button btnPush;Button btnPop;Button btnPeek;Button btnSize;
	ImageView arr1;ImageView arr2;ImageView arr3;
	ImageView arr4;ImageView arr5;ImageView arr6;
	Resources resources;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stack_dr);
		btnPush=(Button)findViewById(R.id.btnPush);btnPush.setEnabled(false);
		btnPop=(Button)findViewById(R.id.btnPop);btnPop.setEnabled(false);
		btnPeek=(Button)findViewById(R.id.btnPeek);btnPeek.setEnabled(false);
		btnSize=(Button)findViewById(R.id.btnSize);btnSize.setEnabled(true);
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
							btnPush.setEnabled(true);
							btnPop.setEnabled(true);
							btnPeek.setEnabled(true);
							btnSize.setEnabled(false);
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
			Toast.makeText(Stack_dr.this,"STACK FULL : OVERFULL", Toast.LENGTH_LONG).show();
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
			Toast.makeText(Stack_dr.this,"STACK EMPTY : UNDERFLOW", Toast.LENGTH_LONG).show();
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
							btnPush.setEnabled(true);
							btnPop.setEnabled(true);
							btnPeek.setEnabled(true);
							btnSize.setEnabled(false);
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
		TextView node1=(TextView)findViewById(R.id.Snode1);
		TextView node2=(TextView)findViewById(R.id.Snode2);
		TextView node3=(TextView)findViewById(R.id.Snode3);
		TextView node4=(TextView)findViewById(R.id.Snode4);
		TextView node5=(TextView)findViewById(R.id.Snode5);
		TextView node6=(TextView)findViewById(R.id.Snode6);
		arr1=(ImageView)findViewById(R.id.arr1);arr2=(ImageView)findViewById(R.id.arr2);
		arr3=(ImageView)findViewById(R.id.arr3);arr4=(ImageView)findViewById(R.id.arr4);
		arr5=(ImageView)findViewById(R.id.arr5);arr6=(ImageView)findViewById(R.id.arr6);
		node1.setVisibility(View.INVISIBLE);node2.setVisibility(View.INVISIBLE);
		node3.setVisibility(View.INVISIBLE);node4.setVisibility(View.INVISIBLE);
		node5.setVisibility(View.INVISIBLE);node6.setVisibility(View.INVISIBLE);
		arr1.setVisibility(View.INVISIBLE);arr2.setVisibility(View.INVISIBLE);
		arr3.setVisibility(View.INVISIBLE);arr4.setVisibility(View.INVISIBLE);
		arr5.setVisibility(View.INVISIBLE);arr6.setVisibility(View.INVISIBLE);
		decrease();
		if(count==0)
		{
			//CLEAR(b);
		}
		else if(count==1)
		{
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);
			arr1.setVisibility(View.VISIBLE);
		}
		else if(count==2)
		{
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);
			arr2.setVisibility(View.VISIBLE);
		}
		else if(count==3)
		{
			
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);
			arr3.setVisibility(View.VISIBLE);
		}
		else if(count==4)
		{
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);

			node4.setText(x[4]+" ");
			node4.setVisibility(View.VISIBLE);
			arr4.setVisibility(View.VISIBLE);
			
		}
		else if(count==5)
		{
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);

			node4.setText(x[4]+" ");
			node4.setVisibility(View.VISIBLE);

			node5.setText(x[5]+" ");
			node5.setVisibility(View.VISIBLE);
			arr5.setVisibility(View.VISIBLE);
			
		}
	}
	public void PEEK(View btnPeek)
	{
		AlertDialog.Builder input=new AlertDialog.Builder(this);
		input.setTitle("PEEK").setMessage("TOP OF STACK");
		final TextView value=new TextView(this);
		value.setGravity(Gravity.CENTER);
		input.setView(value);
		if(count>0)
			value.setText(x[count].toString());
		else
			Toast.makeText(Stack_dr.this,"STACK EMPTY : UNDERFLOW", Toast.LENGTH_LONG).show();
		input.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{return;
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
		TextView node1=(TextView)findViewById(R.id.Snode1);
		TextView node2=(TextView)findViewById(R.id.Snode2);
		TextView node3=(TextView)findViewById(R.id.Snode3);
		TextView node4=(TextView)findViewById(R.id.Snode4);
		TextView node5=(TextView)findViewById(R.id.Snode5);
		TextView node6=(TextView)findViewById(R.id.Snode6);
		arr1=(ImageView)findViewById(R.id.arr1);arr2=(ImageView)findViewById(R.id.arr2);
		arr3=(ImageView)findViewById(R.id.arr3);arr4=(ImageView)findViewById(R.id.arr4);
		arr5=(ImageView)findViewById(R.id.arr5);arr6=(ImageView)findViewById(R.id.arr6);
		if(count==1)
		{
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);
			arr1.setVisibility(View.VISIBLE);
		}
		else if(count==2)
		{
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);
			arr1.setVisibility(View.INVISIBLE);
			
			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);
			arr2.setVisibility(View.VISIBLE);
		}
		else if(count==3)
		{
			arr1.setVisibility(View.INVISIBLE);
			arr2.setVisibility(View.INVISIBLE);
			
			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);
			arr3.setVisibility(View.VISIBLE);
		}
		
		else if(count==4)
		{
			arr1.setVisibility(View.INVISIBLE);
			arr2.setVisibility(View.INVISIBLE);
			arr3.setVisibility(View.INVISIBLE);

			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);

			node4.setText(x[4]+" ");
			node4.setVisibility(View.VISIBLE);
			arr4.setVisibility(View.VISIBLE);
		}
		else if(count==5)
		{
			arr1.setVisibility(View.INVISIBLE);
			arr2.setVisibility(View.INVISIBLE);
			arr3.setVisibility(View.INVISIBLE);
			arr4.setVisibility(View.INVISIBLE);

			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);

			node4.setText(x[4]+" ");
			node4.setVisibility(View.VISIBLE);

			node5.setText(x[5]+" ");
			node5.setVisibility(View.VISIBLE);
			arr5.setVisibility(View.VISIBLE);
		}
		else if(count==6)
		{
			arr1.setVisibility(View.INVISIBLE);
			arr2.setVisibility(View.INVISIBLE);
			arr3.setVisibility(View.INVISIBLE);
			arr4.setVisibility(View.INVISIBLE);
			arr5.setVisibility(View.INVISIBLE);

			node1.setText(x[1]+" ");
			node1.setVisibility(View.VISIBLE);

			node2.setText(x[2]+" ");
			node2.setVisibility(View.VISIBLE);

			node3.setText(x[3]+" ");
			node3.setVisibility(View.VISIBLE);

			node4.setText(x[4]+" ");
			node4.setVisibility(View.VISIBLE);

			node5.setText(x[5]+" ");
			node5.setVisibility(View.VISIBLE);
			
			node6.setText(x[6]+" ");
			node6.setVisibility(View.VISIBLE);
			arr6.setVisibility(View.VISIBLE);
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
				Toast.makeText(Stack_dr.this,"ERROR in SIZE", Toast.LENGTH_LONG).show();
			else if(result.compareTo("size")==-1)
				Toast.makeText(Stack_dr.this," PUSHED : "+result, Toast.LENGTH_LONG).show();
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
					Intent replyIntent =new Intent(Stack_dr.this, FifoQueue_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(Cqu.isChecked())
				{
					Intent replyIntent1 =new Intent(Stack_dr.this, CircularQueue_dr.class);
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
					Intent replyIntent =new Intent(Stack_dr.this, LinkList_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dll.isChecked())
				{
					Intent replyIntent1 =new Intent(Stack_dr.this, DoubleLink.class);
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
	public void callSearch()
	{
		AlertDialog.Builder impSearch=new AlertDialog.Builder(this);
		impSearch.setTitle("Searching ").setMessage("Linear Search ");
		impSearch.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				Intent i=new Intent(Stack_dr.this,LinearSearch.class);
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
					Intent replyIntent =new Intent(Stack_dr.this, BubbleSort1.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(sortS.isChecked())
				{
					Intent replyIntent1 =new Intent(Stack_dr.this, SelectionSort1.class);
					startActivityForResult(replyIntent1, 0);
				}
				else if(sortQ.isChecked())
				{
					Intent replyIntent2 =new Intent(Stack_dr.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortM.isChecked())
				{
					Intent replyIntent2 =new Intent(Stack_dr.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortI.isChecked())
				{
					Intent replyIntent2 =new Intent(Stack_dr.this, InsertionActivity.class);
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
					Intent replyIntent =new Intent(Stack_dr.this, Tree_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(avl.isChecked())
				{
					Intent replyIntent1 =new Intent(Stack_dr.this, AvlTree1.class);
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
