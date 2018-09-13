package flug.project.utils;

public class ConverterUtil {

    public static Integer convertToInt(String s){
        return Integer.parseInt(s.replace("-", "").replace(".0", "").trim());
    }
    public static String splitNull(String s){
        return s.replace(".0", "");
    }

    public static String convertToUrl(String s){
        return s.replace("\"", "").trim();
    }

    public static String setFormat(String s){
        if(Character.isUpperCase(s.codePointAt(1))) {
            StringBuilder builder = new StringBuilder();
            String[] words = s.split(" ");
            for (String word : words) {
                builder.append(word.substring(0, 1).concat(word.substring(1).toLowerCase())).append(" ");
            }
            return builder.toString().trim();
        }
        return s;
    }

}
