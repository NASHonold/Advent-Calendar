import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reorg {
    public static void main(String[] args) throws Exception {

        
        try{
            String thisPathString = "Day3\\src\\Resources\\";
            String fileName = "All_Contents.txt";
            // String fileName = "tester.txt";
            // String fileName = "singleTest.txt";
            FileReader fr = new FileReader(thisPathString + fileName);
            BufferedReader br = new BufferedReader(fr);
            ArrayList<Rucksack> ruckList = new ArrayList<>();
            String line;
            int prSum = 0;
            int idx = 1;
            
            while((line = br.readLine()) != null){
                Rucksack ruck = new Rucksack(line);
                prSum += ruck.getCommonPriority();
                ruckList.add(ruck);
                // System.out.println("****** Line: " + idx + " ******");
                //ruck.print();
                idx++;

            }

            System.out.println("Part 1 Answer: " + prSum);

            //now we have groups of three and the common item between the 3 is the badge
            int teamPrSum = 0;
            for(int i = 0; i < ruckList.size(); i++){
                ArrayList<Rucksack> team = new ArrayList<>();
                for(int j = 0; j < 3;j++){
                    team.add(ruckList.get(i));
                    i++;
                }
                team.get(0).print();
                String elf1 = team.get(0).getContents();
                String elf2 = team.get(1).getContents();
                String elf3 = team.get(2).getContents();
                char teamBadge =  ' ';

                for (char x : elf1.toCharArray()) {
                    int elf2Idx = elf2.indexOf(x);
                    int elf3Idx = elf3.indexOf(x);
                    if(elf2Idx > -1 && elf3Idx > -1)
                        teamBadge = x;
                }
                int teamPriority = team.get(0).getCharPriority(teamBadge);
                teamPrSum += teamPriority;


            }

            System.out.println("Part 2 Answer: " + teamPrSum);



        }catch(Exception e){
            e.printStackTrace();
        }



    }

    
}
