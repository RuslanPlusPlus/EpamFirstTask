package by.me.validator;

public class Validator {

    private static final String NUMERIC_ARRAY = "[0-9-\\s]*";

    public static boolean isValidLine(String line){
        String tempLine = line.trim();
        if (tempLine.isEmpty()){
            return false;
        }
        return tempLine.matches(NUMERIC_ARRAY);
    }

    public static boolean isNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
