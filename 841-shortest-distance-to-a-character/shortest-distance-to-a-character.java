class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] answer = new int[n];
        Arrays.fill(answer, Integer.MAX_VALUE);

        // Left to right pass
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
                answer[i] = 0;
            } else if (prev != -1) {
                answer[i] = i - prev;
            }
        }

        // Right to left pass
        prev = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
                answer[i] = 0;
            } else if (prev != -1) {
                answer[i] = Math.min(answer[i], prev - i);
            }
        }

        return answer;
    }
}
