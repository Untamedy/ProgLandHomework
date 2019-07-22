package homework_10.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YBolshakova
 *
 */
public class ObjectsCounter<T>{
    
    private String path;
    private List<T> objects;
    private Map<T, Integer> result;
   

    public ObjectsCounter() {

    }

    public ObjectsCounter(List<T> objects) {
        this.objects = objects;               
    }

    

    public List<T> getCharacters() {
        return objects;
    }
    
    

    public Map<T, Integer > count(List<T> objects) {
        result = new HashMap<>();       
        for (Object t : objects) {
            Integer quantity = result.get(t);
            if (quantity != null) {
                result.put((T) t, quantity += 1);
            } else {
                result.put((T) t, 1);
            }
        }
        return result;
    }

}
