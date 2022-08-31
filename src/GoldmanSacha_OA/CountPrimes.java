package GoldmanSacha_OA;

//Given an integer n, return the number of prime numbers that are strictly less 
//than n. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: n = 1
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics Array Math Enumeration Number Theory 👍 5386 👎 1068

public class CountPrimes{
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        // read and write the hashset takes some times
//        HashSet<Integer> visited = new HashSet<>();
//
//        int n_sqrt = (int) Math.floor(Math.sqrt(n));
//        //System.out.println("n_sqrt = " +  n_sqrt);
//        for (int i = 2; i <= n_sqrt; i++) {
//            if (visited.contains(i)) continue;
//            int j = i;
//            int temp = i * j;
//
//            while (temp < n) {
//                visited.add(temp);
//                temp = i * ++j;
//            }
//            //System.out.println(visited);
//        }
//
//        return n - visited.size() - 2; // 0, 1 will never be count;

        boolean[] visited = new boolean[n];
        int n_sqrt = (int) Math.ceil(Math.sqrt(n));

        for (int i = 2; i < n_sqrt; i++) {
            if (visited[i]) continue;
            int j = i;
            int temp = j * i;

            while (temp < n) {
                visited[temp] = true;
                temp = i * ++j;
            }
        }

        int result = 0;
        for (boolean flag : visited) {
            if (!flag) {
                result++;
            }
        }

        return result - 2;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}