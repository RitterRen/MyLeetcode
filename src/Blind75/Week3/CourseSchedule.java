package Blind75.Week3;

////There are a total of numCourses courses you have to take, labeled from 0 to 
//
////numCourses - 1. You are given an array prerequisites where prerequisites[i] 
//= [ai,
//// bi] indicates that you must take course bi first if you want to take 
//course ai.
//// 
////
//// 
//// For example, the pair [0, 1], indicates that to take course 0 you have to 
////first take course 1. 
//// 
////
//// Return true if you can finish all courses. Otherwise, return false. 
////
//// 
//// Example 1: 
////
//// 
////Input: numCourses = 2, prerequisites = [[1,0]]
////Output: true
////Explanation: There are a total of 2 courses to take. 
////To take course 1 you should have finished course 0. So it is possible.
//// 
////
//// Example 2: 
////
//// 
////Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
////Output: false
////Explanation: There are a total of 2 courses to take. 
////To take course 1 you should have finished course 0, and to take course 0 
//you 
////should also have finished course 1. So it is impossible.
//// 
////
//// 
//// Constraints: 
////
//// 
//// 1 <= numCourses <= 2000 
//// 0 <= prerequisites.length <= 5000 
//// prerequisites[i].length == 2 
//// 0 <= ai, bi < numCourses 
//// All the pairs prerequisites[i] are unique. 
//// 
//// Related Topics Depth-First Search Breadth-First Search Graph Topological 
////Sort 👍 11250 👎 439
//

import java.util.*;

public class CourseSchedule{
    public static void main(String[] args) {
        Solution solution = new CourseSchedule().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Topological Sort
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // prereqCourse -- course list
        int[] degreeMap = new int[numCourses]; // course from 0 to numCourses - 1
        // boolean[] visited = new boolean[numCourses];
        this.createDegreeMapAndGraph(graph, degreeMap, prerequisites);
        Deque<Integer> deque = new LinkedList<>();
        // System.out.println(Arrays.toString(degreeMap));

        for (int i = 0; i < numCourses; i++) {
            // if (degreeMap[i] == 0 && !visited[i]) this.bfs(graph, degreeMap, visited, i);
            if (degreeMap[i] == 0) deque.add(i);
        }

        this.bfs(graph, degreeMap, deque);

        return this.hasFinish(degreeMap);
    }

    private void createDegreeMapAndGraph(HashMap<Integer, List<Integer>> graph, int[] degreeMap, int[][] prerequisites) {
        for (int[] courses : prerequisites) {
            int preCourse = courses[1];
            int course = courses[0];

            degreeMap[course]++;

            if (!graph.containsKey(preCourse)) {
                graph.put(preCourse, new LinkedList<>());
            }
            graph.get(preCourse).add(course);
        }
    }

    private void bfs(HashMap<Integer, List<Integer>> graph, int[] degreeMap, Deque<Integer> deque) {

        while (!deque.isEmpty()) {
            int preCourse = deque.pollFirst();

            if (!graph.containsKey(preCourse)) continue;
            for (int course : graph.get(preCourse)) {
                degreeMap[course]--;
                if (degreeMap[course] == 0) {
                    deque.add(course);
                    // visited[course] = true;
                }
            }
        }
    }

    private boolean hasFinish(int[] degreeMap) {
        for (int degree : degreeMap) {
            if (degree > 0) return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}