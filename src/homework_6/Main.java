package homework_6;

/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
      Factorial f = new Factorial();
      SumCounter s = new SumCounter();
      int [] arr = {1,2,3,6,5,7,8};
      s.arraySplit(arr, 2);
        System.out.println(s.calcEndValue(29, 4));
        System.out.println(s.calcEndValue(30, 5));
        System.out.println(s.calcEndValue(4, 3));
      
      //f.iniThreads();
      //f.threadStart();
        
        
    }

}
