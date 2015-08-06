package com.calendar.demo.decorators;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.calendar.demo.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

/**
 * Use a custom selector
 */
public class MySelectorDecorator implements DayViewDecorator {

    private int id;
    private final Drawable drawable;

    public MySelectorDecorator(Activity context,int id) {
        this.id=id;
        drawable = context.getResources().getDrawable(id);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return true;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(drawable);
    }
}
