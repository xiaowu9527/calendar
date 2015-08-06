package com.calendar.demo.backSpan;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
public class MyPointSpan implements LineBackgroundSpan {

    public static final float DEFAULT_RADIUS = 3;
    private final float radius;
    private final int[] color;
    public MyPointSpan() {
        this.radius = DEFAULT_RADIUS;
        this.color = null;
    }
    public MyPointSpan(int[] color) {
        this.radius = DEFAULT_RADIUS;
        this.color = color;
    }
    public MyPointSpan(float radius) {
        this.radius = radius;
        this.color = null;
    }
    public MyPointSpan(float radius, int[] color) {
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
        paint.setTextAlign(Paint.Align.LEFT);
        if(color.length!= 0&&!color.equals(null)) {
            switch (color.length){
                case 1:
                    paint.setColor(getColor(color[0]));
//                    canvas.drawCircle(left + right-radius, bottom+top -radius, radius, paint);
                    canvas.drawCircle((left + right) / 2, bottom + radius, radius, paint);
                    break;
                case 2:
                    paint.setColor(getColor(color[0]));
                    canvas.drawCircle((left + right) / 2 - radius, bottom + radius, radius, paint);
                    paint.setColor(getColor(color[1]));
                    canvas.drawCircle((left + right) / 2 + radius, bottom + radius, radius, paint);
                    break;
                case 3:
                    paint.setColor(getColor(color[0]));
                    canvas.drawCircle((left + right) / 2 - 2 * radius, bottom + radius, radius, paint);
                    paint.setColor(getColor(color[1]));
                    canvas.drawCircle((left + right) / 2, bottom + radius, radius, paint);
                    paint.setColor(getColor(color[2]));
                    canvas.drawCircle((left + right) / 2 + 2*radius, bottom + radius, radius, paint);
            }
        }
        paint.setColor(oldColor);
    }
    public int getColor(int colorNum){
        int circleColor=0;
        switch (colorNum){
            case 1:circleColor=Color.BLUE;break;
            case 2:circleColor=Color.GREEN;break;
            case 3:circleColor=Color.RED;break;
        }
        return circleColor;
    }
}
