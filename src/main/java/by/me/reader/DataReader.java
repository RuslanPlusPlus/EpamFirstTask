package by.me.reader;

import by.me.exception.ReaderException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    private static DataReader INSTANCE = null;

    private DataReader(){}

    public static DataReader getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new DataReader();
        }
        return INSTANCE;
    }

    public List<String> readLines(String fileName) throws ReaderException {
        if (fileName == null){
            throw new ReaderException("NULL passed");
        }
        if (fileName.isEmpty()){
            throw new ReaderException("Passed filename is empty");
        }
        List<String> arrays = new ArrayList<>();
        Path path = Paths.get(fileName);
        try {
            Files.lines(path, Charset.defaultCharset()).forEach(arrays::add);
        } catch (IOException e) {
            throw new ReaderException("Failed to open file - " + fileName);
        }
        return arrays;
    }

}
