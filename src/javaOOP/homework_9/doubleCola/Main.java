package javaOOP.homework_9.doubleCola;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        ColaMachine colaMachine = new ColaMachine(5);

        System.out.println("Queue befor:" + colaMachine.getQueueByCola());
        System.out.println("Queue after :" + colaMachine.giveCola());

    }

}
