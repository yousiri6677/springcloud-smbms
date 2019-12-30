package cn.youfull.util;

import java.time.format.DateTimeFormatter;

public enum  TimeFormat {
    TIME_FORMAT;
    public DateTimeFormatter getFormat(){
        return DateTimeFormatter.ISO_DATE;
    }
}
