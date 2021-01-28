package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayUtils {

    private static final Logger logger = LogManager.getLogger();

    public int findMinValue(Array array){
        int n = array.getSize();
        int[] clonedArray = array.getClonedArray();
        int minValue = clonedArray[0];
        for (int i = 0; i < n; i++){
            if (clonedArray[i] < minValue){
                minValue = clonedArray[i];
            }
        }
        return minValue;
    }

    public int findMaxValue(Array array){
        int n = array.getSize();
        int[] clonedArray = array.getClonedArray();
        int maxValue = clonedArray[0];
        for (int i = 0; i < n; i++){
            if (clonedArray[i] > maxValue){
                maxValue = clonedArray[i];
            }
        }
        return maxValue;
    }

    public int findElementsSum(Array array){
        int n = array.getSize();
        int sum = 0;
        int[] clonedArray = array.getClonedArray();
        for (int i = 0; i < n; i++){
            sum += clonedArray[i];
        }
        return sum;
    }

    public double findAverageValue(Array array){
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
        return average;
    }

    public int countNegativeValues(Array array){
        int n = array.getSize();
        int counter = 0;
        int[] clonedArray = array.getClonedArray();
        for (int i = 0; i < n; i++){
            if (clonedArray[i] < 0){
                counter++;
            }
        }
        return counter;
    }

    public void replaceAllEvenByZero(Array array){
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
            e.printStackTrace();
        }
    }
}
