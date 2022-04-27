package AmazonOA;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AmazonFall {
    public static void main(String[] args) {
        String s = "mononom";
        String t = "mon";
        System.out.println(question2(s, t));
    }

    public static int question2(String s, String t) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!dict.containsKey(c)) {
                dict.put(c, 1);
            }else {
                dict.put(c, dict.get(c) + 1);
            }
        }

        int result = s.length();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            result = Math.min(dict.get(c), result);
        }

        return result;
    }

    public static List<Integer> findDataLocations(List<Integer> locations, List<Integer> movedFrom, List<Integer> movedTo) {
        HashSet<Integer> visit = new HashSet<>();
        for (int i = 0; i < locations.size(); i++) {
            visit.add(locations.get(i));
        }

        for (int i = 0; i < movedFrom.size(); i++) {
            visit.remove(movedFrom.get(i));
            visit.add(movedTo.get(i));
        }


    }
}
