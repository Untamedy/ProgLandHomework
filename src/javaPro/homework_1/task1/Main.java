package javaPro.homework_1.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static final Logger logger = Logger.getLogger(javaPro.Main.class.getName());

    public static void main(String[] args) {

        System.out.println(ifAnnotated("javaPro.homework_1.task1.Store"));

    }

    public static String ifAnnotated(String className) {
        String result = "";
        try {
            Class cl = Class.forName(className);
            Method[] methods = cl.getDeclaredMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(MyAnnotation.class)) {
                    Annotation[] annotations = m.getAnnotations();
                    for (Annotation a : annotations) {
                        if (a instanceof MyAnnotation) {
                            MyAnnotation annotation = (MyAnnotation) a;
                            result = (String) m.invoke(cl.newInstance(), annotation.expected(), annotation.actualy());
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | InstantiationException ex) {
            logger.warning(ex.getMessage());
        }
        return result;
    }

}
