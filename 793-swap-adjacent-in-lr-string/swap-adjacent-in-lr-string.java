class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            // skip X's
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            // both reached end
            if (i == n && j == n) return true;
            if (i == n || j == n) return false;

            // check if same char
            if (start.charAt(i) != end.charAt(j)) return false;

            // check movement rule
            if (start.charAt(i) == 'L' && i < j) return false; // L cannot move right
            if (start.charAt(i) == 'R' && i > j) return false; // R cannot move left

            i++;
            j++;
        }

        return true;
    }
}
