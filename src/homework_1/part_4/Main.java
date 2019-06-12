package homework_1.part_4;

/**
 *
 * @author YBolshakova
 */
public class Main {
    public static void main(String[] args) {
        Network network = new Network();
        Phone phone1 = new Phone("+380985589612", network);
        Phone phone2 = new Phone("+380985589613", network);
        Phone phone3 = new Phone("+380985589617", network);
        Phone phone4 = new Phone("+380985589615", network);
        Phone phone5 = new Phone("+380985589616", network);
        
        phone1.registerAtNetwork();
        phone2.registerAtNetwork();
        phone3.registerAtNetwork();
        phone4.registerAtNetwork();
        
        phone1.call(phone2.getPhoneNumber());
        phone2.call(phone3.getPhoneNumber());
        phone3.call(phone4.getPhoneNumber());
        phone4.call(phone5.getPhoneNumber());
        phone3.call(phone1.getPhoneNumber());
        
        
    }

}
