/*
 * Number9 Game Ver.6.0
 * Nuber9Game05
 * 2016.03.01-2016.03.02
 * Domján János
 * 
 * Mûködik!
 * 
 * A játék célja sorba rakni a számokat
 * -------------
 * : 1 : 2 : 3 :
 * -------------
 * : 4 : 5 : 6 :
 * -------------
 * : 7 : 8 :   :
 * -------------
 * Linear elrendezés
 * Minden gombot lehet mozgatni: föl, le, jobbra, balra.
 * A Start gomb megnyomásával kerülnek 3x3-as elrendezésbe a szám-gombok.
 * 
 * A 4.0 Verzió továbbfeljesztés a Gesture02 projekttel.
 * 
 * 
*/

package com.example.number9game;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

//	private int iSelButton;
	private int iButton1LeftStart = 0;
	private int iButton1TopStart= 20;
	private int iButton2LeftStart = 50;
	private int iButton2TopStart = 20;
	private int iButton3LeftStart;
	private int iButton3TopStart;
	private int iButton4LeftStart;
	private int iButton4TopStart;

	private int[] iButtonRealPosition = {0,1,2,3,4,5,6,7,8};
	private int iButtonEmptyPosition = 9;
	private int[] iButtonHere = {0,1,2,3,4,5,6,7,8,0};
	private int iMovedButton ;
