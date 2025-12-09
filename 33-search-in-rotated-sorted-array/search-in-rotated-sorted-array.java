class Solution {
    int findpivot(int arr[],int n)
    {
        int l=0;int r=n-1;
        while(l<r)
        {
            int mid=l+(r-l)/2;
            if(arr[mid]>arr[r])
            {l=mid+1;}

            else
            {r=mid;}
        }
        return r;
    }
    int binsearch(int s,int e, int arr[],int k)
    { 
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(arr[mid]==k)
            {
                return mid;
            }
            else if(arr[mid]<k)
            {
                s=mid+1;
            }
            else
            {
                e=mid-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) 
    {
      int n=nums.length;
      int pivot=findpivot(nums,n);

      int idx=binsearch(0,pivot-1,nums,target);
      if(idx!=-1)
      return idx;

      idx=binsearch(pivot,n-1,nums,target);
      return idx;  
    }
}