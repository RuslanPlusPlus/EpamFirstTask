package by.me;

import by.me.action.ArraySort;
import by.me.action.ArrayUtils;
import by.me.entity.Array;
import by.me.initializer.ArrayInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        ArrayInitializer arrayInitializer = new ArrayInitializer();
        Array array = new Array(6);
        arrayInitializer.fillRandomized(array, -5, 34);
        ArrayUtils.display(array);

        logger.info("Array min value: " + ArrayUtils.getMinValue(array));
        logger.info("Array max value: " + ArrayUtils.getMaxValue(array));
        logger.info("Array average value: " + ArrayUtils.getAverageValue(array));
        logger.info("Array sum value: " + ArrayUtils.getElementsSum(array));
        logger.info("Array negatives amount:  " + ArrayUtils.countNegative(array));

        ArraySort arraySort = new ArraySort();
        arraySort.insertSort(array);
        ArrayUtils.display(array);
    }
}
