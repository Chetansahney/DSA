class Solution {
    public char nextGreatestLetter(char[] letters, char target) 
    {
      int l=0;int r=letters.length-1;int flag=0;
      while(l<=r)
      {
        int mid=l+(r-l)/2;
        if(letters[mid]>target)
        {
            flag=mid;
            r=mid-1;
        }
        else
        l=mid+1;
      } 

      return letters[flag]; 
    }
}