public class MinimumSwaps {
    static int minimumSwaps(int[] arr) {
        int length = arr.length;
        int swaps = 0;
        //
        // Selection sort
        //

        // iterate through the array to sort the array
        // from smallest to largest
        for (int i = 0; i < length; i++) {
            // establish the minimum as the current iteration
            int min = i;

            // run through the array starting
            // from the outer loop plus one
            for (int j = i + 1; j < length; j++) {
                // the current min is greater than j
                if (arr[j] < arr[min]) min = j;
            }

            // make the swap if min is less than the current array
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
