package com.assessment.elixir.config;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

@Component
public class DateTimeSandbox {

    //Different formatters
    DateTimeFormatter dateTimeFormatter1 = new DateTimeFormatterBuilder()
            // case insensitive to parse JAN and FEB
            .parseCaseInsensitive()
            // add pattern
            .appendPattern("dd-MMM-yyyy")
            // create formatter (use English Locale to parse month names)
            .toFormatter(Locale.ENGLISH);

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
    LocalDateTime localDateTime = LocalDateTime.now();


    public void goNuts() {
        LocalDateTime.now().format(dateTimeFormatter);
        String date = "03/dec/2020:05:47:58 ";
        convertStringToDate(date);

    }

    public LocalDateTime convertStringToDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
        return LocalDateTime.parse(date, dateTimeFormatter);
    }

    public LocalDateTime convert(String date1) {
        date1 = "03/Dec/2020:05:47:58";
        DateTimeFormatter f = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss")).toFormatter();
        return LocalDateTime.parse(date1, f);

        // answer : 2020-12-03T05:47:58
    }


}
