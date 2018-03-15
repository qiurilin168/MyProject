package com.cm.schedule;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("abc");
                timer.cancel();
            }
        },3 * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,2,14,20,9,30);
        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("abcd");
                timer1.cancel();
            }
        },calendar.getTime());
    }
}
