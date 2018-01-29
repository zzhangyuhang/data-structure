public class BubbleSort {
    public static int[] bubbleSortDown(int[] nums){//冒泡法排序，每次循环都从后到前排好一个关键字，下沉
        int i=1; //i用于记录该排第几个关键字，冒泡法每次能排好一个关键字，排好关键字的个数为i-1。
                 //也可以用于记录当前没排好序的最后一个位置，length-i
                 //length-1，length-2，length-3 ... length-length=0
                 //因为采用的是大的关键字往后换
                 //每次都是找出当前最大的关键字放到没排好序的最后一个位置，然后没排好序列的最后一个关键字位置-1
                 //也就是i++，当前没排好序的最后一个位置为length-i
        boolean flag=true;
        while(i<nums.length&&flag) {
            for (int j = 0; j < nums.length - i; j++) {//从前到后，因为每次nums.length-i是没排好序号的最后的位置
                                                       //也是当前最大关键字应该所在的位置
                                                       //所以应该遍历到nums.length-i的前一个位置，j<nums.length-i
                                                       //每次都是与后一个关键字比较
                flag=false;                            //当没有交换的时候flag不会变成true
                if (nums[j] > nums[j + 1]) { //用当前关键字和下一个关键字比较
                    int temp = nums[j];      //如果前面大，就和后边对换。
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag=true;                        //当有交换的时候flag变成true，进行下趟排序
                                                      //如果此趟排序没有任何交换，flag=false，说明排好序，跳出排序
                }
            }//这样每次从头到尾交换，就可以把当前最大的关键字换到没排好序的序列的最后边，也就是该在的位置。
            i++;//排下一个关键字
        }
        return nums;
    }
    public static int[] bubbleSortUp(int[] nums){//上浮
        int i=0;
        boolean flag=true;
        while(i<nums.length&&flag){
            for(int j=nums.length-1;j>i;j--){
                flag=false;
                if(nums[j]<nums[j-1]){  //小的上浮
                    int temp=nums[j-1];
                    nums[j-1]=nums[j];
                    nums[j]=temp;
                    flag=true;
                }
            }
            i++;
        }
        return nums;

    }
    public static void main(String args[]){
        int[] sortnums=bubbleSortUp(new int[]{52,39,67,95,70,8,25,52});
        for(int i=0;i<sortnums.length;i++)
            System.out.print(sortnums[i]+" ");
    }
}
