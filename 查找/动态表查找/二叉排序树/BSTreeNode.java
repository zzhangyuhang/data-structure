public class BSTreeNode {
    public Object date;   //数据域
    public BSTreeNode lchild;  //左孩子域
    public BSTreeNode rchild;  //右孩子域
    public BSTreeNode(){
        this.date=0;
        this.lchild=null;
        this.rchild=null;
    }
    public BSTreeNode(Object val){
        date=val;
        lchild=null;
        rchild=null;
    }
}
