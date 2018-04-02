package question11_20;

import java.util.*;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/4/2
 * Time:11:07
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Integer[] b = new Integer[3];
        if (nums.length == 0) {
            return lists;
        }
        if (nums.length == 1) {
            if (nums[0] == 0) {
                Integer[] c = {nums[0]};
                tmp = Arrays.asList(c);
                lists.add(tmp);
            }
            return lists;
        }
        if (nums.length == 2) {
            if (nums[0] + nums[1] == 0) {
                Integer[] c = {nums[0], nums[1]};
                tmp = Arrays.asList(c);
                lists.add(tmp);
            }
            return lists;
        }

        Set<List<Integer>> set = new HashSet<>();
        if (nums.length >= 3) {
            for (int i = 0; i < b.length; i++) {
                b[i] = nums[i];
            }
            calc(b, tmp, set);

            for (int i = b.length - 1, k = nums.length - 1; i >= 0; i--, k--) {
                switch (i) {
                    case 2:
                        for (int j = i + 1; j <= k; j++) {
                            b[i] = nums[j];
                            calc(b, tmp, set);

                        }
                        break;

                    case 1:
                        for (int j = i + 1; j <= k; j++) {
                            b[i] = nums[j];
                            for (int l = j + 1; l <= k + 1; l++) {
                                b[i + 1] = nums[l];
                                calc(b, tmp, set);

                            }
                        }
                        break;

                    case 0:
                        for (int j = i + 1; j <= k; j++) {
                            b[i] = nums[j];
                            for (int l = j + 1; l <= k + 1; l++) {
                                b[i + 1] = nums[l];
                                for (int m = l + 1; m <= k + 2; m++) {
                                    b[i + 2] = nums[m];
                                    calc(b, tmp, set);
                                }
                            }
                        }
                    default:

                }
            }

            lists.addAll(set);
        }

        return lists;
    }

    private static void calc(Integer[] b, List<Integer> tmp, Set<List<Integer>> set) {
        if (calc(b)) {
            Integer[] c = b.clone();
            Arrays.sort(c);
            tmp = Arrays.asList(c);
            set.add(tmp);
        }
    }


    /**
     * 打印数组
     */
    private static boolean calc(Integer[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum == 0) {
            return true;
        }

        return false;
    }
}
