package com.project.datastructure;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InsertionSort2 extends Activity {
	int[] insertion={9,5,7,1};
	int count=0;
	int temp,k;
	int x=0,y=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insertion_sort2);
		TextView arr1=(TextView)findViewById(R.id.texV1);
		TextView arr2=(TextView)findViewById(R.id.texV2);
		TextView arr3=(TextView)findViewById(R.id.texV3);
		TextView arr4=(TextView)findViewById(R.id.texV4);
		
		arr1.setText(Integer.toString(insertion[0]));
		arr2.setText(Integer.toString(insertion[1]));
		arr3.setText(Integer.toString(insertion[2]));
		arr4.setText(Integer.toString(insertion[3]));
	}
	
	public void inSort(View btnnxt1) 
	{
		ImageView img1=(ImageView)findViewById(R.id.imeV1);
		ImageView img2=(ImageView)findViewById(R.id.imeV2);
		ImageView img3=(ImageView)findViewById(R.id.imeV7);
		ImageView img4=(ImageView)findViewById(R.id.imeV4);
		ImageView img5=(ImageView)findViewById(R.id.imeV5);
		ImageView img6=(ImageView)findViewById(R.id.imeV6);
		ImageView img7=(ImageView)findViewById(R.id.imgeV1);
		ImageView img8=(ImageView)findViewById(R.id.imgeV2);
		ImageView img9=(ImageView)findViewById(R.id.imgeV3);
		ImageView img10=(ImageView)findViewById(R.id.imgeV4);
		ImageView img11=(ImageView)findViewById(R.id.imVw1);
		ImageView img12=(ImageView)findViewById(R.id.imVw2);
		ImageView img13=(ImageView)findViewById(R.id.imVw7);
		ImageView img14=(ImageView)findViewById(R.id.imVw3);
		ImageView img15=(ImageView)findViewById(R.id.imVw8);
		ImageView img16=(ImageView)findViewById(R.id.imVw4);
		ImageView img17=(ImageView)findViewById(R.id.imVw5);
		ImageView img18=(ImageView)findViewById(R.id.imVw6);
		Button bb=(Button)findViewById(R.id.btnnxt2);
		TextView arr6=(TextView)findViewById(R.id.texV6);
		TextView arr7=(TextView)findViewById(R.id.texV7);
		TextView arr8=(TextView)findViewById(R.id.texV8);
		TextView arr9=(TextView)findViewById(R.id.texV9);
		TextView arr10=(TextView)findViewById(R.id.texV10);
		TextView arr11=(TextView)findViewById(R.id.texV11);
		TextView arr12=(TextView)findViewById(R.id.texV12);
		TextView arr13=(TextView)findViewById(R.id.texV13);
		TextView arr14=(TextView)findViewById(R.id.texV14);
		TextView arr15=(TextView)findViewById(R.id.texV15);
		TextView arr16=(TextView)findViewById(R.id.texV16);
		TextView arr17=(TextView)findViewById(R.id.texV17);
		
		TextView arr20=(TextView)findViewById(R.id.texV20);
		TextView arr21=(TextView)findViewById(R.id.texV21);
		TextView arr22=(TextView)findViewById(R.id.texV22);
		
		TextView arr24=(TextView)findViewById(R.id.texV24);
		TextView arr25=(TextView)findViewById(R.id.texV25);
		
		TextView arr27=(TextView)findViewById(R.id.texV27);
		TextView arr28=(TextView)findViewById(R.id.texV28);
		TextView arr29=(TextView)findViewById(R.id.texV29);
		TextView arr30=(TextView)findViewById(R.id.texV30);
		
		TextView arr32=(TextView)findViewById(R.id.texV32);
		TextView arr33=(TextView)findViewById(R.id.texV33);
		TextView arr34=(TextView)findViewById(R.id.texV34);
		TextView arr41=(TextView)findViewById(R.id.texV41);
		TextView arr42=(TextView)findViewById(R.id.texV42);
		TextView arr43=(TextView)findViewById(R.id.texV43);
		TextView arr44=(TextView)findViewById(R.id.texV44);
		TextView arr45=(TextView)findViewById(R.id.texV45);
		TextView arr46=(TextView)findViewById(R.id.texV46);
		TextView arr47=(TextView)findViewById(R.id.texV47);
		TextView arr48=(TextView)findViewById(R.id.texV48);
		TextView arr40=(TextView)findViewById(R.id.texV40);
		
		if(count==0)
		{
			if(x==0)
			{
				arr11.setVisibility(View.VISIBLE);
				img7.setVisibility(View.VISIBLE);
				img8.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 1st with 0th ELEMENT");
				x=1;
			}
			
			else if(insertion[0]>insertion[1])
			{
				img1.setVisibility(View.VISIBLE);
				arr14.setVisibility(View.VISIBLE);
				arr14.setText(Integer.toString(insertion[0]));
				arr15.setVisibility(View.VISIBLE);
				arr15.setText(Integer.toString(insertion[1]));
				arr16.setVisibility(View.VISIBLE);
				arr16.setText(Integer.toString(insertion[2]));
				arr17.setVisibility(View.VISIBLE);
				arr17.setText(Integer.toString(insertion[3]));
				img11.setVisibility(View.VISIBLE);
				img12.setVisibility(View.VISIBLE);
				swap(insertion,0,1);
				arr40.setText("INTERCHANGED : "+insertion[0]+" with "+insertion[1]);
				y=1;
			}
			
			else if(x==1 && y==1)
			{
				img2.setVisibility(View.VISIBLE);
				arr27.setVisibility(View.VISIBLE);
				arr27.setText(Integer.toString(insertion[0]));
				arr28.setVisibility(View.VISIBLE);
				arr28.setText(Integer.toString(insertion[1]));
				arr29.setVisibility(View.VISIBLE);
				arr29.setText(Integer.toString(insertion[2]));
				arr30.setVisibility(View.VISIBLE);
				arr30.setText(Integer.toString(insertion[3]));
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
				img7.setVisibility(View.VISIBLE);
				img9.setVisibility(View.VISIBLE);
				arr12.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 2nd with 0th and 1st ELEMENT");
				x=1;
			}
			else if(insertion[1]>insertion[2])
			{
				img4.setVisibility(View.VISIBLE);
				arr20.setVisibility(View.VISIBLE);
				arr20.setText(Integer.toString(insertion[0]));
				arr21.setVisibility(View.VISIBLE);
				arr21.setText(Integer.toString(insertion[1]));
				arr22.setVisibility(View.VISIBLE);
				arr22.setText(Integer.toString(insertion[2]));
				arr41.setVisibility(View.VISIBLE);
				arr41.setText(Integer.toString(insertion[3]));
				img13.setVisibility(View.VISIBLE);
				img14.setVisibility(View.VISIBLE);
				swap(insertion,1,2);
				arr40.setText("INTERCHANGED : "+insertion[1]+" with "+insertion[2]);
				y=1;
			}
			
			else if(x==1 && y==1)
			{
				img5.setVisibility(View.VISIBLE);
				arr32.setVisibility(View.VISIBLE);
				arr32.setText(Integer.toString(insertion[0]));
				arr33.setVisibility(View.VISIBLE);
				arr33.setText(Integer.toString(insertion[1]));
				arr34.setVisibility(View.VISIBLE);
				arr34.setText(Integer.toString(insertion[2]));
				arr42.setVisibility(View.VISIBLE);
				arr42.setText(Integer.toString(insertion[3]));
				count++;
				x=0;
				y=0;
			}
		}
		
		
		
		else if(count==2)
		{
			if(x==0)
			{
				img7.setVisibility(View.VISIBLE);
				img10.setVisibility(View.VISIBLE);
				img8.setVisibility(View.VISIBLE);
				img9.setVisibility(View.VISIBLE);
				arr13.setVisibility(View.VISIBLE);
				arr40.setText("COMPARISON OF 3rd with 0th,1st & 2nd ELEMENT");
				x=1;
			}
			else if(insertion[0]>insertion[3])
			{
				img6.setVisibility(View.VISIBLE);
				img15.setVisibility(View.VISIBLE);
				img16.setVisibility(View.VISIBLE);
				img17.setVisibility(View.VISIBLE);
				img18.setVisibility(View.VISIBLE);
				arr24.setVisibility(View.VISIBLE);
				arr24.setText(Integer.toString(insertion[0]));
				arr25.setVisibility(View.VISIBLE);
				arr25.setText(Integer.toString(insertion[1]));
				arr43.setVisibility(View.VISIBLE);
				arr43.setText(Integer.toString(insertion[2]));
				arr44.setVisibility(View.VISIBLE);
				arr44.setText(Integer.toString(insertion[3]));
				swap(insertion,0,3);
				arr40.setText("INTERCHANGED : "+insertion[0]+" with "+insertion[3]);
				y=1;
			}
			
			else if(x==1 && y==1)
			{
				img3.setVisibility(View.VISIBLE);
				arr45.setVisibility(View.VISIBLE);
				arr45.setText(Integer.toString(insertion[0]));
				arr46.setVisibility(View.VISIBLE);
				arr46.setText(Integer.toString(insertion[1]));
				arr47.setVisibility(View.VISIBLE);
				arr47.setText(Integer.toString(insertion[2]));
				arr48.setVisibility(View.VISIBLE);
				arr48.setText(Integer.toString(insertion[3]));
				arr6.setVisibility(View.VISIBLE);
				arr6.setText(Integer.toString(insertion[0]));
				arr7.setVisibility(View.VISIBLE);
				arr7.setText(Integer.toString(insertion[1]));
				arr8.setVisibility(View.VISIBLE);
				arr8.setText(Integer.toString(insertion[2]));
				arr9.setVisibility(View.VISIBLE);
				arr9.setText(Integer.toString(insertion[3]));
				arr10.setVisibility(View.VISIBLE);
				Toast.makeText(this,"SORTING DONE: ", Toast.LENGTH_LONG).show();
				bb.setEnabled(false);
			}
		}
		
	}
	
	public void swap(int[] insertion,int pos1,int pos2)
	{
		temp=insertion[pos1];
		insertion[pos1]=insertion[pos2];
		for(k=pos2;k>pos1;k--)
		{
			insertion[k]=insertion[k-1];
		}
		insertion[k+1]=temp;
	}
}
