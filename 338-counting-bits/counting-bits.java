class Solution {

    // Recursive function to count number of 1's in binary
    int countOnes(int num) {
        if (num == 0) return 0;
        return (num % 2) + countOnes(num / 2);
    }

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = countOnes(i);
        }
        return arr;
    }
}
