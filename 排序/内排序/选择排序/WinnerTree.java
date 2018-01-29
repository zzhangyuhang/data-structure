public class WinnerTree {
    public static void tournamentSort(int[] nums) { //树形选择排序
        TreeNode[] tree; //胜者树结点数组
        int leafSize = 1; //胜者树的叶子结点数

        while (leafSize < nums.length)//生成叶子结点
            leafSize *= 2;//得到胜者树叶子结点(外结点)的个数，该个数必须是2的幂数

        int TreeSize = 2 * leafSize - 1;  //胜者树的所有节点数
        int loadindex = leafSize - 1; //叶子结点（外结点）存放的起始位置
        tree = new TreeNode[TreeSize];
        int k=0;
        for (int i = loadindex; i < TreeSize; i++) {//把待排序结点复制到胜者树的叶子结点中
            tree[i]=new TreeNode();
            tree[i].index=i;
            if(k<nums.length){  //  把nums的所有数据都加入到胜者树中，从loadindex开始
                tree[i].date=nums[k];
                k++;
            }
            else//若胜者树后边还有叶子结点，赋值为空结点，或不参与比赛。
                tree[i].active=0;
        }

        //开始查找关键字值最小的结点，一趟排序
        int i = loadindex; //从第一个叶子结点开始
        while (i > 0) {
            int j = i;
            while (j < 2 * i) { //处理各对比赛者，树结点到TreeSize=2*leafSize-1=2*i-1,所以j<2*i
                if (tree[j + 1].active == 0 || tree[j].date <= tree[j + 1].date)//j+1为空结点或j的关键字小于j+1的关键字
                    tree[(j - 1) / 2] = tree[j];//当前的父节点赋值为较小的j位置的关键字
                else
                    tree[(j - 1) / 2] = tree[j + 1];//否则，父结点赋值为j+1的关键字
                j += 2;//下一对比赛者
            }
            i = (i - 1) / 2;//处理上层结点
        }
        //处理剩余的n-1个记录
        for (i = 0; i < nums.length - 1; i++) {
            nums[i] = tree[0].date; //将胜者树的根也就是当前最小关键字存入数组nums
            tree[tree[0].index].active = 0;//将记录对应外结点不参见比赛
            updateTree(tree, tree[0].index);//调整胜者树
        }
        nums[nums.length - 1] = tree[0].date;
    }

    public static void updateTree(TreeNode[] tree, int index) {//调整胜者树
        //index是当前最小关键字的下标
        //将当前最小关键字调至无穷比较
        //也可以跟最小关键字相比较的那个结点无条件胜出
        if (index % 2 == 0)//当下标为偶数的时候，对手为左结点
            tree[(index - 1) / 2] = tree[index - 1];//左结点自动胜出
        else  //奇数是，对手为右结点
            tree[(index - 1) / 2] = tree[index + 1];//右结点自动胜出


        int i = (index - 1) / 2; //上升到父节点
        int j;//记录当前结点的对手结点
        while (i > 0) { //直至到i=0，根节点选出当前最小的关键字
            if (i % 2 == 0)
                j = i - 1;
            else
                j = i + 1;
            if (tree[i].active == 0 || tree[j].active == 0) {
                if (tree[i].active == 0) //当i为空结点的时候
                    tree[(i - 1) / 2] = tree[j];//j自动获胜
                else //当j为空结点的时候
                    tree[(i - 1) / 2] = tree[i];//i自动获胜
            } else {
                if (tree[i].date <= tree[j].date) //当i的关键字小
                    tree[(i - 1) / 2] = tree[i]; //i获胜
                else//j的关键字小
                    tree[(i - 1) / 2] = tree[j];//j获胜
            }
            i = (i - 1) / 2; //上升到父节点
        }
    }
    public static void main(String args[]){
        int[] nums = {52,39,67,95,70,8,25,52};
        tournamentSort(nums);
        for(int i=0;i<nums.length;i++)
            System.out.print(nums[i]+" ");
    }
}
