package Apple;

import java.util.Arrays;
import java.util.List;

public class VOPractise {

    public void transformStartToEnd(List<Character> start,List<Character> end) {
        for (int i = 0; i < start.size(); i++) {
            char startAtI = start.get(i);
            char endAtI = end.get(i);
            if (startAtI == endAtI) {
                this.printUnchanged(startAtI);
            } else {
                this.printChanged(startAtI, endAtI);
            }
        }
    }

    public void transformStartToEndDB(List<Character> start, List<Character> end) {
        int startPointer = 0;
        int endPointer = 0;

        for (; startPointer < start.size(); startPointer++) {
            char charAtStart = start.get(startPointer);
            if (endPointer >= end.size()) {
                this.printMinus(charAtStart);
                continue;
            }
            char charAtEnd = end.get(endPointer);

            if (charAtStart == charAtEnd) {
                this.printUnchanged(charAtStart);
                endPointer++;
            } else {
                int startInEnd = this.isInEnd(end, charAtStart, endPointer + 1);
                if (startInEnd < end.size()) {
                    for (; endPointer < startInEnd; endPointer++) {
                        this.printAdd(end.get(endPointer++));
                    }
                    this.printUnchanged(charAtStart);
                } else {
                    this.printMinus(charAtStart);
                }
            }
        }

        while (endPointer < end.size()) {
            char charAtEnd = end.get(endPointer);
            this.printAdd(charAtEnd);
            endPointer++;
        }
    }

    private int isInEnd(List<Character> end, char charAtStart, int startIndex) {
        while (startIndex < end.size()) {
            if (charAtStart == end.get(startIndex)) {
                return startIndex;
            }

            startIndex++;
        }

        return startIndex;
    }

    private void printUnchanged(Character c) {
        System.out.print("      (" + c + " ," + " ." + ")");
    }

    private void printAdd(Character c) {
        System.out.print("      (" + c + " ," + " +" + ")");
    }

    private void printMinus(Character c) {
        System.out.print("      (" + c + " ," + " -" + ")");
    }

    private void printChanged(Character c1, Character c2) {
        System.out.print("    (" + c1 + " ," + " -" + ")");
        System.out.print("    (" + c2 + " ," + " +" + ")");
    }



    public static void main(String[] args) {
        VOPractise solution = new VOPractise();
        Character[] start = {'B', 'C', 'D'};
        Character[] end = {'B', 'E', 'F', 'C', 'H', '1'};
        List<Character> l1 = Arrays.asList(start);
        List<Character> l2 = Arrays.asList(end);

        solution.transformStartToEndDB(l1, l2);
    }
}
