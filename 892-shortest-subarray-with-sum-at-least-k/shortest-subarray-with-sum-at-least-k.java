class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        
        // Build prefix sum
        for (int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + nums[i];

        Deque<Integer> dq = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // Step 1: Check if current prefix allows valid subarray
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                result = Math.min(result, i - dq.peekFirst());
                dq.pollFirst();
            }

            // Step 2: Maintain increasing prefix sums (monotonic queue)
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[i])
                dq.pollLast();

            // Add index of current prefix sum
            dq.offerLast(i);
        }

        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
