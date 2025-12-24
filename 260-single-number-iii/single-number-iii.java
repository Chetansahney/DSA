class Solution {
    public int[] singleNumber(int[] nums) 
    {
       int xorr=0;
       for(int num: nums)
       {
        xorr^=num;
       }
       //mask= search right most set bit
       int mask=xorr&(-xorr);
       int groupa=0;
       int groupb=0;

       for(int num:nums)
       {
        if((num & mask)!=0)
        {
            groupa^=num;
        }
        else
        {
            groupb^=num;
        }
       }
       int arr[]={groupa,groupb};
       return arr ;
           
    }
}