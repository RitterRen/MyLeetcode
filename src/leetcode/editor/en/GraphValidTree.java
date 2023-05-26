package leetcode.editor.en;

////You have a graph of n nodes labeled from 0 to n - 1. You are given an 
//integer 
////n and a list of edges where edges[i] = [ai, bi] indicates that there is an 
////undirected edge between nodes ai and bi in the graph. 
////
//// Return true if the edges of the given graph make up a valid tree, and 
//false 
////otherwise. 
////
//// 
//// Example 1: 
////
//// 
////Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
////Output: true
//// 
////
//// Example 2: 
////
//// 
////Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
////Output: false
//// 
////
//// 
//// Constraints: 
////
//// 
//// 1 <= n <= 2000 
//// 0 <= edges.length <= 5000 
//// edges[i].length == 2 
//// 0 <= ai, bi < n 
//// ai != bi 
//// There are no self-loops or repeated edges. 
//// 
//// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 
//27
////20 👎 79
//

import java.util.*;

public class GraphValidTree{
    public static void main(String[] args) {
        Solution solution = new GraphValidTree().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        //HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> parentMap = new HashMap<>();

        this.createGraph(graph, edges);
        stack.add(0);
        //visited.add(0);
        if (!this.dfs(graph, stack, parentMap)) return false;

        return parentMap.size() == n;
    }

    private void createGraph(HashMap<Integer, LinkedList<Integer>> graph, int[][] edges) {
        for (int[] edge : edges) {
            int num1 = edge[0];
            int num2 = edge[1];

            if (!graph.containsKey(num1)) {
                graph.put(num1, new LinkedList<>());
            }
            if (!graph.containsKey(num2)) {
                graph.put(num2, new LinkedList<>());
            }
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }
    }

    private boolean dfs(HashMap<Integer, LinkedList<Integer>> graph, Stack<Integer> stack, HashMap<Integer, Integer> parentMap) {
        parentMap.put(0, -1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!graph.containsKey(node)) continue;

            for (int leaf : graph.get(node)) {
                if (parentMap.get(node) == leaf) continue;
                if (parentMap.containsKey(leaf)) return false;

                stack.push(leaf);
                parentMap.put(leaf, node);
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}