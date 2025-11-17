//same as 560,930,1074
class Solution {
    public int findMaxLength(int[] nums) {
       HashMap <Integer, Integer> map=new HashMap<>();
       map.put(0,-1);int sum=0;int length=0;
       for(int i=0;i<nums.length;i++)
       {
        if(nums[i]==0)
        {
            sum+=-1;//replaced 0 with -1
        }
        else
        {
            sum+=1;
        }
        if(!map.containsKey(sum))
        {
            map.put(sum,i);
        }
        else
        {
            length=Math.max(i-map.get(sum),length);//if that sum already exist,then find the length of the index 
        }
        
       }
       return length;
    }
}