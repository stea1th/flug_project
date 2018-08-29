package flug.project.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateTimeUtil {

    public static final LocalDate START_DATE = LocalDate.of(1900, 1, 1);

    public static LocalDate transformToDate(String s){
        return DateTimeUtil.START_DATE.plus(Long.parseLong(s.replace(".0", ""))-2, ChronoUnit.DAYS);
    }

    public static LocalTime transformToTime(String t){
        String[] time = t.split(":");
        return LocalTime.of(Integer.parseInt(time[0].trim()), Integer.parseInt(time[1].trim()));
    }
}
