package homework_8.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class BlackList {
    
    public  static final Logger LOGGER = Logger.getLogger(BlackList.class.getName());
    
    private List<Class> blackList = new ArrayList<>();
    
    public BlackList(){
        
    }

    public List<Class> getBlackList() {
        return blackList;
    }
        
    
    public void addToBlackList(Object object){        
        if(!contain(object)){
            blackList.add(object.getClass());
        }  
    }
    
    public void remove(Object object){
        if(contain(object)){
            blackList.remove(object.getClass());
        }
        
    }
    
    public boolean contain(Object object){
        Class<?> objectClass = object.getClass();
        return blackList.contains(objectClass);
    }
    
    
    

}
