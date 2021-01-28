package by.me.parser;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import by.me.exception.ParserException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataParserTest {

    private DataParser dataParser;
    private String line;
    private List<String> lines;
    private int[] array1;
    private int[] array2;
    private int[] array3;

    @BeforeMethod
    public void setUp() {
        this.dataParser = new DataParser();
        this.line = new String("0 23 -1 222");
        this.lines = new ArrayList<>();
        this.lines.add("1 3 3 2424");
        this.lines.add(" 4");
        this.lines.add("23 0 0 2");
        this.array1 = new int[]{1, 3, 3, 2424};
        this.array2 = new int[]{4};
        this.array3 = new int[]{23, 0, 0, 2};
    }

    @AfterMethod
    public void tearDown() {
        this.dataParser = null;
        this.line = null;
    }

    @Test
    public void testParseLine() throws ArrayException {
        int[] arr = {0, 23, -1, 222};
        Array expected = new Array(arr);
        Array actual = null;
        try {
            actual = this.dataParser.parseLine(this.line);
        } catch (ParserException e) {
            e.printStackTrace();
        }
        assertEquals(actual, expected);
    }

    @Test
    public void testParseLines() throws ArrayException, ParserException {
        Array expectedArray1 = new Array(this.array1);
        Array expectedArray2 = new Array(this.array2);
        Array expectedArray3 = new Array(this.array3);
        List<Array> expectedList = new ArrayList<>();
        expectedList.add(expectedArray1);
        expectedList.add(expectedArray2);
        expectedList.add(expectedArray3);
        List<Array> actualList = this.dataParser.parseLines(this.lines);
        assertEquals(actualList, expectedList);
    }
}