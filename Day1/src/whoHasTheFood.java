import java.io.File;

import Elf.*;

public class whoHasTheFood {

    
    public static void main(String[] args) throws Exception {
        
        String fileName = "elf_food.txt";
        File file = new File(fileName);
        ElfTeam team = new ElfTeam();
        boolean built =team.buildTeam(file);
        if (built){
                int singleLargestPack = team.getIndex(team.size()-1).getTotalCalories();
                int top3 = 0;
                for (int i = team.size() - 1; i > team.size()-4; i--) {
                top3 += team.getIndex(i).getTotalCalories();

            }
            System.out.println("--------------- Results ---------------");
            System.out.printf("\nThe largest pack is: %d\nThe top 3 combined is: %d\n\n", singleLargestPack, top3);
            System.out.println("++++++ Heaviest Pack Weight ++++++");
            team.getIndex(team.size() - 1).printElf();
            System.out.println();
            System.out.println("++++++ Lightest Pack Weight ++++++");
            team.getIndex(0).printElf();
            System.out.println();

        }else{
            System.out.println("File did not load");
        }

        
    }  
    
}
