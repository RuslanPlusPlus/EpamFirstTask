package by.epam.array_task.action;

import by.epam.array_task.entity.Array;
import by.epam.array_task.exception.ArrayException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.testng.Assert.*;

public class ArrayUtilsTest {

    private int[] array;
    private ArrayUtils arrayUtils;
    private Array testArray;

    @BeforeMethod
    public void setUp() throws ArrayException {
        this.array = new int[]{-34, 1001, 82, -4, 8, 93};
        this.arrayUtils = new ArrayUtils();
        this.testArray = new Array(this.array);
    }

    @AfterMethod
    public void tearDown() {
        this.array = null;
        this.arrayUtils = null;
        this.testArray = null;
    }

    @Test
    public void testFindMinValue() throws ArrayException {
        int expected = -34;
        OptionalInt temp = arrayUtils.findMinValue(testArray);
        int actual = temp.getAsInt();
        assertEquals(actual,expected);
    }

    @Test
    public void testFindMaxValue() throws ArrayException {
        int expected = 1001;
        OptionalInt temp = arrayUtils.findMaxValue(testArray);
        int actual = temp.getAsInt();
        assertEquals(actual,expected);
    }

    @Test
    public void testFindAverageValue() throws ArrayException {
        double expected = 191;
        OptionalDouble temp = arrayUtils.findAverageValue(testArray);
        double actual = temp.getAsDouble();
        assertEquals(actual,expected, 0.001);
    }

    @Test
    public void testCountNegativeValues() throws ArrayException {
        int expected = 2;
        OptionalInt temp = arrayUtils.countNegativeValues(testArray);
        int actual = temp.getAsInt();
        assertEquals(actual, expected);
    }

    @Test
    public void testFindElementsSum() throws ArrayException {
        int expected = 1146;
        OptionalInt temp = arrayUtils.findElementsSum(testArray);
        int actual = temp.getAsInt();
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