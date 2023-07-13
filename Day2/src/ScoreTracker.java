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
            case 'X':
                score+= 1;
                if (op == 'A'){//Rock v Rock
                    score += 3;
                }
                else if (op == 'Z' ){//Rock v Scissors
                    score += 6;
                }
                break;
            case 'Y':
                score+= 2;
                if (op == 'B'){//Paper v Paper
                    score += 3;
                }
                else if (op == 'A' ){//Paper V Rock
                    score += 6;
                }
                break;
            case 'Z':
                score+= 3;
                if (op == 'C'){//Scissors v Scissors
                    score += 3;
                }
                else if (op == 'B' ){//Scissors v Paper
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

    public int getTotalScore(){
        return this.total;
    }



}
