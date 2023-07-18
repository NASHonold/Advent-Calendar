import java.util.HashMap;


public class Rucksack {
    private String contents;
    private String lPocket;
    private String rPocket;
    private HashMap<Character, Integer> priorities;
    private char commonItem;
    
    public Rucksack(String contents){
        this.contents = contents;
        this.commonItem = ' ';
        setPockets();
        setPriorities();

    }

    /*
     *This divides the content string in two equal substrings
     *and sets them to lPocket and rPocket 
     */
    private void setPockets(){
        int sLen = this.contents.length();
        this.lPocket = contents.substring(0, (sLen/2));
        this.rPocket = contents.substring(sLen/2);
    }
    /*
     * This sets the object hashmap attribute with all 
     * chars and priority values as respective key, value pair
     * Also sets the commonItem char that is present in both pockets
     */
    private void setPriorities(){
        priorities = new HashMap<>();
        for(int i = 0; i < this.lPocket.length(); i++){
            char key = this.lPocket.charAt(i);
            int val = priorityConvert(key);
            this.priorities.put(key, val);
        }
        for(int i = 0; i < this.rPocket.length(); i++){
            char key = this.rPocket.charAt(i);
            int val = priorityConvert(key);

            if((this.lPocket.indexOf(this.rPocket.charAt(i))) > -1){
                this.commonItem = key;
            }
            else
                this.priorities.put(key, val);
        }
    }

    /*
     * Converts char to appropriate priority value
     * lowercase 1-26, uppercase 27-52
     */
    private int priorityConvert(char chr){

        int rVal = (int)chr;
        if(rVal > 96)
            rVal = rVal - 96;
        else
            rVal = rVal - 38;
        return rVal;
    }

    public char getCommonItem(){
        return this.commonItem;
    }

    public int getCommonPriority(){
        if(getCommonItem() != ' ')
            return this.priorities.get(this.commonItem);
        else
            return 0;
    }
    public String getContents(){
        return this.contents;
    }
    public int getCharPriority(char x){
        return this.priorities.get(x);
    }


    public void print(){
        System.out.println("======= Rucksack =======");
        System.out.println("Contents: " + this.contents + " with length of: " + this.contents.length());
        System.out.println("Left Pocket: " + this.lPocket + " with length of: " + this.lPocket.length());
        System.out.println("Right Pocket: " + this.rPocket + " with length of: " + this.rPocket.length());
        System.out.println("Common Item: " + this.commonItem);
        System.out.println("Priority Value: " + getCommonPriority());
        System.out.println("========================\n");

    }





    


}
