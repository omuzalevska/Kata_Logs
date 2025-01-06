package dev.omuzalevska.kata_logs;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LogLineTest {

    @Test
    void testGetLogLevel() {
        LogLine logLine1 = new LogLine("[INF]: File deleted");
        assertEquals(LogLevel.INFO, logLine1.getLogLevel());

        LogLine logLine2 = new LogLine("[WRN]: Low disk space");
        assertEquals(LogLevel.WARNING, logLine2.getLogLevel());

        LogLine logLine3 = new LogLine("[ERR]: Stack Overflow");
        assertEquals(LogLevel.ERROR, logLine3.getLogLevel());

        LogLine logLine4 = new LogLine("[FTL]: System crash");
        assertEquals(LogLevel.FATAL, logLine4.getLogLevel());

        LogLine logLine5 = new LogLine("[XYZ]: Unknown log level");
        assertEquals(LogLevel.UNKNOWN, logLine5.getLogLevel());
    }

    @Test
    void testGetOutputForShortLog() {
        LogLine logLine1 = new LogLine("[INF]:File deleted");
        assertEquals("4:File deleted", logLine1.getOutputForShortLog());

        LogLine logLine2 = new LogLine("[ERR]:Stack Overflow");
        assertEquals("6:Stack Overflow", logLine2.getOutputForShortLog());

        LogLine logLine3 = new LogLine("[WRN]:Low disk space");
        assertEquals("5:Low disk space", logLine3.getOutputForShortLog());

        LogLine logLine4 = new LogLine("[FTL]:System crash");
        assertEquals("42:System crash", logLine4.getOutputForShortLog());

        LogLine logLine5 = new LogLine("[XYZ]:Unknown log level");
        assertEquals("0:Unknown log level", logLine5.getOutputForShortLog());
    }

    @Test
    void testUnknownLogLevel() {
        LogLine logLine = new LogLine("[XYZ]:Random message");
        assertEquals(LogLevel.UNKNOWN, logLine.getLogLevel());
        assertEquals("0:Random message", logLine.getOutputForShortLog());
    }

         @Test
        void testEmptyLogLine() {
            LogLine emptyLine = new LogLine("");
            assertEquals(LogLevel.UNKNOWN, emptyLine.getLogLevel());
        }
    
        @Test
        void testIncompleteLogLine() {
            LogLine incompleteLine = new LogLine("[INF]:");
            assertEquals(LogLevel.INFO, incompleteLine.getLogLevel());
            assertEquals("4:", incompleteLine.getOutputForShortLog());
        }
    
        @Test
        void testInvalidLogLevel() {
            LogLine invalidLogLine = new LogLine("[XYZ]: Invalid log");
            assertEquals(LogLevel.UNKNOWN, invalidLogLine.getLogLevel());
            //assertEquals("0:Invalid log", invalidLogLine.getOutputForShortLog());
        }
}