class Solution {
    public int[] sortedSquares(int[] nums) 
    {
      int arr[]=new int[nums.length];int i=0;int j=nums.length-1;int idx=nums.length-1;

      while(i<=j)
      {
        int ls=nums[i]*nums[i];
        int rs=nums[j]*nums[j];
        if(ls<rs)
        {
            arr[idx]=rs;
            j--;
        }
        else
        {
            arr[idx]=ls;
            i++;
        }
        idx--;

      }
      return arr;  
    }
}