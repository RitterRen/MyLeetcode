package Blind75.Week4;

////Given an m x n board of characters and a list of strings words, return all 
////words on the board. 
////
//// Each word must be constructed from letters of sequentially adjacent cells, 
//
////where adjacent cells are horizontally or vertically neighboring. The same 
//letter 
////cell may not be used more than once in a word. 
////
//// 
//// Example 1: 
////
//// 
////Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i",
////"f","l","v"]], words = ["oath","pea","eat","rain"]
////Output: ["eat","oath"]
//// 
////
//// Example 2: 
////
//// 
////Input: board = [["a","b"],["c","d"]], words = ["abcb"]
////Output: []
//// 
////
//// 
//// Constraints: 
////
//// 
//// m == board.length 
//// n == board[i].length 
//// 1 <= m, n <= 12 
//// board[i][j] is a lowercase English letter. 
//// 1 <= words.length <= 3 * 10⁴ 
//// 1 <= words[i].length <= 10 
//// words[i] consists of lowercase English letters. 
//// All the strings of words are unique. 
//// 
//// Related Topics Array String Backtracking Trie Matrix 👍 6817 👎 289
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchIi{
    public static void main(String[] args) {
        Solution solution = new WordSearchIi().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class TrieNode {
        public HashMap<Character, TrieNode> children;
        String word;

        public TrieNode() {
            this.children = new HashMap<>();
            this.word = null;
        }

        public boolean hasChild(Character c) {
            return this.children.containsKey(c);
        }

        public TrieNode getChild(Character c) {
            if (this.hasChild(c)) return this.children.get(c);

            return null;
        }

        public void addChild(Character c, TrieNode node) {
            this.children.put(c, node);
        }

        public void removeChild(Character c) {
            this.children.remove(c);
        }

        public boolean isEmptyChildren() {
            return this.children.isEmpty();
        }

    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode p = this.root;
            char[] wordArr = word.toCharArray();

            for (char ch : wordArr) {
                if (!p.hasChild(ch)) {
                    p.addChild(ch, new TrieNode());
                }

                p = p.getChild(ch);
            }

            p.word = word;
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


        for (String word : words) {
            trie.addWord(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.hasChild(board[i][j])) {
                    this.dfs(board, trie.root, direction, result, i, j);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] board, TrieNode parent, int[][] direction, List<String> result, int x, int y) {
        Character letter = board[x][y];
        TrieNode currNode = parent.getChild(letter);
        board[x][y] = '#';

        if (currNode.word != null ) {
            result.add(currNode.word);
            currNode.word = null;
        }

        for (int[] direct : direction) {
            int nx = x + direct[0];
            int ny = y + direct[1];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || !currNode.hasChild(board[nx][ny])){
                continue;
            }

            this.dfs(board, currNode, direction, result, nx, ny);
        }
        board[x][y] = letter;

        if (currNode.isEmptyChildren()) {
            parent.removeChild(letter);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}