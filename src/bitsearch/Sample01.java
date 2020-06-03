package bitsearch;

public class Sample01 {

    final private static int BIT_FLAG_0 = (1 << 0);
    final private static int BIT_FLAG_1 = (1 << 1);
    final private static int BIT_FLAG_2 = (1 << 2);
    final private static int BIT_FLAG_3 = (1 << 3);
    final private static int BIT_FLAG_4 = (1 << 4);
    final private static int BIT_FLAG_5 = (1 << 5);
    final private static int BIT_FLAG_6 = (1 << 6);
    final private static int BIT_FLAG_7 = (1 << 7);

    public static void main(String[] args) {
        // 1, 3, 5 にフラグの立ったビット
        int bit = BIT_FLAG_1 | BIT_FLAG_3 | BIT_FLAG_5;
        System.out.println("{1, 3, 5} = " + b(bit));

        if ((bit & BIT_FLAG_3) != 0) {
            System.out.println("3 is in     " + b(bit));
        }

        if ((bit & BIT_FLAG_0) == 0) {
            System.out.println("0 is not in " + b(bit));
        }

        int bit2 = BIT_FLAG_0 | BIT_FLAG_3 | BIT_FLAG_4;
        System.out.println(b(bit) + " AND " + b(bit2) + " = " + b(bit & bit2));
        System.out.println(b(bit) + " OR  " + b(bit2) + " = " + b(bit | bit2));

        System.out.println("before: " + b(bit));
        bit |= BIT_FLAG_6;
        System.out.println("after : " + b(bit) + " (6 included)");

        System.out.println("before: " + b(bit2));
        bit2 &= ~BIT_FLAG_3;
        System.out.println("after : " + b(bit2) + " (3 excluded)");
    }

    private static String b(final int bit) {
        final String s = "00000000" + Integer.toBinaryString(bit);
        return s.substring(s.length() - 8);
    }
}
