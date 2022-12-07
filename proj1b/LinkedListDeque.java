
/**
 * Created by le
 */
public class LinkedListDeque <T> implements Deque<T>{
    private class Node{
        T item;
        Node next;
        Node prev;
        public Node(T t,Node n,Node p){
            item = t;
            next = n;
            prev = p;
        }
    }
    private int size;
    private Node sentinel1 ,sentinel2 ;
    public LinkedListDeque(){
        sentinel1 = new Node(null,null,null);
        sentinel2 = new Node(null,null,null);
        sentinel1.next = sentinel2;
        sentinel2.prev = sentinel1;
        size = 0;
    }
    public void addFirst(T item){
        sentinel1.next = new Node(item,sentinel1.next,sentinel1);
        sentinel1.next.next.prev = sentinel1.next;
        size +=1;
    }
    public void addLast(T item){
        sentinel2.prev = new Node(item,sentinel2,sentinel2.prev);
        sentinel2.prev.prev.next = sentinel2.prev;
        size +=1;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Node p = sentinel1.next;
        while(p.next!=null&&p.next.item!=null){
            System.out.print(p.item+" ");
            p = p.next;
        }
        System.out.println(p.item);
    }
    public T removeFirst(){
        if(sentinel1.next == sentinel2){
            return null;
        }
        Node p = sentinel1.next;
        sentinel1.next = p.next;
        p.next.prev = sentinel1;
        size -=1;
        return p.item;
    }
    public T removeLast(){
        if(sentinel2.prev == sentinel1){
            return null;
        }
        Node p = sentinel2.prev;
        sentinel2.prev = p.prev;
        p.prev.next = sentinel2;
        size -= 1;
        return p.item;
    }
    public T get(int index){
        if(index > size-1&& index<0){
            return null;
        }
        int i = 0;
        Node p = sentinel1.next;
        while (i<index){
            p = p.next;
            i++;
        }
        return p.item;
    }
    public T getRecursive(int index){
        if(index > size-1&& index<0){
            return null;
        }
        return getRecursive(0,index,sentinel1.next);
    }
    private T getRecursive(int start,int index,Node x){
        if(start == index)
            return x.item;
        return getRecursive(start+1,index,x.next);
    }


}