import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Ship {
    private ArrayList<String> cargoInput;
    private ArrayList<Stack<Character>> stacks;
    private int numberOfStacks;

    // ================== Constructor ==================
    public Ship(ArrayList<String> cargo) {
        this.cargoInput = cargo;
        setNumberOfStacks();
        makeStacks();
        setupStacks(true);
    }

    // ================== Public Methods ==================
    /**
     * Resets cargo stacks to original positions
     */
    public void resetShipCargo() {
        makeStacks();
        setupStacks(false);
    }

    /**
     * 
     * @return String of chars that are all top crate chars from l to r
     */
    public String getTopCrates() {
        StringBuilder top = new StringBuilder();
        this.stacks.forEach((x) -> top.append(x.peek()));
        return top.toString();
    }

    /**
     * Arranges cargo with crane model designation &
     * set of instructions
     * 
     * @param model        - Integer Crane Model - 9000 or 9001
     * @param instructions - ArrayList of move instructions
     */
    public void crateMover(int model, ArrayList<String> instructions) {
        if (model == 9000 || model == 9001) {
            instructions.forEach((x) -> moveCrates(model, x));
        } else
            System.out.println("You did not select an available Crate Mover!");

    }

    // ================== Private Methods ==================

    /**
     * Sets up layout of cargo stacks based on
     * cargo input string list.
     * 
     * @param first Boolean that triggers reversal of cargo input string list. This
     *              is needed as the cargoList object is reversed on first pass but
     *              during reset, reversal is not needed.
     * 
     */
    private void setupStacks(boolean first) {
        if (first) {
            Collections.reverse(cargoInput);
        }

        for (int i = 0; i < cargoInput.size(); i++) {
            int charIdx = 1;
            String cargoLine = this.cargoInput.get(i);
            for (int j = 0; j < this.numberOfStacks; j++) {
                char crate = cargoLine.charAt(charIdx);
                if (crate != ' ') {
                    this.stacks.get(j).add(crate);
                }
                charIdx += 4;
            }
        }

    }

    /**
     * Sets up empty stack objs to receive initial char cargo
     */
    private void makeStacks() {
        ArrayList<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < this.numberOfStacks; i++) {
            Stack<Character> eStack = new Stack<>();
            stacks.add(eStack);
        }
        this.stacks = stacks;
    }

    /**
     * Derives the number of stacks from the length of the first string in
     * cargoStacks and sets this.numberOfStacks
     */
    private void setNumberOfStacks() {
        this.numberOfStacks = this.cargoInput.get(0).length() / 4 + 1;
    }

    /**
     * Helper function responsible for sorting/arranging cargo using a set of
     * instruction in the form of ArrayList<String> obj. Uses model number to
     * determine appropriate sorting algorithm
     * 
     * @param model
     * @param instructionString
     */
    private void moveCrates(int model, String instructionString) {
        String[] instructionSteps = instructionString.split(" ");
        int qtyIdx = 1;
        int originIdx = 3;
        int destIdx = 5;
        int qty = Integer.parseInt(instructionSteps[qtyIdx]);
        int origin = Integer.parseInt(instructionSteps[originIdx]) - 1;
        int dest = Integer.parseInt(instructionSteps[destIdx]) - 1;

        switch (model) {
            case 9000:
                for (int i = 0; i < qty; i++) {
                    char mover = this.stacks.get(origin).pop();
                    this.stacks.get(dest).add(mover);
                }
                break;

            case 9001:
                Character[] crates = new Character[qty];
                for (int i = 0; i < qty; i++) {
                    Character x = this.stacks.get(origin).pop();
                    crates[i] = x;

                }
                Collections.reverse(Arrays.asList(crates));
                for (int i = 0; i < qty; i++) {
                    Character x = crates[i];
                    this.stacks.get(dest).add(x);
                }
                break;
        }
    }

}
