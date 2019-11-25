package easycode;

import org.fusesource.jansi.AnsiOutputStream;

import java.util.Collections;
import java.util.Stack;


/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode394 {



    // 辅助栈
    public static String decodeString1(String s) {
        Stack<String> stackRes = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int multi = 0;
        for( char c :  s.toCharArray()) {
            if(c>='0'&& c<='9') {
                multi = multi*10+Integer.parseInt(c+"");
            } else if(c == '[') {
                stackInt.push(multi);
                stackRes.push(sb.toString());
                multi = 0;
                sb.setLength(0);
            } else if(c == ']') {
                String str = String.join("",Collections.nCopies(stackInt.pop(),sb.toString()));
                sb = new StringBuffer().append(stackRes.pop()).append(str);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "3[a]2[bc]";
        System.out.println(decodeString1(s1));

        String s2 = "3[a2[c]fe]";
        //System.out.println(decodeString(s2));

        String s3 = "3[a2[c]]";
        //System.out.println(decodeString(s3));

        String s4 = "2[abc]3[cd]ef";
        //System.out.println(decodeString(s4));

        //String s5 = "3[a]2[b4[F]c]";
        String s5 = "3[a]2[b4[F]c]";
        System.out.println(decodeString1(s5));




    }

}
