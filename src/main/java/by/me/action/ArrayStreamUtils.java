package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayStreamUtils {

    private static final Logger logger = LogManager.getLogger();

    public int findMaxValue(Array array){
        int[] clonedArray = array.getClonedArray();
        int maxValue = Arrays.stream(clonedArray)
                            .max()
                            .getAsInt();
        return maxValue;
    }

    public int findMinValue(Array array){
        int[] clonedArray = array.getClonedArray();
        int minValue = Arrays.stream(clonedArray)
                            .min()
                            .getAsInt();
        return minValue;
    }

    public int countNegativeValues(Array array){
        int[] clonedArray = array.getClonedArray();
        int counter = (int) Arrays.stream(clonedArray)
                            .filter(x -> x < 0)
                            .count();
        return counter;
    }

    public int findElementsSum(Array array){
        int[] clonedArray = array.getClonedArray();
        int sum = Arrays.stream(clonedArray)
                        .sum();
        return sum;
    }

    public double findAverageValue(Array array){
        int[] clonedArray = array.getClonedArray();
        double average = Arrays.stream(clonedArray)
                            .average()
                            .getAsDouble();
        return average;
    }

    public void replaceAllEvenByZero(Array array) {
        int[] clonedArray = array.getClonedArray();
        int[] updatedArray = Arrays.stream(clonedArray).map(x -> {
            if (x % 2 == 0){
                x = 0;
            }
            return x;
        }).toArray();
        try {
            array.setArray(updatedArray);
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
    }

}
