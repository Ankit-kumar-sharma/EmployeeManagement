package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateUtility {
    public static Date parseDate(String dateStr) {
        dateStr = dateStr.replace("\"", "");
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
