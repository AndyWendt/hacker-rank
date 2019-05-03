import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {
    static void minimumBribes(int[] q) {
        // loop through the int[]
        int swaps = 0;
        int length = q.length;

        for (int i = 0; i < length; i++) {
            int currentValue = q[i];
            int currentCorrectIndex = (currentValue - 1);
            int distance = currentCorrectIndex - i;

            if (distance > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(currentCorrectIndex - 1, 0); j < i; j++) {
                if (q[j] > currentCorrectIndex) {
                    swaps++;
                }
            }
        }

        System.out.println(swaps);
    }
}
