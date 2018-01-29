import java.util.LinkedList;

public class BiTree {
    private BiTreeNode root; //树的根节点
    public BiTree(){  //构造一颗空树
        this.root=null;
    }
    public BiTree(BiTreeNode root){  //构造一颗树
        this.root=root;
    }
    public BiTreeNode getRoot(){
        return root;
    }
    public void preRootTraverse(BiTreeNode T){  //先根遍历,递归

        if(T!=null){
            System.out.print(T.date);
            preRootTraverse(T.lchild);
            preRootTraverse(T.rchild);

        }
    }
    public void preRootTraverse(){  //先根遍历，非递归

        BiTreeNode T = root;
        if(T!=null){
            LinkedList<BiTreeNode> stack = new LinkedList();  //构造栈
            stack.push(T); //根节点入栈
            while(!stack.isEmpty()){
                T=stack.pop();  //取出栈顶元素
                System.out.print(T.date);//先根遍历，先访问根节点数据
                while (T!=null){  //出栈节点不为空
                    if(T.lchild!=null)  //访问出栈节点的左孩子
                        System.out.print(T.lchild.date); //访问左孩子
                    if(T.rchild!=null) //访问出栈的节点的右孩子
                        stack.push(T.rchild); //非空，入栈。因为访问顺序是从左往右边。
                    T=T.lchild; //向下遍历。
                }
            }
        }
    }
    public void inRootTraverse(BiTreeNode T){  //中根遍历，递归
        if(T!=null){
            inRootTraverse(T.lchild);
            System.out.print(T.date);
            inRootTraverse(T.rchild);
        }

    }
    public void inRootTraverse(){  //中根遍历，非递归
                                   //访问顺序，当前栈顶的最下边最左边的左边节点开始（非叶子节点），左孩子->节点->右孩子入栈等访问
        BiTreeNode T = root;
        LinkedList<BiTreeNode> stack = new LinkedList<>();
        stack.push(T);  //根节点入栈
        while(!stack.isEmpty()){
            while(stack.peek()!=null){   //将栈顶点的左孩子节点相继入栈
                stack.push(stack.peek().lchild);
            }
            stack.pop(); //叶子节点的左孩子也加入到栈中，取出来。
            if(!stack.isEmpty()){
                T=stack.pop();//取出栈顶节点
                System.out.print(T.date);//访问栈顶节点数据
                stack.push(T.rchild);//把右孩子压入栈中
            }
        }
    }
        public void postRootTraverse(BiTreeNode T){   //后根遍历，递归

            if(T!=null){
                postRootTraverse(T.lchild);
                postRootTraverse(T.rchild);
                System.out.print(T.date);
            }
        }
    public void postRootTraverse(){   //后根遍历，非递归
        BiTreeNode T =root;
        LinkedList<BiTreeNode> stack = new LinkedList<>();
        stack.push(T);

        BiTreeNode p=null;//p指向刚才被访问的节点
        boolean flag; //访问标记

        while(!stack.isEmpty()){
            while(stack.peek()!=null){  //找到当前栈顶节点最下边的左子孙
                stack.push(stack.peek().lchild);
            }//因为最下边左子孙为叶子节点，它的左孩子也进栈了，为null空节点
            stack.pop();//空节点退栈
            while(!stack.isEmpty()){
                T=stack.peek();//获取当前栈顶元素
                if(T.rchild==null||T.rchild==p){ //如果当前栈顶节点没有右孩子，直接访问
                    System.out.print(T.date);//访问
                    stack.pop();//出栈
                    p=T; //p指向当前被访问的节点
                    flag=true; //设置访问过的标志
                }
                else { //如果还有右孩子，继续遍历
                    stack.push(T.rchild);//把右孩子入栈
                    flag=false;//未访问
                }
                if(!flag)  //当flag为true的时候说明此时的栈顶的下面没有需要继续入栈的元素，输出即可，然后下一个栈顶元素判断
                            //当为false的时候说明当前栈顶元素还有子树没有访问完需要继续访问，就不跳出循环
                    break;
            }
        }

    }
    public void levelTraverse(){  //层次遍历，从左到右

        LinkedList<BiTreeNode> queue = new LinkedList<>();  //层次遍历用队列
        BiTreeNode T = root;
        if(T!=null){
            queue.offer(T); //根节点进队
            while (!queue.isEmpty()){
                T=queue.poll();    //输出当前队首
                System.out.print(T.date);
                if(T.lchild!=null) //左孩子入队
                    queue.offer(T.lchild);
                if(T.rchild!=null) //右孩子入队
                    queue.offer(T.rchild);
            }
        }
    }
    public static void main(String args[]){
        BiTreeNode A = new BiTreeNode("A");
        BiTreeNode B = new BiTreeNode("B");
        BiTreeNode C = new BiTreeNode("C");
        BiTreeNode D = new BiTreeNode("D");
        BiTreeNode E = new BiTreeNode("E");
        BiTreeNode F = new BiTreeNode("F");
        BiTreeNode G = new BiTreeNode("G");
        BiTreeNode H = new BiTreeNode("H");

        A.lchild=B;
        A.rchild=C;
        B.lchild=D;
        B.rchild=E;
        E.lchild=G;
        C.lchild=F;
        F.rchild=H;

        BiTree biTree = new BiTree(A);              //构造一颗树
        BiTreeNode root = biTree.getRoot();
        biTree.preRootTraverse(root);
        System.out.println();
        biTree.preRootTraverse();
        System.out.println();
        biTree.inRootTraverse(root);
        System.out.println();
        biTree.inRootTraverse();
        System.out.println();
        biTree.postRootTraverse();
        System.out.println();
        biTree.postRootTraverse(root);
        System.out.println();
        biTree.levelTraverse();



    }
}
