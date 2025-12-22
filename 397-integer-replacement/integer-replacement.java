class Solution {
    public int integerReplacement(int num) 
    {long n=num;
        int steps=0;
        while(n!=1)
        {
            if(n%2==0)
            {
                n>>=1;
            }
            else
            {
                if(n==3)
                n--;
                else if(n%4==1)
                {
                    n--;
                }
                else
                n++;
            }
            steps++;
        }
        return steps;


    }
}