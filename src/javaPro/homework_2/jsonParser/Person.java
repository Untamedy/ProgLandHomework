package javaPro.homework_2.jsonParser;

import java.util.Arrays;

/**
 *
 * @author YBolshakova
 */
public class Person {
    
    private String name;
    private String surname;
    private String [] phones;
    private String [] sites;
    private Address address;
    
    public Person(){
        
    }
    
    public Person(String name, String surname, String [] phones, String [] sites, Address address){
        this.name = name;
        this.surname = surname;
        this.phones = phones;
        this.sites = sites;
        this.address = address;  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public String[] getSites() {
        return sites;
    }

    public void setSites(String[] sites) {
        this.sites = sites;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", phones=" + Arrays.toString(phones) + "sites=" + Arrays.toString(sites) +                
                "," +address.toString() + '}';
    }
    
   
    

}
