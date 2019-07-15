package homework_7.harbor;


/**
 *
 * @author YBolshakova
 */
public class Ship {

    private int cargos;   
    private String name;

    public Ship() {
    }

    public Ship(String name, int cargos) {
        this.name = name;
        this.cargos = cargos;
    }

    public String getName() {
        return name;
    }

    public int getCargos() {
        return cargos;
    }
    
    public void giveCargo(){
       if(cargos>0){
           cargos--;            
        }
    }
    
    public boolean isEmpty(){
      return cargos<1;        
    }

}
