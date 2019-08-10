package javaPro.homework_2.xmlParser;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author YBolshakova
 */
@XmlType(propOrder = {"id","from","to","date"})
public class Train {

    private int id;
    private String from;
    private String to;
    private Date date;

    public Train() {
    }

    public Train(int id, String from, String to, Date date) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    @XmlElement
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {        
        return "Train{" + "id=" + id + ", from=" + from + ", to=" + to + ", date=" + date + '}';
    }

}
