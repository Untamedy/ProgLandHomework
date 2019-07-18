package homework_10.art;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class Main {

    public static void main(String[] args) {
        
        String alphabet = "А,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String path = "C:\\Users\\YBolshakova\\Documents\\gs-maven\\Homework\\folderOne\\alphabet.txt";
        AlphabetReader reader = new AlphabetReader(path,alphabet);
        HashMap<String,String> hash = reader.mapOfLetters(reader.readArtAlphabet(),reader.letters(alphabet));
       /* String [] letters = reader.readArtAlphabet();
        for (String s : letters) {
            String[] str = s.split("!");
            for (String string : str) {
                System.out.println(string);
            }

        }*/
        System.out.println(hash);
       
    }

}
