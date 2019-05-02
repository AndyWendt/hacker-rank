import java.util.ArrayList;

public class MinimumSwaps {
    static int minimumSwaps(int[] arr) {
        int length = arr.length;
        int swaps = 0;

        for (int i = 0; i < length; i++) {
            // loop through the array and find the correct position for the
            // current element and swap it

            if (arr[i] != i + 1) {
                int correctKey = arr[i] - 1;
                int currentTemp = arr[i];
                int swapTemp = arr[correctKey];
                arr[correctKey] = currentTemp;
                arr[i] = swapTemp;
                int currentI = i;
                swaps++;

                if ((swapTemp - 1) != i) {
                    while (swapTemp < (i + 1)) {
                        correctKey = swapTemp - 1;
                        swapTemp = arr[correctKey];
                        currentTemp = arr[currentI];
                        arr[currentI] = swapTemp;
                        arr[correctKey] = currentTemp;
                        swaps++;

                        if ((swapTemp - 1) == currentI) {
                            break;
                        }
                    }
                }
            }

        }

        return swaps;
    }
}
