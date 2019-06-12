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
        
        System.out.println("Triangle square with sides " + firTriangle.printSidesSizes() +  " is " + triangleSquare(firTriangle));
        System.out.println("Triangle square with sides " + secoTriangle.printSidesSizes() +  " is " + triangleSquare(secoTriangle));
        System.out.println("Triangle square with sides " + thirdTriangle.printSidesSizes() +  " is " + triangleSquare(thirdTriangle));
        
    }

    public static double triangleSquare(Triangle triangle) {
        double p = (triangle.getA() + triangle.getB() + triangle.getC()) / 2;
        double square = Math.sqrt(p * (p - triangle.getA()) * (p - triangle.getB()) * (p - triangle.getC()));
        return square;

    }
}
