package flug.project.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static flug.project.utils.ConverterUtil.convertToInt;
import static flug.project.utils.ConverterUtil.splitNull;

public class DateTimeUtil {

    private static final LocalDate START_DATE = LocalDate.of(1900, 1, 1);
    public static LocalDate transformToDate(String s){
        return START_DATE
                .plus(Long.parseLong(splitNull(s))-2,
                        ChronoUnit.DAYS);
    }

    public static LocalTime transformToTime(String t){
        String[] time = t.split(":");
        return LocalTime.of(convertToInt(time[0]), convertToInt(time[1]))
                .truncatedTo(ChronoUnit.MINUTES);
    }
}

