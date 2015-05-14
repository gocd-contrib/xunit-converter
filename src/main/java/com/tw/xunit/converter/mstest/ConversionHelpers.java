package com.tw.xunit.converter.mstest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by nhudacin on 4/24/2015.
 */
public class ConversionHelpers {
    public ConversionHelpers() {
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static double getDateDifference(String start, String end) {
        double result;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String start_fixed = start.substring(0, 23); // remove microseconds & timeoffset
        String end_fixed = end.substring(0, 23); // remove microseconds & timeoffset

        try {
            Date startDate = format.parse(start_fixed);
            Date endDate = format.parse(end_fixed);
            result = endDate.getTime() - startDate.getTime();
            result = result / 1000;
        } catch (ParseException pe) {
            result = -1;
        }

        return result;
    }

    /* Converts the duration format 00:00:00.8964607 to a double seconds */
    public static double durationConverter(String str) {
        double result;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            String formatThis = str.substring(0, 12); // remove microseconds (not valid in java)
            Date date = sdf.parse("1970-01-01 " + formatThis);
            result = date.getTime();
            result = result / 1000;
        } catch (ParseException pe) {
            result = -1;
        }

        return result;
    }

    /* Converts a time format 2015-04-22T12:49:56.6305890-05:00 to yyy-MM-dd hh:mm:ss */
    public static String stringDateFormatter(String str) {
        String result;
        DateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");

        try {
            String formatThis = str.substring(0, 23) + str.substring(28, 32); //remove milliseconds & microseconds
            result = destFormat.format(sourceFormat.parse(formatThis));
        } catch (ParseException pe) {
            result = null;
        }

        return result;
    }
}