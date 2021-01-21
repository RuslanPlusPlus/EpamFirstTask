package by.me.action;

import by.me.entity.Array;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayUtilsTest {
    @Test
    public void testGetMinValue() {
        int[] array = {2, 23, 7, 0};
        Array myArray = new Array(array);
        assertEquals(ArrayUtils.getMinValue(myArray), 0);
    }

    @Test
    public void testGetMaxValue(){
        int[] array = {-34, 1001, 82, 9, 8, 93};
        Array myArray = new Array(array);
        assertEquals(ArrayUtils.getMaxValue(myArray), 1001);
    }

    @Test
    public void testCountNegative() {
        int[] array = {-34, 82, -34, 8, 93, -1};
        Array myArray = new Array(array);
        assertEquals(ArrayUtils.countNegative(myArray), 3);
    }

    @Test
    public void testGetElementsSum() {
        int[] array = {2, 23, 7, 0, -34};
        Array myArray = new Array(array);
        assertEquals(ArrayUtils.getElementsSum(myArray), -2);
    }
}