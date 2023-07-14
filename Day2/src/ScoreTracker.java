public class ScoreTracker {
    
    private Integer projectedTotal;
    private Integer actualScore;
    /*
     * A = Rock
     * B = Paper
     * C = Scissors
     * X = Rock
     * Y = Paper
     * Z = Scissors
     */
    public ScoreTracker(){
        this.projectedTotal = 0;
        this.actualScore = 0;
    }

    private char[] lineParser(String line){


        line = line.trim();
        line = line.toUpperCase();
        line = line.replace(" ", "");
        char[] symbols = line.toCharArray();
        return symbols;

    }

    private int[] getScore(char[] symbols){
        int[] scores = new int[2];
        scores[0] = 0;
        char op = symbols[0];
        char mine = symbols[1];

        switch (mine) {
            case 'X':// You play Rock or you should lose
                scores[0] += 1; //for playing rock
                scores[1] += 0; //for loss
                //System.out.print("You have played Rock against ");
                if (op == 'A'){//Rock v Rock
                    scores[0] += 3;
                    scores[1] += 3;//
                    //System.out.println("Rock. This is a draw.");
                }
                else if (op == 'C' ){//Rock v Scissors
                    scores[0] += 6;
                    scores[1] += 2;
                    //System.out.println("Scissors. This is a win!");
                }
                else{
                    //System.out.println("Paper. This is a loss.");
                    scores[1] += 1;
                }
                break;

            case 'Y':// You play Paper or you should draw
                scores[0] += 2;//for playing paper
                scores[1] += 3;//for draw
                //System.out.print("You have played Paper against ");
                if (op == 'B'){//Paper v Paper
                    scores[0] += 3;
                    scores[1] += 2;
                    //System.out.println("Paper. This is a draw.");
                }
                else if (op == 'A' ){//Paper V Rock
                    scores[0] += 6;
                    scores[1] += 1;
                    //System.out.println("Rock. This is a win!");
                }
                else{
                    scores[1] += 3;
                    //System.out.println("Scissors. This is a loss.");
                }
                break;

            case 'Z':// You play Scissors or you should win
                scores[0]+= 3;
                scores[1]+= 6;
                //System.out.print("You have played Scissors against ");
                if (op == 'C'){//Scissors v Scissors
                    scores[0] += 3;
                    scores[1] += 1;
                    //System.out.println("Scissors. This is a draw.");
                }
                else if (op == 'B' ){//Scissors v Paper
                    scores[0] += 6;
                    scores[1] += 3;
                    //System.out.println("Paper. This is a win!");
                }
                else{
                    scores[1] += 2;
                    //System.out.println("Rock. This is a loss.");
                }
                break;

            default:
                break;
        }
        return scores;
    }

    public void recordScore(String line){
        int[] scores = getScore(lineParser(line));
        this.projectedTotal += scores[0];
        this.actualScore += scores[1];
    }

    public int getProjectedTotalScore(){
        return this.projectedTotal;
    }

    public int getActualScore(){
        return this.actualScore;
    }



}
