package homework_9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class FirstTask {
    private List<String> list;

    public FirstTask() {

    }

    public List<String> getList() {
        return list;
    }
    
    
    
    public List<String> modifyList(){
        addToList();
        List<String> modifiedList = new ArrayList<>();
        System.out.println("Befor modifying: " + list);
        modifiedList = list.subList(2, list.size()-1);
        System.out.println("After modifying: " + modifiedList);
        return modifiedList;
        
    } 

    public void addToList() {
        list = new ArrayList<>();
        String s = "";
        for (int i = 0; i < 10; i++) {
            s = "String №_" + i;
            list.add(s);
        }       
    }

}
