class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }

        int ans = 0;

        for (List<Integer> list : map.values()) {
            int start = 0;
            for (int right = 0; right < list.size(); right++) {
                while (list.get(right) - list.get(start) - (right - start) > k) {
                    start++;
                }
                ans = Math.max(ans, right - start + 1);
            }
        }

        return ans;
    }
}