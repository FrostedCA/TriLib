package ca.tristan.evoveefx;

public final class StringHelper {

    public static String firstLetterToUpper(String text) {
        if(text == null || text.isEmpty()) {
            return "";
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    public static String getDoubleDigitsFormat(String text) {
        if(text.length() == 1) {
            text = "0" + text;
        }
        return text;
    }

    public static String getDoubleDigitsFormat(int number) {
        String parsed = String.valueOf(number);
        if(parsed.length() == 1) {
            parsed = "0" + parsed;
        }
        return parsed;
    }

}
