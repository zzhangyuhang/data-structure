public class BF {
    public static int Bf(String s,String t){
        for(int i=0;;i++){  //注意这里没有循环的限制条件，通过后边限制。
            for(int j=0;;j++){
                if(j==t.length()) //j=t.length-1还需要比较，所以j要走到t.length
                    return i;
                if(i+j>s.length()-1)//当t的字符比剩下s没比较过的字符还要多自动匹配失败
                    return -1;
                if(s.charAt(i+j)!=t.charAt(j))//当有一个字符不匹配，当前位置匹配失败
                    break;
            }
        }
    }
    public static void main(String args[]){
        System.out.print(Bf("cdbbacc","bba"));
    }
}
