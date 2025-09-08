class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return;
        k %= n;
        if (k == 0) return;

        reverse(nums, 0, n - 1);   // whole array
        reverse(nums, 0, k - 1);   // first k
        reverse(nums, k, n - 1);   // remaining n-k
    }

    private void reverse(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l]; a[l] = a[r]; a[r] = t;
            l++; r--;
        }
    }
}
