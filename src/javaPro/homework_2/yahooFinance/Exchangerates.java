package javaPro.homework_2.yahooFinance;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;




/**
 *
 * @author YBolshakova
 */

@XmlRootElement(name = "exchangerates" )
public class Exchangerates {    
  
   @XmlElement(name = "row")
    private List<Row> row;

    public Exchangerates() {
    }

    public Exchangerates(List<Row> row) {
        this.row = row;
    }

   
    public List<Row> getRows() {
        return row;
    }

    public void setRows(List<Row> row) {
        this.row = row;
    }

}
