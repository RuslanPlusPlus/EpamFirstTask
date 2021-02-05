package by.epam.array_task.reader;

import by.epam.array_task.exception.ReaderException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DataReaderTest {

    private DataReader reader;
    private String fileName;
    private List<String> expected;

    @BeforeMethod
    public void setUp() {
        this.reader = DataReader.getInstance();
        this.fileName = "files/testFile.txt";
        this.expected = new ArrayList<>();
        this.expected.add("1 3 3 2424");
        this.expected.add(" 4");
        this.expected.add("23 0 0 2");
    }

    @AfterMethod
    public void tearDown() {
        this.reader = null;
        this.fileName = null;
        this.expected = null;
    }

    @Test
    public void testReadLines() throws ReaderException {
        List<String> actual = this.reader.readLines(this.fileName);
        assertEquals(actual, expected);
    }
}