package easycode;


import javax.sound.midi.Soundbank;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode171 {
    public static int titleToNumber1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int num = 1;
        int level = 26;
        for(char i = 'A';i<='Z';i++) {
            map.put(i,num);
            num++;
        }
        int res = 0;
        int len = s.length();
        for(char c:s.toCharArray()) {
            len--;
            res = (int)(map.get(c)*Math.pow(level,len))+res;
        }
        return res;
    }

    public static int titleToNumber2(String s) {
        int res = 0;
        int len = s.length();
        for(char c:s.toCharArray()) {
            len--;
            res = (int)((c-64)*Math.pow(26,len))+res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber2("ZY"));
    }
}
