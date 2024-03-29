package javaOOP.homework_2;

import java.util.Objects;

/**
 *
 * @author YBolshakova
 */
public class Circle extends Shape {

    private Point a; 
    private Point b;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.a);
        hash = 47 * hash + Objects.hashCode(this.b);
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
        final Circle other = (Circle) obj;
        if (!Objects.equals(this.a, other.a)) {
            return false;
        }
        if (!Objects.equals(this.b, other.b)) {
            return false;
        }
        return true;
    }
    
    

}
