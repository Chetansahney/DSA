class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1; // "122" has only one '1' in first 3

        int[] s = new int[n + 2]; // store magical string
        s[0] = 1; s[1] = 2; s[2] = 2;

        int head = 2;  // pointer for how many times to write next number
        int num = 1;   // next number to append (flip between 1 and 2)
        int count = 1; // initial count of '1's (only first element)

        int tail = 3;  // next insert position

        while (tail < n) {
            for (int k = 0; k < s[head]; k++) {
                s[tail] = num;
                if (num == 1 && tail < n) count++;
                tail++;
            }
            num = 3 - num; // flip 1 <-> 2
            head++;
        }

        return count;
    }
}
