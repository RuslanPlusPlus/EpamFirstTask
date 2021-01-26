package by.me.reader;

import by.me.exception.ReaderException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<String> arrays = new ArrayList<>();
        Path path = Paths.get(fileName);
        Scanner reader = null;
        try {
            reader = new Scanner(path);
        } catch (IOException e) {
            throw new ReaderException("Failed to find file");
        }

        while (reader.hasNextLine()){
            String array = reader.nextLine();
            arrays.add(array);
        }
        return arrays;
    }

}
