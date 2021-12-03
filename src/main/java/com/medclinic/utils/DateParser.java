package com.medclinic.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateParser {

    public static LocalDateTime getDateTimeByString(String date){
        String[] elem = date.split(" ");

        String[] days = elem[0].split("\\.");

        String[] time = elem[1].split(":");

        LocalDateTime localDateTime = LocalDateTime.of(
                Integer.parseInt(days[2]),
                Integer.parseInt(days[1]),
                Integer.parseInt(days[0]),
                Integer.parseInt(time[0]),
                Integer.parseInt(time[1]),
                Integer.parseInt(time[2]));

        return localDateTime;
    }

    public static LocalDate getDateByString(String date){

        String[] elem = date.split("\\.");

        LocalDate localDate = LocalDate.of(Integer.parseInt(elem[2]), Integer.parseInt(elem[1]), Integer.parseInt(elem[0]));

        return localDate;
    }
}