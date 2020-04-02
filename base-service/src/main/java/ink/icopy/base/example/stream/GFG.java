package ink.icopy.base.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author lizhengguang
 */
public class GFG {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 6, 7, 8, 9);
        boolean answer = list.stream().anyMatch(n -> (n * (n + 1)) / 4 == 5);
        System.out.println(answer);

        Stream<String> stream = Stream.of("Geeks", "fOr", "GEEKSQUIZ", "GeeksforGeeks");
        boolean answer1 = stream.anyMatch(str -> Character.isUpperCase(str.charAt(1)));
        System.out.println(answer1);
    }
}
