package javaPro.homework_2.yahooFinance;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author YBolshakova
 */
@XmlType(propOrder = {"ccy","baseCcy", "buy", "sale"})
        
class Exchangerate {

    private String ccy;
    private String baseCcy;
    private double buy;
    private double sale;

    public Exchangerate() {
    }

    public Exchangerate(String ccy, String baseCcy, double buy, double sale) {
        this.ccy = ccy;
        this.baseCcy = baseCcy;
        this.buy = buy;
        this.sale = sale;
    }

   @XmlAttribute
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @XmlAttribute(name = "base_ccy")
    public String getBaseCcy() {
        return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    @XmlAttribute
    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    @XmlAttribute
    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Exchangerate{" + "ccy=" + ccy + ", baseCcy=" + baseCcy + ", buy=" + buy + ", sale=" + sale + '}';
    }
    
    

}
