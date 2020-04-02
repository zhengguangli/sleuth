package ink.icopy.base;

/**
 * @author lizhengguang
 */
public class Test {
    public static void main(String[] args) {
        switchTest("a");
    }

    public static int switchTest(String var1) {
        byte var3 = -1;
        switch (var1.hashCode()) {
            case 97:
                if (var1.equals("a")) {
                    var3 = 0;
                }
                break;
            case 98:
                if (var1.equals("b")) {
                    var3 = 1;
                }
        }

        switch (var3) {
            case 0:
                System.out.println("aa");
                return 11;
            case 1:
                System.out.println("bb");
                return 22;
            default:
                System.out.println("cc");
                return 33;
        }
    }
}
