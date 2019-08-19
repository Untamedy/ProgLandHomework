package javaPro.homework_2.yahooFinance;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author YBolshakova
 */
public class Main {
    
   public static  final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws MalformedURLException, JAXBException {
        String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";      

            Exchangerates exchangerates = getXml(url);
            exchangerates.getRows().forEach((Row r) -> {
                System.out.println(r.getExchangerate().toString());
            });
       

    }

    public static Exchangerates getXml(String urlPath) {
        Exchangerates exchangerates = null;       
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            JAXBContext context = JAXBContext.newInstance(Exchangerates.class, Exchangerate.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            exchangerates = (Exchangerates) unmarshaller.unmarshal(connection.getInputStream());
            connection.disconnect();

        } catch (JAXBException | IOException ex) {
           LOGGER.warning(ex.getMessage());
        }
        
        return exchangerates;
    }

}
