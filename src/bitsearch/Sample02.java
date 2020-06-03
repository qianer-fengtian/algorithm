package bitsearch;

public class Sample02 {

    private final static int BIT_FLAG_DAMAGE    = (1 << 0);
    private final static int BIT_FLAG_DOKU      = (1 << 1);
    private final static int BIT_FLAG_MAHI      = (1 << 2);
    private final static int BIT_FLAG_SENTOFUNO = (1 << 3);

    private final static int MASK_ATTACK    = BIT_FLAG_DAMAGE;
    private final static int MASK_PUNCH     = BIT_FLAG_DAMAGE | BIT_FLAG_MAHI;
    private final static int MASK_DEFEAT    = BIT_FLAG_DAMAGE | BIT_FLAG_SENTOFUNO;
    private final static int MASK_DOKU_MAHI = BIT_FLAG_DOKU   | BIT_FLAG_MAHI;

    public static void main(String[] args) {
        int status = 0;
        System.out.println("start: " + b(status));

        status |= MASK_ATTACK;
        System.out.println("attacked: " + b(status));

        status |= MASK_PUNCH;
        System.out.println("punched: " + b(status));

        if ((status & MASK_DOKU_MAHI) != 0) {
            System.out.println("You are doku or mahi.");
        }

        status &= ~MASK_DOKU_MAHI;
        System.out.println("kaifuku: " + b(status));

        status |= MASK_DEFEAT;
        System.out.println("sentofuno: " + b(status));

        status &= ~MASK_DOKU_MAHI;
        System.out.println("sentofuno no mama: " + b(status));
    }

    private static String b(final int bit) {
        final String s = "0000" + Integer.toBinaryString(bit);
        return s.substring(s.length() - 4);
    }
}
