class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int best = 0;

        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int area = h * (r - l);
            if (area > best) best = area;

            // Move the pointer at the shorter line
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return best;
    }
}
