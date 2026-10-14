class Solution {
    public int[] productExceptSelf(int[] nums) 
    {
     int output[]=new int[nums.length];
     int prod1=1;int prod2=1;
     output[0]=1;int n=nums.length;
     for(int i=1;i<n;i++)
     {
        
        output[i]=output[i-1]*nums[i-1];
     } 
     for(int i=n-1;i>=0;i--)
     {
      
        output[i]=output[i]*prod2;
          prod2=prod2*nums[i];
     }
     return output;  
    }
}