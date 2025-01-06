package dev.omuzalevska.kata_logs;

public class App {
    public static void main(String[] args) {
        LogLine logLine1 = new LogLine("[INF]: File deleted");
        System.out.println("Log level: " + logLine1.getLogLevel()); // Log level: INFO
        System.out.println("Short format: " + logLine1.getOutputForShortLog()); // 4: File deleted

        LogLine logLine2 = new LogLine("[XYZ]: Overly specific, out of context message");
        System.out.println("Log level: " + logLine2.getLogLevel()); // Log level: UNKNOWN
        System.out.println("Short format: " + logLine2.getOutputForShortLog()); // Short format: 0: Overly specific, out of context message 
        
        LogLine logLine3 = new LogLine("[ERR]: Stack Overflow");
        System.out.println("Log level: " + logLine3.getLogLevel()); // Log level: ERROR
        System.out.println("Short format: " + logLine3.getOutputForShortLog()); // Short format: 6: Stack Overflow
    }
}
