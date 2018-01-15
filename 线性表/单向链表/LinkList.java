public class LinkList {
    public class Node{
        private Object val;
        private Node next;
        public Node(){
            this(null,null);
        }
        public Node(Object val){
            this(val,null);
        }
        public Node(Object val,Node next){
            this.val=val;
            this.next=next;
        }
    }
    private Node head;
    public LinkList(){
        this.head = new Node();
    }
    public void clear(){  //链表滞空
        head.next=null;
    }
    public boolean isEmpty(){  //判断链表是否为空
        return head.next==null;
    }
    public int length(){  //返回链表的长度
        int i=0;
        Node p = head.next;
        while(p!=null){
            i++;
            p=p.next;
        }
        return i;
    }
    public void display(){   //打印链表
        Node p = head.next;
        if(p==null){
            System.out.println("链表为空！");
        }
        while(p!=null){
            if(p.next==null)
                System.out.println(p.val);
            else
                System.out.print(p.val+"->");
            p=p.next;
        }


    }
    public void add(Object x){   //添加元素x
        Node p = head;
        while(p.next!=null) {
            p = p.next;
        }
        Node q = new Node(x);
        p.next = q;
    }
    public void insert(int i,Object x){   //在第i个单元插入元素x
        int j=0;
        Node p = head;
        while(p!=null){
            if(j==i-1){
                Node q = new Node(x);
                q.next=p.next;
                p.next=q;
            }
            p=p.next;
            j++;
        }
    }
    public Object get(int i){
        Node p = head;
        int j = 0;
        while(p!=null){
            p=p.next;
            j++;
            if(j==i)
                return p.val;
        }
        return null;
    }
    public int indexOf(Object x){     //查找元素x的索引
        Node p = head;
        int i = 0;
        while(p!=null){
            p=p.next;
            i++;
            if(p.val.equals(x))
                return i;
        }
        return -1;
    }
    public void remove(int i){       //删除i单元的元素
        Node p = head;
        int j = 0;
        while(p!=null){
            if(j==i-1){
                p.next=p.next.next;
            }
            p=p.next;
            j++;
        }
    }
    public static void main(String args[]){
        LinkList ll = new LinkList();
        System.out.println(ll.isEmpty());
        ll.display();
        ll.add(new String("abc"));
        ll.add(new String("b"));
        ll.add(new String("c"));
        System.out.println(ll.isEmpty());
        ll.display();
        System.out.println(ll.length());
        System.out.println(ll.indexOf("abc"));
        System.out.println(ll.get(1));
        ll.insert(1,"abcd");
        ll.display();
        ll.remove(2);
        ll.display();
        ll.clear();
        System.out.println(ll.length());
        System.out.print(ll.isEmpty());

    }

}
