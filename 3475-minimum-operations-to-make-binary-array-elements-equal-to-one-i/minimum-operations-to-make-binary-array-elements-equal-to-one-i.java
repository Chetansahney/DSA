class Solution {
    public int minOperations(int[] nums) 
    {
        int flipcount = 0;
        int flips = 0;
        boolean[] flipped = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {

            // remove expired flip effect
            if (i >= 3 && flipped[i - 3]) {
                flipcount--;
            }

            // if current effective bit is 0, we must flip
            if ((nums[i] ^ (flipcount % 2)) == 0) {

                if (i + 3 > nums.length) return -1;

                flips++;
                flipcount++;
                flipped[i] = true;
            }
        }

        return flips;
    }
}