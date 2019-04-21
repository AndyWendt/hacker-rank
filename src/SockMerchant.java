import java.util.HashMap;

public class SockMerchant {
    public static int calcPairs(int n, int[] ar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer currentCount = map.get(ar[i]) == null ? 1 : map.get(ar[i]) + 1;
            if ((currentCount % 2) == 0) {
                count += (currentCount / 2);
                map.put(ar[i], 0);
            } else {
                map.put(ar[i], currentCount);
            }
        }

        return count;
    }
}
