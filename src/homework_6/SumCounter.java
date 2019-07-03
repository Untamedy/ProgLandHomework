package homework_6;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class SumCounter {

    static final Logger logger = Logger.getLogger(SumCounter.class.getName());

    public SumCounter() {
    }

    public static int multyThreadsCounter(int threadCount, int[] numArray) {
        int allArraySum = 0;
        List<Worker> sumCounters = getWorkersList(numArray, threadCount);
        sumCounters.forEach((w) -> w.start());
        sumCounters.forEach((w) -> {
            try {
                w.join();
            } catch (InterruptedException e) {
            }
        });
        for (Worker w : sumCounters) {
            allArraySum += w.sum;
        }
        return allArraySum;
    }

    private static  List<Worker> getWorkersList(int[] array, int count) {
        int startOfArray = 0;
        int endEnfOfArray = 0;
        count = realThreadQuantity(count);
        int size = (int) Math.ceil(array.length / count);
        List<Worker> arrays = new ArrayList<>();
        if (array.length == 0) {
            return arrays;
        }
        if (size < 2 || count == 1) {
            arrays.add(new Worker(startOfArray, array.length,0,array));
            return arrays;
        } else {
            for (int i = 0; i < count; i++) {
                if (endEnfOfArray == array.length) {
                    return arrays;
                }
                startOfArray = size * i;
                endEnfOfArray = (int) ((i + 1) * size);
                if ((array.length - endEnfOfArray) < size) {
                    endEnfOfArray = array.length;
                }                
                arrays.add(new Worker(startOfArray, endEnfOfArray, i, array));
            }
        }
        return arrays;
    }

    public static int realThreadQuantity(int count) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (count > availableProcessors) {
            count = availableProcessors;
        }
        if ((0 < count) && (count <= availableProcessors)) {
            return count;
        }
        return count;
    }

    public static int countArraySum(int[] num) {
        int sumOfArray = 0;
        for (int i = 0; i < num.length; i++) {
            sumOfArray += num[i];
        }
        return sumOfArray;
    }

    private static class Worker extends Thread{
       
        
        private  int start;
        private  int end;      
        private  long sum;
        private  int index;       
        private  int [] numArray;
        
        public Worker(){
            
        }

        public Worker(int start, int end, int index, int [] numArray) {
            this.numArray = numArray;
            this.start = start;
            this.end = end;           
            this.index = index;                      
        }
       

        public  long getSum() {
            return sum;
        }        

        public  int getIndex() {
            return index;
        }
              

        public void countSum() {
            sum = 0;            
            for (int i = start; i < end; i++) {
                sum += numArray[i];
                logger.log(Level.INFO, "sumCounter {0} iteration number {1} sum = {2}", new Object[]{index, i, sum});
            }
        }

        @Override
        public void run() {
            countSum();
        }

    }

}
