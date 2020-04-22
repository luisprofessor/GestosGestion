package com.example.gestosgestion;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView;


import androidx.core.view.GestureDetectorCompat;

public class MiTexto extends androidx.appcompat.widget.AppCompatTextView{
    private int count=0;
    private static String TAG=MiTexto.class.getName();
    private GestureDetectorCompat mDetector;


    public MiTexto(Context contexto, AttributeSet attributeSet){
        super(contexto,attributeSet);
        mDetector=new GestureDetectorCompat(contexto,new MyGestorListener());

    }

    private class MyGestorListener extends SimpleOnGestureListener{

        @Override
        public boolean onDoubleTap(MotionEvent e) {

            switch (count){
                case 0:setText("Hola");count++;break;
                case 1:setText("Chau");count++;break;
                case 2:setText("No Vemos en el final");count=0;break;
            }
            return true;
        }

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
    }




    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mDetector.onTouchEvent(event);

    }
}
