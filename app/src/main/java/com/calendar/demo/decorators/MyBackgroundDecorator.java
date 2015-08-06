package com.calendar.demo.decorators;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

/**
 * Use a custom selector
 */
public class MyBackgroundDecorator implements DayViewDecorator {

    private int id;
    private CalendarDay date;
    private final Drawable drawable;

    public MyBackgroundDecorator(Activity context, int id,CalendarDay date) {
        this.id=id;
        this.date=date;
        drawable = context.getResources().getDrawable(id);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date.equals(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}
