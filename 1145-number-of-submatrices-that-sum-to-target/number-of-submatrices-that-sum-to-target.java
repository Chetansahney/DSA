class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int k) 
    {
        int rows=matrix.length;
        int col=matrix[0].length;
      
      //cumulative sum calculation row wise
        for(int i=0;i<rows;i++)
        {
            for (int j=1;j<col;j++)
            {
                matrix[i][j]+=matrix[i][j-1];
            }
        }

       // finding the target==sum row wise downwards (leetcode 560)
       int count=0;
       for(int sc=0;sc<col;sc++)
       {
        for(int j=sc;j<col;j++)
        {
            HashMap<Integer,Integer> map=new HashMap<>();
            map.put(0,1);
            int sum=0;
            for(int row=0;row<rows;row++)
            {
                sum+=matrix[row][j]-(sc>0?matrix[row][sc-1]:0);
                if(map.containsKey(sum-k))
                {
                    count+=map.get(sum-k);
                }

                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
       }

       return count; 

    }
}