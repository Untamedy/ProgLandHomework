package homework_5;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class FileHandler {
    
    Logger logger = Logger.getLogger(FileHandler.class.getName()); 

    public void copyFiles(String readFromDir, String writeToDir, String typeFile) {
        int copyNum = 1;
        try {
            File writeTo = new File(writeToDir);
            File[] forRead = getFiles(readFromDir, typeFile);
            if (writeTo.isDirectory()) {
                for (File f : forRead) {
                    File write = new File(writeToDir,"newFile_"+copyNum+".txt");
                    copy(f, write);
                    copyNum++;
                    logger.info("File copied successfully");
                }
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());

        }
    }

    public File[] getFiles(String path, String type) {
        File readFrom = new File(path);
        File[] oneFile = new File[1];
        if (readFrom.isDirectory()) {
            File[] files = readFrom.listFiles((File pathname) -> pathname.getName().endsWith(".txt"));
            logger.log(Level.INFO, "Found {0} files", files.length);
            return files;
        } else {
            if (readFrom.getName().endsWith(type)) {
                oneFile[0] = readFrom;
            }
        }
        return oneFile;
    }

    public void copy(File readFrom, File writeTo) throws FileNotFoundException, IOException {
        byte[] buffer = new byte[1024 * 1024];
        int byteread = 0;        
        try (FileInputStream reader = new FileInputStream(readFrom);
                FileOutputStream writer = new FileOutputStream(writeTo)) {           
            for (; (byteread = reader.read(buffer)) > 0;) {               
                writer.write(buffer,0,byteread);                
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
    }

    public void appendFiles(File firstFile, File secondFile, File writeTo) {                
        List<String> firsdFilecontetn = splitBy(fileContentToString(firstFile), "\\s+|,\\s*|\\.\\s*|\\:\\s*");
        List<String> secondFileContent = splitBy(fileContentToString(secondFile), "\\s+|,\\s*|\\.\\s*");
        firsdFilecontetn.retainAll(secondFileContent);
        try (FileWriter writer = new FileWriter(writeTo)) {
            for (String s : firsdFilecontetn) {
                writer.write(s + ",");
            }
        } catch (IOException e) {
           logger.warning(e.getMessage());
        }
    }

    public String fileContentToString(File file) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String s = "";
            for (; (s = reader.readLine()) != null;) {
                content.append(s.toLowerCase()).append(" ");
            }
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return content.toString();
    }

    public List<String> splitBy(String toSplit, String regex) {                 
        String[] afterSplit = toSplit.split(regex);
        List<String> worsd = new ArrayList<>(Arrays.asList(afterSplit));
        return worsd;
    }
}
