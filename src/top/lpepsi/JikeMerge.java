package top.lpepsi;

import java.util.Arrays;

/**
 * @author 林北
 * @description 归并排序
 * @date 2021-03-25 09:14
 */
public class JikeMerge {

    public static void merge_sort(int[] nums , int n){
        merge_sort_c(nums,0,n-1);
    }

    private static void merge_sort_c(int[] nums, int p, int r) {
        if (p >= r){
            return;
        }
        int q = (p + r)/2;
        merge_sort_c(nums,p,q);
        merge_sort_c(nums,q+1,r);
        merge(nums,p,q,r);
    }

    /**
     * @Author 林北
     * @Description //TODO 并
     * @Param [nums, i, q, n]
     * @return void
     **/
    private static void merge(int[] nums, int p, int q, int r) {
        int i = p; int j = q+1; int k = 0;
        //必须要+1,临时数组才够位置
        int[] temp = new int[r-p+1];
        while (i<=q && j<=r){
            if (nums[i] > nums[j]){
                temp[k++] = nums[j++];
            }else{
                temp[k++] = nums[i++];
            }
        }
        int start = i; int end = q;
        if (j <= r){
            start = j;
            end = r;
        }
        while (start <= end){
            temp[k++] = nums[start++];
        }
        if (r - p + 1 >= 0) {
            System.arraycopy(temp, 0, nums, p, r - p + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,6,3,8,5};
        System.out.println("排序前:");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        JikeMerge.merge_sort(nums,nums.length);
        System.out.println("排序后:");
        Arrays.stream(nums).forEach(System.out::print);
    }
}
