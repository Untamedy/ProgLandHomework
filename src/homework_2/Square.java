package homework_2;

import java.util.Objects;

/**
 *
 * @author YBolshakova
 */
public class Square extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;

    private double sideA;
    private double sideB;
    private double sideC;
    private double sideD;

    private Square() {

    }

    public Square(Point a, Point b, Point c, Point d) {
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
        Square s = createSquare();
        if (isSquare(s)) {
            double perimeter = s.sideA * 4;
            return perimeter;
        }
        throw new RuntimeException("This shape is not a square");
    }

    @Override
    public double getArea() {
        Square s = createSquare();
        if (isSquare(s)) {
            return Math.pow(s.sideA, 2);
        }

        throw new RuntimeException("This shape is not a square");

    }

    public Square createSquare() {
        Square square = new Square();
        square.setSideA(getSideSize(this.a, this.b));
        square.setSideB(getSideSize(this.b, this.c));
        square.setSideC(getSideSize(this.c, this.d));
        square.setSideD(getSideSize(this.d, this.a));
        return square;

    }

    public boolean isSquare(Square squere) {
        if ((squere.sideC == squere.sideD) && (squere.sideA == squere.sideB) && (squere.sideB == squere.sideC)) {
            return true;
        }
        return false;
    }

    public double getSideSize(Point a, Point b) {
        double sideSide = Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
        return sideSide;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.a);
        hash = 41 * hash + Objects.hashCode(this.b);
        hash = 41 * hash + Objects.hashCode(this.d);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Square other = (Square) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        if (!Objects.equals(this.c, other.c)) {
            return false;
        }
        if (!Objects.equals(this.d, other.d)) {
            return false;
        }
        return true;
    }
    
    

}
