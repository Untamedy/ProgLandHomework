package homework_2;

/**
 *
 * @author YBolshakova
 */
public class Rectangle extends Shape{
    
     private Point a,b,c,d;   
    
    private Rectangle(){        
    }
    
    private Rectangle(Point a, Point b, Point c, Point d){
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
        
        if(isRectangle(sideA, sideB, sideC, sideD)){            
                return (sideA*2)+(sideB*2);
            }        
        throw new RuntimeException("This shape is not a rectangle");
    }

    @Override
    public double getArea() {
        double sideA = getSideSize(this.a,this.b);
        double sideB = getSideSize(this.b, this.c);
        double sideC = getSideSize(this.c, this.d);
        double sideD = getSideSize(this.d, this.a);
        if(isRectangle(sideA, sideB, sideC, sideD)){
           return sideA*sideB; 
        }
        
        throw new RuntimeException("This shape is not a rectangle");
       
    }
    
    public boolean isRectangle(double sideA, double sideB, double sideC, double sideD){
        if((sideC==sideA)&&(sideD==sideB)&&(sideB!=sideC)){
            return true;
        }
        return false;
    }
    
    public double getSideSize(Point a, Point b){        
        double sideSide = Math.sqrt(Math.pow((b.getX()-a.getX()),2)+ Math.pow((b.getY()-a.getY()),2));
        return sideSide;
    }
  

}
