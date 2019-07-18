package homework_10.art;



/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {

        String alphabet = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String path = "folderOne\\alphabet.txt";
        AlphabetReader reader = new AlphabetReader(path, alphabet);       
        WordDrawing art = new WordDrawing(reader);
        art.draw("done");  
        
    }
}
