package flug.project.utils;

public class ConverterUtil {

    public static Integer convertInt(String s){
        return Integer.parseInt(s.replace(".0", ""));
    }

    public static String splitNull(String s){
        return s.replace(".0", "");
    }

}
