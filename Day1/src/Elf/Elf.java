package Elf;


public class Elf {
    BackPack myBackPack = new BackPack();

    public Elf(){

    };

    public void giveFood(int itemCalories){
        myBackPack.addFoodItem(itemCalories);
    }

    public void takeFood(int itemCalories){
        if (!myBackPack.removeFoodItem(itemCalories)){
            System.out.println("I got no more food to give!");
        }
        myBackPack.removeFoodItem(itemCalories);
    }

    //================================ Getters ===========================
    public int getLargestFood(){
        return myBackPack.getLargestCal();
    }

    public int getSmallestFood(){
        return myBackPack.getLowestCal();
    }

    public int getFoodItemCount(){
        return myBackPack.getCount();
    }

    public int getTotalCalories(){
        return myBackPack.getTotalCalories();
    }

    //=======================================

    public void printElf(){
        System.out.println("============ Elf ============");
        System.out.println("Total Food Items: " + this.getFoodItemCount());
        System.out.println("Total Calories: " + this.getTotalCalories());
        System.out.println("Smallest Food Item: " + this.getSmallestFood());
        System.out.println("Largest Food Item: " + this.getLargestFood());

    }
}



