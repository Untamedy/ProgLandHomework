package homework_7.fileSearcher;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class FileSearcher {

    private static final Logger logger = Logger.getLogger(FileSearcher.class.getName());

    private ExecutorService executorService;
    private volatile boolean running;

    public FileSearcher() {
        this(realThreadQuantity());
    }

    public FileSearcher(int threadNum) {
        executorService = Executors.newFixedThreadPool(threadNum);
    }

    public void serchFileByName(String path, String name) {
        logger.info("Start search by: " + name + " in " + path);
        running = true;
        File file = new File(path);
        executorService.execute(new SearcherActivity(file, name, this));
    }

    public static int realThreadQuantity() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return availableProcessors;
    }

    public void stop() throws InterruptedException {
        running = false;
        executorService.shutdown();
    }

    private static class SearcherActivity implements Runnable {

        private File file;
        private String name;
        private FileSearcher owner;

        public SearcherActivity(File file, String name, FileSearcher owner) {
            this.file = file;
            this.name = name;
            this.owner = owner;
        }

        @Override
        public void run() {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory()) {
                    if (f.getName().equals(name)) {
                        System.out.println("Found file with name " + f.getName() + " in: " + file.getAbsolutePath());
                    }
                } else {
                    if (owner.running) {                        
                        owner.executorService.execute(new SearcherActivity(f, name, owner));
                    }
                }
            }
        }

    }

}
