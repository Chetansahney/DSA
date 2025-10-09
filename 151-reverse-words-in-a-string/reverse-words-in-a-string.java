class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim and convert to char array
        char[] chars = s.trim().toCharArray();
        int n = chars.length;

        // Step 2: Reverse the entire string
        reverse(chars, 0, n - 1);

        // Step 3: Reverse each word individually
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        // Step 4: Clean up multiple spaces between words
        return cleanSpaces(chars);
    }

    // Helper to reverse a portion of the array
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    // Helper to remove extra spaces and return clean string
    private String cleanSpaces(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;

        while (j < n) {
            // Skip spaces
            while (j < n && chars[j] == ' ') j++;

            // Copy word
            while (j < n && chars[j] != ' ') chars[i++] = chars[j++];

            // Skip spaces between words
            while (j < n && chars[j] == ' ') j++;

            // Add single space if not end
            if (j < n) chars[i++] = ' ';
        }

        return new String(chars, 0, i);
    }
}
