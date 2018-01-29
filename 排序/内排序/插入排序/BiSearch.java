public class BiSearch {
    public static void biSearch(int[] nums){
        for(int i=1;i<nums.length;i++){
            //二分法查找要插入的位置
            int low = 0;
            int high= i-1;
            while(low<=high){
                int mid = (low+high)/2;
                //注意这里不能单独把等于列出来，因为找的是要插入的位置，不是查找该值的索引
                if(nums[i]>nums[mid])
                    low=mid+1;
                else
                    high=mid-1;
            }
            //此时的low是要插入的位置(或者high+1)
            //low之后的数据后移1位
            int temp = nums[i]; //提前把nums[i]当前关键字赋值到temp中保存，避免被覆盖
            int j =i-1; //j为i之前的最后一个关键字
            while(j>=low){ //low到j所有关键字后移，一定要从后向前，要么覆盖数据
                nums[j+1]=nums[j];
                j--;
            }
            nums[low]=temp;//把当前关键字插入到low位置上
        }
    }
    public static void main(String args[]){
        int[] nums = {52,39,67,95,70,8,25,52};
        biSearch(nums);
        for(int i : nums)
            System.out.print(i+" ");
    }
}
