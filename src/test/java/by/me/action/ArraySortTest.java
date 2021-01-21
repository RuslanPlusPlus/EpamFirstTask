package by.me.action;

import by.me.entity.Array;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortTest {

    private ArraySort arraySort;

    @BeforeMethod
    public void setUp() {
        this.arraySort = new ArraySort();
    }

    @AfterMethod
    public void tearDown() {
        this.arraySort = null;
    }

    @Test
    public void testSelectionSort() {
        int[] arr1 = {9, 89, -23, 0};
        int[] arr2 = {-23, 0, 9, 89};

        Array actual = new Array(arr1);
        this.arraySort.selectionSort(actual);
        Array expected = new Array(arr2);
        assertEquals(actual, expected);
    }

    @Test
    public void testBubbleSort() {
        int[] arr1 = {9, 89, -23, 0};
        int[] arr2 = {-23, 0, 9, 89};

        Array actual = new Array(arr1);
        this.arraySort.bubbleSort(actual);
        Array expected = new Array(arr2);
        assertEquals(actual, expected);
    }

    @Test
    public void testInsertSort() {
        int[] arr1 = {9, 89, -23, 0};
        int[] arr2 = {-23, 0, 9, 89};

        Array actual = new Array(arr1);
        this.arraySort.insertSort(actual);
        Array expected = new Array(arr2);
        assertEquals(actual, expected);
    }
}