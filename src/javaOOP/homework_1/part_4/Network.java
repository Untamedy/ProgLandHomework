package javaOOP.homework_1.part_4;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author YBolshakova
 */
public class Network {

    private Set<String> setOfPhoneNumber = new HashSet<>();
    
    public Network(){        
    }

    public Set<String> getSetOfPhoneNumber() {
        return setOfPhoneNumber;
    }

    public void setSetOfPhoneNumber(Set<String> setOfPhoneNumber) {
        this.setOfPhoneNumber = setOfPhoneNumber;
    }
       

    public void addToNetworkSet(Phone phone) {
        String number = phone.getPhoneNumber();
        if (setOfPhoneNumber.contains(number)) {
            System.out.println("This phone " + number + " is already registered");
        } 
        setOfPhoneNumber.add(number);
        
    }
    
    
}
