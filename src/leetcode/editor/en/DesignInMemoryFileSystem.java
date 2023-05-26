package leetcode.editor.en;

//Design a data structure that simulates an in-memory file system. 
//
// Implement the FileSystem class: 
//
// 
// FileSystem() Initializes the object of the system. 
// List<String> ls(String path) 
// 
// If path is a file path, returns a list that only contains this file's name. 
// If path is a directory path, returns the list of file and directory names in 
//this directory. 
// The answer should in lexicographic order. 
// void mkdir(String path) Makes a new directory according to the given path. 
//The given directory path does not exist. If the middle directories in the path do 
//not exist, you should create them as well. 
// void addContentToFile(String filePath, String content) 
// 
// If filePath does not exist, creates that file containing given content. 
// If filePath already exists, appends the given content to original content. 
// 
// String readContentFromFile(String filePath) Returns the content in the file 
//at filePath. 
// 
//
// 
// Example 1: 
// 
// 
//Input
//["FileSystem", "ls", "mkdir", "addContentToFile", "ls", "readContentFromFile"]
//
//[[], ["/"], ["/a/b/c"], ["/a/b/c/d", "hello"], ["/"], ["/a/b/c/d"]]
//Output
//[null, [], null, null, ["a"], "hello"]
// 
//
//Explanation
//FileSystem fileSystem = new FileSystem();
//fileSystem.ls("/"); // return []
//fileSystem.mkdir("/a/b/c");
//fileSystem.addContentToFile("/a/b/c/d", "hello");
//fileSystem.ls("/"); // return ["a"]
//fileSystem.readContentFromFile("/a/b/c/d"); // return "hello"
//
//
// 
// Constraints: 
//
// 
// 1 <= path.length, filePath.length <= 100 
// path and filePath are absolute paths which begin with '/' and do not end 
//with '/' except that the path is just "/". 
// You can assume that all directory names and file names only contain 
//lowercase letters, and the same names will not exist in the same directory. 
// You can assume that all operations will be passed valid parameters, and 
//users will not attempt to retrieve file content or list a directory or file that 
//does not exist. 
// 1 <= content.length <= 50 
// At most 300 calls will be made to ls, mkdir, addContentToFile, and 
//readContentFromFile. 
// 
//
// Related Topics Hash Table String Design Trie 👍 1334 👎 140

import java.util.*;

public class DesignInMemoryFileSystem{
    public static void main(String[] args) {
        FileSystem solution = new DesignInMemoryFileSystem().new FileSystem();

        System.out.println(solution.ls("/"));
        solution.mkdir("/a/b/c");
        System.out.println(solution.ls("/"));
//        solution.addContentToFile("/a/b/c/d", "hello");
//        solution.ls("/");
//        solution.readContentFromFile("/a/b/c/d");

        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class FileSystem {
    Trie trie;

    public FileSystem() {
        trie = new Trie();
    }
    
    public List<String> ls(String path) {
        return trie.ls(path);
    }
    
    public void mkdir(String path) {
        trie.mkdir(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        trie.addContentToFile(filePath, content);
    }
    
    public String readContentFromFile(String filePath) {
        return trie.getContentFromFile(filePath);
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode("/");
        }

        public TrieNode goToFile(String filePath) {
            String[] path = filePath.split("/");

            TrieNode p = root;

            for (int i = 1; i < path.length; i++) {
                String fileName = path[i];
                if (!p.hasFile(fileName)) return null;
                p = p.getFile(fileName);
            }

            return p;
        }

        public void addContentToFile(String filePath, String content) {
            this.mkdir(filePath);
            TrieNode curr = this.goToFile(filePath);
            if (curr != null) {
                curr.addContent(content);
            }
        }

        public void mkdir(String filePath) {
            String[] path = filePath.split("/");
            TrieNode p = root;

            for (int i = 1; i < path.length; i++) {
                String fileName = path[i];
                if (p.hasFile(fileName)) {
                    p = p.getFile(fileName);
                    continue;
                }

                TrieNode newNode = new TrieNode(fileName);
                p.children.put(fileName, newNode);
                p = newNode;
            }
        }

        public String getContentFromFile(String filePath) {
            TrieNode curr = this.goToFile(filePath);
            if (curr != null) {
                return curr.getContent();
            }

            return "";
        }

        public List<String> ls(String filePath) {
            TrieNode curr = this.goToFile(filePath);

            List<String> res = new ArrayList<>();
            if (curr == null) return res;
            if (curr.isFile()) {
                res.add(curr.fileName);
                return res;
            }

            return curr.ls();
        }
    }

    class TrieNode {
        String fileName;
        HashMap<String, TrieNode> children;
        StringBuilder content;

        public TrieNode(String fileName) {
            this.fileName = fileName;
            this.children = new HashMap<>();
            this.content = new StringBuilder();
        }

        public boolean hasFile(String fileName) {
            return children.containsKey(fileName);
        }

        public TrieNode getFile(String fileName) {
            if (!this.hasFile(fileName)) return null;

            return children.get(fileName);
        }

        public void addContent(String content) {
            this.content.append(content);
        }

        public String getContent() {
            return this.content.toString();
        }

        public List<String> ls() {
            ArrayList<String> res = new ArrayList<>(children.keySet());
            Collections.sort(res);
            return res;
        }

        public boolean isFile() {
            return this.content.length() > 0;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
//leetcode submit region end(Prohibit modification and deletion)

}