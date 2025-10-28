class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        // Create buckets: index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int f = freq.get(key);
            if (buckets[f] == null)
                buckets[f] = new ArrayList<>();
            buckets[f].add(key);
        }

        List<Integer> res = new ArrayList<>();
        // Start from most frequent
        for (int i = buckets.length - 1; i >= 0 && res.size() < k; i--) {
            if (buckets[i] != null)
                res.addAll(buckets[i]);
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++)
            ans[i] = res.get(i);

        return ans;
    }
}
