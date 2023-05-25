package Blind75.Week5;

//Given two positive integers num1 and num2, find the integer x such that: 
//
// 
// x has the same number of set bits as num2, and 
// The value x XOR num1 is minimal. 
// 
//
// Note that XOR is the bitwise XOR operation. 
//
// Return the integer x. The test cases are generated such that x is uniquely 
//determined. 
//
// The number of set bits of an integer is the number of 1's in its binary 
//representation. 
//
// 
// Example 1: 
//
// 
//Input: num1 = 3, num2 = 5
//Output: 3
//Explanation:
//The binary representations of num1 and num2 are 0011 and 0101, respectively.
//The integer 3 has the same number of set bits as num2, and the value 3 XOR 3 =
// 0 is minimal.
// 
//
// Example 2: 
//
// 
//Input: num1 = 1, num2 = 12
//Output: 3
//Explanation:
//The binary representations of num1 and num2 are 0001 and 1100, respectively.
//The integer 3 has the same number of set bits as num2, and the value 3 XOR 1 =
// 2 is minimal.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num1, num2 <= 10⁹ 
// 
//
// 👍 122 👎 8

public class MinimizeXor{
    public static void main(String[] args) {
        Solution solution = new MinimizeXor().new Solution();
        
        System.out.println(Integer.toBinaryString(25));
        System.out.println(Integer.toBinaryString(72));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimizeXor(int num1, int num2) {
        int countOne = this.countBinaryOne(Integer.toBinaryString(num2));
        String binaryNum1 = Integer.toBinaryString(num1);
        int countTwo = this.countBinaryOne(binaryNum1);

        if (countOne == countTwo) return num1;

        char[] binaryNum1Arr = binaryNum1.toCharArray();
        StringBuilder sb = new StringBuilder();

        System.out.println("countOne =" + countOne);
        System.out.println("countTwo = " + countTwo);
        if (countOne > countTwo) {
            int diff = countOne - countTwo;

            for (int i = binaryNum1Arr.length - 1; i >= 0; i--) {
                if (binaryNum1Arr[i] == '0' && diff > 0) {
                    binaryNum1Arr[i] = '1';
                    diff--;
                }

                if (diff == 0) break;
            }

            while (diff > 0) {
                sb.append('1');
                diff--;
            }
            System.out.println(sb);
            System.out.println(String.valueOf(binaryNum1Arr));
            sb.append(String.valueOf(binaryNum1Arr));
        } else { // countOne < countTwo
            int diff = countOne;
            for (int i = 0; i < binaryNum1Arr.length; i++) {
                if (binaryNum1Arr[i] == '1' && diff > 0) {
                    sb.append('1');
                    diff--;
                } else if (binaryNum1Arr[i] == '0' && diff > 0) {
                    sb.append('0');
                }

                if (diff == 0) break;
            }
        }

        System.out.println(sb);

        return Integer.parseInt(sb.toString(), 2);
    }

    private int countBinaryOne(String binaryNum) {
        int countOne = 0;

        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '1') {
                countOne++;
            }
        }

        return countOne;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}