class Solution {
    public boolean circularArrayLoop(int[] nums) 
    {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0)
            continue;

            int slow=i,fast=i;

            while(true)
            {
                slow=next(nums,slow);//next index calculation for slow
                if (slow == -1) break;

                // move fast two steps
                fast = next(nums, fast);
                if (fast == -1) break;
                fast = next(nums, fast);
                if (fast == -1) break;

                if (slow == fast) return true; // cycle detected
            }

            // mark all nodes along this path as visited
            int j = i;
            while (nums[j] != 0) {
                int next = next(nums, j);
                nums[j] = 0;
                if (next == -1) break;
                j = next;
            }
        }

        return false;
    }

    private int next(int[] nums, int current) {
        int n = nums.length;
        int nextIndex = (current + nums[current]) % n;
        if (nextIndex < 0) nextIndex += n; // handle negative wrap-around

        // stop if single-element loop
        if (nextIndex == current) return -1;

        // stop if direction changes
        if ((nums[nextIndex] > 0) != (nums[current] > 0)) return -1;

        return nextIndex;
    }
}