package leetcode.editor.en;

//Given four integers sx, sy, tx, and ty, return true if it is possible to 
//convert the point (sx, sy) to the point (tx, ty) through some operations, or false 
//otherwise. 
//
// The allowed operation on some point (x, y) is to convert it to either (x, x +
// y) or (x + y, y). 
//
// 
// Example 1: 
//
// 
//Input: sx = 1, sy = 1, tx = 3, ty = 5
//Output: true
//Explanation:
//One series of moves that transforms the starting point to the target is:
//(1, 1) -> (1, 2)
//(1, 2) -> (3, 2)
//(3, 2) -> (3, 5)
// 
//
// Example 2: 
//
// 
//Input: sx = 1, sy = 1, tx = 2, ty = 2
//Output: false
// 
//
// Example 3: 
//
// 
//Input: sx = 1, sy = 1, tx = 1, ty = 1
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= sx, sy, tx, ty <= 10⁹ 
// 
// Related Topics Math 👍 1058 👎 175

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ReachingPoints{
    public static void main(String[] args) {
        Solution solution = new ReachingPoints().new Solution();
        solution.reachingPoints(1, 1, 2, 2);
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;

        // Double Direction BFS from start and end
        Queue<Pairs> startQueue = new LinkedList<>();
        Queue<Pairs> endQueue = new LinkedList<>();
        HashSet<Pairs> startSet = new HashSet<>();
        HashSet<Pairs> endSet = new HashSet<>();
        Pairs pairS = new Pairs(sx, sy);
        Pairs pairT = new Pairs(tx, ty);
        this.addPairs(pairS, startQueue, startSet);
        this.addPairs(pairT, endQueue, endSet);

        int[][] direction = {{1, 0}, {0, 1}};
        while (!startQueue.isEmpty() || !endQueue.isEmpty()) {
            System.out.println("startSet = " + startSet);
            System.out.println("endSet = " + endSet);
            if (!Collections.disjoint(startSet, endSet)) return true;
            if (!startQueue.isEmpty()) {
                Pairs temp = startQueue.poll();
                int x = temp.num1;
                int y = temp.num2;

                Pairs pair1 = new Pairs(x + y, y);
                Pairs pair2 = new Pairs(x, x + y);
                if (!startSet.contains(pair1)) {
                    this.addPairs(pair1, startQueue, startSet);
                }
                if (!startSet.contains(pair2)) {
                    this.addPairs(pair2, startQueue, startSet);
                }
            }
            if (!endQueue.isEmpty()) {
                Pairs temp = endQueue.poll();
                int x = temp.num1;
                int y = temp.num2;

                Pairs pair1 = new Pairs(x - y, y);
                Pairs pair2 = new Pairs(x, y - x);
                if (!endSet.contains(pair1)) {
                    this.addPairs(pair1, endQueue, endSet);
                }
                if (!endSet.contains(pair2)) {
                    this.addPairs(pair2, endQueue, endSet);
                }
            }
        }

        return false;
    }

    private void addPairs(Pairs pair, Queue<Pairs> queue, HashSet<Pairs> set) {
        queue.add(pair);
        set.add(pair);

    }

    class Pairs{
        Integer num1 = null;
        Integer num2 = null;

        public Pairs(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        Integer hash = null;
        @Override
        public int hashCode() {
            if (num1 != null) {
                hash = num1 * 100;
            }
            if (num2 != null) {
                hash += num2 * 10;
            }

            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pairs o)) return false;

            return this.num1.equals(o.num1)
                    && this.num2.equals(o.num2);
        }

        @Override
        public String toString() {
            return "("
                    + "num1 = " + num1
                    + "num2 = " + num2
                    + ")";
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}