import java.util.LinkedList;

public class QuickSort {
    public static int partition(int i, int j, int[] nums) {//一次的快速排序过程，每次的快速查找都能找到找当前支点的正确位置
        int pivot = nums[i]; //用当前的low，也就是i值作为支点
        while (i < j) {  //当i等于j的时候退出，从两边向中间交换，先后再前，为当前的一次移动，当i=j的时候遍历完毕
            //从后向前遍历，寻找比pivot小的关键字，前移放到pivot前边，移动到nums[i]
            //此时nums[i]数据选为支点，赋值到了pivot中，逻辑上nums[i]为空数据，不用担心覆盖数据
            while (i < j && nums[j] >= pivot)  //从后向前略过比pivot大的关键字
                j--; //大就继续下一个关键字
            //当前关键字nums[j]<pivot小，停下进行交换
            if (i < j) { //判断当前位置是否被交换过，i<j的时候说明没有遍历过
                nums[i] = nums[j]; //把nums[j]赋值到nums[i],直接覆盖掉数据，因为nums[i]的数据已经保存在pivot中
                                   //相当于此时的nums[i]没有数据，同理覆盖了nums[i]的nums[j]
                                   //数列中含有两个nums[j]的关键字，在j位置的没有用了，因为逻辑上移动到i位置，j位置为逻辑为空数据
                i++;//开始从前往后，把大于pivot的关键字放到后边j的位置上
            }
            //从前先后遍历，寻找比pivot大的关键字，后移放到pivot后边，移动到nums[j]
            //此时的nums[j]数据已经赋值到了nums[i]中，逻辑上nums[j]为空数据，不用担心覆盖数据
            while (i < j && nums[i] <= pivot)//从前往后略过比pivot小的关键字
                i++;  //小就继续寻找下一个关键字，
            //当关键字nums[i]>pivot大，就停下进行交换
            if(i<j) { //判断位置是否有效
                nums[j] = nums[i]; //把找到的比pivot小的关键字nums[i]换到nums[j]，所以i位置为逻辑上的空数据
                j--;//开始从后向前，把小于pivot的关键字放到前边i的位置上
            }
        }
        nums[i]=pivot;//当i等于j的时候，说明整个序列都遍历过了，i和j重合的位置正好是支点最后所在的正确位置
        return i; //返回当前支点的位置
    }
    //一次的快速排序能找到当前支点的正确位置，同时把序列分为两个需要排序的子序列，然后需要对子序列排序
    //直到子序列的low=high为止，当开始的快速排序开始之前low=high说明当前的待排序数列只有一个关键字
    public static void quickSort(int low,int high,int[] nums){ //递归方法，实现整个序列的排序
        if(low<high){  //当low=high的时候会退出递归，当low等于high的时候说明该序列只有一个关键字
            int pivotloc = partition(low,high,nums); //找到当前的支点位置
            quickSort(low,pivotloc-1,nums); //用快速排序排支点左边子序列
            quickSort(pivotloc+1,high,nums); //用快速排序排当前支点右边子序列
        }
    }
    public static void quickSortWithD(int low,int high,int[] nums){  //非递归方法
        LinkedList<Integer> s = new LinkedList<>();
        int pivotloc = partition(low,high,nums);
        s.push(low);
        s.push(pivotloc-1);
        s.push(pivotloc+1);
        s.push(high);
        while(!s.isEmpty()){
            int top = s.pop();
            int bottom = s.pop();
            if(bottom<top) {
                pivotloc = partition(bottom, top, nums);
                s.push(bottom);
                s.push(pivotloc - 1);
                s.push(pivotloc + 1);
                s.push(top);
            }
        }
    }
    public static void main(String args[]){
        int[] nums = {52,39,67,95,70,8,25,52};
        quickSortWithD(0,nums.length-1,nums);
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }
}