//	private int iButtonPosition ;

    float x1,x2;
    float y1,y2;
    float diffx, diffy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button button1 = (Button) findViewById(R.id.button_1 );
	    final Button button2 = (Button) findViewById(R.id.button_2 );
	    final Button button3 = (Button) findViewById(R.id.button_3 );
	    final Button button4 = (Button) findViewById(R.id.button_4 );
	    final Button button5 = (Button) findViewById(R.id.button_5 );
	    final Button button6 = (Button) findViewById(R.id.button_6 );
	    final Button button7 = (Button) findViewById(R.id.button_7 );
	    final Button button8 = (Button) findViewById(R.id.button_8 );
	    final Button buttonStart = (Button) findViewById(R.id.button_Start );

	    final Button buttonLeft = (Button) findViewById(R.id.buttonLeft );
	    final Button buttonRight = (Button) findViewById(R.id.buttonRight );
	    final Button buttonUp = (Button) findViewById(R.id.buttonUp );
	    final Button buttonDown = (Button) findViewById(R.id.buttonDown );

	    final TextView textView1 = (TextView) findViewById(R.id.textView1);
	    final TextView textView2 = (TextView) findViewById(R.id.textView2);
	
	    
	    buttonLeft.setOnClickListener(new View.OnClickListener() {
	        @Override
			public void onClick(View v) {
	            // Perform action on click
//	        	button2.setGravity(Gravity.LEFT); // A gombon lévõ szövegre vonatkozik!

	    	    if (iButtonEmptyPosition == 3) return;
	        	if (iButtonEmptyPosition == 6) return;
	        	if (iButtonEmptyPosition == 9) return;

	        	textView1.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	iMovedButton = iButtonHere[iButtonEmptyPosition+1];
        		iButtonRealPosition[iMovedButton]=iButtonEmptyPosition;
        		iButtonHere[iButtonEmptyPosition] = iMovedButton;
        		iButtonHere[iButtonEmptyPosition+1] = 0;
        		iButtonEmptyPosition = iButtonEmptyPosition+1;

	        	textView2.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	switch (iMovedButton){
        			case 1:
        	        	button1.setLeft(button1.getLeft()-50) ;
        	    	    button1.setRight(button1.getLeft()+50);
        			break;
	        		case 2:
        	        	button2.setLeft(button2.getLeft()-50) ;
        	    	    button2.setRight(button2.getLeft()+50);
        			break;
	        		case 3:
        	        	button3.setLeft(button3.getLeft()-50) ;
        	    	    button3.setRight(button3.getLeft()+50);
        			break;
	        		case 4:
        	        	button4.setLeft(button4.getLeft()-50) ;
        	    	    button4.setRight(button4.getLeft()+50);
        			break;
	        		case 5:
        	        	button5.setLeft(button5.getLeft()-50) ;
        	    	    button5.setRight(button5.getLeft()+50);
        			break;
	        		case 6:
        	        	button6.setLeft(button6.getLeft()-50) ;
        	    	    button6.setRight(button6.getLeft()+50);
        			break;
	        		case 7:
        	        	button7.setLeft(button7.getLeft()-50) ;
        	    	    button7.setRight(button7.getLeft()+50);
        			break;
	        		case 8:
        	        	button8.setLeft(button8.getLeft()-50) ;
        	    	    button8.setRight(button8.getLeft()+50);
        			break;

	        	} // end switch
     	
        	
	        } // OnClick
	    }); // buttonLeft

	    buttonRight.setOnClickListener(new View.OnClickListener() {
	        @Override
			public void onClick(View v) {
	            // Perform action on click
	        	if (iButtonEmptyPosition == 1) return;
	        	if (iButtonEmptyPosition == 4) return;
	        	if (iButtonEmptyPosition == 7) return;

	        	textView1.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	iMovedButton = iButtonHere[iButtonEmptyPosition-1];
        		iButtonRealPosition[iMovedButton]=iButtonEmptyPosition;
        		iButtonHere[iButtonEmptyPosition-1] = 0;
        		iButtonHere[iButtonEmptyPosition] = iMovedButton;
        		iButtonEmptyPosition = iButtonEmptyPosition-1;
        		
	        	textView2.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	switch (iMovedButton){
        			case 1:
        	    	    button1.setRight(button1.getLeft()+100);
        	        	button1.setLeft(button1.getLeft()+50) ;
        			break;
	        		case 2:
        	    	    button2.setRight(button2.getLeft()+100);
        	        	button2.setLeft(button2.getLeft()+50) ;
        			break;
	        		case 3:
        	    	    button3.setRight(button3.getLeft()+100);
        	        	button3.setLeft(button3.getLeft()+50) ;
        			break;
	        		case 4:
        	    	    button4.setRight(button4.getLeft()+100);
        	        	button4.setLeft(button4.getLeft()+50) ;
        			break;
	        		case 5:
        	    	    button5.setRight(button5.getLeft()+100);
        	        	button5.setLeft(button5.getLeft()+50) ;
        			break;
	        		case 6:
        	    	    button6.setRight(button6.getLeft()+100);
        	        	button6.setLeft(button6.getLeft()+50) ;
        			break;
	        		case 7:
        	    	    button7.setRight(button7.getLeft()+100);
        	        	button7.setLeft(button7.getLeft()+50) ;
        			break;
	        		case 8:
        	    	    button8.setRight(button8.getLeft()+100);
        	        	button8.setLeft(button8.getLeft()+50) ;
        			break;

	        	} // end switch

	        } // OnClick
	    }); // buttonRight

	    buttonUp.setOnClickListener(new View.OnClickListener() {
	        @Override
			public void onClick(View v) {
	            // Perform action on click
//	        	button2.setGravity(Gravity.LEFT); // A gombon lévõ szövegre vonatkozik!
	        	if (iButtonEmptyPosition == 7) return;
	        	if (iButtonEmptyPosition == 8) return;
	        	if (iButtonEmptyPosition == 9) return;

	        	textView1.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	iMovedButton = iButtonHere[iButtonEmptyPosition+3];
        		iButtonRealPosition[iMovedButton]=iButtonEmptyPosition;
        		iButtonHere[iButtonEmptyPosition+3] = 0;
        		iButtonHere[iButtonEmptyPosition] = iMovedButton;
        		iButtonEmptyPosition = iButtonEmptyPosition+3;
	        		
	        	textView2.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	switch (iMovedButton){
        			case 1:
			        	button1.setTop(button1.getTop()-50) ;
		   	        	button1.setBottom(button1.getTop()+50) ;
        			break;
	        		case 2:
			        	button2.setTop(button2.getTop()-50) ;
		   	        	button2.setBottom(button2.getTop()+50) ;
        			break;
	        		case 3:
			        	button3.setTop(button3.getTop()-50) ;
		   	        	button3.setBottom(button3.getTop()+50) ;
        			break;
	        		case 4:
			        	button4.setTop(button4.getTop()-50) ;
		   	        	button4.setBottom(button4.getTop()+50) ;
        			break;
	        		case 5:
			        	button5.setTop(button5.getTop()-50) ;
		   	        	button5.setBottom(button5.getTop()+50) ;
        			break;
	        		case 6:
			        	button6.setTop(button6.getTop()-50) ;
		   	        	button6.setBottom(button6.getTop()+50) ;
        			break;
	        		case 7:
			        	button7.setTop(button7.getTop()-50) ;
		   	        	button7.setBottom(button7.getTop()+50) ;
        			break;
	        		case 8:
			        	button8.setTop(button8.getTop()-50) ;
		   	        	button8.setBottom(button8.getTop()+50) ;
        			break;

	        	} // end switch
	        	

	        } // OnClick
	    }); // buttonUp

   	        	
   	    buttonDown.setOnClickListener(new View.OnClickListener() {
   	        @Override
			public void onClick(View v) {
   	            // Perform action on click
//   	        	textView1.setText("Down");
	        	if (iButtonEmptyPosition == 1) return;
	        	if (iButtonEmptyPosition == 2) return;
	        	if (iButtonEmptyPosition == 3) return;
	        	textView1.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

        		iMovedButton = iButtonHere[iButtonEmptyPosition-3];
        		iButtonRealPosition[iMovedButton]=iButtonEmptyPosition;
        		iButtonHere[iButtonEmptyPosition-3] = 0;
        		iButtonHere[iButtonEmptyPosition] = iMovedButton;
        		iButtonEmptyPosition = iButtonEmptyPosition-3;
	        		
	        	textView2.setText("MovedB:"+iMovedButton+" / BEmptyPos.:" + iButtonEmptyPosition + "MBrealPos.:" + iButtonRealPosition[iMovedButton]);

	        	switch (iMovedButton){
        			case 1:
			        	button1.setTop(button1.getTop()+50) ;
		   	        	button1.setBottom(button1.getTop()+50) ;
        			break;
	        		case 2:
			        	button2.setTop(button2.getTop()+50) ;
		   	        	button2.setBottom(button2.getTop()+50) ;
        			break;
	        		case 3:
			        	button3.setTop(button3.getTop()+50) ;
		   	        	button3.setBottom(button3.getTop()+50) ;
        			break;
	        		case 4:
			        	button4.setTop(button4.getTop()+50) ;
		   	        	button4.setBottom(button4.getTop()+50) ;
        			break;
	        		case 5:
			        	button5.setTop(button5.getTop()+50) ;
		   	        	button5.setBottom(button5.getTop()+50) ;
        			break;
	        		case 6:
			        	button6.setTop(button6.getTop()+50) ;
		   	        	button6.setBottom(button6.getTop()+50) ;
        			break;
	        		case 7:
			        	button7.setTop(button7.getTop()+50) ;
		   	        	button7.setBottom(button7.getTop()+50) ;
        			break;
	        		case 8:
			        	button8.setTop(button8.getTop()+50) ;
		   	        	button8.setBottom(button8.getTop()+50) ;
        			break;

	        	} // end switch
	        	

	        } // OnClick
   	    }); // buttonDown
   	    
   	    buttonStart.setOnClickListener(new View.OnClickListener() {
   	        @Override
			public void onClick(View v) {
   	            // Perform action on click
   	        	textView1.setText("Start");
   	        	button4.setTop(70)  ;button4.setBottom(120) ;button4.setLeft(0)  ;button4.setRight(50);
   	        	button5.setTop(70)  ;button5.setBottom(120) ;button5.setLeft(50) ;button5.setRight(100);
   	        	button6.setTop(70)  ;button6.setBottom(120) ;button6.setLeft(100);button6.setRight(150);
   	        	button7.setTop(120) ;button7.setBottom(170) ;button7.setLeft(0)  ;button7.setRight(50);
   	        	button8.setTop(120) ;button8.setBottom(170) ;button8.setLeft(50) ;button8.setRight(100);
	        	}
   	    });// buttonStart

   	   button8.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) {
	    		int piMovedButton = 8;
	    		int piButtonPosition = iButtonRealPosition[piMovedButton];
        		switch (piButtonPosition){
        			case 8:
        			{
        				if (iButtonEmptyPosition == 5) {buttonUp.callOnClick(); break;}
        				if (iButtonEmptyPosition == 7) {buttonLeft.callOnClick(); break;} 
        				if (iButtonEmptyPosition == 9) {buttonRight.callOnClick(); break;}
        			break;
        			}
        			case 9:
        			{
        				if (iButtonEmptyPosition == 5) {buttonUp.callOnClick(); break;}
        				if (iButtonEmptyPosition == 8) {buttonLeft.callOnClick(); break;} 
        			break;
        			}
        		} // switch
        		
/*        		
        		iMovedButton = iButtonHere[iButtonEmptyPosition-3];
        		iButtonRealPosition[iMovedButton]=iButtonEmptyPosition;
        		iButtonHere[iButtonEmptyPosition-3] = 0;
        		iButtonHere[iButtonEmptyPosition] = iMovedButton;
        		iButtonEmptyPosition = iButtonEmptyPosition-3;
*/	    		
	    		buttonRight.callOnClick();	
	    	}
	    	});
   	    
   	    
   	    
	} // onCreate

