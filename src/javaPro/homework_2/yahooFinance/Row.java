package javaPro.homework_2.yahooFinance;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author YBolshakova
 */
public class Row {

    private Exchangerate exchangerate;

    public Row() {
    }

    public Row(Exchangerate exchangerate) {
        this.exchangerate = exchangerate;
    }

    @XmlElement
    public Exchangerate getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Exchangerate exchangerate) {
        this.exchangerate = exchangerate;
    }

}
