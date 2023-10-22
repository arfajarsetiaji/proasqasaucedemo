package utils;

public class StringUtils {
    public static String toKebabCase(String text) {
        return text.toLowerCase().replaceAll(" ", "-");
    }
}
