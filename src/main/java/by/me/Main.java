package by.me;

import by.me.action.ArraySort;
import by.me.action.ArrayUtils;
import by.me.entity.Array;
import by.me.initializer.ArrayInitializer;

public class Main {
    public static void main(String[] args) {
        ArrayInitializer arrayInitializer = new ArrayInitializer();
        Array array = new Array(6);
        arrayInitializer.fillRandomized(array, -5, 34);
        ArrayUtils.display(array);
        /*System.out.println("Min value: " +  ArrayUtils.getMinValue(array));
        System.out.println("Max value: " +  ArrayUtils.getMaxValue(array));
        System.out.println("Sum: " +  ArrayUtils.getElementsSum(array));
        System.out.println("Average value: " +  ArrayUtils.getAverageValue(array));
        System.out.println("Negatives amount: " +  ArrayUtils.countNegative(array));*/
    }
}
