package com.daun.goofygame;
import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.*;
import android.widget.*;
import android.util.TypedValue;
import java.util.Random;
import java.lang.Thread;

public class GameActivity
extends Activity{

int f=0;
int inc=1;
TextView textView;
Random rand=new Random();

@Override
public void onCreate
 (Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);

 LinearLayout layout =
 new LinearLayout(this);

 textView = new TextView(this);
 f=rand.nextInt(100);
 textView.setText(String.valueOf(f));
 textView.setTextSize
 (TypedValue.COMPLEX_UNIT_SP
 ,60);
 layout.addView(textView);
 setContentView(layout);


                              }


public void vibrate(int duration){
 Vibrator vibs = (Vibrator)
 getSystemService
 (Context.VIBRATOR_SERVICE);
 vibs.vibrate(duration);
                                 }

@Override
public boolean onKeyDown
(int keyCode, KeyEvent event) {
 if(keyCode==KeyEvent.
 KEYCODE_VOLUME_DOWN){
  if(((int)f/10)!=((int)(f+inc)/10)){
   vibrate(500);
                                    }
   else{
    vibrate(100);
    up();
       }
                     }
 if(keyCode==KeyEvent.
 KEYCODE_VOLUME_UP){
  if(((int)f/10)==((int)(f+inc)/10)){
   vibrate(500);
                                    }
  else{
   vibrate(100);
   up();
      }
                  }
    return true;
                              }

void up(){
 f+=inc;
 if(f>666)f=rand.nextInt(10);
 inc++;
 if(inc>9)inc=1;
 textView.setText(String.valueOf(f)
 + " " + String.valueOf(inc));
         }

                 }
