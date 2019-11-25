package easycode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode007 {

    public static int reverse(int x) {
        String s = String.valueOf(Math.abs(x));
        int len = s.length();
        int level = len - 1;
        long res = 0;
        char[] c = s.toCharArray();
        for(int i = len-1;i>=0;i--) {
            res = res + (int)((c[i]-'0')*Math.pow(10,level));
            level--;
        }
        if(x<0) { res = res*-1; }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            res = 0;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
