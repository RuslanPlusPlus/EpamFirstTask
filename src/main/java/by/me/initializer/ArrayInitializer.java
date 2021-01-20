package by.me.initializer;

import by.me.entity.Array;
import by.me.exception.ArrayException;

public class ArrayInitializer {
    public void fillRandomized(Array array, int minValue, int maxValue){
        if (minValue > maxValue) {
            throw new IllegalArgumentException("minValue cannot be less than maxValue");
        }
        int n = array.getSize();
        for (int i = 0; i < n; i++){
            try {
                array.setElement(i, (int)(minValue + Math.random() * (maxValue - minValue)));
            } catch (ArrayException e) {
                //log ...
            }
        }
    }
}
