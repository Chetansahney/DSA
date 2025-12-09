class Solution {
    int findleft(int nums[],int target,int n)
    {
        int left=-1;
        int l=0;int r=n-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                left=mid;
                r=mid-1;
            }
            else if(nums[mid]<target)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return left;
    }
    int findright(int nums[],int target,int n)
    {
        int right=-1;
        int l=0;int r=n-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==target)
            {
                right=mid;
                l=mid+1;
            }
            else if(nums[mid]<target)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return right;
    }
    public int[] searchRange(int[] nums, int target) 
    {
        int n=nums.length;
        int leftmost=findleft(nums,target,n);
        int rightmost=findright(nums,target,n);
        int array[]={leftmost,rightmost};
        return array;
    }
      
}