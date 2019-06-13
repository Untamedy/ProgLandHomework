package homework_2;

/**
 *
 * @author YBolshakova
 */
public class Rectangle extends Shape {

    private Point a, b, c, d;

    double sideA;
    double sideB;
    double sideC;
    double sideD;

    private Rectangle() {
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public double getSideD() {
        return sideD;
    }

    public void setSideD(double sideD) {
        this.sideD = sideD;
    }

    @Override
    public double getPerimeter() {
        Rectangle r = createRectangle();
        if (isRectangle(r)) {
            return (r.sideA * 2) + (r.sideB * 2);
        }
        throw new RuntimeException("This shape is not a rectangle");
    }

    @Override
    public double getArea() {
        Rectangle r = createRectangle();
        if (isRectangle(r)) {
            return r.sideA * r.sideB;
        }
        throw new RuntimeException("This shape is not a rectangle");
    }

    public Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setSideA(getSideSize(this.a, this.b));
        rectangle.setSideB(getSideSize(this.b, this.c));
        rectangle.setSideC(getSideSize(this.c, this.d));
        rectangle.setSideD(getSideSize(this.d, this.a));
        return rectangle;

    }

    public boolean isRectangle(Rectangle rectangle) {
        if ((rectangle.sideC == rectangle.sideA) && (rectangle.sideD == rectangle.sideB) && (rectangle.sideB != rectangle.sideC)) {
            return true;
        }
        return false;
    }

    public double getSideSize(Point a, Point b) {
        double sideSide = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
        return sideSide;
    }

}
