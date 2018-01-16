public class SqStack implements IStack{
    private Object[] stackElem;
    private int top;   //因为top指向的是当前元素，必须从-1开始。
                       //如果从0开始，进入一个元素后再+1,top就是栈顶元素的下一个空位。
    public SqStack(){
        this.stackElem = new Object[10];
        this.top=-1;
    }
    public SqStack(int maxSize){
        this.stackElem = new Object[maxSize];
        this.top=-1;
    }
    @Override
    public void clear() {
        top=-1;
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public int length() {
        return top+1;
    }

    @Override
    public Object peek() {     //返回栈顶元素
        if(!isEmpty())
            return stackElem[top];
        else
            return null;
    }

    @Override
    public void push(Object x) {    //进栈
        if(top!=stackElem.length) //1.让top指针指向栈顶的下一个空位
            stackElem[++top]=x;   //2.进栈    ++top 就是先top=top+1，然后stackElem[top]=x;
        else
            System.out.println("栈已满");
    }

    @Override
    public Object pop() {  //取出栈顶元素
        if(!isEmpty())
            return stackElem[top--];
        else
            return null;
    }
    public void display(){
        for(int i = top ; i>=0;i--){
            System.out.println("|  "+stackElem[i]+"  |");
        }
        System.out.println("-------");
    }
    public static void main(String args[]){
        SqStack sqStack = new SqStack();
        System.out.println(sqStack.isEmpty());
        System.out.println(sqStack.length());
        System.out.println(sqStack.peek());
        System.out.println(sqStack.pop());
        sqStack.push("a");
        sqStack.push("b");
        sqStack.push("c");
        sqStack.push("d");
        System.out.println(sqStack.length());
        System.out.println(sqStack.peek());
        System.out.println(sqStack.pop());
        System.out.println(sqStack.peek());
        sqStack.display();

    }
}
