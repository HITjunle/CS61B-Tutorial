/**
 * Created by le
 */
public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque =new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addFirst(1);
        ArrayDeque.get(0)    ;
        ArrayDeque.removeFirst()     ;
        ArrayDeque.addFirst(4);
        ArrayDeque.removeLast()    ;
        ArrayDeque.addFirst(6);
        ArrayDeque.get(1)    ;
        ArrayDeque.addLast(8);
        ArrayDeque.removeFirst()     ;
        ArrayDeque.addLast(10);
        ArrayDeque.get(1) ;
        ArrayDeque.addFirst(12);
        ArrayDeque.addLast(13);
        ArrayDeque.addFirst(14);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(16);
        ArrayDeque.addLast(17);
        ArrayDeque.addFirst(18);
        ArrayDeque.get(5) ;
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(21);
        ArrayDeque.addLast(22);
        ArrayDeque.removeFirst();
        System.out.println(ArrayDeque.get(7));
        ArrayDeque.printDeque();
    }
}
