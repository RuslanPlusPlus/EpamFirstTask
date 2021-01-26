package by.me.parser;

import by.me.entity.Array;
import by.me.exception.ParserException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DataParserTest {

    private DataParser dataParser;
    private String line;

    @BeforeMethod
    public void setUp() {
        this.dataParser = new DataParser();
        this.line = new String("0 23 -1 222");
    }

    @AfterMethod
    public void tearDown() {
        this.dataParser = null;
        this.line = null;
    }

    @Test
    public void testParseLine() {
        int[] arr = {0, 23, -1, 222};
        Array expected = new Array(arr);
        Array actual = null;
        try {
            actual = this.dataParser.parseLine(this.line);
        } catch (ParserException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

}