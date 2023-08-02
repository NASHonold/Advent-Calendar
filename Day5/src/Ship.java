import java.util.ArrayList;
import java.util.Stack;

public class Ship {
    private ArrayList<String> cargoInput;
    private ArrayList<Stack<Character>> stacks;
    private int numberOfStacks;

    public Ship(ArrayList<String> cargo) {
        this.cargoInput = cargo;
        setNumberOfStacks();
        makeStacks();
        setupStacks();
    }

    private void setupStacks() {

        for (int i = this.cargoInput.size() - 1; i >= 0; i--) {
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

    private void makeStacks() {
        ArrayList<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < this.numberOfStacks; i++) {
            Stack<Character> eStack = new Stack<>();
            stacks.add(eStack);
        }
        this.stacks = stacks;
    }

    private void setNumberOfStacks() {
        this.numberOfStacks = this.cargoInput.get(0).length() / 4 + 1;
    }

    public String getTopCrates() {
        StringBuilder top = new StringBuilder();

        this.stacks.forEach((x) -> top.append(x.peek()));
        return top.toString();
    }

    public void arrangeCargo(ArrayList<String> instructions) {

        instructions.forEach((x) -> moveCrates(x));

    }

    private void moveCrates(String instructionString) {
        String[] instructionSteps = instructionString.split(" ");
        int qtyIdx = 1;
        int originIdx = 3;
        int destIdx = 5;
        int qty = Integer.parseInt(instructionSteps[qtyIdx]);
        int origin = Integer.parseInt(instructionSteps[originIdx]) - 1;
        int dest = Integer.parseInt(instructionSteps[destIdx]) - 1;

        for (int i = 0; i < qty; i++) {
            char mover = this.stacks.get(origin).pop();
            this.stacks.get(dest).add(mover);
        }

    }

}
