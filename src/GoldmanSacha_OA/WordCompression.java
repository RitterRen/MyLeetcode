package GoldmanSacha_OA;

import java.util.HashMap;
import java.util.LinkedList;

public class WordCompression {

    public static void main(String[] args) {
        String test1 = "abbbcccb";
        int k1 = 3;
        System.out.println(wordCompression(test1, 3));
    }

    public static String wordCompression(String word, int k) {
        LinkedList<WordAndNums> wordStack = new LinkedList<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (wordStack.isEmpty() || wordStack.peek().ch != ch) {
                wordStack.push(new WordAndNums(ch, 1));
            } else {
                WordAndNums wan = new WordAndNums(ch, wordStack.peek().times + 1);
                wordStack.push(wan);
                if (wan.times == k) {
                    int temp = k;
                    while (!wordStack.isEmpty() && temp > 0) {
                        wordStack.pop();
                        temp--;
                    }
                }
            }
        }

        return getStrFromStack(wordStack);
    }

    private static String getStrFromStack(LinkedList<WordAndNums> stack) {
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop().ch);
        }

        return sb.reverse().toString();
    }

    static class WordAndNums {
        int times = 0;
        char ch;

        public WordAndNums(char ch, int times) {
            this.ch = ch;
            this.times = times;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof WordAndNums) ) return false;

            WordAndNums wan = (WordAndNums)obj;
            return this.ch == wan.ch;
        }

        @Override
        public String toString() {
            return "("
                    + "char = " + ch
                    + " times = " + times
                    + ")";
        }
    }
}
