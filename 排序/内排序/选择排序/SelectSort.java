public class SelectSort {
    public static void selectSort(int[] nums){//直接选择排序
        int i = 0;
        while(i<nums.length-1){//最后一个关键字nums[length-1]不用比较，在原位即可，最大
                               //所以比较到length-2，i<length-1
                               //每一趟排序确定一个当前未排序序列中最小关键字的位置
            int j = i+1;  //从i+1开始比较
            int minIndex = i; //minIndex记录最小关键字的坐标
            while(j<nums.length){  //选取i后边最小的关键字
                if(nums[j]<nums[minIndex]){  //当前关键字要是小于记录的最小关键字
                    minIndex = j;//记录该下标
                }
                j++;//大于略过
            }
            //因为初始的最小关键字下标是i，所以最开始关键字与最小关键字比较的关键字是nums[i]
            //也就是最小关键字初始化为nums[i]
            if(nums[minIndex]!=nums[i]){ //当最小关键字不等于nums[i]的时候交换
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex]=temp;
            }
            i++;//进行下一趟排序
        }
    }
    public static void main(String args[]){
        int[] nums = {52,39,67,95,70,8,95,25};
        selectSort(nums);
        for(int i : nums)
            System.out.print(i+" ");
    }
}
