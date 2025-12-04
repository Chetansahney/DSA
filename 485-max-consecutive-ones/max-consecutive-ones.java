class Solution {
    public int findMaxConsecutiveOnes(int[] nums) 
    {
      int count=0;int flag=0;
      for(int i=0;i<nums.length;i++)
      {
        if(nums[i]!=0)
        {
            count++;
        }
        else
        { 
            count=0;
        }
        flag = Math.max(flag, count);

      }return flag;  
    }
}