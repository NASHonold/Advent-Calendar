import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reorg {

  public static void main(String[] args) throws Exception {
    try {
      String thisPathString = "Day3\\src\\Resources\\";
      String fileName = "All_Contents.txt"; // main file, test files below can be used to see example inputs
      // String fileName = "tester.txt";
      // String fileName = "singleTest.txt";
      FileReader fr = new FileReader(thisPathString + fileName);
      BufferedReader br = new BufferedReader(fr);
      ArrayList<Rucksack> ruckList = new ArrayList<>();
      String line;
      int prSum = 0;

      while ((line = br.readLine()) != null) { // read in data
        Rucksack ruck = new Rucksack(line);
        prSum += ruck.getCommonPriority();
        ruckList.add(ruck);

      }
      br.close();
      System.out.println("========= DAY 3 =========");
      System.out.println("Part 1 Answer: " + prSum);

      // now we have groups of three and the common item between the 3 is the badge
      int teamPrSum = 0;
      for (int i = 2; i < ruckList.size(); i += 3) {
        ArrayList<Rucksack> team = new ArrayList<>();
        team.add(ruckList.get(i - 2));
        team.add(ruckList.get(i - 1));
        team.add(ruckList.get(i));

        // team.get(0).print();
        String elf1 = team.get(0).getContents();
        String elf2 = team.get(1).getContents();
        String elf3 = team.get(2).getContents();
        char teamBadge = ' ';

        for (char x : elf1.toCharArray()) {
          int elf2Idx = elf2.indexOf(x);
          int elf3Idx = elf3.indexOf(x);
          if (elf2Idx > -1 && elf3Idx > -1)
            teamBadge = x;
        }

        int teamPriority = team.get(0).getCharPriority(teamBadge);
        teamPrSum += teamPriority;
      }

      System.out.println("Part 2 Answer: " + teamPrSum);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
