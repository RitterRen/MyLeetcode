package LumaFinancial;

import BinarySearch.FirstBadVersion;

public class Solution2 {
    /**
     *  debug a reverse print number
     *  except leading 0
     *  original code
     */
    public void solution(int num) {
        int canPrint = num % 10;

        while (num > 0) {
            if (canPrint == 0 && num % 10 != 0) {
                canPrint = 1;
            } else if (canPrint == 1) {
                System.out.println(num % 10);
            }
            num /= 10;
        }
    }

    /**
     * Correct answer
     * @param num
     */
    public void solu2(int num) {
        int canPrint = num % 10 == 0 ? 0 : 1;

        while (num > 0) {
            System.out.println("num = " + num);
            if (canPrint == 0 && num % 100 != 0) {
                canPrint = 1;
            } else if (canPrint == 1) {
                System.out.println(num % 10);
            }
            num /= 10;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();

        solution2.solu2(50100);
    }
}
