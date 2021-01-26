package by.me.action;

import by.me.entity.Array;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayUtilsTest {

    private int[] array;
    private ArrayUtils arrayUtils;
    private Array testArray;

    @BeforeMethod
    public void setUp() {
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
    public void testGetMinValue() {
        int expected = -34;
        int actual = arrayUtils.getMinValue(testArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testGetMaxValue(){
        int expected = 1001;
        int actual = arrayUtils.getMaxValue(testArray);
        assertEquals(actual,expected);
    }

    @Test
    public void testCountNegative() {
        int expected = 2;
        int actual = arrayUtils.countNegative(testArray);
        assertEquals(actual, expected);
    }

    @Test
    public void testGetElementsSum() {
        int expected = 1146;
        int actual = arrayUtils.getElementsSum(testArray);
        assertEquals(actual,expected);
    }
}