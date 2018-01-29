import javax.swing.plaf.synth.SynthEditorPaneUI;

public class CircleSqQueue implements IQueue {
    int front = 0 , rear = 0;
    Object[] queueElem ;
    int flag=0; //进出队标志，进对+1，出队-1，初始为0。
    public CircleSqQueue(){
        queueElem = new Object[10];
    }
    public CircleSqQueue(int maxSize){
        queueElem = new Object[maxSize];
    }
    @Override
    public void clear() {
        front=0;
        rear=0;
        flag=0;
    }

    @Override
    public boolean isEmpty() {  //当入队状态下的front==rear，为队列满
        return (front==rear)&&(flag==0||flag==-1);
    }

    @Override
    public int length() {  //因为是循环队列，所有需要+queueElem.length确保为正数，然后求余数
        return (rear-front+queueElem.length)%queueElem.length;
    }

    @Override
    public Object peek() {  //取队首元素
        return queueElem[front];
    }

    @Override
    public void offer(Object x) { //进队,队尾指针+1
        if((rear)%queueElem.length==front&&flag==+1)
            System.out.println("队列已满");
        else {
            queueElem[rear] = x;
            rear = (rear + 1) % queueElem.length;//因为是循环队列，需要求余
            flag = +1;
        }
    }

    @Override
    public Object poll() {  //出队
        if(this.isEmpty()){
            System.out.println("队列为空");
            return null;
        }
        else {
            Object temp = queueElem[front];
            front=(front+1)%queueElem.length;
            flag=-1;
            return temp;
        }
    }
    public void display(){
        for(int i=front;i<=rear;i=(i+1)%queueElem.length)
            System.out.print(queueElem[i]+" ");
        System.out.println();
    }
    public static void main(String args[]){
        CircleSqQueue queue = new CircleSqQueue();
        System.out.println(queue.isEmpty());
        System.out.println(queue.length());
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(queue.length());
        queue.offer("d");
        queue.offer("d");
        queue.offer("d");
        queue.offer("d");
        queue.offer("d");
        queue.offer("d");
        queue.offer("d");
        queue.offer("d");
        for(int i=0;i<10;i++)
            queue.poll();
        queue.poll();



    }
}
