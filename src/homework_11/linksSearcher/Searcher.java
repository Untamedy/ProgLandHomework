package homework_11.linksSearcher;

import com.sun.corba.se.impl.util.Version;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author YBolshakova
 */
public class Searcher {

    public static final Logger LOGGER = Logger.getLogger(Searcher.class.getName());

    private String urlAdress;

    public Searcher() {

    }

    public Searcher(String urlAdress) {
        this.urlAdress = urlAdress;
    }

    public void writeLiksToFile() {
        List<String> links = parsPage();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("folderOne\\Links.txt")))) {
            if (!links.isEmpty()) {
                links.forEach((s) -> {
                    try {
                        writer.write(s + "\n");
                    } catch (IOException ex) {
                        LOGGER.warning(ex.getMessage());
                    }
                });
            }
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }
    }

    public HttpURLConnection connect() {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlAdress);
            connection = (HttpURLConnection) url.openConnection();
            return connection;
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }
        return connection;
    }

    public List<String> parsPage() {
        HttpURLConnection connection = connect();
        String httpcontent = getContent(connection);
        String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        Pattern linkPattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher pageMatcher = linkPattern.matcher(httpcontent);
        ArrayList<String> links = new ArrayList<String>();
        while (pageMatcher.find()) {
            links.add(pageMatcher.group());
        }
        return links;
    }

    public String getContent(HttpURLConnection connection) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException ex) {
            LOGGER.warning(ex.getMessage());
        }
        return builder.toString();
    }

}
