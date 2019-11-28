package com.alfredomarino.mybooks.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    public static Date getValidDate(String dateStr) {
        Date publishedDate = null;
        try {
            if (!DateUtils.isValidDateFormat(dateStr, "yyyy-MM-dd")){
                dateStr = dateStr + "-01-01";
            }
            publishedDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return publishedDate;
    }


    public static boolean isValidDateFormat(String dateStr, String dateFormat) {
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
