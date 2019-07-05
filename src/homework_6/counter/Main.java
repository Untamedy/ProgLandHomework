package homework_6.counter;

/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
        int[] secondarray = {1, 2, 3, 6, 5, 4, 7, 8, 9, 8, 7, 4, 5, 8, 6, 9, 5, 4, 8};

        long tStart = System.currentTimeMillis();
        int sum = SumCounter.countArraySum(secondarray);
        System.out.println("checked sum = " + sum);
        long tEnd = System.currentTimeMillis();
        long timeResult = tEnd - tStart;
        System.out.println("Result_defoultCounter = " + timeResult);

        tStart = System.currentTimeMillis();
        int result = SumCounter.multyThreadsCounter(30, secondarray);
        tEnd = System.currentTimeMillis();
        System.out.println("Result = " + result);
        timeResult = tEnd - tStart;
        System.out.println("Result_multithreadCounter = " + timeResult);
    }
}
