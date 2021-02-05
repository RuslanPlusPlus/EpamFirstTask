package by.epam.array_task.validator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {

    private Validator validator;
    private String array;
    private String number;

    @BeforeMethod
    public void setUp() {
        this.validator = new Validator();
        this.array = "    1 34 3  24  -90";
        this.number = "-345";
    }

    @AfterMethod
    public void tearDown() {
        this.array = null;
        this.validator = null;
    }

    @Test
    public void testIsValidLine() {
        boolean actual = this.validator.isValidLine(this.array);
        assertEquals(actual, true);
    }

    @Test
    public void testIsNumber() {
        boolean actual = this.validator.isNumber(this.number);
        assertEquals(actual, true);
    }
}