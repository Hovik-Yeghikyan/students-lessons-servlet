package com.example.studentslessonsservlet.util;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {


    private static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("hh:mm");



    public static Date stringToDateTime(String dateTimeStr) throws ParseException {
        return SDF_TIME.parse(dateTimeStr);
    }


    public static String dateTimeToString(Date date) {

        return SDF_TIME.format(date);
    }
}
