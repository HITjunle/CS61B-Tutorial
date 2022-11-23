/**
 * Created by le
 */
public class ArrayDeque<T>{
    private T[] items;
    private int size;
    private int first;
    private int last;
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        first = items.length-1;
        last = 0;
    }
    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items,0,a,0,items.length);
        first = a.length-1;
        last = items.length;
        items = a;
    }
    public void addFirst(T item){
        if(items.length ==size)
            resize(items.length*2);
        items[first] = item;
        if(first <=0){
            first = (first+ items.length-1)%(items.length);
        }
        else {
            first =(first-1)%(items.length);
        }
        size+=1;
    }
    public void addLast(T item){
        if(items.length ==size)
            resize(items.length*2);
        items[last] = item;
        last = (last+1)%(items.length);
        size+=1;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int i = first;
        while (i!=last-1){
            i++;
            i=i%(items.length);
            System.out.print(items[i]+" ");
        }
    }
    public T removeFirst(){
        first = (first+1)% items.length;
        if(items[first]==null)
            return null;
        T t = items[first];
        items[first] = null;
        size -=1;
        return t;
    }
    public T removeLast(){
        if(last <= 0){
            last = last+items.length;
        }
        else {
            last = (last-1)%(items.length);}
        if(items[last]==null)
            return null;
        T t = items[last];
        items[last] = null;
        size -=1;
        return t;
    }
    public T get(int index){
        if(index>=size)
            return null;
        return items[(first+index+1)%(items.length)];
    }

}
