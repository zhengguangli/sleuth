package ink.icopy.base.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lizhengguang
 */
public class GFG {
    public static void main(String[] args) {
//        arrSort();
//        alSort();
//        arrReverse();
//        alReverse();
//        arrSubSort(args);
    }

    private static void arrSubSort(String[] args) {
        int[] arr = {13, 7, 6, 45, 21, 9, 2, 100};
        Arrays.sort(args, 1, 5);
        System.out.printf("Modified arr[] : %s",
                Arrays.toString(arr));
    }

    private static void alReverse() {
        ArrayList<String> al = new ArrayList<>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");
        Collections.sort(al, Collections.reverseOrder());
        System.out.println("List after the use of"
                + " Collection.sort() :\n" + al);
    }

    private static void arrReverse() {
        Integer[] arr = {13, 7, 6, 45, 21, 9, 2, 100};
        Arrays.sort(arr, Collections.reverseOrder());
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
    }

    private static void alSort() {
        List<String> al = new ArrayList<>();
        al.add("Geeks For Geeks");
        al.add("Friends");
        al.add("Dear");
        al.add("Is");
        al.add("Superb");

        Collections.sort(al);
        System.out.printf("List after the use of" + " Collection.sort() :\n" + al);
    }

    private static void arrSort() {
        int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
        // 自然排序
        Arrays.sort(arr);
        System.out.printf("Modified arr[] : %s", Arrays.toString(arr));
    }
}
