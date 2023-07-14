public class ScoreTracker {
    
    private Integer total;
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
            case 'X':// You play Rock
                score+= 1; 
                System.out.print("You have played Rock against ");
                if (op == 'A'){//Rock v Rock
                    score += 3;
                    System.out.println("Rock. This is a draw.");
                }
                else if (op == 'C' ){//Rock v Scissors
                    score += 6;
                    System.out.println("Scissors. This is a win!");
                }
                else{
                    System.out.println("Paper. This is a loss.");
                }
                break;
            case 'Y':// You play Paper
                score+= 2;
                System.out.print("You have played Paper against ");
                if (op == 'B'){//Paper v Paper
                    score += 3;
                    System.out.println("Paper. This is a draw.");
                }
                else if (op == 'A' ){//Paper V Rock
                    score += 6;
                    System.out.println("Rock. This is a win!");
                }
                else{
                    System.out.println("Scissors. This is a loss.");
                }
                break;
            case 'Z':// You play Scissors
                score+= 3;
                System.out.print("You have played Scissors against ");
                if (op == 'C'){//Scissors v Scissors
                    score += 3;
                    System.out.println("Scissors. This is a draw.");
                }
                else if (op == 'B' ){//Scissors v Paper
                    score += 6;
                    System.out.println("Paper. This is a win!");
                }
                else{
                    System.out.println("Rock. This is a loss.");
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

    public int getTotalScore(){
        return this.total;
    }



}
