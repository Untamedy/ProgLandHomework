package homework_6;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        Factorial f = new Factorial();
        
        SumCounter s = new SumCounter();
        
        int[] arr = {1, 2, 3, 6, 5, 4, 7, 8};

        long tStart = System.currentTimeMillis();
        int sum = SumCounter.countArraySum(arr);
        System.out.println("checked sum = " + sum);
        long tEnd = System.currentTimeMillis();
        long timeResult = tEnd - tStart;
        System.out.println("Result_defoultCounter = " + timeResult);

        tStart = System.currentTimeMillis();
        int result = s.multyThreadsCounter(30, arr);
        tEnd = System.currentTimeMillis();
        System.out.println("Result = " + result);
        timeResult = tEnd - tStart;
        System.out.println("Result_multithreadCounter = " + timeResult);

    }

}
