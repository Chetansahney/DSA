class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int mask = 0;

        // from most significant bit (31) to least (0)
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> prefixes = new HashSet<>();

            for (int num : nums) {
                prefixes.add(num & mask);  // keep only top bits up to i
            }

            int candidate = maxXor | (1 << i);  // try to set current bit to 1

            for (int prefix : prefixes) {
                // If there exists two prefixes with XOR = candidate, this bit can be 1
                if (prefixes.contains(prefix ^ candidate)) {
                    maxXor = candidate;
                    break;
                }
            }
        }
        return maxXor;
    }
}
