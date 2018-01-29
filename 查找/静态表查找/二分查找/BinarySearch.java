public class BinarySearch {
    public static int binarySearch(int[] array,int key){
        int low=0,high=array.length-1;  //初始化low、high、mid指针
        int mid;
        while(high>=low){
            mid=(low+high)/2;  //当前比较的位置
            if(key==array[mid])  //查找成功，返回下标
                return mid;
            else if(key<array[mid]) //当key值比当前比较的值小，缩小范围到前半段
                high=mid-1;
            else   //当key值比当前比较的值大，缩小范围到后半段
                low=mid+1;
        }
        return -1;  //当low>high，说明遍历完毕，没有返回值，查找失败返回-1
    }
    public static void main(String args[]){
        int[] nums = new int[]{1,2,4,5,6,7,8,9};
        System.out.print(binarySearch(nums,1));
    }
}
