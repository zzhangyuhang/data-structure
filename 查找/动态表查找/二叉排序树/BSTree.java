import java.util.LinkedList;

public class BSTree {
    private BSTreeNode root;

    public BSTree() {
        root = null;
    }

    public BSTree(int date) {
        root = new BSTreeNode(date);
    }

    public BSTree(BSTreeNode root) {
        this.root = root;
    }

    //二叉排序树的顺序遍历等于二叉树的中序遍历
    public void inOrderTraverse(BSTreeNode T) { //递归方法
        if (T != null) {
            inOrderTraverse(T.lchild);
            System.out.print(T.date);
            inOrderTraverse(T.rchild);
        }
    }

    public void inOrderTraverse() {  //非递归
        BSTreeNode T = root;
        LinkedList<BSTreeNode> s = new LinkedList<>();
        if(T!=null) {
            s.push(T);
            while (!s.isEmpty()) {
                while (s.peek() != null) {
                    s.push(s.peek().lchild);
                }
                s.pop();
                if (!s.isEmpty()) {
                    T = s.pop();
                    System.out.print(T.date+" ");
                    s.push(T.rchild);
                }
            }
        }
    }
    public Object searchBST(Object key){
        if(key==null||root==null)//二叉排序树为空的时候返回null
            return null;
        else
            return searchBST(key,root);
    }
    public java.lang.Object searchBST(Object key, BSTreeNode root){
        if(root.date.equals(key))//当搜索到节点
            return root.date; //返回数据
        if((Integer)key<(Integer)root.date){//小于当前的根节点，
            return searchBST(key, root.lchild); //递归搜索左子树
        }
        if((Integer)key>(Integer)root.date){//大于当前根节点
            return searchBST(key, root.rchild);//递归搜素右子树
        }
        return null;//搜索失败返回null
    }
    public boolean insertBST(Object key,BSTreeNode T){  //递归添加key
        if(root==null){ //如果树为空，建立根节点。
            root=new BSTreeNode(key);//存入树中的root
            return true;
        }
        if((Integer)T.date==(Integer)key){//如果树中含有等于key的节点，不插入返回false
            return false;
        }
        if((Integer)key<(Integer)T.date){//如果key小于当前的根节点
            if(T.lchild==null){ //根节点的左孩子为空
                T.lchild=new BSTreeNode(key);//插入
                return true;//返回结果true
            }
            else//当当前的根节点左孩子不为空
                return insertBST(key,T.lchild);//递归插入当前根节点左子树
        }
        if((Integer)key>(Integer)T.date){//如果key大于当前的根节点
            if(T.rchild==null){//根节点的右孩子为空
                T.rchild=new BSTreeNode(key);//直接插入
                return true;//返回结果
            }
            else//右孩子不为空
                return insertBST(key,T.rchild);//递归插入当前节点的右子树
        }
        return false;//没有插入，返回失败，false
    }
    public Object removeBST(Object key,BSTreeNode p,BSTreeNode parent){//p为当前根节点，parent为p的双亲节点
        if(p!=null){
            if((Integer)key<(Integer) p.date){//key比当前根节点小的时候
                return removeBST(key,p.lchild,p);//在左子树中搜索要删除的值
            }
            if((Integer)key>(Integer)p.date){//key比当前根节点大的时候
                return removeBST(key,p.rchild,p);//在右子树中搜索要删除的值
            }
            //通过上两步的递归查找，找到要删除的值为当前的节点p
            if(p.lchild!=null&&p.rchild!=null){//情况4，当前待删除节点p既有左孩子又有右孩子
                                               //用中序的前驱或者后继代替
                BSTreeNode innext = p.rchild;  //寻找p的中序后继节点innext
                while(innext.lchild!=null)     //p的中序后继节点为其右子树的最左孩子
                    innext=innext.lchild;
                p.date=innext.date;//用后继节点替换当前节点p
                                   //用后继节点替换后，该节点无左子树，在其右子树中删除innext
                return removeBST(innext.date,p.rchild,p);//递归删除innext节点
            }else {//p的左右子树不同时为空的时候
                if (p.rchild == null ) {//情况2，待删除节点无右子树，只有左子树
                    if (parent.lchild == p)//待删除节点是其双亲节点的左子树
                        parent.lchild = p.lchild;//用待删除节点的左子树代替
                    if (parent.rchild == p) //待删除节点是其双亲节点的右子树
                        parent.rchild = p.lchild;//用待删除节点的左子树代替
                    return p.date;
                }
                if (p.lchild == null ) {//情况3，待删除节点无左子树，只有右子树
                    if (parent.lchild == p)//待删除节点是其双亲节点的左子树
                        parent.lchild = p.rchild;//用待删除节点的右子树代替
                    if (parent.rchild == p) //待删除节点是其双亲节点的右子树
                        parent.rchild = p.rchild;//用待删除节点的右子树代替
                    return p.date;
                }
                if (p.lchild == null && p.rchild == null) {//情况1，当p既没有左子树也没有右子树的是时候，p是叶子节点
                    if (parent.lchild == p)  //直接删除
                        parent.lchild = null;
                    if (parent.rchild == p)  //直接删除
                        parent.rchild = null;
                    return p.date;
                }
                if (parent == null) {//待删除节点p的双亲节点parent为null的时候，p为根节点
                    if(p.lchild!=null)
                        root = p.lchild;
                    else
                        root = p.rchild;
                    return p.date;
                }
            }
        }
        return null;
    }

    public static void main(String args[]) {
        BSTreeNode a = new BSTreeNode(49);
        BSTreeNode b = new BSTreeNode(12);
        BSTreeNode c = new BSTreeNode(65);
        BSTreeNode d = new BSTreeNode(8);
        BSTreeNode e = new BSTreeNode(35);
        BSTreeNode f = new BSTreeNode(88);
        BSTreeNode g = new BSTreeNode(5);
        BSTreeNode h = new BSTreeNode(10);
        BSTreeNode i = new BSTreeNode(15);
        BSTreeNode j = new BSTreeNode(68);

        a.lchild=b;
        a.rchild=c;
        b.lchild=d;
        b.rchild=e;
        c.rchild=f;
        d.lchild=g;
        d.rchild=h;
        e.lchild=i;
        f.lchild=j;

        BSTree bsTree = new BSTree(a);
        bsTree.inOrderTraverse();
        System.out.println();
        System.out.println(bsTree.searchBST(8));
        System.out.println(bsTree.insertBST(4, bsTree.root));
        bsTree.inOrderTraverse();
        System.out.println();
        System.out.println(bsTree.removeBST(12,bsTree.root,null));
        bsTree.inOrderTraverse();
    }
}