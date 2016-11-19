package com.project.datastructure;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class LinearSearch extends Activity {
	
	int key;
	
	int count=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_linear_search);
		TextView tv1=(TextView)findViewById(R.id.tView1);
		TextView tv2=(TextView)findViewById(R.id.tView2);
		TextView tv3=(TextView)findViewById(R.id.tView3);
		TextView tv4=(TextView)findViewById(R.id.tView4);
		TextView tv5=(TextView)findViewById(R.id.tView5);
		TextView tv6=(TextView)findViewById(R.id.tView6);
		tv1.setText("13");
		tv2.setText("27");
		tv3.setText("48");
		tv4.setText("63");
		tv5.setText("84");
		tv6.setText("97");
	}
	public void key(View btnkey)
	{
		final Button b1=(Button)findViewById(R.id.btnkey);
		AlertDialog.Builder s=new AlertDialog.Builder(this);
		s.setTitle("KEY").setMessage("Enter Element to search ");
		final EditText value=new EditText(this);
		s.setView(value);
		s.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
					key=Integer.parseInt(value.getText().toString());
					b1.setEnabled(false);
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
	public void search(View btnsrch)
	{
		TextView tv1=(TextView)findViewById(R.id.tView1);
		TextView tv2=(TextView)findViewById(R.id.tView2);
		TextView tv3=(TextView)findViewById(R.id.tView3);
		TextView tv4=(TextView)findViewById(R.id.tView4);
		TextView tv5=(TextView)findViewById(R.id.tView5);
		TextView tv6=(TextView)findViewById(R.id.tView6);
		TextView tv7=(TextView)findViewById(R.id.tView7);
		TextView tv8=(TextView)findViewById(R.id.tView8);
		TextView tv9=(TextView)findViewById(R.id.tView9);
		TextView tv10=(TextView)findViewById(R.id.tView10);
		TextView tv11=(TextView)findViewById(R.id.tView11);
		TextView tv12=(TextView)findViewById(R.id.tView12);
		TextView tv13=(TextView)findViewById(R.id.tView13);
		ImageView iv1=(ImageView)findViewById(R.id.iView1);
		ImageView iv2=(ImageView)findViewById(R.id.iView2);
		ImageView iv3=(ImageView)findViewById(R.id.iView3);
		ImageView iv4=(ImageView)findViewById(R.id.iView4);
		ImageView iv5=(ImageView)findViewById(R.id.iView5);
		ImageView iv6=(ImageView)findViewById(R.id.iView6);
		Button b1=(Button)findViewById(R.id.btnkey);
		Button b2=(Button)findViewById(R.id.btnsrch);
		if(count==0)
		{
			tv13.setText("COMPARISON WITH 1st ELEMENT");
			iv1.setVisibility(View.VISIBLE);
			if(key==Integer.parseInt(tv1.getText().toString()))
			{
				tv7.setText("=Key");
				tv13.setText("Found At Index:"+count);
				b2.setEnabled(false);
				
			}
			else
			{
				tv7.setText("!=Key");
				
			}
			count++;
			
		}
		
		else if(count==1)
		{
			iv1.setVisibility(View.INVISIBLE);
			tv7.setVisibility(View.INVISIBLE);
			tv13.setText("COMPARISON WITH 2nd ELEMENT");
			iv2.setVisibility(View.VISIBLE);
			if(key==Integer.parseInt(tv2.getText().toString()))
			{
				tv8.setText("=Key");
				tv13.setText("Found At Index: "+count);
				
				b2.setEnabled(false);
			}
			else
			{
				tv8.setText("!=Key");
				
			}
			count++;
		}
		
		else if(count==2)
		{
			iv2.setVisibility(View.INVISIBLE);
			tv8.setVisibility(View.INVISIBLE);
			tv13.setText("COMPARISON WITH 3rd ELEMENT");
			iv3.setVisibility(View.VISIBLE);
			if(key==Integer.parseInt(tv3.getText().toString()))
			{
				tv9.setText("=Key");
				tv13.setText("Found At Index:"+count);
				
				b2.setEnabled(false);
			}
			else
			{
				tv9.setText("!=Key");
				
			}
			count++;
		}
		
		else if(count==3)
		{
			iv3.setVisibility(View.INVISIBLE);
			tv9.setVisibility(View.INVISIBLE);
			tv13.setText("COMPARISON WITH 4th ELEMENT");
			iv4.setVisibility(View.VISIBLE);
			if(key==Integer.parseInt(tv4.getText().toString()))
			{
				tv10.setText("=Key");
				tv13.setText("Found At Index:"+count);
				
				b2.setEnabled(false);
			}
			else
			{
				tv10.setText("!=Key");
				
			}
			count++;
		}
		
		else if(count==4)
		{
			iv4.setVisibility(View.INVISIBLE);
			tv10.setVisibility(View.INVISIBLE);
			tv13.setText("COMPARISON WITH 5th ELEMENT");
			iv5.setVisibility(View.VISIBLE);
			if(key==Integer.parseInt(tv5.getText().toString()))
			{
				tv11.setText("=Key");
				tv13.setText("Found At Index:"+count);
				
				b2.setEnabled(false);
			}
			else
			{
				tv11.setText("!=Key");
				
			}
			count++;
		}
		
		else if(count==5)
		{
			iv5.setVisibility(View.INVISIBLE);
			tv11.setVisibility(View.INVISIBLE);
			tv13.setText("COMPARISON WITH 6th ELEMENT");
			iv6.setVisibility(View.VISIBLE);
			if(key==Integer.parseInt(tv6.getText().toString()))
			{
				tv12.setText("=Key");
				tv13.setText("Found At Index:"+count);
				
				b2.setEnabled(false);
			}
			else
			{
				tv12.setText("!=Key");
				
			}
			count++;
		}
		else
		{
			iv6.setVisibility(View.INVISIBLE);
			tv13.setText("INVALID KEY");
			tv12.setVisibility(View.INVISIBLE);
			b2.setEnabled(false);
		}
	}
	public void DOCS(View v)
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
					CopyReadAssets("LinearSearch_hi.pdf");
				}
				else if(en.isChecked())
				{
					CopyReadAssets("LinearSearch_en.pdf");
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
	public void CLEAR(View btncler)
	{
		Intent replyIntent =new Intent(this,  LinearSearch.class);		
		startActivityForResult(replyIntent, 0);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.linearsearch, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item)
    {
		switch (item.getItemId()) 
		{
			case R.id.itemTree:
				callTree();
			break;
			
			case R.id.itemQueue:
				callQueue();	
				break;
			case R.id.itemLink:
				callLink();
				break;
			case R.id.itemStack:
				callStack();
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
	public void callStack()
	{
		AlertDialog.Builder inputStack=new AlertDialog.Builder(this);
		inputStack.setTitle("Stack ").setMessage("Choose a type ");
		final RadioGroup Qrg=new RadioGroup(this);
		final RadioButton stack=new RadioButton(this);
		stack.setText("Stack");
		final RadioButton dstack=new RadioButton(this);
		dstack.setText("Dual Stack");
		Qrg.addView(stack);Qrg.addView(dstack);
		inputStack.setView(Qrg);
		inputStack.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(stack.isChecked())
				{
					Intent replyIntent =new Intent(LinearSearch.this, Stack_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dstack.isChecked())
				{
					Intent replyIntent1 =new Intent(LinearSearch.this, DualStack.class);
					startActivityForResult(replyIntent1, 0);
				}
			}
		});
		inputStack.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				
				return;
			}
		});
		inputStack.show();
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
					Intent replyIntent =new Intent(LinearSearch.this, LinkList_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dll.isChecked())
				{
					Intent replyIntent1 =new Intent(LinearSearch.this, DoubleLink.class);
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
					Intent replyIntent =new Intent(LinearSearch.this, LinearSearch.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(Cqu.isChecked())
				{
					Intent replyIntent1 =new Intent(LinearSearch.this, CircularQueue_dr.class);
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
					Intent replyIntent =new Intent(LinearSearch.this, BubbleSort1.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(sortS.isChecked())
				{
					Intent replyIntent1 =new Intent(LinearSearch.this, SelectionSort1.class);
					startActivityForResult(replyIntent1, 0);
				}
				else if(sortQ.isChecked())
				{
					Intent replyIntent2 =new Intent(LinearSearch.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortM.isChecked())
				{
					Intent replyIntent2 =new Intent(LinearSearch.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortI.isChecked())
				{
					Intent replyIntent2 =new Intent(LinearSearch.this, InsertionActivity.class);
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
					Intent replyIntent =new Intent(LinearSearch.this, Tree_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(avl.isChecked())
				{
					Intent replyIntent1 =new Intent(LinearSearch.this, AvlTree1.class);
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
