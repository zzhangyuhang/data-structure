public class KMP {
    public static int[] getNext(String t){  //得出子字符串的next[j]数组
        int[] next = new int[t.length()];
        next[0]=-1; //初始next[0]=-1
        next[1]=0; //初始
        int k=0;  //模式串指针
        int j=1;  //主串指针
        while (j<t.length()-1){ //每次用j和k匹配的是next[j+1]的值，所以遍历到t的倒数第二位就可以完成next[j]数组的定义
            if(t.charAt(j)==t.charAt(k)){//当前位置j和k匹配成功
                next[j+1]=k+1;  //next[j+1]=k+1
                j++;            //j走，无论匹配成功与否j都会走
                k++;            //只有匹配成功的时候k才会走，失败的时候回退到next[k]中的位置
            }
            else if (k == 0) {  //如果k=0，说明k已经回退到头了，依旧没有匹配成功
                next[j+1]=0; //彻底匹配失败的时候next[j+1]=0
                j++;//j走
            }
            else {
            }
                k=next[k]; //每次匹配失败，k回退，回退到next[k]中的位置
        }
        return next;
    }
    public static int kmp(String s,String t){
        int[] next = getNext(t); //获取子字符串的next[]用于匹配失败的时候回退子字符串
        int i = 0;  //主字符串的指针
        int j = 0;  //子字符串的指针
        while(i<s.length()&&j<t.length()){
            if(j==-1||s.charAt(i)==t.charAt(j)){//当j=-1的时候，说明子字符串已经回退到头了，头部还没匹配成功
                j++;                            //当子字符串回退到头还没有匹配成功，说明当前位置匹配失败，开始下一个位置的匹配
                i++;                            //j++回到子字符串的头部因为j之前等于-1，i++主字符串走向下一个位置开始匹配
            }
            else
                j=next[j];//当前匹配失败，子字符串回退到next[j]位置
        }
        if(j==t.length()) //匹配成功，因为j走到了t.length,说明在t-length-1的位置匹配成功
            return i-t.length();//因为kmp算法i是不回退的，i一直向前走，当j匹配成功的时候，i也走了t.length,
                                //注意这里不能用i-j，因为j是子字符串回退的位置，不一定回退到头。
        else
            return -1;  //匹配失败
    }
    public static void main(String args[]){
        System.out.print(kmp("cdbbacc","bba"));
    }
}
