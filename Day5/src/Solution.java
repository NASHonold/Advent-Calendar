import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
            // objects to be passed to the Ship object later
            while ((line = br.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    // create cargo package
                    while (line.contains("[")) {// all cargo strings have brackets present
                        shipCargo.add(line);
                        line = br.readLine();
                    }
                    br.readLine();// advance past the string of whitespace
                } else {// add strings used for commands/instructions to commands package
                    commands.add(line);
                }
            }

            br.close();
            Ship cargoShip = new Ship(shipCargo);// Create ship and initialize it with current cargo layout
            cargoShip.crateMover(9000, commands);// use CrateMover 9000 to organize cargo
            System.out.println("=========== Day 5 ===========");
            System.out.println("Part 1 solution: " + cargoShip.getTopCrates());

            cargoShip.resetShipCargo();
            cargoShip.crateMover(9001, commands); // use CrateMover 9001 to organize cargo
            System.err.println("Part 2 Solution: " + cargoShip.getTopCrates());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
