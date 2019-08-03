package javaOOP.homework_6.observer;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Observer {

    static final Logger logger = Logger.getLogger(Observer.class.getName());

    private static Set<File> curentState;
    private static String path;
    private static boolean isRunning;
    private static Callback callback;
    private Worker worker;

    public Observer() {

    }

    public Observer(String path, Callback callback) {
        this.path = path;
        this.callback = callback;        
    }

    public Worker getWorker() {
        return worker;
    }

   

    private void init(String path) {
        if(path == null|| path.isEmpty()){
            throw new IllegalArgumentException("Path can't be null or empty");
        }
        curentState = getFiles(path);
    }

    public void start() {
        isRunning = true;
        init(path);
        worker = new Worker();
        worker.start();
    }

    public void stop() {
        isRunning = false;
    }

    public static Set<File> getFiles(String path) {
        File directory = new File(path);
        Set<File> setOfFiles = new HashSet<>();
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            setOfFiles.addAll(Arrays.asList(files));
        }
        return setOfFiles;
    }

    public static void checkDirect() {
        Set<File> newState = getFiles(path);
        if ((!curentState.containsAll(newState)) || (curentState.size() != newState.size())) {
            curentState = newState;
            callback.execute();
        }
    }

    public static class Worker extends Thread {

        public Worker() {
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    checkDirect();
                    logger.info("Folder is checked");
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Observer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static interface Callback {

        public void execute();
    }
}
