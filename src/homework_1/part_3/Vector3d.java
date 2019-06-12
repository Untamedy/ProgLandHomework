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

    public String vectorCoordinatesToString() {
        String coordinates = "(" + this.x + "," + this.y + "," + this.z + ")";
        return coordinates;

    }

}
