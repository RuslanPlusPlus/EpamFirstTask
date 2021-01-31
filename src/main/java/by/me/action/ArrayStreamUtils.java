package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayStreamUtils {

    static final Logger logger = LogManager.getLogger();

    public OptionalInt findMaxValue(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findMaxValue method)");
        }
        int[] clonedArray = array.getClonedArray();
        OptionalInt maxValue = Arrays.stream(clonedArray)
                            .max();
        return maxValue;
    }

    public OptionalInt findMinValue(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findMinValue method)");
        }
        int[] clonedArray = array.getClonedArray();
        OptionalInt minValue = Arrays.stream(clonedArray)
                            .min();
        return minValue;
    }

    public OptionalInt countNegativeValues(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (countNegativeValues method)");
        }
        if (array.isEmpty()){
            return OptionalInt.empty();
        }
        int[] clonedArray = array.getClonedArray();
        int counter = (int) Arrays.stream(clonedArray)
                            .filter(x -> x < 0)
                            .count();
        return OptionalInt.of(counter);
    }

    public OptionalInt findElementsSum(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findElementsSum method)");
        }
        int[] clonedArray = array.getClonedArray();
        OptionalInt sum = Arrays.stream(clonedArray)
                        .reduce(Integer::sum);
        return sum;
    }

    public OptionalDouble findAverageValue(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findAverageValue method)");
        }
        int[] clonedArray = array.getClonedArray();
        OptionalDouble average = Arrays.stream(clonedArray)
                            .average();
        return average;
    }

    public void replaceAllEvenByZero(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (replaceAllEvenByZero method)");
        }
        if (array.isEmpty()){
            logger.error("passed array is empty (replaceAllEvenByZero method)");
            return;
        }
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
        logger.info("replaceAllEvenByZero method is successfully done");
    }

}
