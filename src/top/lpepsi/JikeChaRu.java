package top.lpepsi;

import java.util.Arrays;

/**
 * @author 林北
 * @description 插入排序 *
 * @date 2021-03-24 09:27
 */
public class JikeChaRu {

    public static void insertionSort(int[] nums,int n){
        if (n <= 1){
            System.out.println("n <= 1 排序结束");
            return;
        }
        for (int i = 1; i<n; i++){
            int value = nums[i];
            int j = i-1;
            for(; j>=0; j--){
                if (nums[j] > value){
                    //移动数据
                    nums[j+1] = nums[j];
                }else{
                    break;
                }
            }
            //插入数据
            nums[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,1,6,7,2,3,4};
        System.out.println("排序前:");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        JikeChaRu.insertionSort(nums,nums.length);
        System.out.println("排序后:");
        Arrays.stream(nums).forEach(System.out::print);
    }
}
