package javaOOP.homework_2;



/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        Point pointA = new Point(1, 1);
        Point pointB = new Point(1, 3);
        Point pointC = new Point(3, 3);
        Point pointD = new Point(3, 1);
        Point pointE = new Point(4, 1);
        Point pointF = new Point(4, 3);
        
        Shape firstShape = new Square(pointA,pointB,pointC,pointD);        
        Shape secondShape = new Circle(pointC, pointF);
        Shape thirdShape = new Rectangle(pointA, pointB, pointF, pointE);
        
        Blackboard blackboard = new Blackboard();
        blackboard.addShape(firstShape);
        blackboard.addShape(secondShape);
        blackboard.addShape(thirdShape);
        System.out.println(blackboard.toString());      
        
        System.out.println("\n***After remote***");
        blackboard.removeShape(secondShape);
        System.out.println(blackboard.toString());
        
        System.out.println("\n***After remote***");        
        blackboard.removeShape(thirdShape);
        System.out.println(blackboard.toString());
           
        
    }

}
