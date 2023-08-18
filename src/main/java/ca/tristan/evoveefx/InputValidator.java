package ca.tristan.evoveefx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputValidator {

    private static boolean isMatchingString(String text1, String text2) {
        return text1.equals(text2);
    }

    public static boolean validatePassword(String password1, String password2) {
        boolean matching = isMatchingString(password1, password2);
        boolean lengthReq = password1.length() >= 8;
        boolean uppercaseReq = !password1.equals(password1.toLowerCase());
        boolean lowerCaseReq = !password1.equals(password1.toUpperCase());
        boolean digitReq = password1.matches(".*\\d.*");
        boolean specialCharReq = !password1.matches("[A-Za-z0-9]*");

        return matching && lengthReq && uppercaseReq && lowerCaseReq && digitReq && specialCharReq;
    }

    public static boolean validateEmail(String text) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean validate24HoursFormat(String text) {
        boolean lengthReq = text.length() == 2 || text.length() == 1;
        boolean digitReq = isDigit(text);
        boolean isLowerThan24 = false;
        if(digitReq) {
            isLowerThan24 = Integer.parseInt(text) < 24;
        }

        return lengthReq && digitReq && isLowerThan24;
    }

    public static boolean validate60MinutesFormat(String text) {
        boolean lengthReq = text.length() == 2 || text.length() == 1;
        boolean digitReq = isDigit(text);
        boolean isLowerThan60 = false;
        if(digitReq) {
            isLowerThan60 = Integer.parseInt(text) < 60;
        }

        return lengthReq && digitReq && isLowerThan60;
    }

    public static boolean isDigit(String text) {
        return text.matches("[0-9]*");
    }

}
