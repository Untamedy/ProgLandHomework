package javaOOP.homework_7.harbor;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Seaport {
    
    public static final Logger logger = Logger.getLogger(Seaport.class.getName());
    
    private ExecutorService dockers;
    private final static int DEFAULT_DOC_NUMBER = 2;

    public Seaport() {
        this(DEFAULT_DOC_NUMBER);
    }

    public Seaport(int dockNumber) {
        dockers = Executors.newFixedThreadPool(dockNumber);
    }
    
    public void unloadShip(Ship ship){
        logger.info("Unload ship " + ship.getName());
        dockers.execute(new DockActivity(ship));
    }
    
    public  void stop(){
        dockers.shutdown();
    }

    public class DockActivity implements Runnable {
        private Ship ship;

        private boolean isUnloading = false;

        public DockActivity(Ship ship) {   
            this.ship = ship;
        }
        
       

        @Override
        public void run() { 
            Thread t = Thread.currentThread();
            logger.info("Thread " + t.getName() + " start working with " + ship.getName());
            while(!ship.isEmpty()){
                try {
                    ship.giveCargo();
                    Thread.sleep(500);
                    logger.info("Thread " + t.getName() + " ship = " + ship.getName() + " cargo = " + ship.getCargos());
                } catch (InterruptedException ex) {
                   logger.severe(ex.getMessage());
                }
            }            

        }

    }
}
