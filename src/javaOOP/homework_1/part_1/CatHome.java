package javaOOP.homework_1.part_1;

/**
 *
 * @author YBolshakova
 */
public class CatHome {
    public static void main (String [] args){
        Cat firstCat = new Cat("Boris", 1, "red");
        Cat secondCat = new Cat("Vasiliy", 3, "black");
        Cat thirdCat = new Cat();
        
        thirdCat.setName("Murka");
        thirdCat.setColor("white");
        
        firstCat.figthWith(secondCat);
        secondCat.changeColor("green");
        thirdCat.calculateAge();
        
        
    }
    

}
