package homework_6.shell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class ShellSort {   
    static final Logger logger = Logger.getLogger(ShellSort.class.getName());

    public ShellSort() {        
    }

    public static int [] shellSort(int [] numArray){
        int increment = numArray.length / 2;
        List<Worker> workers = new ArrayList<>();
        while (increment >= 1) {
            for (int startIndex = 0; startIndex < increment; startIndex++) {                
                Worker worker = new Worker(numArray, startIndex, increment);
                workers.add(worker);
                worker.start();
                logger.info("thread start. Result: " + Arrays.toString(numArray)); 
            }
            for(Worker w: workers){
                try {
                    w.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ShellSort.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            workers = new ArrayList<>();
            increment = increment / 2;
        }
        return numArray;
    }

    private static void insertionSort(int[] arr, int startIndex, int increment) {
        for (int i = startIndex; i < arr.length - 1; i = i + increment) {
            for (int j = Math.min(i + increment, arr.length - 1); j - increment >= 0; j = j - increment) {
                if (arr[j - increment] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - increment];
                    arr[j - increment] = tmp;
                } else {
                    break;
                }
            }
        }
    }
 
    public static class Worker extends Thread {

        private int[] array;
        private int startIndex;
        private int increment;

        public Worker(int[] array, int startIndex, int increment) {
            this.array = array;
            this.startIndex = startIndex;
            this.increment = increment;

        }

        @Override
        public void run() {
            insertionSort(this.array, this.startIndex, this.increment);
        }

    }
}
