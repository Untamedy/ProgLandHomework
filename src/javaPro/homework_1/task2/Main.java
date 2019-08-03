package javaPro.homework_1.task2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javaPro.homework_1.task1.Main.logger;
import jdk.nashorn.internal.objects.annotations.Constructor;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        
        String className = "javaPro.homework_1.task2.Saver";
        TextContainer container = new TextContainer("Hello World!"); 
        
        try {
            try {
                ifAnnotated(className,container);
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ifAnnotated(String className, TextContainer container) throws ClassNotFoundException, NoSuchMethodException {
        String path = "";
        Class objclass = Class.forName(className);
        if (objclass.isAnnotationPresent(FilePath.class)) {
            Annotation[] annotations = objclass.getAnnotations();
            for (Annotation a : annotations) {
                if (a instanceof FilePath) {
                    FilePath filePath = (FilePath) a;
                    path = filePath.path();
                }
            }
        }
        Method[] classMethods = objclass.getDeclaredMethods();
        for (Method m : classMethods) {
            if (m.isAnnotationPresent(Writer.class)) {
                Annotation[] annotations = m.getAnnotations();
                for (Annotation a : annotations) {
                    if (a instanceof Writer) {
                        try {                              
                            m.invoke(objclass.getConstructor(TextContainer.class).newInstance(container), path);
                        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException ex) {
                            logger.warning(ex.getMessage());
                        } catch (InstantiationException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        
                    }
                }

            }
        }
        }
    }
}
    
    

