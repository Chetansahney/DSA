class Solution {
    public int numberOfBeams(String[] bank) 
    {
        int prev=count(0,bank);int sum=0;
        for(int k=1;k<bank.length;k++)
        {
            int curr=count(k,bank);
            if(curr>0)
            {
                sum=sum+(prev*curr);
                prev=curr;
            }
        }
        return sum;
    }
    public int count(int j, String b[])
    {
       String str=b[j];
       int l=str.length();int count=0;
       for(int i=0;i<l;i++)
       {
        if(str.charAt(i)=='1')
        count++;
       }

       return count;

    }
}