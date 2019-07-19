package homework_11.linksSearcher;

import java.net.HttpURLConnection;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {

        Searcher s = new Searcher("https://www.lamoda.ua/c/4153/default-women/?is_new=1&sitelink=topmenuW&l=1");
        s.writeLiksToFile();

    }

}
