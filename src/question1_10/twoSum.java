package question1_10;

/**
 * Created by intellij IDEA
 *
 * @author Raven
 * Date:2018/4/2
 * Time:11:06
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Examples
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class twoSum{
    public static void main(String[] args){
        int[] nums = {3,2,4};
        int target = 6;
        int[] a = twoSum(nums,target);
        System.out.println(a[0]+"  "+a[1]);

    }
    /**
     * 自己写的最傻的一种方法，运行时间为O(N^2)
     * */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for(int i = 0;i < nums.length;i++){
            for(int j = i+1;j < nums.length;j++){
                if(( nums[i]+nums[j] ) == target){
                    arr[0] = i;
                    arr[1] = j;
                    break;
                }
            }
        }
        return arr;
    }
}

