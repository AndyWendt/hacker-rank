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
            int nextIndex = i + 1;
            int distance = currentCorrectIndex - i;

            if (distance > 2) {
                System.out.print("Too chaotic");
                return;
            }

            if (currentCorrectIndex == i) {
                continue;
            }

            if (nextIndex >= q.length) {
                continue;
            }

            int nextValue = q[nextIndex];

            // while current is not in position
            if (currentValue > nextValue) {
                q[i] = nextValue;
                q[nextIndex] = currentValue;
                swaps++;
                continue;
            }

            int currentForwardIndex = i;

            // process forward nodes since currentValue doesn't equal
            while (true) {
                currentValue = q[i];
                currentCorrectIndex = (currentValue - 1);
                int currentForwardValue = q[currentForwardIndex];
                int correctCurrentForwardIndex = (currentForwardValue - 1);
                int nextForwardIndex = currentForwardIndex + 1;
                int currentForwardDistance = correctCurrentForwardIndex - currentForwardIndex;

                if (currentForwardDistance > 2) {
                    System.out.print("Too chaotic");
                    return;
                }

                if (currentCorrectIndex == i) {
                    break;
                }

                if (nextForwardIndex >= q.length) {
                    currentForwardIndex = i;
                    continue;
                }

                int nextForwardValue = q[nextForwardIndex];

                // while current is not in position
                if (currentForwardValue > nextForwardValue) {
                    q[currentForwardIndex] = nextForwardValue;
                    q[nextForwardIndex] = currentForwardValue;
                    swaps++;
                    continue;
                }

                if ((currentForwardIndex + 1) < length) {
                    currentForwardIndex++;
                    continue;
                }

                currentForwardIndex = i;
                continue;
            }
        }

        System.out.print(swaps);
    }
}
