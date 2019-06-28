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

    public SumCounter() {
    }

    public SumCounter(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

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
    
    

    public long sumCounter(int[] intArray, int start, int end) {
        long sum = 0;
        for (int i = start; i <=end; i += 1) {
            sum += intArray[i];
        }
        return sum;
    }
    
    public long multyThreadsCounter(int threadCount, int [] numArray){ 
        long sum = 0;
        Thread [] threads = createThreads(threadCount);
        
        
        
        return sum;
        
    }
    
    public List<int []> arraySplit(int [] array, int count){
        int startOfArray = 0;
        int endEnfOfArray = calcEndValue(array.length, count);
        List<int []> arrays = new ArrayList<>();
        for(int i=1;i<=count+1;i++){            
            int [] newArray = Arrays.copyOfRange(array, startOfArray, endEnfOfArray);
            arrays.add(newArray);
            startOfArray = endEnfOfArray;
            endEnfOfArray = endEnfOfArray +count-1;
            System.out.println(Arrays.toString(newArray));
        }        
        return arrays;
        
    }
    
    public int calcEndValue(int length, int count){
        int endOfArray = 0;
        if((length%count)!=0) {
           return endOfArray =  Math.abs(length/count+1); 
        }
        return endOfArray = length/count;
    }
    
    public Thread [] createThreads(int count){
        Thread [] threads = new Thread[count];
        for (int i = 0; i < threads.length; i+=1) {
            threads[i]= new Thread(new SumCounter());            
        }
        return threads;        
    }
    
    

    @Override
    public void run() {

    }

}
