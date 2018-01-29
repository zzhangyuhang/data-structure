public class BiTreeNode { //二叉链表节点
    public Object date;      //数据域
    public BiTreeNode lchild;//左孩子域，注意数据类型，因为每个节点类型都是BiTreeNode，所以指针类型也是
    public BiTreeNode rchild;//右孩子域
    public BiTreeNode(){
        date=null;
        lchild=null;
        rchild=null;
    }
    public BiTreeNode(Object date){
        this.date=date;
        lchild=null;
        rchild=null;
    }
    public BiTreeNode(Object date,BiTreeNode lchild,BiTreeNode rchild){
        this.date=date;
        this.lchild=lchild;
        this.rchild=rchild;
    }
}
