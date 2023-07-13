import java.util.Random;

import Elf.Elf;
import Elf.ElfTeam;


public class test {
    
    public static void main(String[] args) {
        Random rand = new Random();
    

        ElfTeam team = new ElfTeam();

        

        for (int i = 0; i < 15; i++) {
            Elf thisElf = new Elf();
            for (int j = 0; j < 10;j++){
                int food = rand.nextInt(0,5000);
                thisElf.giveFood(food);
            }
             team.add(thisElf);
        }
        

        
        System.out.println("========== Before Sort =========");
        for (int i = 0; i < team.size();i++){
            team.getIndex(i).printElf();
        }

        team.sort();
        System.out.println("n\n\nAfter Sort\n\n");
        
        for (int i = 0; i < team.size();i++){
            team.getIndex(i).printElf();
        }


        
        
    }
}
