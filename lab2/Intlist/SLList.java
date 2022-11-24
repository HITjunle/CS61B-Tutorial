/**
 * Created on 2022-11-4
 */
public class SLList implements {

    private IntNode first;
    /** the first item (if it exists) is at sentinel.next
     *
     */
    public IntNode sentinel;
    public IntNode last;
    public int size;
    public SLList() {
        sentinel =new IntNode(63,null, null);
        last=sentinel;
        size=0;
    }
    public SLList(int x){
        sentinel=new IntNode(63,null,null);
        sentinel.next=new IntNode(x,null,sentinel);
        last=sentinel.next;
        size=1;
    }
    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next=new IntNode(x,sentinel.next,sentinel);
        size+=1;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }
    public void addlast(int x)
    {
        last.next=new IntNode(x,null,last);
        last=last.next;
        size+=1;
    }
    public void insert(int item, int position){
        int i=0;
        IntNode ptr=sentinel;
        while(i!=position){
            ptr=ptr.next;
            i++;
        }
        ptr.next=new IntNode(item,ptr.next,ptr);
        if(position==size-1)
            last=ptr.next;
        size+=1;
    }
    public void printList(){
        IntNode ptr=sentinel;
        do
        {
            ptr=ptr.next;
            System.out.println(ptr.item);
        }while (ptr.next!=null);
    }
    public int getlast()
    {
        return last.item;
    }
    /**
     *
     * return the size of the list that starts at IntNode p;
     */

    /** remove the last node of the list
     */
    public void removeLast()
    {
        last.prev.next=null;
        last=last.prev;
    }

    public SLList reverse(){
        SLList Rl=new SLList();
        IntNode ptr=sentinel;
        while(ptr.next!=null){
            ptr=ptr.next;
            Rl.addFirst(ptr.item);
        }
        return Rl;
    }
    private int size(IntNode p){
        if(p.next==null)
            return 1;
        else
            return 1+size(p.next);
    }
    public int size(){
        return size(first);
    }
    public static void main(String[] args) {
        SLList L=new SLList(10);
        L.addFirst(5);
        L.addlast(20);
        L.addlast(29);
        L.removeLast();
        L.insert(3,3);
        L=L.reverse();
        L.printList();
    }
}
