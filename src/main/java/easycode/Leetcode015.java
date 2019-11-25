package easycode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode015 {
    // 排序+双指针
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return null;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(11);l2.add(12);
        list.add(l1);list.add(l2);
        System.out.println(Arrays.toString(list.toArray()));
        int[] nums = {9,7,-1,2,3,1,0};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

    }
}
