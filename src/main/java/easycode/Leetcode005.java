package easycode;


/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode005 {

    // 暴力解法
    // 根据回文子串的定义，枚举所有长度大于等于 2 的子串，依次判断它们是否是回文
    // 1) 枚举所有长度大于等于 2 的子串
    // 2) 验证子串 s[left, right] 是否为回文串
    public static String longestPalindrome(String s) {
        final int len = s.length();
        int max_len = 1;
        String res = "";
        if(len>=1) {
            res = s.substring(0,1);
        }
        for(int i = 0;i < len-1;i++) {
            for(int j = i+1;j<len;j++) {
                boolean signal = isValid(s,i,j);
                if(signal) {
                    int newLen = j-i+1;
                    if(newLen > max_len) {
                        max_len = newLen;
                        res = s.substring(i,j+1);
                    }
                }
            }
        }
        return res;
    }

    // 判断字符串是否为回文
    public static boolean isValid(String s,int left,int right) {
        while(left < right) {
            if( s.charAt(left) != s.charAt(right) ) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababa"));
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
    }
}
