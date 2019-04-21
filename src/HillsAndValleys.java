public class HillsAndValleys {
    static int countingValleys(int n, String s) {
        char[] strings = s.toCharArray();
        int count = 0;
        int level = 0;
        boolean inValley = false;

        for (int i = 0; i < n; i++) {
            if (strings[i] == 'U') {
                level++;
                if (level >= 0 ) {
                    inValley = false;
                }
            } else if (strings[i] == 'D') {
                level--;
                if (level < 0 && !inValley) {
                    inValley = true;
                    count++;
                }
            }
        }

        return count;
    }
}
