public class ScoreTracker {
    
    Integer total;
    /*
     * A = Rock
     * B = Paper
     * C = Scissors
     * X = Rock
     * Y = Paper
     * Z = Scissors
     */
    public ScoreTracker(){
        this.total = 0;
    }

    private char[] lineParser(String line){


        line = line.trim();
        line = line.toUpperCase();
        line = line.replace(" ", "");
        char[] symbols = line.toCharArray();
        return symbols;

    }

    private int getScore(char[] symbols){
        int score = 0;
        char op = symbols[0];
        char mine = symbols[1];

        switch (mine) {
            case 'X':
                score+= 1;
                if (op == 'A'){
                    score += 3;
                }
                else if (op == 'Z' ){
                    score += 6;
                }
                break;
            case 'Y':
                score+= 2;
                if (op == 'B'){
                    score += 3;
                }
                else if (op == 'A' ){
                    score += 6;
                }
                break;
            case 'Z':
                score+= 3;
                if (op == 'C'){
                    score += 3;
                }
                else if (op == 'B' ){
                    score += 6;
                }
                break;

            default:
                break;
        }
        return score;
    }

    public void recordScore(String line){
        int score = getScore(lineParser(line));
        this.total += score;
    }



}
