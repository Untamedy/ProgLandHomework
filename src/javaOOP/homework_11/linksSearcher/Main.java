package javaOOP.homework_11.linksSearcher;

import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        String forTestOne = "http://chp.com.ua/spravochnik/edinyj-nalog";
        String forTestTwo = "https://www.lamoda.ua/c/4153/default-women/?is_new=1&sitelink=topmenuW&l=1";

        Searcher s = new Searcher(forTestOne);
        s.writeLiksToFile();

    }

}
