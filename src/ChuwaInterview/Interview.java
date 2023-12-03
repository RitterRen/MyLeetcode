package ChuwaInterview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Interview {
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * Input: strs = ["eat","tea","tan","ate","nat","bat"] "aet"
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    /**
     * Time Complexity: N * nlogn
     * Space Complexity: O(N)
     * @param strs
     * @return
     */
    public List<List<String>> groupOfAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return null;

        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for (String word: strs) {
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String key = new String(wordArr);

            if (!anagramMap.containsKey(key)) {
                anagramMap.put(key, new LinkedList<String>());
            }

            anagramMap.get(key).add(word);
        }

        List<List<String>> res = new LinkedList<>();
        for (String key: anagramMap.keySet()) {
            res.add(anagramMap.get(key));
        }

        return res;
    }

    public static void main(String[] args) {
        Interview solution = new Interview();
        String[] testCase1 = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(solution.groupOfAnagrams(testCase1));
    }
}
