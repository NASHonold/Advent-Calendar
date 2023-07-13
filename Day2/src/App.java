import java.io.BufferedReader;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
       //Create a class that checks a line input and returns score

       try {
        String filename = "strategy_guide.txt";
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        

        
       } catch (Exception e) {
            System.out.println(e);
       }
        
    }
}