// onTouchEvent () method gets called when User performs any touch event on screen 
// Method to handle touch event like left to right swap and right to left swap
public boolean onTouchEvent(MotionEvent touchevent)
	   {
	    final Button buttonLeft = (Button) findViewById(R.id.buttonLeft );
	    final Button buttonRight = (Button) findViewById(R.id.buttonRight );
	    final Button buttonUp = (Button) findViewById(R.id.buttonUp );
	    final Button buttonDown = (Button) findViewById(R.id.buttonDown );

	   switch (touchevent.getAction())
	          {
	          // when user first touches the screen we get x and y coordinate
	          case MotionEvent.ACTION_DOWN:
	               {
	               x1 = touchevent.getX();
	               y1 = touchevent.getY();
	               break;
	               }
	           case MotionEvent.ACTION_UP:
	                {
	                x2 = touchevent.getX();
	                y2 = touchevent.getY(); 
	                diffx = x2-x1;
	                diffy = y2-y1;
	                //if left to right sweep event on screen
	                if (x1 < x2 && Math.abs(diffy) < Math.abs(diffx))
	                    {Toast.makeText(this, "Left to Right Swap Performed", Toast.LENGTH_LONG).show();
	                    buttonRight.callOnClick();
	                    }
	                                       
	                // if right to left sweep event on screen
	                if (x1 > x2 && Math.abs(diffy) < Math.abs(diffx))
	                   {Toast.makeText(this, "Right to Left Swap Performed", Toast.LENGTH_LONG).show();
	                    buttonLeft.callOnClick();
	                   }
	                                       
	                // if UP to Down sweep event on screen
	                if (y1 < y2 && Math.abs(diffx) < Math.abs(diffy))
	                   {Toast.makeText(this, "UP to Down Swap Performed", Toast.LENGTH_LONG).show();
	                    buttonDown.callOnClick();
	                   }
	                //if Down to UP sweep event on screen
	                if (y1 > y2 && Math.abs(diffx) < Math.abs(diffy))
	                   {Toast.makeText(this, "Down to UP Swap Performed", Toast.LENGTH_LONG).show();
	                    buttonUp.callOnClick();
	                   }
	                break;
	                } // case MotionEvent.ACTION_UP
	                
	           } // switch (touchevent.getAction())
	            return false;
	     } // onTouchEvent
	
