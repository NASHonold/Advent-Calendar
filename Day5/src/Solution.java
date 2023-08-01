import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws Exception {
        try {

            String pathString = "Day5\\src\\Resources\\";
            String fileName = "example.txt";
            // String fileName = "input.txt";
            BufferedReader br = new BufferedReader(new FileReader(pathString + fileName));
            String line;
            ArrayList<String> inputLines = new ArrayList<>();
            ArrayList<Stack<Character>> stacks = new ArrayList<>();
            boolean firstLine = true;

            /*
             * Problem is how the set up of crates is represented.
             * On the first line the only thing that indicates the number of stacks
             * is the string length. You cannot split
             */
            while ((line = br.readLine()) != null) {
                inputLines.add(line);
                if (firstLine) {
                    // Doing set up from string length
                    firstLine = false;
                    int stackNumber = (line.length() / 4) + 1;

                    for (int i = 0; i < stackNumber; i++) {
                        Stack<Character> shipStack = new Stack<>();
                        stacks.add(shipStack);
                    }
                    while (line.contains("[")) {
                        int charIdx = 1;
                        for (int i = 0; i < stackNumber; i++) {
                            char stackChar;
                            stackChar = line.charAt((charIdx));
                            if (stackChar != ' ') {
                                stacks.get(i).add(stackChar);
                            }
                            charIdx += 4;
                        }
                        line = br.readLine();
                    }
                    System.out.println(br.readLine());
                } else {
                    String[] command = new String[6];
                    command = line.split(" ");
                    // create an abstract class that does work given the arraylist of stacks
                    // and each instruction
                    System.out.println(Arrays.toString(command));

                }

            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }
}
