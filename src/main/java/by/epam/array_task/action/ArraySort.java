package by.epam.array_task.action;

import by.epam.array_task.entity.Array;
import by.epam.array_task.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySort {

    static final Logger logger = LogManager.getLogger();

    public void bubbleSort(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (bubbleSort method)");
        }
        if (array.isEmpty()){
            logger.error("Passed array is empty (bubbleSort method)");
            return;
        }
        int n = array.getSize();
        try {
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (array.getElement(i) > array.getElement(j)) {
                        swap(array, i, j);
                    }
                }
            }
        }catch (ArrayException e){
            logger.error(e.getMessage());
        }
        logger.info("Array is sorted by bubble sorting");
    }

    public void selectionSort(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (selectionSort method)");
        }
        if (array.isEmpty()){
            logger.error("Passed array is empty (selectionSort method)");
            return;
        }
        int n = array.getSize();
        for (int i = 0; i < n; i++){
            int minIndex = min(array, i, n);
            if (i != minIndex){
                swap(array, i, minIndex);
            }
        }
        logger.info("Array is sorted by selection sorting");
    }

    public void insertSort(Array array) throws ArrayException {
        if (array == null){
            throw new ArrayException("Passed argument is null (insertSort method)");
        }
        if (array.isEmpty()){
            logger.error("Passed array is empty (insertSort method)");
            return;
        }
        int n = array.getSize();
        try {
            for (int i = 1; i < n; i++){
                int value = array.getElement(i);
                int j = i - 1;
                while (j >= 0 && array.getElement(j) > value){
                    array.setElement(j+1, array.getElement(j));
                    j -= 1;
                }
                array.setElement(j+1, value);
            }
        }catch (ArrayException e){
            logger.error(e.getMessage());
        }
        logger.info("Array is sorted by insert sorting");
    }

    private void swap(Array array, int i, int j){
        try {
            int temp = array.getElement(j);
            array.setElement(j, array.getElement(i));
            array.setElement(i, temp);
        }catch (ArrayException e){
            logger.error(e.getMessage());
        }
    }

    private int min(Array array, int begin, int end){
        int n = array.getSize();
        int minValue = 0;
        int minIndex = 0;
        try {
            minValue = array.getElement(begin);
            minIndex = begin;
            for (int i = begin + 1; i < end; i++){
                if (array.getElement(i) < minValue){
                    minValue = array.getElement(i);
                    minIndex = i;
                }
            }
        } catch (ArrayException e) {
            logger.error(e.getMessage());
        }
        return minIndex;
    }
}
