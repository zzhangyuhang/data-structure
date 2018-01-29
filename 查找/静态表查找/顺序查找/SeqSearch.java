public class SeqSearch {
    public static int seqSearch(Object[] nums,Object key){
        int i=0;
        while(i<nums.length&&!nums[i].equals(key))
            i++;
        if(i < nums.length)
            return i;
        return -1;
    }
    public static int seqSearchWithGurad(Object[] nums,Object key){
        int i = nums.length-1;  //从尾巴开始遍历
        nums[0]=key;  //将表第一个数据nums[0]改为key，当成监视哨，当比较到监视哨的时候比较会停 此时i=1
        while(!nums[i].equals(key)) //不等于向下遍历
            i--;
        if(i>0)  //
            return i;
        return -1;
    }

    public static void main(String args[]){
        String[] nums = new String[]{"aaa","bbb","ccc","ddd"};
        System.out.print(seqSearchWithGurad(nums,"ccc"));
    }
}
