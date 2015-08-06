package com.calendar.demo.decorators;

import android.content.Context;
import android.graphics.Color;

import com.calendar.demo.backSpan.MyPointSpan;
import com.calendar.demo.backSpan.RedPointSpan;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Administrator on 2015/8/3.
 */
public class RedPointDecorator implements DayViewDecorator {
    private String sNum;
    private CalendarDay date;

    public RedPointDecorator(){
    }
    public RedPointDecorator(CalendarDay date){
        this.date=date;
    }
    public RedPointDecorator(String sNum,CalendarDay date) {
        this.sNum=sNum;
        this.date = date;
    }

    public String getsNum() {
        return sNum;
    }

    public CalendarDay getDate() {
        return date;
    }

    public void setsNum(String sNum) {
        this.sNum = sNum;
    }

    public void setDate(CalendarDay date) {
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date != null && day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new RedPointSpan(sNum,Color.RED));
    }
}