protected void ButtonStartPositions(){	

	final Button button1 = (Button) findViewById(R.id.button_1 );
    final Button button2 = (Button) findViewById(R.id.button_2 );
    final Button button3 = (Button) findViewById(R.id.button_3 );
    final Button button4 = (Button) findViewById(R.id.button_4 );
    final TextView textView1 = (TextView) findViewById(R.id.textView1);
	
    button1.performClick();
		iButton1LeftStart = button1.getLeft() ;
	  	iButton1TopStart = button1.getTop() ;
	  	iButton2LeftStart = button2.getLeft() ;
	  	iButton2TopStart = button2.getTop() ;
	  	iButton3LeftStart = button3.getLeft() ;
	  	iButton3TopStart = button3.getTop() ;
	  	iButton4LeftStart = button4.getLeft() ;
	  	iButton4TopStart = button4.getTop() ;

	  	textView1.setText(
	  			" Button1 - "+"Left:"+iButton1LeftStart+" / Top:"+iButton1TopStart+
	  			" Button2 - "+"Left:"+iButton2LeftStart+" / Top:"+iButton2TopStart+
	  			" Button3 - "+"Left:"+iButton3LeftStart+" / Top:"+iButton3TopStart+
	  			" Button4 - "+"Left:"+iButton4LeftStart+" / Top:"+iButton4TopStart
	  			);

  	  	}


@Override
protected void onStart(){
	super.onStart();
//	ButtonStartPositions();
// Ez mûködik
	final Button buttonStart = (Button) findViewById(R.id.button_Start );
	buttonStart.callOnClick() ;

//	StartOrder(); Ez nem csinál semmit!
	
}

@Override
protected void onResume(){
	super.onResume();
//	ButtonStartPositions();
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

protected void StartOrder(){	

    final TextView textView1 = (TextView) findViewById(R.id.textView1);
    final Button button4 = (Button) findViewById(R.id.button_4 );
    final Button button5 = (Button) findViewById(R.id.button_5 );
    final Button button6 = (Button) findViewById(R.id.button_6 );
    final Button button7 = (Button) findViewById(R.id.button_7 );
    final Button button8 = (Button) findViewById(R.id.button_8 );
	
	textView1.setText("StartOrder");
   	button4.setTop(70)  ;button4.setBottom(120) ;button4.setLeft(0)  ;button4.setRight(50);
   	button5.setTop(70)  ;button5.setBottom(120) ;button5.setLeft(50) ;button5.setRight(100);
   	button6.setTop(70)  ;button6.setBottom(120) ;button6.setLeft(100);button6.setRight(150);
   	button7.setTop(120) ;button7.setBottom(170) ;button7.setLeft(0)  ;button7.setRight(50);
   	button8.setTop(120) ;button8.setBottom(170) ;button8.setLeft(50) ;button8.setRight(100);
}


   	
} // MainActivity
