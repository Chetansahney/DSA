class Solution {
    public boolean isValidSerialization(String preorder) 
    {
      if(preorder==null)
      return false;

      Stack <String> st=new Stack<>();
      String nodes[]=preorder.split(",");
      for(int i=0;i<nodes.length;i++)
      {
        String curr=nodes[i];
        while(curr.equals("#") && !st.isEmpty() && st.peek().equals(curr))
        {
            st.pop();
            if(st.isEmpty())return false;

            st.pop();

        }
        st.push(curr);
      } 
      return st.size()==1 && st.peek().equals("#"); 
    }
}