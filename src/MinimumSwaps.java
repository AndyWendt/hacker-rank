public class MinimumSwaps {
    static int minimumSwaps(int[] arr) {
        int length = arr.length;
        int swaps = 0;

        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < arr[min]) min = j;
            }

            if (arr[min] < arr[i]) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                swaps++;
            }
        }

        return swaps;
    }
}
