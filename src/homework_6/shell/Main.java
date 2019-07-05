package homework_6.shell;

import homework_6.copier.FileCopier;
import homework_6.counter.SumCounter;
import java.util.Arrays;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
       
        int[] arr = {5, 9, 8, 74, 75, 2, 5, 9, 8, 6, 4, 7, 1, 3};
        int[] newarr = ShellSort.shellSort(arr);
        System.out.println(Arrays.toString(newarr));
        

       
       
        
    }

}
