public class Sqlist {
    private Object[] listElem;     //用于内部存储的数组
    private int curLen;            //当前顺序表的长度，注意并不是数组的最大长度。
    public Sqlist(int maxSize){    //顺序表的初始化，这里给出带参数的构造方法
        this.curLen=0;             //实际arraylist是有无参数构造的，初始的存储数组大小为10
        this.listElem=new Object[maxSize];
    }
    public void clear(){         //清空，这里清空并不能真的清空，因为计算机中数据就是直接覆盖使用的
        curLen=0;                //所以只需要把当前的顺序表长度初始为0就好了
        listElem = new Object[1];
    }
    public boolean isEmpty(){    //判断是否为空，只需要判断当前长度就好了，为0返回true。
        if(curLen==0)
            return true;
        else
            return false;
    }
    public int length(){       //返回当前顺序表的长度，注意这里并不是内在数组的大小，因为数组有的位置可能为空
        return curLen;
    }
    public void add(Object x){   //注意修改当前长度curLen
        listElem[curLen]=x;
        curLen++;
    }
    public Object get(int i)throws Exception{
        if(i<1||i>curLen)
            throw new Exception("第"+i+"元素不存在");
        return listElem[i-1];
    }
    public void insert(int i,Object x)throws Exception{
        if(curLen==listElem.length){
            throw new Exception("顺序表已满！");
        }
        for(int j=curLen;j>i-1;j--){                      //在插入数据的时候，预插入位置后边的数据都要向后移动一位
            listElem[j]=listElem[j-1];                    //在移动的过程中，注意一定要从最后的那个元素开始向后移动1位
        }                                                 //要是从前边移动的话，后边的数据都会被覆盖
        listElem[i-1]=x;                //移动完毕后，直接覆盖原来那个位置的元素就行
        curLen+=1;                      //修改当前长度，插入长度+1
    }
    public void remove(int i){
        if(i<1||i>curLen)
            System.out.println("位置不合法！");
        for(int j=i;j<curLen;j++){             //删除，删除后边的数据都要向前移动一位
            listElem[j-1]=listElem[j];         //注意，移动的时候一定要从前边开始移动，从后边的话数据都会被覆盖。
        }
        curLen--;               //注意修改长度，删除 -1
    }
    public int indexOf(Object x){
        for(int i=0;i<curLen;i++){
            if(x.equals(listElem[i]))      //注意，判断相等的时候要用equals(),Object是引用类型 用==的话会出错
                return i+1;                //要是基础数据类型可以用 ==
        }
        return -1;                        //找不到的时候返回-1
    }
    public void display(){
        System.out.print("[");
        for(int i=0;i<curLen;i++){
            if(i==curLen-1)
                System.out.print(listElem[i]);
            else
                System.out.print(listElem[i]+",");
        }
        System.out.println("]");
    }
    public static void main(String args[]) throws Exception {
        Sqlist sqlist = new Sqlist(10);
        System.out.println(sqlist.isEmpty());
        sqlist.add("a");
        sqlist.add("b");
        sqlist.add("c");
        sqlist.display();
        System.out.println(sqlist.length());
        System.out.println(sqlist.get(1));
        System.out.println(sqlist.indexOf("b"));
        sqlist.insert(1,"z");
        sqlist.display();
        sqlist.remove(1);
        sqlist.display();
        System.out.println(sqlist.isEmpty());
        sqlist.clear();
        System.out.println(sqlist.isEmpty());
        System.out.println(sqlist.length());
    }
}
