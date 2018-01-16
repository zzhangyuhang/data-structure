public class LinkStack implements IStack {
    //链栈内部是用不带头结点的链表来存储数据的
    //在插入链节的时候采用头查法
    //一般我们常见的都是有头节点的尾插法
    public class Node{
        private Object val;
        private Node next;
        public Node(){
            this(null,null);
        }
        public Node(Object x){
            this(x,null);
        }
        public Node(Object x,Node p){
            this.val=x;
            this.next=p;
        }
    }
    private Node top;
    public LinkStack(){
        this.top = null;
    }
    @Override
    public void clear() {
        top=null;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
    }

    @Override
    public int length() {
        int i=0;
        Node p = top;
        while(p!=null){
            i++;
            p=p.next;
        }
        return i;
    }

    @Override
    public Object peek() {
        return top.val;
    }

    @Override
    public void push(Object x) {
        Node stackNode = new Node(x);
        stackNode.next=top;
        top=stackNode;
    }

    @Override
    public Object pop() {
        Node p = top;
        top=top.next;
        return p.val;
    }
    public void display(){
        Node p = top;
        while(p!=null){
            System.out.println("| "+p.val+" |");
            p=p.next;
        }
        System.out.println(" --- ");
    }
    public static void main(String args[]){
        LinkStack linkStack = new LinkStack();
        System.out.println(linkStack.isEmpty());
        System.out.println(linkStack.length());
        linkStack.push("a");
        linkStack.push("b");
        linkStack.push("c");
        linkStack.display();
        System.out.println(linkStack.isEmpty());
        System.out.println(linkStack.length());
        System.out.println(linkStack.peek());
        System.out.println(linkStack.pop());
        System.out.println(linkStack.peek());
        linkStack.clear();
        System.out.println(linkStack.isEmpty());
        System.out.print(linkStack.length());
    }
}
