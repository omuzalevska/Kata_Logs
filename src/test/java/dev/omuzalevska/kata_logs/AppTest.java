package dev.omuzalevska.kata_logs;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testMainMethod() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;  
        System.setOut(new PrintStream(outputStream));  

        App.main(new String[]{});

        System.setOut(originalSystemOut);

        String output = outputStream.toString().trim();
        
        String expectedOutput = "Log level: INFO\n" +
                                 "Short format: 4:File deleted\n" +
                                 "Log level: UNKNOWN\n" +
                                 "Short format: 0:Overly specific, out of context message\n" +
                                 "Log level: ERROR\n" +
                                 "Short format: 6:Stack Overflow";
        
        assertEquals(expectedOutput, output);
    }

    @Test
    void testMainWithEmptyInput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalSystemOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // порожні параметри
        App.main(new String[]{});

        System.setOut(originalSystemOut);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("Log level: INFO"));
    }
}