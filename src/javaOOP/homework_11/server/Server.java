package javaOOP.homework_11.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Server {
    private int index =1;
    
    public Server(){
        
    }
    
    public void showParameters(){
        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                Socket clSocket = socket.accept();                
                Client client = new Client(clSocket, getAnswer(index));
                index++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        } 
    }
    
    
    
    public List<String> getParameters(){
        Runtime runtime = Runtime.getRuntime();        
        List<String> parameters = new ArrayList<>();
        parameters.add("Processors: " + runtime.availableProcessors());
        parameters.add("Free memory: " + runtime.freeMemory());
        parameters.add("Total memory: " + runtime.totalMemory());
        return parameters;
        
    }
    
    public String getAnswer(int index) {
        String answer = "";
        List<String> parameters = getParameters();
        answer += "<html><head><title>My computer</title><meta charset='utf-8'></head><body><p>My computer parameters for connection №" + index;
        answer += "<table border='2' cellpadding='5'><tr><th>Parameters</th></tr>";
        for (String parameter : parameters) {
            answer += "<tr><td>" + parameter + "</td></tr>";
        }
        answer += "</table></body></html>";
        index++;

        return answer;

    }
    
   

}
