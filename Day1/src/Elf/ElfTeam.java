package Elf;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ElfTeam {//

    private ArrayList<Elf> team = new ArrayList<Elf>();
    private long totalFoodCalories;

    public ElfTeam() {
        this.totalFoodCalories = 0;

    }

    public void add(Elf elf) {
        this.team.add(elf);
        this.totalFoodCalories += elf.getTotalCalories();
        this.sort();

    }

    public boolean remove(int index) {
        try {
            this.totalFoodCalories -= team.get(index).getTotalCalories();
            this.team.remove(index);
            this.sort();
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    public int size() {
        return this.team.size();
    }

    public Elf getIndex(int index) {
        return this.team.get(index);
    }

    private void swap(int indexA, int indexB) {
        Elf temp = this.team.get(indexB);

        this.team.add(indexB, this.team.get(indexA));
        this.team.remove(indexB + 1);
        this.team.add(indexA, temp);
        this.team.remove(indexA + 1);

    }

    public void sort() {
        int start = 0;

        int end = this.team.size() - 1;
        int moverIndex = 0;
        while (start != end && end > 0) {

            while (moverIndex < end) {
                // int moverIndexVal = this.team.get(moverIndex).getTotalCalories();
                // int compareToVal = this.team.get(moverIndex + 1).getTotalCalories();
                if (this.team.get(moverIndex).getTotalCalories() > this.team.get(moverIndex + 1).getTotalCalories()) {
                    this.swap(moverIndex, moverIndex + 1);
                    moverIndex++;
                } else {
                    moverIndex++;
                }
            }
            end--;
            while (moverIndex > start) {
                // int moverIndexVal = this.team.get(moverIndex).getTotalCalories();
                // int compareToVal = this.team.get(moverIndex - 1).getTotalCalories();
                if (this.team.get(moverIndex).getTotalCalories() < this.team.get(moverIndex - 1).getTotalCalories()) {
                    this.swap(moverIndex, moverIndex - 1);
                    moverIndex--;
                } else {
                    moverIndex--;
                }
            }
            if (start == end) {
                return;
            }
            start++;
            moverIndex++;
        }
    }

    public boolean buildTeam(File file) {

        try {
            Scanner myReader = new Scanner(file);

            boolean finished = false;

            while (!finished) {
                if (myReader.hasNextLine()) {
                    String curLine = myReader.nextLine().trim();
                    if (curLine != "") {
                        Elf thisElf = new Elf();
                        this.add(thisElf);

                        do {
                            int calorieVal = Integer.parseInt(curLine);
                            thisElf.giveFood(calorieVal);
                            if (myReader.hasNextLine()) {
                                curLine = myReader.nextLine().trim();
                            } else {
                                finished = true;
                            }
                        } while ((curLine != "") && (finished == false));
                    }
                } else {

                    finished = true;

                }

            }
            myReader.close();

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        this.sort();
        return true;

    }

    public Elf getLightestElf() {
        return this.team.get(0);
    }

    public Elf getHeaviestElf() {
        return this.team.get(this.team.size() - 1);
    }

}
