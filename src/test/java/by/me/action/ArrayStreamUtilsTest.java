package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayStreamUtilsTest {

    private int[] array;
    private ArrayStreamUtils arrayUtils;
    private Array testArray;

    @BeforeMethod
    public void setUp() throws ArrayException {
        this.array = new int[]{-34, 1001, 82, -4, 8, 93};
        this.arrayUtils = new ArrayStreamUtils();
        this.testArray = new Array(this.array);
    }

    @AfterMethod
    public void tearDown() {
        this.array = null;
        this.arrayUtils = null;
        this.testArray = null;
    }

    @Test
    public void testFindMaxValue() {
        int expected = 1001;
        int actual = arrayUtils.findMaxValue(testArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testFindMinValue() {
        int expected = -34;
        int actual = arrayUtils.findMinValue(testArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testCountNegativeValues() {
        int expected = 2;
        int actual = arrayUtils.countNegativeValues(testArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testFindElementsSum() {
        int expected = 1146;
        int actual = arrayUtils.findElementsSum(testArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testReplaceAllEvenByZero() throws ArrayException {
        int [] tempArray = {0, 1001, 0, 0, 0, 93};
        Array expected = new Array(tempArray);
        Array actual = new Array(this.array);
        this.arrayUtils.replaceAllEvenByZero(actual);
        assertEquals(actual, expected);
    }
}