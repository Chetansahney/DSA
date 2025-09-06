class Solution {
    public int removeDuplicates(int[] ar) {
        int n = ar.length;
        if (n <= 2) return n;  // already valid

        int i = 2;  // index for placing next element
        for (int j = 2; j < n; j++) {
            if (ar[j] != ar[i - 2]) {
                ar[i] = ar[j];
                i++;
            }
        }
        return i;  // new length
    }
}
