package Blind75.Week1;

//Given an array of strings strs, group the anagrams together. You can return 
//the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
// Related Topics Array Hash Table String Sorting 👍 10899 👎 349

import java.util.*;

public class GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new GroupAnagrams().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<BitKey, List<String>> resultMap = new HashMap<>();
        for (String str : strs) {
            BitKey bitKey = new BitKey(str);
            if (resultMap.containsKey(bitKey)) {
                List<String> temp = resultMap.get(bitKey);
                temp.add(str);
            } else {
                List<String> tempList = new LinkedList<>();
                tempList.add(str);
                resultMap.put(bitKey, tempList);
            }
        }
        return new ArrayList<>(resultMap.values());

    }

    private String sortStr(String str) {
        char[] strCharArray = str.toCharArray();
        Arrays.sort(strCharArray);

        return Arrays.toString(strCharArray);
    }

    class BitKey {
        private final int[] bits = new int[26];

        public BitKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                bits[str.charAt(i) - 'a']++;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof BitKey c)) return false;

            int[] cBits = c.getBits();

            for (int i = 0; i < bits.length; i++) {
                if (bits[i] != cBits[i]) return false;
            }

            return true ;
        }

        private Integer hash = null ;

        @Override
        public int hashCode() {
            if (hash == null) {
                hash = 1;
                for (int i = 0; i < bits.length; i++) {
                    hash += bits[i] + (29 << i) * bits[i];
                }
            }

            return hash ;
        }

        public int[] getBits() {
            return bits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}