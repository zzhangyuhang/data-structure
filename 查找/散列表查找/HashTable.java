import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.LinkedList;

public class HashTable {
    private LinkedList[] table;
    public HashTable(){
        table=null;
    }
    public HashTable(int m){  //初始化
        table = new LinkedList[m];
        for(int i=0;i<m;i++)
            table[i]= new LinkedList<Integer>();
    }
    public int hash(int key){  //生成散列地址
        return key % table.length;
    }
    public void insert(Integer element){  //插入
        int key = hash(element); //生成散列地址
        table[key].addFirst(element); //插入到地址链表的头部
    }
    public void displayTable(){  //输出hashtable中的数据
        for(int i=0;i<table.length;i++){
            System.out.print(i+": ");
            for(Object it : table[i])
                System.out.print(it+" ");
            System.out.println();
        }
    }
    public Object search(Integer element){  //查找
        int key = hash(element);
        int index = table[key].indexOf(element);
        if(index>=0)
            return table[key].get(index);   //查找成功，返回该数据值
        else
            return null;  //查找失败，返回null
    }
    public boolean contains(Integer element){  //是否包含
        return search(element)!=null;
    }
    public void remove(Integer element){ //删除
        int key = hash(element);
        table[key].remove(element);
    }
    public static void main(String args[]){
        HashTable hashTable = new HashTable(5);
        hashTable.insert(6);
        hashTable.insert(3);
        hashTable.insert(9);
        hashTable.insert(11);
        hashTable.insert(13);
        hashTable.insert(23);

        hashTable.displayTable();
        System.out.println(hashTable.search(11));
        System.out.println(hashTable.contains(11));
        hashTable.remove(11);
        hashTable.displayTable();
    }
}
