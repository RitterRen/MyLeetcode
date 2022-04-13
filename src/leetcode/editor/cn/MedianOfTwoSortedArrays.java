package leetcode.editor.cn;

//////////Given two sorted arrays nums1 and nums2 of size m and n respectively, 
//
////////return 
//////////the median of the two sorted arrays. 
//////////
////////// The overall run time complexity should be O(log (m+n)). 
//////////
////////// 
////////// Example 1: 
//////////
////////// 
//////////Input: nums1 = [1,3], nums2 = [2]
//////////Output: 2.00000
//////////Explanation: merged array = [1,2,3] and median is 2.
////////// 
//////////
////////// Example 2: 
//////////
////////// 
//////////Input: nums1 = [1,2], nums2 = [3,4]
//////////Output: 2.50000
//////////Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
//
////////// 
//////////
////////// 
////////// Constraints: 
//////////
////////// 
////////// nums1.length == m 
////////// nums2.length == n 
////////// 0 <= m <= 1000 
////////// 0 <= n <= 1000 
////////// 1 <= m + n <= 2000 
////////// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
////////// 
////////// Related Topics 数组 二分查找 分治 👍 5316 👎 0
////////
//////
////
//

public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {-1,0,0,0,0,0,1};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays1(int[] nums1, int[] nums2) {

            return 0;
        }

        // O((m + n) / 2)
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int middle = (nums1.length + nums2.length) / 2;
            boolean flag = (nums1.length + nums2.length) % 2 == 0;
            int p1 = 0; // pointer for nums1
            int p2 = 0; // pointer for nums2
            int p = 0;
            int pre = 0;
            int curr = 0;

            while (p <= middle) {
                if (p1 < nums1.length && p2 < nums2.length && nums1[p1] <= nums2[p2]) {
                    pre = curr;
                    curr = nums1[p1];
                    p1++;
                }else if(p1 < nums1.length && p2 < nums2.length && nums2[p2] < nums1[p1]) {
                    pre = curr;
                    curr = nums2[p2];
                    p2++;
                }else if (p1 == nums1.length) {
                    pre = curr;
                    curr = nums2[p2];
                    p2++;
                }else if (p2 == nums2.length) {
                    pre = curr;
                    curr = nums1[p1];
                    p1++;
                }
                p++;
            }


            if (flag) return ((double)pre + curr) / 2;
            return curr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}