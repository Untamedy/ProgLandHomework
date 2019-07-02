package homework_6;

/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
      Factorial f = new Factorial();
      SumCounter s = new SumCounter();
      int [] arr = {1,2,3,6,5,4,7,8};
     
      s.arraySplit(arr,2);
      long l = s.multyThreadsCounter(2, arr);
        System.out.println(l);
      //f.iniThreads();
      //f.threadStart();
        
        
    }

}
