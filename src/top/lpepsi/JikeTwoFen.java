package top.lpepsi;


/**
 * @author 林北
 * @description 二分查找和其变形
 * @date 2021-03-29 08:45
 */
public class JikeTwoFen {

    /**
     * @Author 林北
     * @Description //TODO 二分查找 最简单版本 非递归
     * @Param [nums, n, k]
     * @return java.lang.Integer
     **/
    public static Integer bSearch(int[] nums ,int n,int k){
        if ( n <  1){
            return -1;
        }
        int low = 0;
        int height = n-1;
        while (low <= height){
            int mid = low + (height - low)/2;
            if (nums[mid] > k){
                height = mid - 1;
            }else if(nums[mid] < k){
                low = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    /**
     * @Author 林北
     * @Description //TODO 二分查找 最简单版本 递归
     * @Param [nums, low, height, k]
     * @return java.lang.Integer
     **/
    public static Integer bSearchDG(int[] nums ,int low ,int height,int k){
        if ( low > height){
            return -1;
        }
        int mid  = low + (height - low)/2;
        if (nums[mid] == k){
            return mid;
        }else if (nums[mid] > k){
            return bSearchDG(nums,low,mid - 1,k);
        }else{
            return bSearchDG(nums,mid + 1,height,k);
        }
    }

    /**
     * @Author 林北
     * @Description //TODO 变形1: 查找第一个值等于给定值的元素
     * @Param [nums, n, k]
     * @return java.lang.Integer
     **/
    public static Integer bSearch3(int[] nums, int n ,int k){
        if ( n <  1){
            return -1;
        }
        int low = 0;
        int height = n-1;
        while (low <= height){
            int mid = low + (height - low)/2;
            if (nums[mid] > k){
                height = mid - 1;
            }else if(nums[mid] < k){
                low = mid + 1;
            }else{
                if (mid == 0 || nums[mid - 1] != k){
                    return mid;
                }else {
                    height = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * @Author 林北
     * @Description //TODO 变形2: 查找最后一个值等于给定值的元素
     * @Param [nums, n, k]
     * @return java.lang.Integer
     **/
    public static Integer bSearch4(int[] nums ,int n , int k){
        if ( n <  1){
            return -1;
        }
        int low = 0;
        int height = n-1;
        while (low <= height){
            int mid = low + (height - low)/2;
            if (nums[mid] > k){
                height = mid - 1;
            }else if(nums[mid] < k){
                low = mid + 1;
            }else{
                if (mid == n - 1 || nums[mid + 1] != k){
                    return mid;
                }else {
                    height = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * @Author 林北
     * @Description //TODO 变形3: 查找第一个大于等于给定值的元素
     * @Param [nums, n, k]
     * @return java.lang.Integer
     **/
    public static Integer bSearch5(int[] nums ,int n ,int k){
        if ( n <  1){
            return -1;
        }
        int low = 0;
        int height = n-1;
        while (low <= height){
            int mid = low + (height - low)/2;
            if (nums[mid] > k){
                if ( mid == 0 || nums[mid - 1] <= k){
                    return mid;
                }else {
                    height = mid - 1;
                }
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * @Author 林北
     * @Description //TODO 变形4: 查找最后一个小于等于给定值的元素
     * @Param [nums, n, k]
     * @return java.lang.Integer
     **/
    public static Integer bSearch6(int[] nums,int n ,int k){
        if ( n <  1){
            return -1;
        }
        int low = 0;
        int height = n-1;
        while (low <= height){
            int mid = low + (height - low)/2;
            if (nums[mid] > k){
                    height = mid - 1;
            }else{
                if (mid == n - 1 || nums[mid + 1] > k){
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,4,5,6,7,7,8,9};
        int index = JikeTwoFen.bSearch6(nums,nums.length,7);
        System.out.println("在下标: "+index);
    }
}
