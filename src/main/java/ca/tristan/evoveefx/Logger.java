package ca.tristan.evoveefx;

import java.util.Calendar;

public final class Logger {

    private static void print(String text) {
        Calendar calendar = Calendar.getInstance();

        String hours = StringHelper.getDoubleDigitsFormat(calendar.get(Calendar.HOUR_OF_DAY));
        String minutes = StringHelper.getDoubleDigitsFormat(calendar.get(Calendar.MINUTE));
        String seconds = StringHelper.getDoubleDigitsFormat(calendar.get(Calendar.SECOND));
        String dateStr = "[" + hours + ":" + minutes + ":" + seconds + "]: ";

        System.out.println(dateStr + text);
    }

    private static void log(LogType type, String text) {
        if(type == LogType.NONE) {
            print(text);
            return;
        }
        text = "[" + type.color + type.name() + LogColors.RESET + "]: " + text;
        print(text);
    }

    public static void log(String text) {
        log(LogType.NONE, text);
    }

    public static void ok(String text) {
        log(LogType.OK, LogType.OK.color + text + LogColors.RESET);
    }

    public static void error(String text) {
        log(LogType.ERROR, LogType.ERROR.color + text + LogColors.RESET);
    }

    public static void warning(String text) {
        log(LogType.WARNING, LogType.WARNING.color + text + LogColors.RESET);
    }

}
