public class PriorityQueue implements IQueue {
    private class PriorityDate{
        private Object val;
        private int priority;
        public PriorityDate(Object val,int priority){
            this.val=val;
            this.priority=priority;
        }
    }
    private class Node{
        private Object val;
        private Node next;
        public Node(){
            val=null;
            next=null;
        }
        public Node(Object val){
            this.val=val;
            next=null;
        }
    }
    private Node front;
    private Node rear;
    public PriorityQueue(){
        front=null;
        rear=null;
    }
    @Override
    public void clear() {
        front=null;
        rear=null;
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public int length() {
        Node p = front;
        int counter=0;
        while(p!=null){
            counter++;
            p=p.next;
        }
        return counter;
    }

    @Override
    public Object peek() {
        return front.val;
    }

    @Override
    public void offer(Object x) {
        PriorityDate priorityDate =(PriorityDate)x;
        Node q = new Node(priorityDate);
        if(isEmpty())
            front=rear=q;
        else {
            Node p = front;
            Node pp = front;
            while(p!=null&&priorityDate.priority>=((PriorityDate)p.val).priority){//找应该插入的位置
                pp=p;  //记录当前位置
                p=p.next;//p走到下一个位置
            }
            if(p==null){ //当插入的位置在末尾的时候直接查到尾
                rear.next=q;
                rear=q;
            }
            else if(p==front){//当插入的位置在头的时候
                q.next=front;
                front=q;
            }
            else {//当插入的位置在中间的时候 pp和p之间。
                pp.next=q;
                q.next=p;
            }
        }
    }

    @Override
    public Object poll() {
        if(isEmpty())
            return null;
        else {
            Node p = front;
            front = front.next;
            return p.val;
        }
    }
    public void display(){
        Node p = front;
        while(p!=null)
            System.out.print(p.val+" ");
    }
    
}
