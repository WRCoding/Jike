package top.lpepsi;


import java.util.Arrays;

/**
 * @author 林北
 * @description 快速排序
 * @date 2021-03-26 08:49
 */
public class JikeKuaiPai {

    public static void quick_sort(int[] nums ,int n ){
        quick_sort_c(nums,0,n-1);
    }

    private static void quick_sort_c(int[] nums,int p, int r ) {
        if (p > r){
            return;
        }
        int pivot = partition(nums,p,r);
        //以下是找K值的代码
//        if (pivot+1 == k){
//            System.out.println(nums[pivot],k);
//        }else if (pivot+1 > k){
//            quick_sort_c(nums,p,pivot-1,k);
//        }else {
//            quick_sort_c(nums,pivot+1,r,k);
//        }
        quick_sort_c(nums,p,pivot-1);
        quick_sort_c(nums,pivot+1,r);
    }

    private static int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++){
            // 找K值时需要将 '<' 变成 '>'
            if (nums[j] < pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,r);
        return i;
    }

//    /**
//     * @Author 林北
//     * @Description //TODO 找到无序数组中第K大的值
//     * @Param [nums, k]
//     * @return void
//     **/
//    public static void findK(int[] nums ,int k){
//        quick_sort(nums, nums.length,k);
//
//    }

    /**
     * @Author 林北
     * @Description //TODO 交换
     * @Param [nums, i, j]
     * @return void
     **/
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {6,8,7,6,3,5,9,4};
        System.out.println("排序前:");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println();
        JikeKuaiPai.quick_sort(nums,nums.length);
        System.out.println("排序后:");
        Arrays.stream(nums).forEach(System.out::print);
//        JikeKuaiPai.findK(nums,8);
    }
}
