class Solution {
    public boolean hasSameDigits(String s) {
        // Continue until string length becomes 2
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();

            for (int i = 0; i < s.length() - 1; i++) {
                int num1 = s.charAt(i) - '0';       // Convert char → int
                int num2 = s.charAt(i + 1) - '0';   // Convert char → int
                int sum = (num1 + num2) % 10;       // Sum modulo 10
                next.append((char)(sum + '0'));     // Convert back to char
            }

            s = next.toString(); // Update string
        }

        // Check if final two digits are equal
        return s.charAt(0) == s.charAt(1);
    }
}
