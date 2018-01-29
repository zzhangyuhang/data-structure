public class HeapSort {
    public static void sift(int low,int high,int[] nums){ //小顶堆的调整
        int i = low;  //子树的根结点
        int j = 2*i+1; //子树根结点的左孩子
        int temp = nums[i];
        while(j<high){
            if(j<high-1&&nums[j]>nums[j+1])//j为左孩子，j+1为右孩子，找到关键字最小的孩子，令j的等于它
                j++;
            if(temp>nums[j]){ //如果当前根结点比最小的孩子大
                nums[i]=nums[j];//孩子结点上移到当前根结点的位置
                i=j;//令当前根结点为刚交换的子结点，继续往下调整
                j=2*i+1;//j为当前根节点的左孩子
            }
            else {//找到满足堆定义的位置
                break;//退出循环，当前堆已经调整完毕
            }
            nums[i]=temp;//将temp插入到i位置
        }
    }
    public static void heapSort(int[] nums){
        int n = nums.length;
        for(int i=n/2-1;i>=0;i--){  //i=n/2-1，为完全二叉树的最后一个非叶子结点
            sift(i,n,nums);  //把nums调整成为堆
        }
        for(int i=n-1;i>0;i--){  //每趟将最小关键字与当前最后一个无序序列关键字交换
            int temp = nums[0];//nums[i]和nums[n-i]交换
            nums[0]=nums[i];
            nums[i]=temp;
            sift(0,i-1,nums);//调整成堆
        }
    }
    public static void main(String args[]){
        int[] nums = {33,25,46,13,58,95,18,63};
        heapSort(nums);
        for(int i : nums)
            System.out.print(i+" ");
    }
}
