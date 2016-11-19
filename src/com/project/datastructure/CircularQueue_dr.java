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

public class CircularQueue_dr extends Activity {

	int s=90,count=0,countfrnt=0,s1=99,e=0,e1;
	String queue[]={"-99","-99","-99","-99","-99","-99","-99","-99","-99","-99"};
	ImageView Cfront1;ImageView Cfront2;ImageView Cfront3;ImageView Cfront4;ImageView Cfront5;ImageView Cfront6;
	ImageView Cfront7;ImageView Cfront8;ImageView Cfront9;
	ImageView Crear1;ImageView Crear2;ImageView Crear8;ImageView Crear3;ImageView Crear4;ImageView Crear5;
	ImageView Crear6;ImageView Crear7;ImageView Crear9;
	TextView TxtCrear1;TextView TxtCrear2;TextView TxtCrear3;
	TextView TxtCrear4;TextView TxtCrear5;TextView TxtCrear6;
	TextView TxtCrear7;TextView TxtCrear8;TextView TxtCrear9;
	TextView TxtCfront1;TextView TxtCfront2;TextView TxtCfront3;
	TextView TxtCfront4;TextView TxtCfront5;TextView TxtCfront6;
	TextView TxtCfront7;TextView TxtCfront8;TextView TxtCfront9;
	TextView node1;TextView node2;TextView node3;TextView node4;
	TextView node5;TextView node6;TextView node7;TextView node8;TextView node9;
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circular_queue);
		Crear1=(ImageView)findViewById(R.id.cirRear1);Crear2=(ImageView)findViewById(R.id.cirRear2);Crear3=(ImageView)findViewById(R.id.cirRear3);
		Crear4=(ImageView)findViewById(R.id.cirRear4);Crear5=(ImageView)findViewById(R.id.cirRear5);Crear6=(ImageView)findViewById(R.id.cirRear6);
		Crear7=(ImageView)findViewById(R.id.cirRear7);Crear8=(ImageView)findViewById(R.id.cirRear8);Crear9=(ImageView)findViewById(R.id.cirRear9);
		Cfront1=(ImageView)findViewById(R.id.cirFront1);Cfront2=(ImageView)findViewById(R.id.cirFront2);Cfront3=(ImageView)findViewById(R.id.cirFront3);
		Cfront4=(ImageView)findViewById(R.id.cirFront4);Cfront5=(ImageView)findViewById(R.id.cirFront5);Cfront6=(ImageView)findViewById(R.id.cirFront6);
		Cfront7=(ImageView)findViewById(R.id.cirFront7);Cfront8=(ImageView)findViewById(R.id.cirFront8);Cfront9=(ImageView)findViewById(R.id.cirFront9);
		TxtCrear1=(TextView)findViewById(R.id.txtCrear1);TxtCrear2=(TextView)findViewById(R.id.txtCrear2);TxtCrear3=(TextView)findViewById(R.id.txtCrear3);
		TxtCrear4=(TextView)findViewById(R.id.txtCrear4);TxtCrear5=(TextView)findViewById(R.id.txtCrear5);TxtCrear6=(TextView)findViewById(R.id.txtCrear6);
		TxtCrear7=(TextView)findViewById(R.id.txtCrear7);TxtCrear8=(TextView)findViewById(R.id.txtCrear8);TxtCrear9=(TextView)findViewById(R.id.txtCrear9);
		TxtCfront1=(TextView)findViewById(R.id.txtCfront1);TxtCfront2=(TextView)findViewById(R.id.txtCfront2);TxtCfront3=(TextView)findViewById(R.id.txtCfront3);
		TxtCfront4=(TextView)findViewById(R.id.txtCfront4);TxtCfront5=(TextView)findViewById(R.id.txtCfront5);TxtCfront6=(TextView)findViewById(R.id.txtCfront6);
		TxtCfront7=(TextView)findViewById(R.id.txtCfront7);TxtCfront8=(TextView)findViewById(R.id.txtCfront8);TxtCfront9=(TextView)findViewById(R.id.txtCfront9);
		node1=(TextView)findViewById(R.id.CNode1);node2=(TextView)findViewById(R.id.CNode2);
		node3=(TextView)findViewById(R.id.CNode3);node4=(TextView)findViewById(R.id.CNode4);
		node5=(TextView)findViewById(R.id.CNode5);node6=(TextView)findViewById(R.id.CNode6);
		node7=(TextView)findViewById(R.id.CNode7);node8=(TextView)findViewById(R.id.CNode8);
		node9=(TextView)findViewById(R.id.CNode9);
		Crear1.setVisibility(View.INVISIBLE); Crear2.setVisibility(View.INVISIBLE);Crear3.setVisibility(View.INVISIBLE);
		Crear4.setVisibility(View.INVISIBLE); Crear5.setVisibility(View.INVISIBLE);Crear6.setVisibility(View.INVISIBLE);
		Crear7.setVisibility(View.INVISIBLE); Crear8.setVisibility(View.INVISIBLE);Crear9.setVisibility(View.INVISIBLE);
		TxtCrear2.setVisibility(View.INVISIBLE);TxtCrear3.setVisibility(View.INVISIBLE);TxtCrear4.setVisibility(View.INVISIBLE);
		TxtCrear5.setVisibility(View.INVISIBLE);TxtCrear6.setVisibility(View.INVISIBLE);TxtCrear7.setVisibility(View.INVISIBLE);
		TxtCrear8.setVisibility(View.INVISIBLE);TxtCrear9.setVisibility(View.INVISIBLE);
		Cfront1.setVisibility(View.INVISIBLE);Cfront2.setVisibility(View.INVISIBLE);Cfront3.setVisibility(View.INVISIBLE);
		Cfront4.setVisibility(View.INVISIBLE);Cfront5.setVisibility(View.INVISIBLE);Cfront6.setVisibility(View.INVISIBLE);
		Cfront7.setVisibility(View.INVISIBLE);Cfront8.setVisibility(View.INVISIBLE);Cfront9.setVisibility(View.INVISIBLE);
		TxtCfront2.setVisibility(View.INVISIBLE);TxtCfront3.setVisibility(View.INVISIBLE);TxtCfront4.setVisibility(View.INVISIBLE);
		TxtCfront6.setVisibility(View.INVISIBLE);TxtCfront5.setVisibility(View.INVISIBLE);TxtCfront7.setVisibility(View.INVISIBLE);
		TxtCfront8.setVisibility(View.INVISIBLE);TxtCfront9.setVisibility(View.INVISIBLE);
	}
	public void DEQUEUE(View btnDel)
	{
		if(isEmpty())
			new CirQueue_b().execute("empty");
		else
		{
			countfrnt++;
			if(countfrnt==10)
			{
				s1=99;
				countfrnt=1;
			}
			Toast.makeText(CircularQueue_dr.this,"DELETED : "+queue[countfrnt], Toast.LENGTH_SHORT).show();
			queue[countfrnt]="-99";
			redrawDel();
			
		}
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
					if(isFull())
						new CirQueue_b().execute("full");
					else
					{
						count++;
						if(count==10)
						{	
							count=1; 
						}
						queue[count]=value.getText().toString();
						redraw();
					}
				}
				else
					new CirQueue_b().execute("value");
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
	private boolean isEmpty()
	{
		int i;
		for(e1=0,i=1;i<=9;i++)
			if(queue[i].compareTo("-99")==0)
				e1++;
		if(e1==9)
			return true;
		else
			return false;
	}
	private boolean isFull()
	{
		int i;
		for(e=0,i=1;i<=9;i++)
			if(queue[i].compareTo("-99")!=0)
				e++;
		if(e==9)
			return true;
		else
			return false;
	}
	public void CLEAR(View btnClear)
	{
		Intent replyIntent =new Intent(btnClear.getContext(), CircularQueue_dr.class);
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
					CopyReadAssets("CQueue_hi.pdf");
				}
				else if(en.isChecked())
				{
					CopyReadAssets("CQueue_en.pdf");
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
	public void FIFO(View btnFifo)
	{
		Intent replyIntent =new Intent(btnFifo.getContext(), FifoQueue_dr.class);
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
			TxtCrear9.setVisibility(View.INVISIBLE);
			Crear9.setVisibility(View.INVISIBLE);
			TxtCrear1.setVisibility(View.VISIBLE);
			TxtCrear1.setText("REAR :"+count);
			Crear1.setVisibility(View.VISIBLE);
		}
		else if(count==2)
		{
			TxtCrear1.setVisibility(View.INVISIBLE);
			Crear1.setVisibility(View.INVISIBLE);
			Crear2.setVisibility(View.VISIBLE);
			TxtCrear2.setVisibility(View.VISIBLE);
		}
		else if(count==3)
		{
			TxtCrear2.setVisibility(View.INVISIBLE);
			Crear2.setVisibility(View.INVISIBLE);
			Crear3.setVisibility(View.VISIBLE);
			TxtCrear3.setVisibility(View.VISIBLE);
		}
		else if(count==4)
		{
			TxtCrear3.setVisibility(View.INVISIBLE);
			Crear3.setVisibility(View.INVISIBLE);
			Crear4.setVisibility(View.VISIBLE);
			TxtCrear4.setVisibility(View.VISIBLE);
		}
		else if(count==5)
		{
			TxtCrear4.setVisibility(View.INVISIBLE);
			Crear4.setVisibility(View.INVISIBLE);
			Crear5.setVisibility(View.VISIBLE);
			TxtCrear5.setVisibility(View.VISIBLE);
		}
		else if(count==6)
		{
			TxtCrear5.setVisibility(View.INVISIBLE);
			Crear5.setVisibility(View.INVISIBLE);
			Crear6.setVisibility(View.VISIBLE);
			TxtCrear6.setVisibility(View.VISIBLE);
		}
		else if(count==7)
		{
			TxtCrear6.setVisibility(View.INVISIBLE);
			Crear6.setVisibility(View.INVISIBLE);
			Crear7.setVisibility(View.VISIBLE);
			TxtCrear7.setVisibility(View.VISIBLE);
		}
		else if(count==8)
		{
			TxtCrear7.setVisibility(View.INVISIBLE);
			Crear7.setVisibility(View.INVISIBLE);
			Crear8.setVisibility(View.VISIBLE);
			TxtCrear8.setVisibility(View.VISIBLE);
		}
		else if(count==9)
		{
			TxtCrear8.setVisibility(View.INVISIBLE);
			Crear8.setVisibility(View.INVISIBLE);
			Crear9.setVisibility(View.VISIBLE);
			TxtCrear9.setVisibility(View.VISIBLE);
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
			TxtCfront9.setVisibility(View.INVISIBLE);
			Cfront9.setVisibility(View.INVISIBLE);
			TxtCfront1.setVisibility(View.VISIBLE);
			TxtCfront1.setText("FRONT :"+countfrnt);
			Cfront1.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==2)
		{
			TxtCfront1.setVisibility(View.INVISIBLE);
			Cfront1.setVisibility(View.INVISIBLE);
			Cfront2.setVisibility(View.VISIBLE);
			TxtCfront2.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==3)
		{
			TxtCfront2.setVisibility(View.INVISIBLE);
			Cfront2.setVisibility(View.INVISIBLE);
			Cfront3.setVisibility(View.VISIBLE);
			TxtCfront3.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==4)
		{
			TxtCfront3.setVisibility(View.INVISIBLE);
			Cfront3.setVisibility(View.INVISIBLE);
			Cfront4.setVisibility(View.VISIBLE);
			TxtCfront4.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==5)
		{
			TxtCfront4.setVisibility(View.INVISIBLE);
			Cfront4.setVisibility(View.INVISIBLE);
			Cfront5.setVisibility(View.VISIBLE);
			TxtCfront5.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==6)
		{
			TxtCfront5.setVisibility(View.INVISIBLE);
			Cfront5.setVisibility(View.INVISIBLE);
			Cfront6.setVisibility(View.VISIBLE);
			TxtCfront6.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==7)
		{
			TxtCfront6.setVisibility(View.INVISIBLE);
			Cfront6.setVisibility(View.INVISIBLE);
			Cfront7.setVisibility(View.VISIBLE);
			TxtCfront7.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==8)
		{
			TxtCfront7.setVisibility(View.INVISIBLE);
			Cfront7.setVisibility(View.INVISIBLE);
			Cfront8.setVisibility(View.VISIBLE);
			TxtCfront8.setVisibility(View.VISIBLE);
		}
		else if(countfrnt==9)
		{
			TxtCfront8.setVisibility(View.INVISIBLE);
			Cfront8.setVisibility(View.INVISIBLE);
			Cfront9.setVisibility(View.VISIBLE);
			TxtCfront9.setVisibility(View.VISIBLE);
		}
		
	}
	class CirQueue_b extends AsyncTask<String, Void ,String>
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
				Toast.makeText(CircularQueue_dr.this,"QUEUE is FULL !!", Toast.LENGTH_SHORT).show();
			else if(result.compareTo("value")==0)
				Toast.makeText(CircularQueue_dr.this,"ERROR in value !!", Toast.LENGTH_LONG).show();
			else if(result.compareTo("empty")==0)
				Toast.makeText(CircularQueue_dr.this,"QUEUE EMPTY !!", Toast.LENGTH_LONG).show();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.queue_dr, menu);
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
					Intent replyIntent =new Intent(CircularQueue_dr.this, Stack_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dstack.isChecked())
				{
					Intent replyIntent1 =new Intent(CircularQueue_dr.this, DualStack.class);
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
					Intent replyIntent =new Intent(CircularQueue_dr.this, LinkList_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(dll.isChecked())
				{
					Intent replyIntent1 =new Intent(CircularQueue_dr.this, DoubleLink.class);
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
				Intent i=new Intent(CircularQueue_dr.this,LinearSearch.class);
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
					Intent replyIntent =new Intent(CircularQueue_dr.this, BubbleSort1.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(sortS.isChecked())
				{
					Intent replyIntent1 =new Intent(CircularQueue_dr.this, SelectionSort1.class);
					startActivityForResult(replyIntent1, 0);
				}
				else if(sortQ.isChecked())
				{
					Intent replyIntent2 =new Intent(CircularQueue_dr.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortM.isChecked())
				{
					Intent replyIntent2 =new Intent(CircularQueue_dr.this, LinearSearch.class);
					startActivityForResult(replyIntent2, 0);
				}
				else if(sortI.isChecked())
				{
					Intent replyIntent2 =new Intent(CircularQueue_dr.this, InsertionActivity.class);
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
					Intent replyIntent =new Intent(CircularQueue_dr.this, Tree_dr.class);
					startActivityForResult(replyIntent, 0);
				}
				else if(avl.isChecked())
				{
					Intent replyIntent1 =new Intent(CircularQueue_dr.this, AvlTree1.class);
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

