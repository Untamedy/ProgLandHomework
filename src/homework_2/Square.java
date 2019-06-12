package homework_2;

/**
 *
 * @author YBolshakova
 */
public class Square extends Shape{
    
    private Point a,b,c,d;
   
    
    private Square(){
        
    }
    private Square(Point a, Point b, Point c, Point d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;        
    }
    

    @Override
    public double getPerimeter() {  
        double sideA = getSideSize(this.a,this.b);
        double sideB = getSideSize(this.b, this.c);
        double sideC = getSideSize(this.c, this.d);
        double sideD = getSideSize(this.d, this.a);
        
        if(isSquare(sideA, sideB, sideC, sideD)){            
                double perimeter = sideA*4;
                        return perimeter;
            }
        
        throw new RuntimeException("This shape is not a square");
    }

    @Override
    public double getArea() {
        double sideA = getSideSize(this.a,this.b);
        double sideB = getSideSize(this.b, this.c);
        double sideC = getSideSize(this.c, this.d);
        double sideD = getSideSize(this.d, this.a);
        if(isSquare(sideA, sideB, sideC, sideD)){
           return Math.pow(sideA, 2); 
        }
        
        throw new RuntimeException("This shape is not a square");
       
    }
    
    public boolean isSquare(double sideA, double sideB, double sideC, double sideD){
        if((sideC==sideD)&&(sideA==sideB)&&(sideB==sideC)){
            return true;
        }
        return false;
    }
    
    public double getSideSize(Point a, Point b){        
        double sideSide = Math.sqrt(Math.pow((b.getX()-a.getX()),2)+ Math.pow((b.getY()-a.getY()),2));
        return sideSide;
    }
    
    

}
