import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws Exception {

        try {

            String pathString = "Day5\\src\\Resources\\";
            // String fileName = "example.txt";
            String fileName = "input.txt";
            BufferedReader br = new BufferedReader(new FileReader(pathString + fileName));
            String line;
            ArrayList<String> shipCargo = new ArrayList<>();
            ArrayList<String> commands = new ArrayList<>();
            boolean firstLine = true;

            // Read in current cargo layout and instructions in 2 different ArrayList
            // objects
            // to be passed to the Ship object later
            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    // create cargo package
                    while (line.contains("[")) {
                        shipCargo.add(line);
                        line = br.readLine();
                    }

                    System.out.println(br.readLine());
                } else {
                    commands.add(line);
                }
            }

            Ship cargoShip = new Ship(shipCargo);// Create ship and initialize it with current cargo layout
            cargoShip.arrangeCargo(commands);
            br.close();
            System.out.println("=========== Day 5 ===========");
            System.out.println("Part 1 solution: " + cargoShip.getTopCrates());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }
}
