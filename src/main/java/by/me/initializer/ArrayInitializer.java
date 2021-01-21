package by.me.initializer;

import by.me.entity.Array;
import by.me.exception.ArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayInitializer {

    private static final Logger logger = LogManager.getLogger();

    public void fillRandomized(Array array, int minValue, int maxValue){
        if (minValue > maxValue) {
            throw new IllegalArgumentException("minValue cannot be less than maxValue");
        }
        int n = array.getSize();
        for (int i = 0; i < n; i++){
            try {
                array.setElement(i, (int)(minValue + Math.random() * (maxValue - minValue)));
            } catch (ArrayException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
