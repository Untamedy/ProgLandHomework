package homework_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class SumCounter implements Runnable {

    private int[] numbers;
    private int start;
    private int end;
    private Thread thread;
    private long sum;
    

    public SumCounter() {
    }

    public SumCounter(int[] numbers) {
        this.numbers = numbers;
        this.thread = new Thread(this);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;    }
    

    public int[] getNumbers() {
        return numbers;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public long multyThreadsCounter(int threadCount, int[] numArray) {
        long allArraySum = 0;         
        List<SumCounter> sumCounters = arraySplit(numArray, threadCount);
        for(SumCounter s: sumCounters){
            try{ 
                allArraySum+=this.sum;
                s.getThread().join();              
                
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }          
        }        
       return sum;
    }

    public List<SumCounter> arraySplit(int[] array, int count) {
        int size = (int) Math.ceil(array.length / count);
        int startOfArray = 0;
        int endEnfOfArray = 0;
        List<SumCounter> arrays = new ArrayList<>();
        if (array.length == 0) {
            return arrays;
        }
        if (size < 2 || count == 1) {
            arrays.add(new SumCounter(array));            
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
                int[] newArray = Arrays.copyOfRange(array, startOfArray, endEnfOfArray);
                arrays.add(new SumCounter(newArray));                
            }
        }
        return arrays;
    }

    public SumCounter[] createThreads(int count) {
        SumCounter[] sumCounters = new SumCounter[1];
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (count > availableProcessors) {
            sumCounters = new SumCounter[availableProcessors];
        }
        if ((0 < count) && (count <= availableProcessors)) {
            sumCounters = new SumCounter[count];
            return sumCounters;
        }
        return sumCounters;
    }

    

    public void countSum() {
        int [] numArray = this.numbers;
        sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            sum += numArray[i];
        }
      
    }

    @Override
    public void run() {
        countSum();
    }

}
