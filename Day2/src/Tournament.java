import java.io.BufferedReader;
import java.io.FileReader;

public class Tournament {
    public static void main(String[] args) throws Exception {
       //Create a class that checks a line input and returns score

       try {

        String filename = "Day2\\src\\Resources\\strategy_guide.txt";
        //String filename = "Day2\\src\\Resources\\test.txt";
        String line;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        ScoreTracker trac = new ScoreTracker();
        //int idx = 1;

        while ((line = br.readLine()) != null){

            trac.recordScore(line);
            //System.out.printf("You have %d points on iteration %d\n", trac.getTotalScore(), idx);
            //idx++;
        }

        System.out.printf("Your guess score a total of %d points", trac.getProjectedTotalScore());
        System.out.printf("\nYour actual score a total of %d points", trac.getActualScore());

        br.close();
        
       } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
       }
        
    }
}

