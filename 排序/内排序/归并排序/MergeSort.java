public class MergeSort {
    public static void merge(int[] order,int[] nums,int start,int mid,int end){
        //第一个子序列为[start-mid]
        //第二个子序列为[mid+1-end]
        int i = start;
        int j = mid+1;
        int k=start;

        while(i<=mid&&j<=end){
            if(nums[i]>nums[j])  //当前子序列关键字小，就加入到order中，然后向后移动一位
                order[k++] = nums[j++];
            else
                order[k++] = nums[i++];
        }

        while(i<=mid) //把前一个子序列的剩余元素复制到order中
            order[k++]=nums[i++];
        while(j<=end) //把后一个子序列的剩余元素复制到order中
            order[k++]=nums[j++];
    }
    public static void mergepass(int[] nums,int[] order,int n,int s){
        //nums为原始数组
        //order为存储结果的数组
        //n为数组长度
        //s为子表长度
        int p = 0; //p为每一对待合并表的第1个元素下标，初值为0
        //每两个待比较的子表为[p,p+s],[p+s+1,p+2s]
        //因为时0开头，[p,p+s-1],[p+s,p+2s-1]
        while(p+2*s-1<=n-1){  //先合并前面长度相等的子序列
            merge(order,nums,p,p+s-1,p+2*s-1);
            p=p+2*s;//跳过两个合并完的子表，下两个子表进行合并
        }
        if(p+s-1<n-1){ //合并完长度相等的子序列，或者没有长度相等的子序列，合并长度不相等的子序列
            merge(order,nums,p,p+s-1,n-1);//归并两个长度不相等的序列，如图第3趟排序
        }
        else {  //将剩余的有序表复制到order中
            for(int i=p;i<n;i++){
                order[i]=nums[i];
            }
        }
    }
    public static void mergeSort(int[] nums){
        int s = 1; //s为已排列的子序列长度，初值为1
        int n = nums.length;
        int[] temp = new int[n]; //辅助数组
        while(s<n){
            mergepass(nums,temp,n,s);//一趟归并，将nums数组中各个子序列归并到temp中
            s*=2; //子序列长度加倍
            mergepass(temp,nums,n,s);//二趟归并，将temp数组中各个子序列归并到nums中
            s*=2;//子序列长度再加倍
        }
    }
    public static void main(String args[]){
        int[] nums = {52,39,67,95,70,8,25,52,26};
        mergeSort(nums);
        for(int i : nums)
            System.out.print(i+" ");
    }

}
