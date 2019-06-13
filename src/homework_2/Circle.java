package homework_2;

/**
 *
 * @author YBolshakova
 */
public class Circle extends Shape {

    private Point a, b;

    public Circle() {
    }

    public Circle(Point a, Point b) {
        this.a = a;
        this.b = b;
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

    @Override
    public double getPerimeter() {
        double circumference = 3.14 * (getRadius(this.a, this.b) * 2);
        return circumference;
    }

    @Override
    public double getArea() {
        double area = 3.14 * Math.pow(getRadius(this.a, this.b), 2);
        return area;

    }

    public double getRadius(Point a, Point b) {
        double radius = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
        return radius;
    }

}
