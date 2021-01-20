package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;

public class ArrayUtil {
    public static void display(Array array){
        int n = array.getSize();
        for (int i = 0; i < n; i++){
            try {
                System.out.print(array.getElement(i) + " ");
            } catch (ArrayException e) {
                //log...
            }
        }
        System.out.println();
    }

    public static int getMinValue(Array array){
        int n = array.getSize();
        int minValue = 0;
        try {
            minValue = array.getElement(0);
            for (int i = 0; i < n; i++){
                if (array.getElement(i) < minValue){
                    minValue = array.getElement(i);
                }
            }
        } catch (ArrayException e) {
            //
        }
        return minValue;
    }

    public static int getMaxValue(Array array){
        int n = array.getSize();
        int maxValue = 0;
        try {
            maxValue = array.getElement(0);
            for (int i = 0; i < n; i++){
                if (array.getElement(i) > maxValue){
                    maxValue = array.getElement(i);
                }
            }
        } catch (ArrayException e) {
            // log
        }
        return maxValue;
    }

    public static int getElementsSum(Array array){
        int n = array.getSize();
        int sum = 0;
        for (int i = 0; i < n; i++){
            try {
                sum += array.getElement(i);
            } catch (ArrayException e) {
                // log
            }
        }
        return sum;
    }

    public static double getAverageValue(Array array){
        return ArrayUtil.getElementsSum(array) / (double)array.getSize();
    }

    public static int countNegative(Array array){
        int n = array.getSize();
        int counter = 0;
        for (int i = 0; i < n; i++){
            try {
                if (array.getElement(i) < 0){
                    counter++;
                }
            } catch (ArrayException e) {
                // log...
            }
        }
        return counter;
    }
}
