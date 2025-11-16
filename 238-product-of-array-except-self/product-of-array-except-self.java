class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
     int output[]=new int[nums.length];
     int prod1=1;int prod2=1;
     output[0]=1;int n=nums.length;
     for(int i=0;i<n-1;i++)
     {
        prod1=prod1*nums[i];
        output[i+1]=prod1;
     } 
     for(int i=n-1;i>=1;i--)
     {
        prod2=prod2*nums[i];
        output[i-1]=output[i-1]*prod2;
     }
     return output;  
    }
}