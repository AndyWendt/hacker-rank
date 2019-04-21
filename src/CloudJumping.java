public class CloudJumping {
    public static int jumpingOnClouds(int[] c) {
        int moves = 0;
        int indexIncrease = 0;
        for (int i = 0; i < c.length; i += indexIncrease) {
            int leftIndex = i+1;
            int rightIndex = i+2;

            if (leftIndex >= c.length) {
                indexIncrease = 1;
                continue;
            }


            if (rightIndex >= c.length) {
                indexIncrease = 1;
                moves++;
                continue;
            }


            int left = c[leftIndex];
            int right = c[rightIndex];

            if (right != 1) {
                moves++;
                indexIncrease = 2;
            } else {
                moves++;
                indexIncrease = 1;
            }
        }

        return moves;
    }
}
