public class StringRepeat {
    public static long repeatedString(String s, long n) {
        // determine number of strings
        // determine remainder
        // determine count of a in the string to repeat
        // determine positions of a?
        // divide s by n to find the count
        // modulo s by n to find the remainder
        // determine number of a's in remainder

        long length = s.length();
        long count = 0;
        long lastCount = 0;
        long times = 0;
        long remainder;
        char[] strings = s.toCharArray();

        times += Math.abs(n / length);
        remainder = n % length;

        for (int i = 0; i < length; i++) {
            char string = strings[i];
            if (string == 'a') {
                count++;
                if (remainder > i) {
                    lastCount++;
                }
            }
        }

        return (count * times) + lastCount;
    }
}
