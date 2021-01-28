package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortTest {

    private int[] arr1;
    private int[] arr2;
    private ArraySort arraySort;

    @BeforeMethod
    public void setUp() {
        this.arr1 = new int[]{9, 89, -23, 0};
        this.arr2 = new int[]{-23, 0, 9, 89};
        this.arraySort = new ArraySort();
    }

    @AfterMethod
    public void tearDown() {
        this.arr1 = null;
        this.arr2 = null;
        this.arraySort = null;
    }

    @Test
    public void testSelectionSort() throws ArrayException {
        Array actual = new Array(arr1);
        this.arraySort.selectionSort(actual);
        Array expected = new Array(arr2);
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleSort() throws ArrayException {
        Array actual = new Array(arr1);
        this.arraySort.bubbleSort(actual);
        Array expected = new Array(arr2);
        assertEquals(actual, expected);
    }

    @Test
    public void testInsertSort() throws ArrayException {
        Array actual = new Array(arr1);
        this.arraySort.insertSort(actual);
        Array expected = new Array(arr2);
        assertEquals(actual, expected);
    }
}