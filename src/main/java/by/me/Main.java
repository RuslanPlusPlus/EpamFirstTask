package by.me;

import by.me.action.ArrayUtil;
import by.me.entity.Array;
import by.me.initializer.ArrayInitializer;

public class Main {
    public static void main(String[] args) {
        ArrayInitializer arrayInitializer = new ArrayInitializer();
        Array array = new Array(8);
        arrayInitializer.fillRandomized(array, -5, 1);
        ArrayUtil.display(array);
        System.out.println("Min value: " +  ArrayUtil.getMinValue(array));
        System.out.println("Max value: " +  ArrayUtil.getMaxValue(array));
        System.out.println("Sum: " +  ArrayUtil.getElementsSum(array));
        System.out.println("Average value: " +  ArrayUtil.getAverageValue(array));
        System.out.println("Negatives amount: " +  ArrayUtil.countNegative(array));
    }
}
