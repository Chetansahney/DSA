class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;   // next position to write into chars
        int i = 0;       // start of current run

        while (i < n) {
            char c = chars[i];
            int j = i;

            // advance j to end of this run of c
            while (j < n && chars[j] == c) j++;

            // write the character once
            chars[write++] = c;  // safe because compressed length never exceeds n

            int count = j - i;
            if (count > 1) {
                // write each digit of the count
                String s = Integer.toString(count);
                for (int k = 0; k < s.length(); k++) {
                    chars[write++] = s.charAt(k); // still safe (443 guarantees compressed length <= n)
                }
            }

            // move to next run
            i = j;
        }
        return write;
    }
}
