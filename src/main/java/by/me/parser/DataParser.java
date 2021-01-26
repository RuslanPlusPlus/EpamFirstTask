package by.me.parser;

import by.me.entity.Array;
import by.me.exception.ParserException;
import by.me.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    private static final String SPLITTER = "\\s";
    private static final Logger logger = LogManager.getLogger();

    public Array parseLine(String line) throws ParserException{
        if (Validator.isValidLine(line)){
            String[] numbers = line.trim().split(SPLITTER);
            Array array = createArray(numbers);
            logger.info("Line is parsed");
            return array;
        }else {
            throw new ParserException("String is not valid");
        }

    }

    public List<Array> parseLines(List<String> lines) throws ParserException {
        List<Array> arrayList = new ArrayList<>();
        for (String line: lines){
            if (Validator.isValidLine(line)){
                String[] numbers = line.trim().split(SPLITTER);
                Array array = createArray(numbers);
                arrayList.add(array);
            }
        }
        if (arrayList.isEmpty()){
            throw new ParserException("No valid lines found");
        }
        logger.info("List of lines is parsed");
        return arrayList;
    }

    private Array createArray(String[] numbers) throws ParserException {
        int size = numbers.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            int value;
            try {
                value = Integer.parseInt(numbers[i]);
            }catch (NumberFormatException e){
                throw new ParserException("Not numeric format");
            }
            arr[i] = value;
        }
        return new Array(arr);
    }
}
