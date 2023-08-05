import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {

        String pathString = "Day6\\src\\Resources\\";
        String fileName = "input.txt";
        // String fileName = "ex1.txt";
        String line;

        try {// read in the input
            BufferedReader br = new BufferedReader(new FileReader(pathString + fileName));
            line = br.readLine();
            char[] signal = line.toCharArray();// convert to char array to work
            int starts[] = findStartPoints(signal);// method return an int array with the 2 start points needed

            System.out.println("=========== Day 6 ===========");
            System.out.println("Part 1 solution: Characters processed before start-of-packet is " + starts[0]);
            System.out.println("Part 2 solution: Characters processed before start-of-message is " + starts[1]);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * @param signal char[] of the split string to be checked
     * @return int array of size 2 with packet start at index 0, message start at
     *         index 1
     */
    static int[] findStartPoints(char[] signal) {
        int[] startPoints = new int[2];
        startPoints[0] = findPatternStart(signal, 4);
        startPoints[1] = findPatternStart(signal, 14);
        return startPoints;

    }

    /**
     * using patternLength, will find the index immediately after the
     * first occurrence of a patternLength of characters that are distinct if
     * iterating from 0 to n
     * 
     * @param signal        char[] of signal string
     * @param patternLength
     * @return int of
     */
    static int findPatternStart(char[] signal, int patternLength) {

        ArrayDeque<Character> rollingStartCode = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < patternLength; i++) {// set up first patterLength Characters in queue
            rollingStartCode.add(signal[i]);
            idx = i;
        }

        idx++;

        for (int i = idx; i < signal.length; i++) {
            char nextChar = signal[i];
            rollingStartCode.add(nextChar);
            rollingStartCode.poll();
            if (!isRepeatChar(rollingStartCode))// if the pattern is distinct
                return i + 1;
        }
        return signal.length;
    }

    /**
     * Checks if a ArrayDeque<Character> object contains any duplicates Characters
     * 
     * @param chars
     * @return true if duplicate/s found, false if not
     */
    static boolean isRepeatChar(ArrayDeque<Character> chars) {
        int expected = chars.size();
        HashSet<Character> checker = new HashSet<>(chars);
        if (checker.size() < expected)
            return true;
        else
            return false;
    }

}
