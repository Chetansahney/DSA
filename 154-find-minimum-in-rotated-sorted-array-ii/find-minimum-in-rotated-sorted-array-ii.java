class Solution {
    public int findMin(int[] arr) 
    {int n=arr.length;
      int l=0;int r=n-1;
        while(l<r&&arr[l]==arr[l+1])
        {
            l++;
        }
        while(l<r&&arr[r]==arr[r-1])
        {
            r--;
        }
        
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]>arr[r])
            {l=mid+1;}

            else
            {r=mid;}
        }
        return arr[r];  
    }
}