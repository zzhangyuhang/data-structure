public class SqString implements IString {
    private char[] stringElem;
    private int curlen;
    public SqString(){
        stringElem = new char[10];
        curlen=0;
    }
    public SqString(int maxSize){
        stringElem = new char[maxSize];
        curlen=0;
    }
    public SqString(char[] stringElem){
        this.stringElem=stringElem;
        this.curlen=stringElem.length;
    }
    @Override
    public void clear() {
        curlen=0;
    }

    @Override
    public boolean isEmpty() {
        return curlen==0;
    }

    @Override
    public int length() {
        return curlen;
    }

    @Override
    public char charAt(int index) {
        return stringElem[index];
    }

    @Override
    public IString substring(int begin, int end) {
        int j=0;
        char[] nsqs = new char[end-begin];
        for(int i=begin;i<end;i++){
            nsqs[j]=stringElem[i];
            j++;
        }
        return new SqString(nsqs);
    }

    @Override
    public IString insert(int offset, IString str) {
        if(str.length()+curlen<stringElem.length){
            int j=0;
            for(int i=offset;i<str.length();i++){
                char c=stringElem[i];
                stringElem[i]=str.charAt(j);
                stringElem[i+str.length()]=c;
                j++;
            }
            return new SqString(stringElem);
        }
        else{
            char[] nsqs = new char[curlen+str.length()];
            for(int i=0;i<offset;i++)
                nsqs[i]=stringElem[i];
            for(int i=offset,j=0;i<str.length()+offset;i++,j++)
                nsqs[i]=str.charAt(j);
            for(int i=offset;i<curlen;i++)
                nsqs[i+str.length()]=stringElem[i];
            return new SqString(nsqs);
        }

    }

    @Override
    public IString delete(int beging, int end) {
        char[] nsqs = new char[curlen-(end-beging)];
        for(int i=0;i<beging;i++)
            nsqs[i]=stringElem[i];
        for(int i=end,j=beging;i<curlen;i++,j++)
            nsqs[j]=stringElem[i];
        return new SqString(nsqs);
    }

    @Override
    public IString concat(IString str) {

        return insert(curlen,str);
    }

    @Override
    public int compareTo(IString str) {
        return 0;
    }

    @Override
    public int indexOf(IString str, int begin) {
        return 0;
    }
    public void display(){
        for(int i=0;i<curlen;i++)
            System.out.print(stringElem[i]);
    }
    public static void main(String args[]){
        char[] c= new char[]{'a','b','c','d','e','f'};
        SqString sqString = new SqString(c);
        System.out.println(sqString.isEmpty());
        System.out.println(sqString.length());
        System.out.println(sqString.charAt(2));
        SqString str = new SqString(new char[]{'a','b'});
        SqString res = (SqString)sqString.substring(0,3);
        res.display();
    }
}
