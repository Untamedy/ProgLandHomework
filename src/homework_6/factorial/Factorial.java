package homework_6.factorial;

import java.math.BigInteger;

/**
 *
 * @author YBolshakova
 */
public class Factorial implements Runnable {

    private int num =1;

    private Thread[] threads = new Thread[100];

    public Factorial() {

    }

    public Factorial(int num) {
        this.num = num;
    }

    public Thread[] getThreads() {
        return threads;
    }

    public int getNum() {
        return num;
    }

    public void iniThreads() {
        for (int i = 0; i < threads.length; i += 1) {
            threads[i] = new Thread(new Factorial(num), "Thread_" + this.num);
            num++;
            System.out.println("thread " + this.num + " created");
        }
    }

    public BigInteger calcFactorial(int num) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= num; i += 1) {
            factorial = factorial.multiply(new BigInteger("" + i));
        }
        return factorial;
    }
    
    public void threadStart(){
        for(int i = 0; i<threads.length;i+=1){
            threads[i].start();
            System.out.println(threads[i].getName() + " started");
        }
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 1; i <=this.num; i++) {
            System.out.println(thread.getName() + " " + i + "!= " + calcFactorial(i));
        }

    }

}
