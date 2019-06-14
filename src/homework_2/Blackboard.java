package homework_2;

/**
 *
 * @author YBolshakova
 */
public class Blackboard {

    private Shape[] blackboard = new Shape[4];

    public Blackboard() {

    }

    public Shape[] getBlackboard() {
        return blackboard;
    }    

    public void setBlackboard(Shape[] blackboard) {
        this.blackboard = blackboard;
    }

    public void addShape(Shape shape) {
        for (int i = 0; i < blackboard.length; i++) {
            if (blackboard[i] == null) {
                blackboard[i] = shape;
                break;
            }
        }
    }

    public void removeShape(Shape shape) {
        for (int i = 0; i < blackboard.length; i++) {
            if (null!= blackboard[i]&&blackboard[i].equals(shape)) {
                blackboard[i] = null;
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        double sumArea = 0;
        for (int i = 0; i < blackboard.length; i++) {
            if (blackboard[i] != null) {
                sumArea += blackboard[i].getArea();
                result.append("\n This shape is " + blackboard[i].getClass().getName() + ","
                        + "Perimeter =" + blackboard[i].getPerimeter() + ","
                        + "Area = " + blackboard[i].getArea());
            }
        }
        return result + "\n Area sum = "  + sumArea;
    }

}
