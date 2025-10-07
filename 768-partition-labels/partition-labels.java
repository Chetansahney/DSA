class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> lastIndex = new HashMap<>();

        // Step 1: Store last index of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        // Step 2: Traverse and find partitions
        int size = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            size+=1;
            end = Math.max(end, lastIndex.get(s.charAt(i))); // expand the end if needed

            // when current index reaches the end of current partition
            if (i == end) {
                result.add(size);
                size= 0; // next partition starts
            }
        }

        return result;
    }
}