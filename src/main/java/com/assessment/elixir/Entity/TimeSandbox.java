package com.assessment.elixir.Entity;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Entity
public class TimeSandbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    private Date date;
    private LocalDateTime localDateTime;
    private final String localDateTimeInString = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    private LocalDate localDate;
    private LocalTime localTime;
    private Time time;
    private DateTime dateTime;

    public TimeSandbox() {
    }

    public TimeSandbox(Date date, LocalDateTime localDateTime, LocalDate localDate, LocalTime localTime, Time time, DateTime dateTime) {
        this.date = date;
        this.localDateTime = localDateTime;
        this.localDate = localDate;
        this.localTime = localTime;
        this.time = time;
        this.dateTime = dateTime;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
