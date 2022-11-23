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
        first = 0;
        last = 0;
    }
    public void addFirst(T item){
        items[first] = item;
        if(first <=0){
            first = (first+7)%8;
        }
        else {
            first =(first-1)%8;
        }
        size+=1;
    }
    public void addLast(T item){
        last = (last+1)%8;
        items[last] = item;
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
        while (i!=last){
            i++;
            i=i%8;
            System.out.println(items[i]);
        }
    }
    public T removeFirst(){
        T t = items[first+1];
        items[first+1] = null;
        first =(first+1)%8;
        size -=1;
        return t;
    }
    public T removeLast(){
        T t = items[last];
        items[last] = null;
        if(last <= 0){
            last = last+7;
        }
        else {
        last = (last-1)%8;}
        size -=1;
        return t;
    }
    public T get(int index){
        return items[(first+index+1)%8];
    }


}
