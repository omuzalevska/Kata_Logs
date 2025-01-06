package dev.omuzalevska.kata_logs;

public class LogLine {
    private String line;

    public LogLine(String line) {
        this.line = line;
    }

    public LogLevel getLogLevel() {
        if (line == null || line.trim().isEmpty()) {
            return LogLevel.UNKNOWN; 
        }
        String levelSubstring = this.line.substring(1, 4);
        return LogLevel.fromString(levelSubstring);
    }

    public String getOutputForShortLog() {
        LogLevel logLevel = getLogLevel();
        //String message = this.line.substring(6);
        String encodedLevel = String.valueOf(logLevel.getEncodedValue());
        String message = line.length() > 5 ? line.substring(5) : "";
        // return logLevel.getEncodedValue() + ":" + message;
        return encodedLevel + "" + message;
    }
}