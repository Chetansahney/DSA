class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int papers = n - mid;   // number of papers with ≥ citations[mid]

            if (citations[mid] >= papers) {
                // mid is a valid h-index candidate → try to go left for a larger h
                r = mid - 1;
            } else {
                // citations too small → move right
                l = mid + 1;
            }
        }

        // l stops at the first index where citations[l] >= n - l
        return n - l;
    }
}
