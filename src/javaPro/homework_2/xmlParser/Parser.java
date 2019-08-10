package javaPro.homework_2.xmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author YBolshakova
 */
public class Parser {

    private TimeTable timeTable;
    private File file;

    public Parser(File file,TimeTable timeTable) {
        this.file = file;
        this.timeTable = timeTable;
    }

    public Object getObject(Class c) {
        Object object = null;
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            object = unmarshaller.unmarshal(file);
        } catch (JAXBException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return object;
    }

    public void saveObject() {
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(timeTable.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(timeTable, file);
        } catch (JAXBException ex) {
            Logger.getLogger(Parser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Train> parsByDate(Date from, Date to) {
        List<Train> list = new ArrayList<>();
        TimeTable newTimeTable = (TimeTable) getObject(TimeTable.class);
        List<Train> timeTablelist = newTimeTable.getTrains();
        timeTablelist.stream().filter((t)->((t.getDate().compareTo(from)>=0)&&(t.getDate().compareTo(to)<=0))).forEachOrdered((t)->{
            list.add(t);
        });
        return list;
    }

    public void addNewTrain(Train train) {
        timeTable.addNewTrain(train);
        saveObject();
    }

}
