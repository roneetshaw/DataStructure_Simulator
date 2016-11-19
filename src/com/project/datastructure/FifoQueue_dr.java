package com.project.datastructure;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.net.Uri;
import android.os.AsyncTask;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FifoQueue_dr extends Activity 
{
	int s=90,count=0,countfrnt=0,s1=90;
	String queue[]={"-99","-99","-99","-99","-99","-99","-99","-99","-99","-99"};
	ImageView rear1;ImageView rear2;ImageView rear3;ImageView rear4;ImageView rear5;ImageView rear6;
	ImageView rear7;ImageView rear8;ImageView rear9;
	ImageView front1;ImageView front2;ImageView front3;	ImageView front4;ImageView front5;ImageView front6;
	ImageView front7;ImageView front8;ImageView front9;
	TextView txtrear1;TextView txtrear2;TextView txtrear3;TextView txtrear4;TextView txtrear5;TextView txtrear6;
	TextView txtrear7;TextView txtrear8;TextView txtrear9;
	TextView txtfront1;TextView txtfront2;TextView txtfront3;TextView txtfront4;TextView txtfront5;TextView txtfront6;
	TextView txtfront7;TextView txtfront8;TextView txtfront9;
	TextView node1;TextView node2;TextView node3;TextView node4;
	TextView node5;TextView node6;TextView node7;TextView node8;TextView node9;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fifo_queue_dr);
		rear1=(ImageView)findViewById(R.id.Qrear1);rear2=(ImageView)findViewById(R.id.Qrear2);rear3=(ImageView)findViewById(R.id.Qrear3);
		rear4=(ImageView)findViewById(R.id.Qrear4);rear5=(ImageView)findViewById(R.id.Qrear5);rear6=(ImageView)findViewById(R.id.Qrear6);
		rear7=(ImageView)findViewById(R.id.Qrear7);rear8=(ImageView)findViewById(R.id.Qrear8);rear9=(ImageView)findViewById(R.id.Qrear9);
		front1=(ImageView)findViewById(R.id.Qfront1);front2=(ImageView)findViewById(R.id.Qfront2);front3=(ImageView)findViewById(R.id.Qfront3);
		front4=(ImageView)findViewById(R.id.Qfront4);front5=(ImageView)findViewById(R.id.Qfront5);front6=(ImageView)findViewById(R.id.Qfront6);
		front7=(ImageView)findViewById(R.id.Qfront7);front8=(ImageView)findViewById(R.id.Qfront8);front9=(ImageView)findViewById(R.id.Qfront9);
		txtrear1=(TextView)findViewById(R.id.txtRear1);txtrear2=(TextView)findViewById(R.id.txtRear2);txtrear3=(TextView)findViewById(R.id.txtRear3);
		txtrear4=(TextView)findViewById(R.id.txtRear4);txtrear5=(TextView)findViewById(R.id.txtRear5);txtrear6=(TextView)findViewById(R.id.txtRear6);
		txtrear7=(TextView)findViewById(R.id.txtRear7);txtrear8=(TextView)findViewById(R.id.txtRear8);txtrear9=(TextView)findViewById(R.id.txtRear9);
		txtfront1=(TextView)findViewById(R.id.txtFront1);txtfront2=(TextView)findViewById(R.id.txtFront2);txtfront3=(TextView)findViewById(R.id.txtFront3);
		txtfront4=(TextView)findViewById(R.id.txtFront4);txtfront5=(TextView)findViewById(R.id.txtFront5);txtfront6=(TextView)findViewById(R.id.txtFront6);
		txtfront7=(TextView)findViewById(R.id.txtFront7);txtfront8=(TextView)findViewById(R.id.txtFront8);txtfront9=(TextView)findViewById(R.id.txtFront9);
		node1=(TextView)findViewById(R.id.fifoNode1);node2=(TextView)findViewById(R.id.fifoNode2);
		node3=(TextView)findViewById(R.id.fifoNode3);node4=(TextView)findViewById(R.id.fifoNode4);
		node5=(TextView)findViewById(R.id.fifoNode5);node6=(TextView)findViewById(R.id.fifoNode6);
		node7=(TextView)findViewById(R.id.fifoNode7);node8=(TextView)findViewById(R.id.fifoNode8);
		node9=(TextView)findViewById(R.id.fifoNode9);
		rear1.setVisibility(View.INVISIBLE);rear2.setVisibility(View.INVISIBLE);rear3.setVisibility(View.INVISIBLE);
		rear4.setVisibility(View.INVISIBLE);rear5.setVisibility(View.INVISIBLE);rear6.setVisibility(View.INVISIBLE);
		rear7.setVisibility(View.INVISIBLE);rear8.setVisibility(View.INVISIBLE);rear9.setVisibility(View.INVISIBLE);
		front1.setVisibility(View.INVISIBLE);front2.setVisibility(View.INVISIBLE);front3.setVisibility(View.INVISIBLE);
		front4.setVisibility(View.INVISIBLE);front5.setVisibility(View.INVISIBLE);front6.setVisibility(View.INVISIBLE);
		front7.setVisibility(View.INVISIBLE);front8.setVisibility(View.INVISIBLE);front9.setVisibility(View.INVISIBLE);
		txtrear2.setVisibility(View.INVISIBLE);txtrear3.setVisibility(View.INVISIBLE);txtrear4.setVisibility(View.INVISIBLE);
		txtrear5.setVisibility(View.INVISIBLE);txtrear6.setVisibility(View.INVISIBLE);txtrear7.setVisibility(View.INVISIBLE);
		txtrear8.setVisibility(View.INVISIBLE);txtrear9.setVisibility(View.INVISIBLE);
		txtfront2.setVisibility(View.INVISIBLE);txtfront3.setVisibility(View.INVISIBLE);txtfront4.setVisibility(View.INVISIBLE);
		txtfront5.setVisibility(View.INVISIBLE);txtfront6.setVisibility(View.INVISIBLE);txtfront7.setVisibility(View.INVISIBLE);
		txtfront8.setVisibility(View.INVISIBLE);txtfront9.setVisibility(View.INVISIBLE);
	}
	public void DEQUEUE(View btnDel)
	{
		if(countfrnt < 9 && count > 0 && countfrnt < count)
		{
			countfrnt++;
			Toast.makeText(FifoQueue_dr.this,"DELETED : "+queue[countfrnt], Toast.LENGTH_SHORT).show();
			queue[countfrnt]="-99";
			redrawDel();
		}
		else
			new fifoQueue_b().execute("empty");
	}
	public void ENQUEUE(View btnAdd)
	{
		
		AlertDialog.Builder inputAdd=new AlertDialog.Builder(this);
		inputAdd.setTitle("ENQUEUE ").setMessage("Enter an Element ");
		final EditText value=new EditText(this);
		inputAdd.setView(value);
		inputAdd.setPositiveButton("OK",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				if(value.getText().toString().length()!=0)
				{
					if(count<9)
					{
						count++;
						queue[count]=value.getText().toString();
						redraw();
					}
					else
						new fifoQueue_b().execute("full");
				}
				else
					new fifoQueue_b().execute("value");
			}
		});
		inputAdd.setNegativeButton("CANCEL",new DialogInterface.OnClickListener() 
		{
			@Override
			public void onClick(DialogInterface dialog, int which) 
			{
				return;
			}
		});
		inputAdd.show();
		
	}
	public void CLEAR(View btnClear)
	{
		Intent replyIntent =new Intent(btnClear.getContext(), FifoQueue_dr.class);
		startActivityForResult(replyIntent, 0);
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
					CopyReadAssets("FifoQueue_hi.pdf");
				}
				else if(en.isChecked())
				{
					CopyReadAssets("FifoQueue_en.pdf");
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
	public void Cqueue(View btnCqueue)
	{
		Intent replyIntent =new Intent(btnCqueue.getContext(), CircularQueue_dr.class);
		startActivityForResult(replyIntent, 0);
	}
	private void redraw()
	{
		if(queue[1].compareTo("-99")!=0)
			node1.setText(queue[1]);
		if(queue[2].compareTo("-99")!=0)
			node2.setText(queue[2]);
		if(queue[3].compareTo("-99")!=0)
			node3.setText(queue[3]);
		if(queue[4].compareTo("-99")!=0)
			node4.setText(queue[4]);
		if(queue[5].compareTo("-99")!=0)
			node5.setText(queue[5]);
		if(queue[6].compareTo("-99")!=0)
			node6.setText(queue[6]);
		if(queue[7].compareTo("-99")!=0)
			node7.setText(queue[7]);
		if(queue[8].compareTo("-99")!=0)
			node8.setText(queue[8]);
		if(queue[9].compareTo("-99")!=0)
			node9.setText(queue[9]);
		if(count==1)
		{
			txtrear1.setVisibility(View.VISIBLE);
			txtrear1.setText("REAR :"+count);
			rear1.setVisibility(View.VISIBLE);
		}
		else if(count==2)
		{
			txtrear1.setVisibility(View.INVISIBLE);
			rear1.setVisibility(View.INVISIBLE);
			rear2.setVisibility(View.VISIBLE);
			txtrear2.setVisibility(View.VISIBLE);
		}
		else if(count==3)
		{
			txtrear2.setVisibility(View.INVISIBLE);
			rear2.setVisibility(View.INVISIBLE);
			rear3.setVisibility(View.VISIBLE);
			txtrear3.setVisibility(View.VISIBLE);
		}
		else if(count==4)
		{
			txtrear3.setVisibility(View.INVISIBLE);
			rear3.setVisibility(View.INVISIBLE);
			rear4.setVisibility(View.VISIBLE);
			txtrear4.setVisibility(View.VISIBLE);
		}
		else if(count==5)
		{
			txtrear4.setVisibility(View.INVISIBLE);
			rear4.setVisibility(View.INVISIBLE);
			rear5.setVisibility(View.VISIBLE);
			txtrear5.setVisibility(View.VISIBLE);
		}
		else if(count==6)
		{
			txtrear5.setVisibility(View.INVISIBLE);
			rear5.setVisibility(View.INVISIBLE);
			rear6.setVisibility(View.VISIBLE);
			txtrear6.setVisibility(View.VISIBLE);
		}
		else if(count==7)
		{
			txtrear6.setVisibility(View.INVISIBLE);
			rear6.setVisibility(View.INVISIBLE);
			rear7.setVisibility(View.VISIBLE);
			txtrear7.setVisibility(View.VISIBLE);
		}
		else if(count==8)
		{
			txtrear7.setVisibility(View.INVISIBLE);
			rear7.setVisibility(View.INVISIBLE);
			rear8.setVisibility(View.VISIBLE);
			txtrear8.setVisibility(View.VISIBLE);
		}
		else if(count==9)
		{
			txtrear8.setVisibility(View.INVISIBLE);
			rear8.setVisibility(View.INVISIBLE);
			rear9.setVisibility(View.VISIBLE);
			txtrear9.setVisibility(View.VISIBLE);
		}
	}
	private void redrawDel()
	{
		node1.setText(" ");node2.setText(" ");node3.setText(" ");
		node4.setText(" ");node5.setText(" ");node6.setText(" ");
		node7.setText(" ");node8.setText(" ");node9.setText(" ");
		if(queue[1].compareTo("-99")!=0)
			node1.setText(queue[1]);
		if(queue[2].compareTo("-99")!=0)
			node2.setText(queue[2]);
		if(queue[3].compareTo("-99")!=0)
			node3.setText(queue[3]);
		if(queue[4].compareTo("-99")!=0)
			node4.setText(queue[4]);
		if(queue[5].compareTo("-99")!=0)
			node5.setText(queue[5]);
		if(queue[6].compareTo("-99")!=0)
			node6.setText(queue[6]);
		if(queue[7].compareTo("-99")!=0)
			node7.setText(queue[7]);
		if(queue[8].compareTo("-99")!=0)
			node8.setText(queue[8]);
		if(queue[9].compareTo("-99")!=0)
			node9.setText(queue[9]);                                               
		if(countfrnt==1)
		{
			txtfront1.setVisibility(View.VISIBLE);
			txtfront1.setText("FRONT :"+countfrnt);
			front1.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==2)
		{
			txtfront1.setVisibility(View.INVISIBLE);
			front1.setVisibility(View.INVISIBLE);
			front2.setVisibility(View.VISIBLE);
			txtfront2.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==3)
		{
			txtfront2.setVisibility(View.INVISIBLE);
			front2.setVisibility(View.INVISIBLE);
			front3.setVisibility(View.VISIBLE);
			txtfront3.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==4)
		{
			txtfront3.setVisibility(View.INVISIBLE);
			front3.setVisibility(View.INVISIBLE);
			front4.setVisibility(View.VISIBLE);
			txtfront4.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==5)
		{
			txtfront4.setVisibility(View.INVISIBLE);
			front4.setVisibility(View.INVISIBLE);
			front5.setVisibility(View.VISIBLE);
			txtfront5.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==6)
		{
			txtfront5.setVisibility(View.INVISIBLE);
			front5.setVisibility(View.INVISIBLE);
			front6.setVisibility(View.VISIBLE);
			txtfront6.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==7)
		{
			txtfront6.setVisibility(View.INVISIBLE);
			front6.setVisibility(View.INVISIBLE);
			front7.setVisibility(View.VISIBLE);
			txtfront7.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==8)
		{
			txtfront7.setVisibility(View.INVISIBLE);
			front7.setVisibility(View.INVISIBLE);
			front8.setVisibility(View.VISIBLE);
			txtfront8.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==9)
		{
			txtfront8.setVisibility(View.INVISIBLE);
			front8.setVisibility(View.INVISIBLE);
			front9.setVisibility(View.VISIBLE);
			txtfront9.setVisibility(View.VISIBLE);
		}
		
	}
	class fifoQueue_b extends AsyncTask<String, Void ,String>
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
			if(result.compareTo("full")==0)
				Toast.makeText(FifoQueue_dr.this,"QUEUE is FULL !!", Toast.LENGTH_SHORT).show();
			else if(result.compareTo("value")==0)
				Toast.makeText(FifoQueue_dr.this,"ERROR in value !!", Toast.LENGTH_LONG).show();
			else if(result.compareTo("empty")==0)
				Toast.makeText(FifoQueue_dr.this,"QUEUE EMPTY !!", Toast.LENGTH_LONG).show();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fifo_dr, menu);
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
					Intent replyIntent =new Intent(FifoQueue_dr.this, Stack_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dstack.isChecked())
				{
					Intent replyIntent1 =new Intent(FifoQueue_dr.this, DualStack.class);
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
					Intent replyIntent =new Intent(FifoQueue_dr.this, LinkList_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dll.isChecked())
				{
					Intent replyIntent1 =new Intent(FifoQueue_dr.this, DoubleLink.class);
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
				Intent i=new Intent(FifoQueue_dr.this,LinearSearch.class);
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
					Intent replyIntent =new Intent(FifoQueue_dr.this, BubbleSort1.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(sortS.isChecked())
				{
					Intent replyIntent1 =new Intent(FifoQueue_dr.this, SelectionSort1.class);
					startActivityForResult(replyIntent1, 0);
				}
				else if(sortQ.isChecked())
				{
					Intent replyIntent2 =new Intent(FifoQueue_dr.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortM.isChecked())
				{
					Intent replyIntent2 =new Intent(FifoQueue_dr.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortI.isChecked())
				{
					Intent replyIntent2 =new Intent(FifoQueue_dr.this, InsertionActivity.class);
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
					Intent replyIntent =new Intent(FifoQueue_dr.this, Tree_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(avl.isChecked())
				{
					Intent replyIntent1 =new Intent(FifoQueue_dr.this, AvlTree1.class);
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
