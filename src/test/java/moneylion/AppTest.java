package moneylion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Unit test
 */
public class AppTest 
{
    @Test
    public void testBoundingBoxCase1() throws IOException {
        String input = "**-------\n-*--**--\n-----***\n-------*\n";
        String expectedOutput = "(2,5)(4,8)";
        assertEquals(expectedOutput, runAppWithInput(input));
    }

    @Test
    public void testBoundingBoxCase2() throws IOException {
        String input = "----*----\n---------\n---------\n-*-------\n";
        String expectedOutput = "(1,5)(1,5)";
        assertEquals(expectedOutput, runAppWithInput(input));
    }

    @Test
    public void testBoundingBoxCase3() throws IOException {
        String input = "--**\n-**-\n----\n";
        String expectedOutput = "(1,2)(2,4)";
        assertEquals(expectedOutput, runAppWithInput(input));
    }

    @Test
    public void testBoundingBoxCase4() throws IOException {
        String input = "*****\n*****\n*****\n";
        String expectedOutput = "(1,1)(3,5)";
        assertEquals(expectedOutput, runAppWithInput(input));
    }
    @Test
    public void testBoundingBoxCase5() throws IOException {
        String input = "--------\n--------\n--------\n";
        String expectedOutput = "";
        assertEquals(expectedOutput, runAppWithInput(input));
    }
    @Test
    public void testBoundingBoxCase6() throws IOException {
        String input = "----\n-**-\n-**-\n----\n";
        String expectedOutput = "(2,2)(3,3)";
        assertEquals(expectedOutput, runAppWithInput(input));
    }

    private String runAppWithInput(String input) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));

        App.main(new String[0]);

        return out.toString().trim().replaceAll("\r\n", "\n");
    }
}
