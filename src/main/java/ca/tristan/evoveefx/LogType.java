package ca.tristan.evoveefx;

public enum LogType {

    NONE (LogColors.RESET),
    OK (LogColors.GREEN_BOLD),
    ERROR (LogColors.RED_BOLD),
    WARNING (LogColors.YELLOW_BOLD),
    ;

    final String color;

    LogType(String color) {
        this.color = color;
    }

}
