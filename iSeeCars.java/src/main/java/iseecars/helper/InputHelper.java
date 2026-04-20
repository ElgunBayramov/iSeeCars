package iseecars.helper;
import static java.lang.System.out;
import java.util.Scanner;
import java.util.function.Predicate;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);
    public static int readInt(String message, Predicate<Integer> validate, String errorMessage){
        while (true){
            out.println(message);
            try{
                int value = Integer.parseInt(scanner.nextLine());
                if(validate.test(value))
                    return value;

            } catch (Exception ignored){}

            ConsoleHelper.printErrorMessage(errorMessage);
        }
    }

    public static double readDouble(String message, Predicate<Double> validate,String errorMessage){
        while (true){
            out.println(message);

            try{
                double value = Double.parseDouble(scanner.nextLine().replace(",","."));
                if(validate == null || validate.test(value))
                    return value;
            }
            catch(Exception ignored){}
            ConsoleHelper.printErrorMessage(errorMessage);
        }
    }

    public static String readString(String message,Predicate<String> validate,String errorMessage){
        while(true){
            out.println(message);
            String input = scanner.nextLine();

            if(validate.test(input))
                return input;

            ConsoleHelper.printErrorMessage(errorMessage);
        }
    }
}
