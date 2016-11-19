package com.project.datastructure;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SelectionSort2 extends Activity {
	int[] selection={Integer.parseInt(SelectionSort3.s2[0]),Integer.parseInt(SelectionSort3.s2[1]),Integer.parseInt(SelectionSort3.s2[2]),Integer.parseInt(SelectionSort3.s2[3])};
	int count=0;
	int temp;
	int x=0,y=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selection_sort2);
		TextView arr1=(TextView)findViewById(R.id.txV1);
		TextView arr2=(TextView)findViewById(R.id.txV2);
		TextView arr3=(TextView)findViewById(R.id.txV3);
		TextView arr4=(TextView)findViewById(R.id.txV4);
		
		arr1.setText(Integer.toString(selection[0]));
		arr2.setText(Integer.toString(selection[1]));
		arr3.setText(Integer.toString(selection[2]));
		arr4.setText(Integer.toString(selection[3]));
	}
	
	public void seSort(View btnnxt1) 
	{
		ImageView img1=(ImageView)findViewById(R.id.iV1);
		ImageView img2=(ImageView)findViewById(R.id.iV2);
		ImageView img3=(ImageView)findViewById(R.id.iV3);
		ImageView img4=(ImageView)findViewById(R.id.iV4);
		ImageView img5=(ImageView)findViewById(R.id.iV5);
		ImageView img6=(ImageView)findViewById(R.id.iV6);
		ImageView img7=(ImageView)findViewById(R.id.imV1);
		ImageView img8=(ImageView)findViewById(R.id.imV2);
		ImageView img9=(ImageView)findViewById(R.id.imV3);
		ImageView img10=(ImageView)findViewById(R.id.imV4);
		Button bb=(Button)findViewById(R.id.btnnxt1);
		TextView arr6=(TextView)findViewById(R.id.txV6);
		TextView arr7=(TextView)findViewById(R.id.txV7);
		TextView arr8=(TextView)findViewById(R.id.txV8);
		TextView arr9=(TextView)findViewById(R.id.txV9);
		TextView arr10=(TextView)findViewById(R.id.txV10);
		TextView arr11=(TextView)findViewById(R.id.txV11);
		TextView arr12=(TextView)findViewById(R.id.txV12);
		TextView arr13=(TextView)findViewById(R.id.txV13);
		TextView arr14=(TextView)findViewById(R.id.txV14);
		TextView arr15=(TextView)findViewById(R.id.txV15);
		TextView arr16=(TextView)findViewById(R.id.txV16);
		TextView arr17=(TextView)findViewById(R.id.txV17);
		
		TextView arr20=(TextView)findViewById(R.id.txV20);
		TextView arr21=(TextView)findViewById(R.id.txV21);
		TextView arr22=(TextView)findViewById(R.id.txV22);
		
		TextView arr24=(TextView)findViewById(R.id.txV24);
		TextView arr25=(TextView)findViewById(R.id.txV25);
		
		TextView arr27=(TextView)findViewById(R.id.txV27);
		TextView arr28=(TextView)findViewById(R.id.txV28);
		TextView arr29=(TextView)findViewById(R.id.txV29);
		TextView arr30=(TextView)findViewById(R.id.txV30);
		
		TextView arr32=(TextView)findViewById(R.id.txV32);
		TextView arr33=(TextView)findViewById(R.id.txV33);
		TextView arr34=(TextView)findViewById(R.id.txV34);
		
		TextView arr36=(TextView)findViewById(R.id.txV36);
		TextView arr37=(TextView)findViewById(R.id.txV37);
		TextView arr38=(TextView)findViewById(R.id.txV38);
		TextView arr39=(TextView)findViewById(R.id.txV39);
		TextView arr40=(TextView)findViewById(R.id.txV40);
		
		if(count==0)
		{
			if(x==0)
			{
				arr11.setVisibility(View.VISIBLE);
				img7.setVisibility(View.VISIBLE);
				img8.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 0th and 1st ELEMENT");
				x=1;
			}
			
			else if(selection[0]>selection[1])
			{
				swap(selection,0,1);
				arr40.setText("SWAPPED : "+selection[0]+" > "+selection[1]);
				y=1;
			}
			else
			{
				arr40.setText("NO SWAPPING:");
				y=1;
			}
			if(x==1 && y==1)
			{
				
				img1.setVisibility(View.VISIBLE);
				arr14.setVisibility(View.VISIBLE);
				arr14.setText(Integer.toString(selection[0]));
				arr15.setVisibility(View.VISIBLE);
				arr15.setText(Integer.toString(selection[1]));
				arr16.setVisibility(View.VISIBLE);
				arr16.setText(Integer.toString(selection[2]));
				arr17.setVisibility(View.VISIBLE);
				arr17.setText(Integer.toString(selection[3]));
				count++;
				x=0;
				y=0;
			}
		}
		
		else if(count==1)
		{
			if(x==0)
			{
				img8.setVisibility(View.INVISIBLE);
				img7.setVisibility(View.VISIBLE);
				img9.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 0th and 2nd ELEMENT");
				x=1;
			}
			else if(selection[0]>selection[2])
			{
				swap(selection,0,2);
				arr40.setText("SWAPPED : "+selection[1]+" > "+selection[2]);
				y=1;
			}
			else
			{
				arr40.setText("NO SWAPPING:");
				y=1;
			}
			if(x==1 && y==1)
			{
				img2.setVisibility(View.VISIBLE);
				arr27.setVisibility(View.VISIBLE);
				arr27.setText(Integer.toString(selection[0]));
				arr28.setVisibility(View.VISIBLE);
				arr28.setText(Integer.toString(selection[1]));
				arr29.setVisibility(View.VISIBLE);
				arr29.setText(Integer.toString(selection[2]));
				arr30.setVisibility(View.VISIBLE);
				arr30.setText(Integer.toString(selection[3]));
				count++;
				x=0;
				y=0;
			}
		}
		
		else if(count==2)
		{
			if(x==0)
			{
				img8.setVisibility(View.INVISIBLE);
				img9.setVisibility(View.INVISIBLE);
				img7.setVisibility(View.VISIBLE);
				img10.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 0th and 3rd ELEMENT");
				x=1;
			}
			else if(selection[0]>selection[3])
			{
				swap(selection,0,3);
				arr40.setText("SWAPPED : "+selection[0]+" > "+selection[3]);
				y=1;
			}
			else
			{
				arr40.setText("NO SWAPPING:");
				y=1;
			}
			if(x==1 && y==1)
			{
				img3.setVisibility(View.VISIBLE);
				arr36.setVisibility(View.VISIBLE);
				arr36.setText(Integer.toString(selection[0]));
				arr37.setVisibility(View.VISIBLE);
				arr37.setText(Integer.toString(selection[1]));
				arr38.setVisibility(View.VISIBLE);
				arr38.setText(Integer.toString(selection[2]));
				arr39.setVisibility(View.VISIBLE);
				arr39.setText(Integer.toString(selection[3]));
				
				arr6.setVisibility(View.VISIBLE);
				arr6.setText(Integer.toString(selection[0]));
				
				count++;
				x=0;
				y=0;
			}
		}
		
		else if(count==3)
		{
			if(x==0)
			{
				img7.setVisibility(View.INVISIBLE);
				img10.setVisibility(View.INVISIBLE);
				img8.setVisibility(View.VISIBLE);
				img9.setVisibility(View.VISIBLE);
				arr12.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 1st and 2nd ELEMENT");
				x=1;
			}
			else if(selection[1]>selection[2])
			{
				swap(selection,1,2);
				arr40.setText("SWAPPED : "+selection[1]+" > "+selection[2]);
				y=1;
			}
			else
			{
				arr40.setText("NO SWAPPING:");
				y=1;
			}
			if(x==1 && y==1)
			{
				img4.setVisibility(View.VISIBLE);
				
				arr20.setVisibility(View.VISIBLE);
				arr20.setText(Integer.toString(selection[1]));
				arr21.setVisibility(View.VISIBLE);
				arr21.setText(Integer.toString(selection[2]));
				arr22.setVisibility(View.VISIBLE);
				arr22.setText(Integer.toString(selection[3]));
				
				count++;
				x=0;
				y=0;
			}
		}
		
		else if(count==4)
		{
			if(x==0)
			{
				img7.setVisibility(View.INVISIBLE);
				img8.setVisibility(View.VISIBLE);
				img9.setVisibility(View.INVISIBLE);
				img10.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 1st and 3rd ELEMENT");
				x=1;
			}
			
			else if(selection[1]>selection[3])
			{
				swap(selection,1,3);
				arr40.setText("SWAPPED : "+selection[1]+" > "+selection[3]);
				y=1;
			}
			else
			{
				arr40.setText("NO SWAPPING:");
				y=1;
			}
			if(x==1 && y==1)
			{
				img5.setVisibility(View.VISIBLE);
				arr32.setVisibility(View.VISIBLE);
				arr32.setText(Integer.toString(selection[1]));
				arr33.setVisibility(View.VISIBLE);
				arr33.setText(Integer.toString(selection[2]));
				arr34.setVisibility(View.VISIBLE);
				arr34.setText(Integer.toString(selection[3]));
				arr7.setVisibility(View.VISIBLE);
				arr7.setText(Integer.toString(selection[1]));
				
				count++;
				x=0;
				y=0;
			}
		}
		
		else if(count==5)
		{
			if(x==0)
			{
				img7.setVisibility(View.INVISIBLE);
				img8.setVisibility(View.INVISIBLE);
				img9.setVisibility(View.VISIBLE);
				img10.setVisibility(View.VISIBLE);
				arr13.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 2nd and 3rd ELEMENT");
				x=1;
			}
			else if(selection[2]>selection[3])
			{
				swap(selection,2,3);
				arr40.setText("SWAPPED : "+selection[2]+" > "+selection[3]);
				y=1;
			}
			else
			{
				arr40.setText("NO SWAPPING:");
				y=1;
			}
			if(x==1 && y==1)
			{
				img6.setVisibility(View.VISIBLE);
				
				arr24.setVisibility(View.VISIBLE);
				arr24.setText(Integer.toString(selection[2]));
				arr25.setVisibility(View.VISIBLE);
				arr25.setText(Integer.toString(selection[3]));
				arr8.setVisibility(View.VISIBLE);
				arr8.setText(Integer.toString(selection[2]));
				arr9.setVisibility(View.VISIBLE);
				arr9.setText(Integer.toString(selection[3]));
				arr10.setVisibility(View.VISIBLE);
				Toast.makeText(this,"SORTING DONE: ", Toast.LENGTH_LONG).show();
				bb.setEnabled(false);
			}
			
		}
	}
	
	public void swap(int[] selection,int pos1,int pos2)
	{
		temp=selection[pos1];
		selection[pos1]=selection[pos2];
		selection[pos2]=temp;
	}

	

}
