package com.tignioj.timelineapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtils {


    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * 判断现在时间是否在传入的两个时间段内，排除日期(年月日)，只判断时间(时分秒)
     * @param startTime
     * @param endTime
     * @return
     */
    public static boolean betweenStartTimeAndEndTime(Date startTime, Date endTime) {
        Calendar cNow = Calendar.getInstance();
        Calendar cStart = Calendar.getInstance();
        Calendar cEnd = Calendar.getInstance();
        Date now = new Date();

        cNow.setTime(now);
        cStart.setTime(startTime);
        cEnd.setTime(endTime);

        //设置成相同第日期，这时候只有时间不同了
        cNow.set(1970,1,1);
        cStart.set(1970,1,1);
        cEnd.set(1970,1,1);

        //开始时间比现在早， 现在比结束时间早
        return cStart.before(cNow) && cNow.before(cEnd);
    }




}
