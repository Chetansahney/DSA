class Solution {
    public void reverseString(char[] s) 
    {for(int i=0;i<(s.length/2);i++)
    {
        char c=s[i];
        s[i]=s[s.length-i-1];
        s[s.length-i-1]=c;
    }
    for(int i=0;i<s.length;i++)
    {
        System.out.print(s[i]);
    }
        
    }
}