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

            int currentForwardIndex = nextIndex;

            // process forward nodes since currentValue doesn't equal
            while (true) {
                int currentForwardValue = q[currentForwardIndex];
                int correctCurrentForwardIndex = (currentForwardValue - 1);
                int nextForwardIndex = currentForwardIndex + 1;
                int currentForwardDistance = correctCurrentForwardIndex - currentForwardIndex;

                if (currentForwardDistance > 2) {
                    System.out.print("Too chaotic");
                    return;
                }

                if (correctCurrentForwardIndex == currentForwardIndex) {
                    break;
                }

                if (nextForwardIndex >= q.length) {
                    currentForwardIndex = nextIndex;
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

                currentForwardIndex = nextIndex;
                continue;
            }



            // process each node individually
            // look ahead as needed

//            // look for violation: too many bribes, going the wrong way
//            if (distance > 2) {
//                System.out.print("Too chaotic");
//                return;
//            }
//
//            // ... unfortunately distance != swaps
//            // change the input array back to the original to check the swaps
//            if (distance > 0) {
//                swaps += distance;
//            }
        }

        System.out.print(swaps);
    }
}
