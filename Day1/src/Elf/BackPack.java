package Elf;

import java.util.ArrayList;
import java.util.Comparator;



public class BackPack {
    private ArrayList<Integer> foodlist = new ArrayList<Integer>();
    private int totalFoodItems = 0;
    private int totalFoodCalories = 0;
    private int largestCalorieItem = 0;
    private int fewestCalorieItem = Integer.MAX_VALUE;

    public BackPack() {
        
    }

    public boolean addFoodItem(int itemCalories){
        this.totalFoodItems++;
        this.foodlist.add(itemCalories);
        this.totalFoodCalories += itemCalories;
        this.foodlist.sort(Comparator.naturalOrder());

        if (itemCalories > this.largestCalorieItem){
            this.largestCalorieItem = itemCalories;
        }else if(itemCalories < this.fewestCalorieItem){
            this.fewestCalorieItem = itemCalories;
        }


        this.largestCalorieItem = this.foodlist.get(this.foodlist.size() - 1);
        this.fewestCalorieItem = this.foodlist.get(0);

        return true;
    }

    public boolean removeFoodItem(int itemCalories){
        try {
            int index = this.foodlist.indexOf(itemCalories);
            this.totalFoodItems--;
            this.totalFoodCalories -= itemCalories;
            this.foodlist.remove(index);
            if (this.foodlist.size() > 0){
                this.foodlist.sort(Comparator.naturalOrder());
                this.largestCalorieItem = this.foodlist.get(this.foodlist.size() - 1);
                this.fewestCalorieItem = this.foodlist.get(0);   
            }
            else{
                this.largestCalorieItem = 0;
                this.fewestCalorieItem = 0;
            }
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public int getLowestCal(){
        return this.fewestCalorieItem;
    }

    public int getLargestCal(){
        return this.largestCalorieItem;
    }

    public int getCount(){
        return this.totalFoodItems;
    }

    public int getTotalCalories(){
        return this.totalFoodCalories;
    }



}


