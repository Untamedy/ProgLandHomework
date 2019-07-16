package homework_8.stack;

import java.util.logging.Logger;

/**
 *
 * @author YBolshakova
 */
public class Stack {

    public static final Logger LOGGER = Logger.getLogger(Stack.class.getName());

    private Object[] stackObjects = new Object[10];
    private BlackList blackList;
    private int index = 0;
    private int lastIndex = 0;

    public Stack() {

    }

    public Stack(BlackList blackList) {
        this.blackList = blackList;
    }

    public void addToStack(Object object) {
        if (!isCorrect(index)) {
            LOGGER.warning("Array is full");
        }
        if (!blackList.contain(object)) {
            stackObjects[index] = object;
            lastIndex = index;
            index++;
        } else {
            LOGGER.warning("This class " + object.getClass() + " contains at blackList");
        }

    }

    public void removeFromStack() {
        if (isCorrect(lastIndex)) {
            stackObjects[lastIndex] = null;
            index--;
            LOGGER.info("Remove objeck with index = " + lastIndex);
            lastIndex-=1;
        } else {
            throw new ArrayIndexOutOfBoundsException("Array is empty");

        }
    }

    public Object peekFromStack() {
        Object newObject = new Object();
        if (isCorrect(lastIndex)) {
            newObject = stackObjects[lastIndex];
            System.out.println("");
            LOGGER.info("Return objeck with index = " + lastIndex);
        }
        return newObject;
    }

    public boolean isCorrect(int index) {
        return ((index >= 0) && (index < stackObjects.length));
    }

}
