package AmazonOA;

import java.util.HashSet;

public class KindleDirectPublish {
    public static void main(String[] args) {
        String str1 = "abcabcd";
        System.out.println(solution(str1));
    }

    public static int solution(String inputs) {
        if (inputs.length() == 0) return 0;

        int result = 0;
        HashSet<String> dict = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < inputs.length(); i++) {
            int j = i;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(inputs.charAt(j));
            while (dict.contains(sb2.toString()) && j < inputs.length()) {
                j++;
                sb2.append(inputs.charAt(j));
                System.out.println("sb2 = " + sb2.toString());
            }
            if (j > i) result += j - i;
            sb.append(inputs.charAt(i));
            dict.add(sb.toString());
            //System.out.println(dict.toString());
            //System.out.println("result = " + result);
        }
        return result + inputs.length();
    }


}
