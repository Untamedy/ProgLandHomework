package homework_1.part_2;

/**
 *
 * @author YBolshakova
 */
public class SquareCalculator {

    public static void main(String[] args) {
        Triangle firTriangle = new Triangle(4.5, 2.6, 6.5);
        Triangle secoTriangle = new Triangle(2, 2, 2);
        Triangle thirdTriangle = new Triangle(4, 5, 6);
        
        System.out.println("Triangle square with sides " + firTriangle.printSidesSizes() +  " is " + firTriangle.triangleSquare());
        System.out.println("Triangle square with sides " + secoTriangle.printSidesSizes() +  " is " + secoTriangle.triangleSquare());
        System.out.println("Triangle square with sides " + thirdTriangle.printSidesSizes() +  " is " + thirdTriangle.triangleSquare());        
    }

    
}
