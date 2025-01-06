package dev.omuzalevska.kata_logs;

class LogLine {
    private String line;

    public LogLine(String line) {
        this.line = line;
    }

    public LogLevel getLogLevel() {
        String levelSubstring = this.line.substring(1, 4);
        return LogLevel.fromString(levelSubstring);
    }

    public String getOutputForShortLog() {
        LogLevel logLevel = getLogLevel();
        String message = this.line.substring(6);
        return logLevel.getEncodedValue() + ":" + message;
    }
}