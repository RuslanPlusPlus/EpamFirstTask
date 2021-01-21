package by.me.action;

import by.me.entity.Array;
import by.me.exception.ArrayException;

public class ArraySort {
    public void bubbleSort(Array array){
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
            //log
        }
    }

    public void selectionSort(Array array){
        int n = array.getSize();
        for (int i = 0; i < n; i++){
            int minIndex = min(array, i, n);
            if (i != minIndex){
                swap(array, i, minIndex);
            }
        }
    }

    public void insertSort(Array array){
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

        }
    }

    private void swap(Array array, int i, int j){
        try {
            int temp = array.getElement(j);
            array.setElement(j, array.getElement(i));
            array.setElement(i, temp);
        }catch (ArrayException e){
            //
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
            //
        }
        return minIndex;
    }
}
