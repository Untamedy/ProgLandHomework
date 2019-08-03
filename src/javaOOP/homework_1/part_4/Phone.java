package javaOOP.homework_1.part_4;

/**
 *
 * @author YBolshakova
 */
public class Phone {
    
    private String phoneNumber;
    private Network network;
    
  public Phone(){
      
  }
  public Phone(String phoneNumber, Network network){
      this.network = network;
      this.phoneNumber = phoneNumber;      
  }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }
  
  public void call(String number){
      if(!network.getSetOfPhoneNumber().contains(number)){
          System.out.println("The subscriber with number " + number + " is not registered");
      }else{
      System.out.println("The subscriber with number " + number + " is called");
      }      
  }
  
  public void registerAtNetwork(){
      network.addToNetworkSet(this);      
  }

}
