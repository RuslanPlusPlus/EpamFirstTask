package by.me;

import by.me.action.ArraySort;
import by.me.action.ArrayUtils;
import by.me.entity.Array;
import by.me.creator.ArrayCreator;
import by.me.exception.ParserException;
import by.me.parser.DataParser;
import by.me.reader.DataReader;
import by.me.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        /*ArrayCreator arrayCreator = new ArrayCreator();
        Array array = new Array(6);
        arrayCreator.fillRandomized(array, -5, 34);
        ArrayUtils arrayUtils = new ArrayUtils();

        logger.info("Array min value: " + arrayUtils.getMinValue(array));
        logger.info("Array max value: " + arrayUtils.getMaxValue(array));
        logger.info("Array average value: " + arrayUtils.getAverageValue(array));
        logger.info("Array sum value: " + arrayUtils.getElementsSum(array));
        logger.info("Array negatives amount:  " + arrayUtils.countNegative(array));

        ArraySort arraySort = new ArraySort();
        arraySort.insertSort(array);*/

        DataReader reader = DataReader.getInstance();
        DataParser parser = new DataParser();
        try {
            List<String> lines = reader.readLines("arrays.txt");
            List<Array> arrayList = parser.parseLines(lines);
            for (Array array: arrayList){
                System.out.println(array);
            }
        } catch (IOException | ParserException e) {
            logger.error(e.getMessage());
        }

    }
}
