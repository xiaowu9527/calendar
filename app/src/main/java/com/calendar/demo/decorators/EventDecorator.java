package com.calendar.demo.decorators;

import com.calendar.demo.backSpan.MyPointSpan;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

/**
 * Decorate several days with a dot
 */
public class EventDecorator implements DayViewDecorator {

    private int[] color;
    private CalendarDay date;

    public EventDecorator(int[] color, CalendarDay date) {
        this.color = color;
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date != null && day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new MyPointSpan(6, color));
    }
}
