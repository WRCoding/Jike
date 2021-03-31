package top.lpepsi;

import java.util.Arrays;

/**
 * @author 林北
 * @description 排序算法-选择排序 *
 * @date 2021-03-25 08:48
 */
public class JikeChoice {

    public static void choiceSort(int[] nums ,int n){
        if (n <= 1){
            System.out.println("n <= 1 排序结束");
            return;
        }
        for (int i = 0; i<n;i++){
            int minIndex = i;
            for (int j = i; j<n; j++){
                if (nums[j] < nums[minIndex]){
                    //找到最小值的下标
                    minIndex = j;
                }
            }
            //交换
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,6,3,8,5};
        System.out.println("排序前:");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        JikeChoice.choiceSort(nums,nums.length);
        System.out.println("排序后:");
        Arrays.stream(nums).forEach(System.out::print);
    }
}
