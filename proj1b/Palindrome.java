/**
 * Created by le
 */
import java.util.LinkedList;
public class Palindrome extends LinkedList<Character> {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> D =new LinkedListDeque<>();
        for(int i= 0;i<word.length();i++){
            D.addLast(word.charAt(i));
        }
        return D;
    }
    /*
    public boolean isPalindrome(String word){
        if(word.length()==1 || word.length()==0)
            return true;
        int left = 0;
        int right = word.length()-1;
        while (left < right){
            if(word.charAt(left)!=word.charAt(right)){
                return false;
            }
            left+=1;
            right-=1;
        }
        return true;
    }

     */

    /*
    public boolean isPalindrome(String word){
        if(word.length()==1 || word.length()==0){
            return true;
        }
        return isPalindrome(word,0,word.length()-1);
    }
    private boolean isPalindrome(String word, int left, int right){
        if(right==left){
            return true;
        }
        if(word.charAt(left)==word.charAt(right))
        {
            return isPalindrome(word,left+1,right-1);
        }
        else
            return false;

    }
     */

    public boolean isPalindrome(String word){
        Deque<Character> D = wordToDeque(word);
        while (D.size()!=1 && D.size()!=0){
            if(D.removeFirst()!=D.removeLast())
                return false;
        }
        return true;

    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length()==1 || word.length()==0)
            return true;
        int left = 0;
        int right = word.length()-1;
        while (left < right){
            if(!cc.equalChars(word.charAt(left),word.charAt(right))){
                return false;
            }
            left+=1;
            right-=1;
        }
        return true;
    }
}
