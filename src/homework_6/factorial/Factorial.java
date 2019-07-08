package homework_6.factorial;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Factorial {
    
     public static Logger logger = Logger.getLogger(Factorial.class.getName());

    private Thread[] threads = new Thread[100];

    public Factorial() {

    }

    public Thread[] getThreads() {
        return threads;
    }

    public void threadStart() {
        iniThreads();
        for (int i = 0; i < threads.length; i += 1) {
            threads[i].start();
            logger.info(threads[i].getName() + " started");
        }
    }

    public void iniThreads() {
        for (int i = 0; i < threads.length; i += 1) {
            int num = i + 1;
            threads[i] = new Thread(new Worker(num), "Thread_" + num);
            logger.info("thread " + num + " created");
        }
    }

    public static BigInteger calcFactorial(int num) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= num; i += 1) {
            factorial = factorial.multiply(new BigInteger("" + i));
        }
        return factorial;
    }

    public static class Worker extends Thread {

        private int num = 1;

        public Worker() {

        }

        public Worker(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
             

        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 1; i <= this.num; i++) {
                logger.info(thread.getName() + " " + i + "!= " + calcFactorial(i));
            }

        }
    }

}
