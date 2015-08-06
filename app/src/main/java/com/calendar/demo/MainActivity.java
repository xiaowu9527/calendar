package com.calendar.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.calendar.demo.decorators.EventDecorator;
import com.calendar.demo.decorators.MyBackgroundDecorator;
import com.calendar.demo.decorators.MySelectorDecorator;
import com.calendar.demo.decorators.OneDayDecorator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.calendar.demo.decorators.RedPointDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateChangedListener;
import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends Activity implements OnDateChangedListener {
    @Bind(R.id.tv_title)TextView tv_title;
    @Bind(R.id.tv_content) TextView tv_content;
    @Bind(R.id.calendarView)
    MaterialCalendarView calendarView;
    private Calendar calendar;
    private OneDayDecorator oneDayDecorator= new OneDayDecorator();
    private List<RedPointDecorator> list_redPoint=new ArrayList<RedPointDecorator>();
    private static DateFormat FORMATTER = SimpleDateFormat.getDateInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        calendarView.setOnDateChangedListener(this);
        calendar = Calendar.getInstance();
        calendarView.setFirstDayOfWeek(calendar.SUNDAY);//设置一周起始日
        calendarView.setSelectedDate(calendar.getTime());//当日选中
//        calendarView.setMaximumDate(calendar.getTime());//当日之后不开选
        calendarView.addDecorators(new MyBackgroundDecorator(this, R.drawable.bitmap_blank,
                CalendarDay.from(calendar.getTime())));
//        calendarView.setSelectionColor(Color.BLUE);//选中日期颜色
        calendarView.addDecorators(new MySelectorDecorator(this, R.drawable.my_selector_blue),
                oneDayDecorator);

        try {
            List<EventDecorator> list_even=new ArrayList<EventDecorator>();
            list_even.add(new EventDecorator(new int[]{1,2} ,strTranCalendar("2015-08-04")));
            list_even.add(new EventDecorator(new int[]{3} ,strTranCalendar("2015-08-11")));
            list_even.add(new EventDecorator(new int[]{1, 2, 3},strTranCalendar("2015-08-26")));
            for (int i=0;i<list_even.size();i++){
                calendarView.addDecorator(list_even.get(i));
            }
            list_redPoint.add(new RedPointDecorator("1",strTranCalendar("2015-08-07")));
            list_redPoint.add(new RedPointDecorator("3",strTranCalendar("2015-08-15")));
            list_redPoint.add(new RedPointDecorator("6", strTranCalendar("2015-08-20")));
            for (int i=0;i<list_redPoint.size();i++){
                calendarView.addDecorator(list_redPoint.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tv_content.setText(calendar.getTime()+"");
    }
    @Override
    public void onDateChanged(MaterialCalendarView widget,CalendarDay date) {
        for (int i=0;i<list_redPoint.size();i++){
            if (date.equals(list_redPoint.get(i).getDate())){
                calendarView.removeDecorator(list_redPoint.get(i));
                list_redPoint.remove(i);
            }
        }
        calendarView.invalidateDecorators();//去除首次选中项
 //       Toast.makeText(this, FORMATTER.format(date.getDate()), Toast.LENGTH_SHORT).show();
        tv_content.setText(FORMATTER.format(date.getDate()));
    }
    public CalendarDay strTranCalendar(String str){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(str);
            calendar.setTime(date);
            CalendarDay calendarDay = CalendarDay.from(calendar);
            return calendarDay;
        } catch (ParseException e) {
            e.printStackTrace();return null;
        }
    }
}
