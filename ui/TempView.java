package com.test.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

/**
 * Package com.hc.studycoordinatelayout
 * Created by HuaChao on 2016/6/1.
 */
public class TempView extends View {
    private int lastX;
    private int lastY;
    private int mWidth;
    private int mHeight;
    float density;//dp的密度
    private int screenWidth;
    private int screenHeight;
    float centerxx=0;
    float cnneryy=0;
    public TempView(Context context) {
        super(context);
        DisplayMetrics display = context.getResources().getDisplayMetrics();
        screenWidth = display.widthPixels;
        screenHeight = display.heightPixels;
        density= getResources().getDisplayMetrics().density;
    }

    public TempView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        density= getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode=MeasureSpec.getMode(widthMeasureSpec);
        int heighmode=MeasureSpec.getMode(heightMeasureSpec);
        int widthsize=MeasureSpec.getSize(widthMeasureSpec);
        int heightsize=MeasureSpec.getSize(heightMeasureSpec);
        int width=0,height=0;

        if(widthMode==MeasureSpec.EXACTLY){
            width=widthsize;
        }else{
            width=(int)(48*5*density);
        }
        if(heighmode==MeasureSpec.EXACTLY){
            height=heightsize;
        }else{
            height=(int)(48*5*density);
        }
//super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size=Math.min(width,height);
        centerxx=getWidth()/2+getPaddingLeft();
        cnneryy=getHeight()/2+getPaddingTop();
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        int centerx=getWidth()/2+getPaddingLeft();
        int centery=getHeight()/2+getPaddingTop();
        int radio=getWidth()/2;
        canvas.drawCircle(centerx,centery,radio,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getRawX();
        int y = (int) event.getRawY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN: {

                break;
            }

            case MotionEvent.ACTION_MOVE: {
                CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) getLayoutParams();
                int left = layoutParams.leftMargin + x - lastX;
                int top = layoutParams.topMargin + y - lastY;

                layoutParams.leftMargin = left;
                layoutParams.topMargin = top;
                setLayoutParams(layoutParams);
                requestLayout();
                break;
            }

            case MotionEvent.ACTION_UP: {

                break;
            }

        }
        lastX = x;
        lastY = y;
        return true;
    }
}
