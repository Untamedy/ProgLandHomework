package homework_6;



/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {   
        String readFromDir = "folderOne\\";
        String writeToDir = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\";
        

        FileCopier.multithreadCopier(readFromDir, writeToDir, 2);
    
        //Worker w = new FileCopier.Worker();
        //System.out.println(w.copyDirectory(readFromDir, writeToDir));
        

        /*int[] arr = {1, 2, 3, 6, 5, 4, 7, 8, 9, 8, 7, 4, 5, 8, 6, 9, 5, 4, 8};

        long tStart = System.currentTimeMillis();
        int sum = SumCounter.countArraySum(arr);
        System.out.println("checked sum = " + sum);
        long tEnd = System.currentTimeMillis();
        long timeResult = tEnd - tStart;
        System.out.println("Result_defoultCounter = " + timeResult);

        tStart = System.currentTimeMillis();
        int result = SumCounter.multyThreadsCounter(30, arr);
        tEnd = System.currentTimeMillis();
        System.out.println("Result = " + result);
        timeResult = tEnd - tStart;
        System.out.println("Result_multithreadCounter = " + timeResult);*/

    }

}
