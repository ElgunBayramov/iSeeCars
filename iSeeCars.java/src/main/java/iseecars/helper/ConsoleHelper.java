package iseecars.helper;
import static java.lang.System.out;
import static java.lang.System.in;
public class ConsoleHelper {
    public static void pause(){
    out.println("Press Enter to continue...");
    try{
        in.read();
    } catch (Exception ignored){}
     clearConsole();
    }

    public static void clearConsole(){
        for (int i = 0; i < 50; i++){
            out.println();
        }
    }
    public static void printErrorMessage(String message){
        out.println("\u001B[31m" + message + "\u001B[0m");
    }
}
