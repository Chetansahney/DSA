class Solution {
    public int hammingDistance(int x, int y) 
    {
      int count=0;
      int d=x^y;
      while(d!=0)
      {
        d&=d-1;
        count++;
      }  
      return count;
    }
}