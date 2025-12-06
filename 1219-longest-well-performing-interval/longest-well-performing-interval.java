class Solution {
    public int longestWPI(int[] hours) 
    {int n=hours.length;
        int nums[]=new int[hours.length];int sum=0;int maxlen=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
          sum+=hours[i]>8?1:-1;
          if(sum>0)
          {
            maxlen=i+1;
          }
          else
          {
            if(map.containsKey(sum-1))
            {maxlen = Math.max(maxlen, i - map.get(sum - 1));}
          }
          map.putIfAbsent(sum, i);
          
        }
        return maxlen;
    }
}