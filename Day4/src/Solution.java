import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {

        try {

            String pathString = "Day4\\src\\Resources\\";
            // String fileName = "example.txt";
            String fileName = "assigned_sections.txt";
            BufferedReader br = new BufferedReader(new FileReader(pathString + fileName));
            ArrayList<Elf> elfs = new ArrayList<>();
            String line;
            int coverOccurences = 0;

            while ((line = br.readLine()) != null) {// read in lines of file (2 elves per line)
                String[] strPair = line.split(",");
                Elf elf1 = new Elf(strPair[0]);
                Elf elf2 = new Elf(strPair[1]);

                elfs.add(elf1);
                elfs.add(elf2);

                if (elf1.isCoveredSection(elf2) || elf2.isCoveredSection(elf1))
                    coverOccurences++;
            }

            System.out.println("=========== Day 4 ===========");
            System.out.println("Part 1 solution: " + coverOccurences);

            br.close();

            // part 2
            int overlapOccurences = 0;
            for (int i = 1; i < elfs.size(); i += 2) { // create pairs
                Elf elf1 = elfs.get(i - 1);
                Elf elf2 = elfs.get(i);

                if (elf1.isOverlapped(elf2) || elf2.isOverlapped(elf1))// check them against each other
                    overlapOccurences++;
            }
            System.out.println("Part 2 solution: " + overlapOccurences);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
