import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test {

    public static int[] getNext(String t){
        int[] next = new int[t.length()];
        next[0]=-1;
        next[1]=0;
        int j = 1;  //主串指针
        int k = 0;  //模式串指针
        while (j<t.length()-1){ //每次匹配出来的数值都是下一个位置的next的值，所以到t.length-2就可以出t.length-1的值了
            if(t.charAt(j)==t.charAt(k)){  //匹配成功
                next[j+1]=k+1;
                j++;
                k++;
            }
            else if(k == 0){
                next[j+1] = 0;
                j++;
            }
            else
                k=next[k];
        }
        return next;
    }
    public static int Kmp(String s,String t){
        int[] next = getNext(t);
        int i = 0;
        int j = 0;
        while(i<s.length()&&j<t.length()){  //j==-1 这行代码很关键，证明子字符串已经 回退到 0，主字符串可以进行下一位的匹配
            if(j==-1||s.charAt(i)==t.charAt(j)) {  //j==-1的时候说明子字符串已经回退到0，t[0]!=s[j],不相等，匹配失败
                i++;   //失败也都向下走一位，开始新的匹配。
                j++;   //i++向下走一位，j++等于0，回到子字符串头t.charAt[0]
            }
            else {
                j=next[j]; //j指针回退，回退位置由next[j]数组决定
            }
        }
        if(j<t.length())   //j没走完整个t,匹配失败  匹配成功j一定走完t
            return -1;
        else
            return i-t.length();//匹配成功的时候，返回当前i位置减去t的长度，不能减j，以为j没有回退到0.
    }
    public static int Sunday(String s,String t){
        int i = 0;
        int j = 0;
        int k;
        while(i<s.length()-t.length()+j){
            if(s.charAt(i)!=t.charAt(j)){ //不相等的时候
                k=contains(t.toCharArray(),s.charAt(i+t.length()-j));
                if(k==-1){//不包含的时候i先移动到与j相同的位置，
                    i=i+t.length()-j+1;   //j每次移动的距离是t.length-j，i移动也一样
                                          //但是这次i比j要多动一格，i=i+t.length-j+1
                    j=0;                  //j回调到t的头部
                }
                else {
                    i=i+t.length()-j-k;  //因为在第k的位置相等，所以j少移动了k格，j移动了t.length-j-k
                    j=0;                 //j回调到t的头部
                }
            }
            else {
                if(j==t.length()-1){ //j已经走到了字符串的最后一位,匹配成功
                    return i-j;  //返回最开始匹配的位置，因为i走的长度始终等于j走的长度，j是从0开始走的
                }                //所有j走的长度为j，i的起始点为i-j
                else {
                    i++;
                    j++;
                }
            }
        }
        return -1;
    }
    public static int contains(char[] str,char ch){
        for(int i = str.length-1;i>=0;i--){ //从t的尾巴开始向前遍历
            if(str[i]==ch)  //找到等于的s.charAt(k)的那个在t中的相对位置
                return i;  //找到返回该位置
        }
        return -1;//没找到返回-1
    }

    public static void main(String args[]){
        System.out.println(Kmp("hello","ll"));
        System.out.println(Sunday("hello","ll"));
    }
}
