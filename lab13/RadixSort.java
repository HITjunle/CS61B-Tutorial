import java.util.Arrays;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     * @return String[] the sorted array
     */
    static int[][] start1;
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        String[] sorted = new String[asciis.length];
        System.arraycopy(asciis, 0, sorted, 0, asciis.length);
        int maxLength = 0;
        for (int i = 0; i < asciis.length; i++) {
            maxLength = maxLength > asciis[i].length() ? maxLength : asciis[i].length();
        }
        for (int i = maxLength - 1; i >= 0; i--) {
            sortHelperLSD(sorted, i);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     *
     * @param asciis Input array of Strings
     * @param index  The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] count = new int[257];
        String[] sorted = new String[asciis.length];
        for (String ascii : asciis) {
            int i = charATAscii(ascii, index);
            count[i] += 1;
        }
        int pos = 0;
        int[] start = new int[257];

        for (int i = 0; i < start.length; i++) {
            start[i] = pos;
            pos += count[i];
        }
        for (int i = 0; i < asciis.length; i++) {
            String s = asciis[i];
            int place = start[charATAscii(s, index)];
            sorted[place] = s;
            start[charATAscii(s, index)] += 1;
        }
        System.arraycopy(sorted, 0, asciis, 0, asciis.length);
    }

    private static int charATAscii(String s, int index) {
        if (index < s.length() && index >= 0)
            return s.charAt(index) + 1;
        else
            return 0;


    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start  int for where to start sorting in this method (includes String at start)
     * @param end    int for where to end sorting in this method (does not include String at end)
     * @param index  the index of the character the method is currently sorting on
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index,int[][]start1) {
        // Optional MSD helper method for optional MSD radix sort
        int maxLength = 0;
        for (int i = 0; i < asciis.length; i++) {
            maxLength = maxLength > asciis[i].length() ? maxLength : asciis[i].length();
        }
        int[][] count = new int[257][maxLength];
        String[] sorted = new String[asciis.length];
        for (int i = start; i <= end;i++){
            count[charATAscii(asciis[i],index)][index] += 1;
        }
        int pos = start;
        for (int i = 0; i < start1.length; i++) {
            start1[i][index] = pos;
            pos += count[i][index];
        }
        for (int i = start; i <= end; i++) {
            String s = asciis[i];
            int place = start1[charATAscii(s, index)][index];
            sorted[place] = s;
            start1[charATAscii(s, index)][index] += 1;
        }
        for (int i = start;i<end+1;i++)
            asciis[i] = sorted[i];

    }
    private static String[] MSD(String[] asciis) {
        String[] s =  Arrays.copyOf(asciis,asciis.length);
        int maxLength = 0;
        for (int i = 0; i < asciis.length; i++) {
            maxLength = maxLength > asciis[i].length() ? maxLength : asciis[i].length();
        }
        int index = 0;
        int[][] start1 = new int[257][maxLength];
        sortHelperMSD(asciis,0,asciis.length-1,0,start1);
        for (int j = 0;j < start1.length-1;j++)
            for (int i = 1; i < maxLength; i++) {
                if (start1[j][i - 1] == start1[j + 1][i - 1])
                    break;
                sortHelperMSD(asciis, start1[j][i - 1], start1[j + 1][i - 1]-1, i, start1);
            }
        return s;
    }

    public static void main(String[] args) {
        String[] ss = {"a11","gh1","b23","b4","c2","A333"};
        String[] s = MSD(ss);
    }
}
