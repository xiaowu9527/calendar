package com.calendar.demo.backSpan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;

import com.calendar.demo.R;

/**
 * Created by Administrator on 2015/8/3.
 */
public class RedPointSpan implements LineBackgroundSpan{
    public static final float DEFAULT_RADIUS = 22;
    private final float radius;
    private  int color=0;
    private String sNum=null;
    public RedPointSpan() {
        this.radius = DEFAULT_RADIUS;
        this.color = color;
    }
//    public RedPointSpan(float radius) {
//        this.radius = radius;
//        this.color = color;
//    }
    public RedPointSpan(String sNum,int color){
        this.radius=DEFAULT_RADIUS;
        this.sNum=sNum;
        this.color=color;
    }
    public RedPointSpan(float radius, int color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public void drawBackground(
            Canvas canvas, Paint paint,
            int left, int right, int top, int baseline, int bottom,
            CharSequence charSequence,
            int start, int end, int lineNum
    ) {

        int oldColor = paint.getColor();
        paint.setColor(Color.RED);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawCircle(left + right - radius, (bottom + top) / 2 - radius, radius, paint);
        paint.setColor(Color.WHITE);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(sNum, (left + right) / 2 + radius, (bottom + top) / 2 - radius / 2, paint);
        paint.setColor(oldColor);
        paint.setTextAlign(Paint.Align.LEFT);
    }

}
