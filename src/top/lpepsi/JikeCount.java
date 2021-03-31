package top.lpepsi;

import java.util.Arrays;

/**
 * @author 林北
 * @description 排序算法-计数排序
 * @date 2021-03-27 15:59
 */
public class JikeCount {
    /**
     * @Author 林北
     * @Description //TODO 计数排序
     * @Param [nums, n]
     * @return void
     **/

     public static void countingSort(int[] nums ,int n){
         if (n <= 0){
             return;
         }
         int max = nums[0];
         for (int i = 0; i < n; i++){
             if (max < nums[i]){
                 max = nums[i];
             }
         }
         int[] b = new int[max+1];
         for (int i = 0; i < n; i++) {
             b[nums[i]]++;
         }
         for (int i = 1; i < b.length; i++) {
             b[i] = b[i-1] +b[i];
         }
         int[] temp = new int[n];
         for (int i = nums.length - 1; i >= 0; i--) {
             //从后往前取保证了稳定性
             int params = nums[i];
             int index = b[params];
             temp[index-1] = params;
             b[params]--;
         }
         System.arraycopy(temp, 0, nums, 0, temp.length - 1 + 1);
     }

    public static void main(String[] args) {
        int[] nums = {4,32,1,6,2,5,9,2,0};
        System.out.println("排序前:");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        JikeCount.countingSort(nums,nums.length);
        System.out.println("排序后:");
        Arrays.stream(nums).forEach(System.out::print);
    }
}
