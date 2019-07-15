package homework_8.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Faculty {

    public static final Logger LOGGER = Logger.getLogger(Faculty.class.getName());

    private List<GroupOfStudent> groups;
   

    public Faculty() {

    }

    public List<GroupOfStudent> createFaculty(List<Student> list, int groupNum) {
        groups = new ArrayList<>();
        GroupOfStudent group = new GroupOfStudent(groupNum, 5);
        for (Student s : list) {
            if (group.isFull()) {
                groups.add(group);
                groupNum++;
                group = new GroupOfStudent(groupNum, 5);
                group.addStudent(s);
            } else {
                group.addStudent(s);
            }
        }
        if(!group.getList().isEmpty()){
            groups.add(group); 
        }       
        return groups;
    }

    public void addToBase(String path) {
        File file = new File(path);
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file, true))) {            
                writer.writeObject(groups);                
             
           
        } catch (IOException ex) {
            LOGGER.severe(ex.getMessage());
        }
    }

    public List<GroupOfStudent> readFromBase(String path) {       
        List<GroupOfStudent> groupAfterRead = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {
            groupAfterRead = (List<GroupOfStudent>) reader.readObject();               

        } catch (IOException | ClassNotFoundException ex) {
           LOGGER.severe(ex.getMessage());
        }
        return groupAfterRead;
    }
}
