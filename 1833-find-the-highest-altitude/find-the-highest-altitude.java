class Solution {
    public int largestAltitude(int[] gain) 
    {
      int sum=0;int maxsum=0;
      for(int alt:gain)
      {
        sum+=alt;
        maxsum=Math.max(maxsum,sum);
      }  return maxsum;
    }
}