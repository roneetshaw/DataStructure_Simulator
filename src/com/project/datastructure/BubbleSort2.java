package com.project.datastructure;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BubbleSort2 extends Activity {
	
	int[] bubble={Integer.parseInt(BubbleSort3.s1[0]),Integer.parseInt(BubbleSort3.s1[1]),Integer.parseInt(BubbleSort3.s1[2]),Integer.parseInt(BubbleSort3.s1[3])};
	
	int count=0;
	int temp;
	int x=0;
	int y=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bubble_sort2);
		TextView arr1=(TextView)findViewById(R.id.tV1);
		TextView arr2=(TextView)findViewById(R.id.tV2);
		TextView arr3=(TextView)findViewById(R.id.tV3);
		TextView arr4=(TextView)findViewById(R.id.tV4);
		
		arr1.setText(Integer.toString(bubble[0]));
		arr2.setText(Integer.toString(bubble[1]));
		arr3.setText(Integer.toString(bubble[2]));
		arr4.setText(Integer.toString(bubble[3]));
	}
	public void bbSort(View btnnxt)
	{
		ImageView img1=(ImageView)findViewById(R.id.ibV1);
		ImageView img2=(ImageView)findViewById(R.id.ibV2);
		ImageView img3=(ImageView)findViewById(R.id.ibV3);
		ImageView img4=(ImageView)findViewById(R.id.ibV4);
		ImageView img5=(ImageView)findViewById(R.id.ibV5);
		ImageView img6=(ImageView)findViewById(R.id.ibV6);
		ImageView img7=(ImageView)findViewById(R.id.imgV1);
		ImageView img8=(ImageView)findViewById(R.id.imgV2);
		ImageView img9=(ImageView)findViewById(R.id.imgV3);
		ImageView img10=(ImageView)findViewById(R.id.imgV4);
		Button bb=(Button)findViewById(R.id.btnnxt);
		TextView arr6=(TextView)findViewById(R.id.tV6);
		TextView arr7=(TextView)findViewById(R.id.tV7);
		TextView arr8=(TextView)findViewById(R.id.tV8);
		TextView arr9=(TextView)findViewById(R.id.tV9);
		TextView arr10=(TextView)findViewById(R.id.tV10);
		TextView arr11=(TextView)findViewById(R.id.tV11);
		TextView arr12=(TextView)findViewById(R.id.tV12);
		TextView arr13=(TextView)findViewById(R.id.tV13);
		TextView arr14=(TextView)findViewById(R.id.tV14);
		TextView arr15=(TextView)findViewById(R.id.tV15);
		TextView arr16=(TextView)findViewById(R.id.tV16);
		TextView arr17=(TextView)findViewById(R.id.tV17);
		
		TextView arr20=(TextView)findViewById(R.id.tV20);
		TextView arr21=(TextView)findViewById(R.id.tV21);
		TextView arr22=(TextView)findViewById(R.id.tV22);
		
		TextView arr24=(TextView)findViewById(R.id.tV24);
		TextView arr25=(TextView)findViewById(R.id.tV25);
		
		TextView arr27=(TextView)findViewById(R.id.tV27);
		TextView arr28=(TextView)findViewById(R.id.tV28);
		TextView arr29=(TextView)findViewById(R.id.tV29);
		TextView arr30=(TextView)findViewById(R.id.tV30);
		
		TextView arr32=(TextView)findViewById(R.id.tV32);
		TextView arr33=(TextView)findViewById(R.id.tV33);
		TextView arr34=(TextView)findViewById(R.id.tV34);
		
		TextView arr36=(TextView)findViewById(R.id.tV36);
		TextView arr37=(TextView)findViewById(R.id.tV37);
		TextView arr38=(TextView)findViewById(R.id.tV38);
		TextView arr39=(TextView)findViewById(R.id.tV39);
		TextView arr40=(TextView)findViewById(R.id.tV40);
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
			else if(bubble[0]>bubble[1])
			{
				swap(bubble,0,1);
				arr40.setText("SWAPPED : "+bubble[0]+" AND "+bubble[1]);
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
				arr14.setText(Integer.toString(bubble[0]));
				arr15.setVisibility(View.VISIBLE);
				arr15.setText(Integer.toString(bubble[1]));
				arr16.setVisibility(View.VISIBLE);
				arr16.setText(Integer.toString(bubble[2]));
				arr17.setVisibility(View.VISIBLE);
				arr17.setText(Integer.toString(bubble[3]));
				
				count++;
				x=0;
				y=0;
			}
		}
		else if(count==1)
		{
			if(x==0)
			{
				img8.setVisibility(View.VISIBLE);
				img7.setVisibility(View.INVISIBLE);
				img9.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 1st and 2nd ELEMENT");
				x=1;
			}
			else if(bubble[1]>bubble[2])
			{
				swap(bubble,1,2);
				arr40.setText("SWAPPED : "+bubble[1]+" AND "+bubble[2]);
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
				arr27.setText(Integer.toString(bubble[0]));
				arr28.setVisibility(View.VISIBLE);
				arr28.setText(Integer.toString(bubble[1]));
				arr29.setVisibility(View.VISIBLE);
				arr29.setText(Integer.toString(bubble[2]));
				arr30.setVisibility(View.VISIBLE);
				arr30.setText(Integer.toString(bubble[3]));
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
				img9.setVisibility(View.VISIBLE);
				img7.setVisibility(View.INVISIBLE);
				img10.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 2nd and 3rd ELEMENT");
				x=1;
			}
			else if(bubble[2]>bubble[3])
			{
				swap(bubble,2,3);
				arr40.setText("SWAPPED : "+bubble[2]+" AND "+bubble[3]);
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
				arr36.setText(Integer.toString(bubble[0]));
				arr37.setVisibility(View.VISIBLE);
				arr37.setText(Integer.toString(bubble[1]));
				arr38.setVisibility(View.VISIBLE);
				arr38.setText(Integer.toString(bubble[2]));
				arr39.setVisibility(View.VISIBLE);
				arr39.setText(Integer.toString(bubble[3]));
				
				arr9.setVisibility(View.VISIBLE);
				arr9.setText(Integer.toString(bubble[3]));
				
				count++;
				x=0;
				y=0;
			}
		}
		else if(count==3)
		{
			if(x==0)
			{
				img7.setVisibility(View.VISIBLE);
				img10.setVisibility(View.INVISIBLE);
				img8.setVisibility(View.VISIBLE);
				img9.setVisibility(View.INVISIBLE);
				arr12.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 0th and 1st ELEMENT");
				x=1;
			}
			else if(bubble[0]>bubble[1])
			{
				swap(bubble,0,1);
				arr40.setText("SWAPPED : "+bubble[0]+" AND "+bubble[1]);
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
				arr20.setText(Integer.toString(bubble[0]));
				arr21.setVisibility(View.VISIBLE);
				arr21.setText(Integer.toString(bubble[1]));
				arr22.setVisibility(View.VISIBLE);
				arr22.setText(Integer.toString(bubble[2]));
				
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
				img9.setVisibility(View.VISIBLE);
				img10.setVisibility(View.INVISIBLE);
				arr40.setText("COMPARISON OF 2nd and 3rd ELEMENT");
				x=1;
			}
			else if(bubble[1]>bubble[2])
			{
				swap(bubble,1,2);
				arr40.setText("SWAPPED : "+bubble[1]+" AND "+bubble[2]);
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
				arr32.setText(Integer.toString(bubble[0]));
				arr33.setVisibility(View.VISIBLE);
				arr33.setText(Integer.toString(bubble[1]));
				arr34.setVisibility(View.VISIBLE);
				arr34.setText(Integer.toString(bubble[2]));
				arr8.setVisibility(View.VISIBLE);
				arr8.setText(Integer.toString(bubble[2]));
				
				count++;
				x=0;
				y=0;
			}
		}
		else if(count==5)
		{
			if(x==0)
			{
				img7.setVisibility(View.VISIBLE);
				img8.setVisibility(View.VISIBLE);
				img9.setVisibility(View.INVISIBLE);
				img10.setVisibility(View.INVISIBLE);
				arr13.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 2nd and 3rd ELEMENT");
				x=1;
			}
			else if(bubble[0]>bubble[1])
			{
				swap(bubble,0,1);
				arr40.setText("SWAPPED : "+bubble[0]+" AND "+bubble[1]);
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
				arr24.setText(Integer.toString(bubble[0]));
				arr25.setVisibility(View.VISIBLE);
				arr25.setText(Integer.toString(bubble[1]));
				arr7.setVisibility(View.VISIBLE);
				arr7.setText(Integer.toString(bubble[1]));
				arr6.setVisibility(View.VISIBLE);
				arr6.setText(Integer.toString(bubble[0]));
				arr10.setVisibility(View.VISIBLE);
				Toast.makeText(this,"SORTING DONE: ", Toast.LENGTH_LONG).show();
				bb.setEnabled(false);
				x=0;
				y=0;
			}
			
		}
		
	}
	public void swap(int[] bubble,int pos1,int pos2)
	{
		temp=bubble[pos1];
		bubble[pos1]=bubble[pos2];
		bubble[pos2]=temp;
	}
}
