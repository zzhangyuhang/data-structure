public class InsertSort {
    public static int[] insertSort(int[] nums){
        for(int i=1;i<nums.length;i++){  //第一个关键字组成排好序的序列，所以从第二个开始，也就是i=1.
            int temp = nums[i];
            int j=i-1;
            while(j>=0&&nums[j]>temp){  //需要比较不成超出下届和nums[j]和temp的大小
                                        //比nums[i]大的后移一位，当遇到小于等于temp的关键字停下
                    nums[j+1]=nums[j]; //不用担心覆盖什么数据，最次全部后移一位
                                      // 最多只能覆盖最后一位的下一位是nums[i]，还保存在了temp中
                    j--; //向前遍历
            }
            //当全部关键字都比temp大，一直j--，一直到j=-1<0结束，要插入的位置是表头nums[j+1=0]
            //当nums[j]小于等于temp才退出，所以nums[j+1]才是要插入的位置。
            nums[j+1]=temp;
        }
        return nums;
    }
    public static int[] insertSortWithGuard(int nums[]){
        for(int i=1;i<nums.length;i++){
            nums[0]=nums[i];//用nums[0]当作哨站并保存当前要排序的关键字，当遍历到nums[0]的时候 相等，退出循环
            int j=i-1;      //省了一次比较j位置是否越界
                            //但是需要节省出一个表头空间不能保存数据
            while(nums[j]>nums[0]){ //当nums[i]大于关键字的时候
                nums[j+1]=nums[j];//向后移动一个位置
                j--;//向前遍历
            }
            nums[j+1]=nums[0];
        }
        return nums;
    }
    public static void main(String args[]){
        int[] nums = {0,3,4,2,5,9,7,6};
        int[] sortnums = insertSortWithGuard(nums);
        for(int i=1;i<sortnums.length-1;i++)
            System.out.print(sortnums[i]+" ");
    }
}
