public class LinkQueue implements IQueue {
    public class Node{
        private Object val;
        private Node next;
        public Node(){
            this.val=null;
            this.next=null;
        }
        public Node(Object val){
            this.val=val;
            this.next=null;
        }
    }
    private Node front;
    private Node rear;
    public LinkQueue(){
        this.front=null;
        this.rear=null;
    }
    @Override
    public void clear() {
        rear=front=null;
    }

    @Override
    public boolean isEmpty() {
        return front==null;
    }

    @Override
    public int length() {
        Node p = new Node();
        p=front;
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
        Node p = new Node(x);
        if(front!=null) {
            rear.next=p;
            rear=p;
        }
        else  //第一次添加把头尾节点连在一起
            front=rear=p;
    }

    @Override
    public Object poll() {
        if(front!=null){
            Node p = front;
            front=front.next;
            return p.val;
        }
        else
            return null;
    }
    public void display(){
        Node p = front;
        while (p!=null){
            System.out.print(p.val+" ");
            p=p.next;
        }
    }
    public static void main(String args[]){
        LinkQueue linkQueue = new LinkQueue();
        System.out.println(linkQueue.isEmpty());
        System.out.println(linkQueue.length());
        linkQueue.offer("a");
        linkQueue.offer("b");
        linkQueue.offer("c");
        System.out.println(linkQueue.peek());
        System.out.println(linkQueue.poll());
        System.out.println(linkQueue.peek());
        System.out.println(linkQueue.isEmpty());
        System.out.println(linkQueue.length());
        linkQueue.display();
    }
}
