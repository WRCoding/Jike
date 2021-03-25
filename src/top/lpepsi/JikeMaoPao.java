package top.lpepsi;

import java.util.Arrays;

/**
 * @author 林北
 * @description 冒泡排序
 * @date 2021-03-19 12:36
 */
public class JikeMaoPao {

    /**
     * @Author 林北
     * @Description //TODO 注意冒泡循环的判断条件 j
     * @Param [nums]
     * @return void
     **/

    public static void maoPao(Integer[] nums){
        if (nums.length <=1){
            System.out.println("不用排序");
        }
        System.out.println("-----排序前------:");
        Arrays.stream(nums).forEach(System.out::print);
        System.out.println("");
        for(int i = 0;i<nums.length;i++){
            boolean flag = false;
            for (int j=0 ; j<nums.length-1-i;j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }
        System.out.println("-----排序后------:");
        Arrays.stream(nums).forEach(System.out::print);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,2,1,4,5,6};
        JikeMaoPao.maoPao(nums);
    }
}
