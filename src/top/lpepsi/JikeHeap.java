package top.lpepsi;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 林北
 * @description 堆
 * @date 2021-04-01 12:38
 */
public class JikeHeap {
    private Integer[] nums;
    private Integer n;
    private Integer count;

    public Integer[] getNums() {
        return nums;
    }

    public JikeHeap(int capacity) {
        this.nums = new Integer[capacity + 1];
        this.n = capacity;
        this.count = 0;
    }
    /**
     * @Author 林北 堆插入
     * @Description //TODO
     * @Param [data]
     * @return void
     **/
     public void insert(int data){
        if (count >= n){
            System.out.println("堆已经满了，无法插入");
            return;
        }
        nums[++count] = data;
        int i = count;
        //小顶堆 nums[i] < nums[i/2], 大顶堆 nums[i] > nums[i/2]
        while (i/2 > 0 && nums[i] < nums[i/2]){
            swap(nums,i/2,i);
            i = i/2;
        }
     }

     /**
      * @Author 林北
      * @Description //TODO 删除堆顶结点
      * @Param []
      * @return void
      **/
     public void delete(){
         if (count == 0){
             System.out.println("堆为空");
             return;
         }
         nums[1] = nums[count];
         nums[count] = null;
         delete_head(nums,1,--count);
     }

    private void delete_head(Integer[] nums, int i, Integer n) {
         while (true){
             int index = i;
             if (i * 2 <= n && nums[i] > nums[i*2]) {
                 index = i*2;
             }
             if (i*2+1 <= n && nums[i] > nums[i*2+1]){
                 index = i*2+1;
             }
             //说明左右两个子节点都比父节点小，即可结束比较
             if (index == i){
                 break;
             }
             swap(nums,i,index);
             i = index;
         }
    }

    /**
     * @Author 林北
     * @Description //TODO TopK 获取前K大的所有数
     * @Param [data, k]
     * @return void
     **/

    public void topK(int[] data, int k){
        //初始化大小为K的小顶堆
         initKheap(data,k);
        for (int i = k; i < data.length; i++) {
            if (nums[1] < data[i]){
                //删除堆顶
                delete();
                //插入数据
                insert(data[i]);
            }
        }
        System.out.print("TopK: ");
        Arrays.stream(nums).filter(Objects::nonNull).forEach(System.out::print);
    }

    /**
     * @Author 林北
     * @Description //TODO 初始化K顶堆
     * @Param [data, k]
     * @return void
     **/
    private void initKheap(int[] data, int k) {
        for (int i = 0; i < k; i++) {
            insert(data[i]);
        }
    }

    private void swap(Integer[] nums, int i, int r) {
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        JikeHeap heap = new JikeHeap(5);
//        heap.insert(4);
//        heap.insert(2);
//        heap.insert(1);
//        heap.insert(6);
//        heap.insert(5);
//        for (Integer num : heap.getNums()) {
//            System.out.print(num);
//        }
//        System.out.println("");
//        heap.delete();
//        for (Integer num : heap.getNums()) {
//            System.out.print(num);
//        }
//        System.out.println("");
        int[] nums = {0,4,1,2,3,6,7,8,9,3,4,5,6};
        heap.topK(nums,3);
    }
}
