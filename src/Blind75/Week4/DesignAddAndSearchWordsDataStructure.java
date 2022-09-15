package Blind75.Week4;

////Design a data structure that supports adding new words and finding if a 
////string matches any previously added string. 
////
//// Implement the WordDictionary class: 
////
//// 
//// WordDictionary() Initializes the object. 
//// void addWord(word) Adds word to the data structure, it can be matched 
//later. 
////
//// bool search(word) Returns true if there is any string in the data 
//structure 
////that matches word or false otherwise. word may contain dots '.' where dots 
//can 
////be matched with any letter. 
//// 
////
//// 
//// Example: 
////
//// 
////Input
////["WordDictionary","addWord","addWord","addWord","search","search","search",
////"search"]
////[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
////Output
////[null,null,null,null,false,true,true,true]
////
////Explanation
////WordDictionary wordDictionary = new WordDictionary();
////wordDictionary.addWord("bad");
////wordDictionary.addWord("dad");
////wordDictionary.addWord("mad");
////wordDictionary.search("pad"); // return False
////wordDictionary.search("bad"); // return True
////wordDictionary.search(".ad"); // return True
////wordDictionary.search("b.."); // return True
//// 
////
//// 
//// Constraints: 
////
//// 
//// 1 <= word.length <= 25 
//// word in addWord consists of lowercase English letters. 
//// word in search consist of '.' or lowercase English letters. 
//// There will be at most 3 dots in word for search queries. 
//// At most 10⁴ calls will be made to addWord and search. 
//// 
//// Related Topics String Depth-First Search Design Trie 👍 5418 👎 281
//

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure{
    public static void main(String[] args) {
        WordDictionary solution = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    TrieNode root;

    public WordDictionary() {

        root = new TrieNode();
    }


    public void addWord(String word) {

        TrieNode curr = root;

        for (int i = 0; i < word.length(); ++i) {

            char c = word.charAt(i);

            if (!curr.children.containsKey(c)) {

                curr.children.put(c, new TrieNode());
            }

            curr = curr.children.get(c);
        }

        curr.endOfWord = true;
    }


    public boolean search(String word) {
        if (word.length() == 0) return false;
        TrieNode curr = root;

        boolean result = searchRecursive(curr, word, 0);

        return result;
    }


    private boolean searchRecursive(TrieNode curr, String word, int index) {

        if (index == word.length()) {

            return curr.endOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {

            boolean result;

            for (Character ch : curr.children.keySet()) {

                TrieNode node = curr.children.get(ch);

                result = searchRecursive(node, word, index+1);

                if (result)
                    return true;
            }

            return false;

        } else {

            if (curr.children.containsKey(c)) {

                return searchRecursive(curr.children.get(c), word, index+1);
            } else {

                return false;
            }
        }
    }


    private class TrieNode {

        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {

            children = new HashMap<>();
            endOfWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}