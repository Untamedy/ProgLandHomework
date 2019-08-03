package javaOOP.homework_6.shell;


import java.util.Arrays;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        int[] arr = {5, 9, 8, 74, 75, 2, 5, 9, 8, 6, 4, 7, 1, 3};       
        int[] newarr = ShellSort.shellSort(arr);       
        logger.info("Result = " + Arrays.toString(newarr));
    }

}
