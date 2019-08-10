package javaPro.homework_2.xmlParser;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author YBolshakova
 */
@XmlRootElement(name = "timetable")
public class TimeTable {
    
    private List<Train> trains;
    private Parser parser;
    
    public TimeTable(){
        
    }

    public TimeTable(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> getTrains() {
        return trains;
    }

    @XmlElement
    @XmlElementWrapper
    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }
    
    
    public void addNewTrain(Train train){
        trains.add(train); 
    }
    
    

}
