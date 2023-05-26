package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

//<p>There are <code>n</code> dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.</p>
//
//<p>After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.</p>
//
//<p>When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.</p>
//
//<p>For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.</p>
//
//<p>You are given a string <code>dominoes</code> representing the initial state where:</p>
//
//<ul>
//	<li><code>dominoes[i] = &#39;L&#39;</code>, if the <code>i<sup>th</sup></code> domino has been pushed to the left,</li>
//	<li><code>dominoes[i] = &#39;R&#39;</code>, if the <code>i<sup>th</sup></code> domino has been pushed to the right, and</li>
//	<li><code>dominoes[i] = &#39;.&#39;</code>, if the <code>i<sup>th</sup></code> domino has not been pushed.</li>
//</ul>
//
//<p>Return <em>a string representing the final state</em>.</p>
//
//<p>&nbsp;</p>
//<p><strong class="example">Example 1:</strong></p>
//
//<pre>
//<strong>Input:</strong> dominoes = &quot;RR.L&quot;
//<strong>Output:</strong> &quot;RR.L&quot;
//<strong>Explanation:</strong> The first domino expends no additional force on the second domino.
//</pre>
//
//<p><strong class="example">Example 2:</strong></p>
//<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/05/18/domino.png" style="height: 196px; width: 512px;" />
//<pre>
//<strong>Input:</strong> dominoes = &quot;.L.R...LR..L..&quot;
//<strong>Output:</strong> &quot;LL.RR.LLRRLL..&quot;
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li><code>n == dominoes.length</code></li>
//	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
//	<li><code>dominoes[i]</code> is either <code>&#39;L&#39;</code>, <code>&#39;R&#39;</code>, or <code>&#39;.&#39;</code>.</li>
//</ul>
//<div><div>Related Topics</div><div><li>Two Pointers</li><li>String</li><li>Dynamic Programming</li></div></div><br><div><li>👍 3184</li><li>👎 199</li></div>
public class PushDominoes{
    public static void main(String[] args) {
        Solution solution = new PushDominoes().new Solution();
        String testcase1 = ".L.R...LR..L..";
        
        System.out.println(solution.pushDominoes(testcase1));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes.length() <= 1) return dominoes;

        char[] dominoArr = dominoes.toCharArray();
        LinkedList<Integer> queue = new LinkedList<>();
        int[] strengthArr = new int[dominoes.length()];
        boolean[] visited = new boolean[dominoes.length()];
        for (int i = 0; i < dominoArr.length; i++) {
            if (dominoArr[i] == 'L' || dominoArr[i] == 'R') {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < len; j++) {
                int i = queue.pollFirst();
                char direct = dominoArr[i];
                int next = i;

                if (direct == 'R') {
                    next += 1;
                }else if (direct == 'L') {
                    next -= 1;
                }

                if (next >= 0 && next < dominoArr.length && dominoArr[next] == '.' && !visited[next]) {
                    strengthArr[next] += direct == 'R' ? 1 : -1;
                    set.add(next);
                }
            }
            //System.out.println(set);
            for (Integer k: set) {
                if (strengthArr[k] > 0) {
                    dominoArr[k] = 'R';
                } else if (strengthArr[k] < 0) {
                    dominoArr[k] = 'L';
                }
                queue.add(k);
                visited[k] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : dominoArr) {
            sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}