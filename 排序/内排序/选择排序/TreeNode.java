public class TreeNode {  //胜者树的节点结构
    public int date;  //数据域
    public int index;  //结点在满二叉树中的序号
    public int active;  //是否参与选举

    public TreeNode(){
        date=-1;
        index=-1;
        active=1;
    }
}
