class Solution {
    public int arrangeCoins(int n) {
        int i = 1;  // row number
        while (n >= i) { // if we have enough coins for this row
            n -= i;      // use i coins
            i++;         // move to next row
        }
        return i - 1;    // last full row
    }
}
