package homework_1.part_2;

/**
 *
 * @author YBolshakova
 */
public class Triangle {
    
    private double a;
    private double b;
    private double c;
    
    public Triangle(){        
    }
    
    public Triangle(double a, double b, double c){  
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    public String printSidesSizes(){
        String sideSizes = "(" + this.a + "," + this.b + "," + this.c + ")";
        return sideSizes;
    }
    
    public  double triangleSquare() {
        double p = (this.getA() + this.getB() + this.getC()) / 2;
        double square = Math.sqrt(p * (p - this.getA()) * (p - this.getB()) * (p - this.getC()));
        return square;

    }

}
