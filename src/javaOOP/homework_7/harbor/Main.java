package javaOOP.homework_7.harbor;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        Seaport seaport = new Seaport();        
        
        seaport.unloadShip(new Ship("Titanic_1", 10));
        seaport.unloadShip(new Ship("Titanic_2", 10));
        seaport.unloadShip(new Ship("Titanic_3", 10));
        seaport.stop();
        
    }

}
