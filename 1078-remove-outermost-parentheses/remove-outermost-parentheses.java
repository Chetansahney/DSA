class Solution {
    public String removeOuterParentheses(String s) {
        Scanner sc=new Scanner(System.in);
        int n=s.length();
        int count=0;int start=0;
        String wrd="";
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);

            if(c=='(')
            {
                count+=1;

            }
            else
            count-=1;

            if(count==0)
            {
                wrd=wrd+s.substring(start+1,i);
                start=i+1;
            }

        }
        return wrd;
    }
}