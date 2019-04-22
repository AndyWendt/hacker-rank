
public class ArrayLeftRotation {
    static int[] rotLeft(int[] a, int d) {
        if (d == a.length) {
            return a;
        }

        int[] out = new int[a.length];

        if (d > a.length) {
            d = d % a.length;
        }

        int newKey;
        for (int i = 0; i < a.length; i++) {
            newKey = i - d;
            if (newKey < 0) {
                newKey = a.length - (newKey * -1);
            }

            out[newKey] = a[i];
        }

        return out;
    }
}
