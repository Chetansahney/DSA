class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] map = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        while (num != 0 && sb.length() < 8) {
            int digit = num & 15;  // Get last 4 bits
            sb.append(map[digit]);
            num >>>= 4;  // Unsigned right shift
        }

        return sb.reverse().toString();
    }
}
