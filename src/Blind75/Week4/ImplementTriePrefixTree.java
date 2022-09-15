package Blind75.Week4;

//A trie (pronounced as "try") or prefix tree is a tree data structure used to 
//efficiently store and retrieve keys in a dataset of strings. There are various 
//applications of this data structure, such as autocomplete and spellchecker. 
//
// Implement the Trie class: 
//
// 
// Trie() Initializes the trie object. 
// void insert(String word) Inserts the string word into the trie. 
// boolean search(String word) Returns true if the string word is in the trie (
//i.e., was inserted before), and false otherwise. 
// boolean startsWith(String prefix) Returns true if there is a previously 
//inserted string word that has the prefix prefix, and false otherwise. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//Output
//[null, null, true, false, true, null, true]
//
//Explanation
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // return True
//trie.search("app");     // return False
//trie.startsWith("app"); // return True
//trie.insert("app");
//trie.search("app");     // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word and prefix consist only of lowercase English letters. 
// At most 3 * 10⁴ calls in total will be made to insert, search, and 
//startsWith. 
// 
// Related Topics Hash Table String Design Trie 👍 8109 👎 101

import java.util.HashMap;

public class ImplementTriePrefixTree{
    public static void main(String[] args) {
        Trie solution = new ImplementTriePrefixTree().new Trie();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {
    class TrieNode {
        String val;
        HashMap<Character, TrieNode> children;
        boolean isEnd;

        public TrieNode(String val) {
            this.val = val;
            this.children = new HashMap<>();
        }

        public boolean addChildren(Character c, TrieNode son) {
            this.children.put(c, son);

            return true;
        }

        public boolean hasChild(Character c) {
            return this.children.containsKey(c);
        }

        public TrieNode getChild(Character c) {
            if (this.hasChild(c)) return this.children.get(c);

            return null;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode("");
    }
    
    public void insert(String word) {
        TrieNode p = root;
        char[] wordArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            sb.append(c);
            if (!p.hasChild(c)) {
                TrieNode node = new TrieNode(sb.toString());
                p.addChildren(c, node);
            }
            p = p.getChild(c);
        }

        p.isEnd = true;
    }
    
    public boolean search(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode p = root;

        for (int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];

            if (p.hasChild(c)) {
                p = p.getChild(c);
            }else {
                return false;
            }
        }

        return p.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        char[] prefixArr = prefix.toCharArray();
        TrieNode p = root;

        for (int i = 0; i < prefixArr.length; i++) {
            char c = prefixArr[i];

            if (p.hasChild(c)) p = p.getChild(c);
            else return false;

        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}