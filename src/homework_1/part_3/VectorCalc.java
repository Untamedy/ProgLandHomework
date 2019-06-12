package homework_1.part_3;

/**
 *
 * @author YBolshakova
 */
public class VectorCalc {

     public static void main(String[] args) {

        Vector3d firstVector = new Vector3d(3, 1, 6);
        Vector3d secoVector3d = new Vector3d(1, 1, 2);
        Vector3d n = vectorProduct(firstVector, secoVector3d);

        System.out.println("Vector product = " + n.vectorCoordinatesToString());
        System.out.println("Scalar product = " + scalarProduct(firstVector, secoVector3d));

    }

    public static Vector3d vectorProduct(Vector3d v1, Vector3d v2) {
        Vector3d vector = new Vector3d();
        vector.setX((v1.getY() * v2.getZ()) - (v1.getZ() * v2.getY()));
        vector.setY((v1.getZ() * v2.getX()) - (v1.getX() * v2.getZ()));
        vector.setZ((v1.getX() * v2.getY()) - (v1.getY() * v2.getX()));
        return vector;
    }

    public static int scalarProduct(Vector3d v1, Vector3d v2) {
        int c = ((v1.getX() * v2.getX()) + (v1.getY() * v2.getY()) + (v1.getZ() * v2.getZ()));
        return c;
    }

}
