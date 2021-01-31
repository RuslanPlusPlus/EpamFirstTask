package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;
import java.util.OptionalInt;

public class ArrayUtils {

    static final Logger logger = LogManager.getLogger();

    public OptionalInt findMinValue(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findMinValue method)");
        }
        if (array.isEmpty()){
            return OptionalInt.empty();
        }
        int n = array.getSize();
        int[] clonedArray = array.getClonedArray();
        int minValue = clonedArray[0];
        for (int i = 0; i < n; i++){
            if (clonedArray[i] < minValue){
                minValue = clonedArray[i];
            }
        }
        return OptionalInt.of(minValue);
    }

    public OptionalInt findMaxValue(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findMaxValue method)");
        }
        if (array.isEmpty()){
            return OptionalInt.empty();
        }
        int n = array.getSize();
        int[] clonedArray = array.getClonedArray();
        int maxValue = clonedArray[0];
        for (int i = 0; i < n; i++){
            if (clonedArray[i] > maxValue){
                maxValue = clonedArray[i];
            }
        }
        return OptionalInt.of(maxValue);
    }

    public OptionalInt findElementsSum(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findElementsSum method)");
        }
        if (array.isEmpty()){
            return OptionalInt.empty();
        }
        int n = array.getSize();
        int sum = 0;
        int[] clonedArray = array.getClonedArray();
        for (int i = 0; i < n; i++){
            sum += clonedArray[i];
        }
        return OptionalInt.of(sum);
    }

    public OptionalDouble findAverageValue(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (findAverageValue method)");
        }
        if (array.isEmpty()){
            return OptionalDouble.empty();
        }
        int n = array.getSize();
        int sum = 0;
        int[] clonedArray = array.getClonedArray();
        for (int i = 0; i < n; i++){
            try {
                sum += array.getElement(i);
            } catch (ArrayException e) {
                logger.error(e.getMessage());
            }
        }
        double average = (double) sum/n;
        return OptionalDouble.of(average);
    }

    public OptionalInt countNegativeValues(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (countNegativeValues method)");
        }
        if (array.isEmpty()){
            return OptionalInt.empty();
        }
        int n = array.getSize();
        int counter = 0;
        int[] clonedArray = array.getClonedArray();
        for (int i = 0; i < n; i++){
            if (clonedArray[i] < 0){
                counter++;
            }
        }
        return OptionalInt.of(counter);
    }

    public void replaceAllEvenByZero(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (replaceAllEvenByZero method)");
        }
        if (array.isEmpty()){
            logger.error("Passed array is empty (replaceAllEvenByZero method)");
            return;
        }
        int n = array.getSize();
        int[] clonedArray = array.getClonedArray();
        for (int i = 0; i < n; i++){
            if (clonedArray[i] % 2 == 0){
                clonedArray[i] = 0;
            }
        }
        try {
            array.setArray(clonedArray);
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
        logger.info("replaceAllEvenByZero method is successfully done");
    }
}
