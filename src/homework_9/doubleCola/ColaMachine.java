package homework_9.doubleCola;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class ColaMachine {

    private Queue<Human> queueByCola;
    private int quantity;

    public ColaMachine() {

    }

    public ColaMachine(int quantity) {
        this.quantity = quantity;
        initQueue();
    }
    
    public Queue<Human> getQueueByCola() {
        return queueByCola;
    }

    public Queue<Human> giveCola() {
        int counter = 0;
        while (counter < quantity) {
            Human client = queueByCola.poll();
            if (null != client) {
                try {
                    Human newClient = (Human) client.clone();
                    queueByCola.offer(client);
                    queueByCola.offer(newClient);
                    counter++;
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(ColaMachine.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return queueByCola;
    }

    private void initQueue() {
        queueByCola = new ArrayDeque<>();
        queueByCola.offer(new Human("Sheldon"));
        queueByCola.offer(new Human("Penny"));
        queueByCola.offer(new Human("Wolowitz"));
        queueByCola.offer(new Human("Leonard"));
        queueByCola.offer(new Human("Koothrappali"));
    }

    
    
    

    public class Human implements Cloneable {

        private String name;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Humen{" + "name=" + name + '}';
        }
        
        

    }

}
