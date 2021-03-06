package com.project.datastructure;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class InsertionActivity extends Activity 
{
	WebView wbInsert;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertion);
		wbInsert=(WebView)findViewById(R.id.webViewInsertion);
		wbInsert.setVerticalScrollBarEnabled(false);
		wbInsert.setHorizontalScrollBarEnabled(false);
		wbInsert.getSettings().setJavaScriptEnabled(true);
		wbInsert.setOnTouchListener(new View.OnTouchListener()
		{
			@Override
            public boolean onTouch(View v, MotionEvent event) {
              return (event.getAction() == MotionEvent.ACTION_MOVE);
            }

          });
        String URL="insertiongif.gif";
        String html = "<html><body><img src=\"" + URL + "\" width=\"100%\" height=\"100%\"\"/></body></html>";
        wbInsert.loadDataWithBaseURL("file:///android_asset/",html, "text/html","utf-8", null);
        wbInsert.setBackgroundResource(R.color.white);
        wbInsert.setBackgroundColor(0);
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
					CopyReadAssets("InsertionSort_hi.pdf");
				}
				else if(en.isChecked())
				{
					CopyReadAssets("InsertionSort_en.pdf");
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
	public void onClickSimulate(View v)
	{
		Intent i=new Intent(this,InsertionSort2.class);
		startActivity(i);
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
			case R.id.itemStack:
				callStack();
				break;
			case R.id.itemQueue:
				callQueue();
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
					Intent replyIntent =new Intent(InsertionActivity.this, Stack_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dstack.isChecked())
				{
					Intent replyIntent1 =new Intent(InsertionActivity.this, DualStack.class);
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
					Intent replyIntent =new Intent(InsertionActivity.this, LinkList_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dll.isChecked())
				{
					Intent replyIntent1 =new Intent(InsertionActivity.this, DoubleLink.class);
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
				Intent i=new Intent(InsertionActivity.this,LinearSearch.class);
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
					Intent replyIntent =new Intent(InsertionActivity.this, FifoQueue_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(Cqu.isChecked())
				{
					Intent replyIntent1 =new Intent(InsertionActivity.this, CircularQueue_dr.class);
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
					Intent replyIntent =new Intent(InsertionActivity.this, Tree_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(avl.isChecked())
				{
					Intent replyIntent1 =new Intent(InsertionActivity.this, AvlTree1.class);
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
