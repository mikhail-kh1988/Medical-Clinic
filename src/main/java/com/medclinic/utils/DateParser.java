package com.medclinic.utils;

import java.time.LocalDate;

public class DateParser {

    public static LocalDate getDateByString(String date){
        String[] startDate = date.split(".");
        String[] yearDate = startDate[1].split(" ");
        return LocalDate.of(Integer.parseInt(yearDate[0]), Integer.parseInt(startDate[1]), Integer.parseInt(startDate[0]));
    }
}
