public class ShellSort {
    public static int[] shellSort(int[] d,int[] nums){  //d为增量序列，nums为待排序序列
        for(int k=0;k<d.length;k++) { //取每个增量dk进行插入排序
            int dk = d[k];
            for (int c=0; c < dk; c++) {  //第c个子表，每个子表的起点为c+0，第二个数据为c+dk
                for (int i = dk+c; i < nums.length; i = i + dk) { //注意，i起点变成了dk+c，而不是0+c.因为之前增量为1，现在为dk
                    //i为当前子表的第二个元素，因为第一个元素不用比较直接入有序序列，所以跳过为第二个
                    int temp = nums[i]; //对当前i进行插入排序
                    int j = i - dk; //i的前一位是i-dk，j=i-dk
                    while (j >= 0 && nums[j] > temp) { //判断下标是否有效j>=0,同时判断每个的关键字大小
                        nums[j + dk] = nums[j];//大于就向后移动一位，这里增量为dk，所以向后移动dk位
                        j = j - dk;//上一位数据位置为j-dk，从后往前
                    }
                    nums[j + dk] = temp;
                }
                for (int i = 0; i < nums.length; i++)
                    System.out.print(nums[i] + " ");
                System.out.println();
            }
        }
        return nums;
    }
    public static void main(String args[]){
        int[] d = {5,3,1};
        int[] nums={52,39,67,95,70,8,25,52,56,5};
        int[] sortnums=shellSort(d,nums);
        for(int i=0;i<sortnums.length;i++)
            System.out.print(sortnums[i]+" ");
    }
}
