package leetcode.editor.en;

//Design a data structure that supports adding new words and finding if a 
//string matches any previously added string. 
//
// Implement the WordDictionary class: 
//
// 
// WordDictionary() Initializes the object. 
// void addWord(word) Adds word to the data structure, it can be matched later. 
//
// bool search(word) Returns true if there is any string in the data structure 
//that matches word or false otherwise. word may contain dots '.' where dots can 
//be matched with any letter. 
// 
//
// 
// Example: 
//
// 
//Input
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//Output
//[null,null,null,null,false,true,true,true]
//
//Explanation
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
// Constraints: 
//
// 
// 1 <= word.length <= 25 
// word in addWord consists of lowercase English letters. 
// word in search consist of '.' or lowercase English letters. 
// There will be at most 2 dots in word for search queries. 
// At most 10⁴ calls will be made to addWord and search. 
// 
//
// Related Topics String Depth-First Search Design Trie 👍 6789 👎 386

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DesignAddAndSearchWordsDataStructure{
    public static void main(String[] args) {
        WordDictionary solution = new DesignAddAndSearchWordsDataStructure().new WordDictionary();
        
        solution.addWord("bad");
        solution.addWord("dad");
        solution.search("b..");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.addWord(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode('*');
        }

        public void addWord(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.hasChild(c)) {
                    p = p.getChild(c);
                    continue;
                }

                TrieNode node = new TrieNode(c);
                p.addChild(node);
                p = p.getChild(c);
            }
            p.isWord = true;
        }

        public boolean search(String s) {
            return this.searchDfs(0, s, this.root);
        }

        private boolean searchDfs(int index, String s, TrieNode p) {

            for (int i = index; i < s.length(); i++) {
                char c = s.charAt(i);

                if (c == '.') {
                    for (TrieNode child: p.children.values()) {
                        if (child != null && this.searchDfs(index + 1, s, child)) return true;
                    }
                    return false;
                }

                if (!p.hasChild(c)) return false;

                p = p.getChild(c);
            }

            return p.isWord;
        }
    }

    class TrieNode {
        Character val;
        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode(char c) {
            this.val = c;
            this.children = new HashMap<>();
            this.isWord = false;
        }

        public boolean hasChild(char c) {
            return this.children.containsKey(c);
        }

        public void addChild(TrieNode node) {
            this.children.put(node.val, node);
        }

        public TrieNode getChild(char c) {
            if (!this.hasChild(c)) return null;

            return this.children.get(c);
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