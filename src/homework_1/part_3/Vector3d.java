package homework_1.part_3;

/**
 *
 * @author YBolshakova
 */
public class Vector3d {

    private int x;
    private int y;
    private int z;

    public Vector3d() {
    }

    public Vector3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public  String vectorCoordinatesToString() {
        String coordinates = "(" + this.x + "," + this.y + "," + this.z + ")";
        return coordinates;

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
