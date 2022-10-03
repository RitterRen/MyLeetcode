package Blind75.Week3;

//Design an algorithm to encode a list of strings to a string. The encoded 
//string is then sent over the network and is decoded back to the original list of 
//strings. 
//
// Machine 1 (sender) has the function: 
//
// 
//string encode(vector<string> strs) {
//  // ... your code
//  return encoded_string;
//} 
//Machine 2 (receiver) has the function:
//
// 
//vector<string> decode(string s) {
//  //... your code
//  return strs;
//}
// 
//
// So Machine 1 does: 
//
// 
//string encoded_string = encode(strs);
// 
//
// and Machine 2 does: 
//
// 
//vector<string> strs2 = decode(encoded_string);
// 
//
// strs2 in Machine 2 should be the same as strs in Machine 1. 
//
// Implement the encode and decode methods. 
//
// You are not allowed to solve the problem using any serialize methods (such 
//as eval). 
//
// 
// Example 1: 
//
// 
//Input: dummy_input = ["Hello","World"]
//Output: ["Hello","World"]
//Explanation:
//Machine 1:
//Codec encoder = new Codec();
//String msg = encoder.encode(strs);
//Machine 1 ---msg---> Machine 2
//
//Machine 2:
//Codec decoder = new Codec();
//String[] strs = decoder.decode(msg);
// 
//
// Example 2: 
//
// 
//Input: dummy_input = [""]
//Output: [""]
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] contains any possible characters out of 256 valid ASCII characters. 
// 
//
// 
// Follow up: Could you write a generalized algorithm to work on any possible 
//set of characters? 
// Related Topics Array String Design 👍 995 👎 268

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings{
    public static void main(String[] args) {
        Codec solution = new EncodeAndDecodeStrings().new Codec();
        
        System.out.println();
    }

//leetcode submit region begin(Prohibit modification and deletion)
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) return String.valueOf((char) 258);

        char splitSyntax = (char)257;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            sb.append(strs.get(i));
            sb.appendCodePoint(splitSyntax);
        }

        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(String.valueOf((char) 258))) return new LinkedList<String>();

        String splitSyntax = String.valueOf((char)257) ;
        String[] resultArr = s.split(splitSyntax, -1);

        return new LinkedList<>(Arrays.asList(resultArr));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
//leetcode submit region end(Prohibit modification and deletion)

}