package homework_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class FileCopier {

    static final Logger logger = Logger.getLogger(FileCopier.class.getName());

    public static void multithreadCopier(String readFrom, String writeTo, int threadCount){
        File [] files = getFiles(readFrom);
        
     List<Worker> workers = getWorkersList(files, threadCount, writeTo);
     for (Worker w : workers) {                      
            w.start();
            logger.info("thread " + w.getIndex() + " started" );
     }
        for (Worker w : workers) {
            try {
                w.join();
            } catch (InterruptedException e) {
            }
        }        
       
    }
      
        
    
    public static List<Worker> getWorkersList(File[] array, int count, String writeTo) {
        int startOfArray = 0;
        int endEnfOfArray = 0;
        count = realThreadQuantity(count);
        int size = (int) Math.ceil(array.length / count);
        List<Worker> arrays = new ArrayList<>();
        if (array.length == 0) {
            return arrays;
        }
        if (size < 2 || count == 1) {
            arrays.add(new Worker(array, writeTo, startOfArray, endEnfOfArray, 0));
            return arrays;
        } else {
            for (int i = 0; i < count; i++) {
                if (endEnfOfArray == array.length) {
                    return arrays;
                }
                startOfArray = size * i;
                endEnfOfArray = (int) ((i + 1) * size);
                if ((array.length - endEnfOfArray) < size) {
                    endEnfOfArray = array.length;
                }                
                arrays.add(new Worker(array, writeTo, startOfArray, endEnfOfArray, i));
            }
        }
        return arrays;
    }
    
    
    public static int realThreadQuantity(int count) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (count > availableProcessors) {
            count = availableProcessors;
        }
        if ((0 < count) && (count <= availableProcessors)) {
            return count;
        }
        return count;
    }

    public static File[] getFiles(String path) {
        File[] files = new File[1];
        File direct = new File(path);
        if (direct.isDirectory()) {
            files = direct.listFiles();
            return files;
        }
        files[0] = direct;
        return files;
    }

    

    public static class Worker extends Thread{
        
        private int start;
        private int end;
        private int index;
        private File [] readFrom;
        private String writeTo;      
        
        public Worker(){
            
        }
        
        public Worker(File [] readFrom, String writeTo, int start, int end, int index){
            this.readFrom = readFrom;
            this.writeTo = writeTo; 
            this.start = start;
            this.end = end;
            this.index = index;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        
        public int getIndex() {
            return index;
        }
        
        
        

        public void copyFiles(File [] files, String writeToDir, int start, int end) {
            int copyNum = 1;
            try {
                File writeTo = new File(writeToDir);                
                if (writeTo.isDirectory()) {
                    for (int i = start; i<end;i+=1) {
                        File write = new File(writeToDir, "newFile_" + copyNum + ".txt");
                        copy(files[i], write);
                        copyNum++;
                        logger.info("File copied successfully");
                    }
                }
            } catch (IOException e) {
                logger.warning(e.getMessage());

            }

        }
         public void copy(File readFrom, File writeTo) throws FileNotFoundException, IOException {
        byte[] buffer = new byte[1024 * 1024];
        int byteRead = 0;
        try (FileInputStream reader = new FileInputStream(readFrom); FileOutputStream writer = new FileOutputStream(writeTo)) {
            for (; (byteRead = reader.read(buffer)) > 0;) {
                writer.write(buffer, 0, byteRead);
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

        @Override
        public void run() {
            copyFiles(this.readFrom,this.writeTo, this.start, this.end);
           
        }
        

    }
    
}
