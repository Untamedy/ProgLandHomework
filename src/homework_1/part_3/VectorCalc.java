package homework_1.part_3;

/**
 *
 * @author YBolshakova
 */
public class VectorCalc {

     public static void main(String[] args) {

        Vector3d firstVector = new Vector3d(3, 1, 6);
        Vector3d secondVector3d = new Vector3d(1, 1, 2);
        Vector3d n = Vector3d.vectorProduct(firstVector, secondVector3d);

        System.out.println("Vector product = " + n.vectorCoordinatesToString());
        System.out.println("Scalar product = " + Vector3d.scalarProduct(firstVector, secondVector3d));

    }   

}
