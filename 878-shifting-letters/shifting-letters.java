class Solution {
    public String shiftingLetters(String s, int[] shifts) 
    {int postfix[]=new int[shifts.length];
    postfix[shifts.length-1]=shifts[shifts.length-1];
     for(int i=shifts.length-2;i>=0;i--)
     {
        postfix[i]=(postfix[i+1]+shifts[i])%26;
     }  

     StringBuilder result=new StringBuilder();
     for(int i=0;i<shifts.length;i++)
     {
        int newChar = ((s.charAt(i) - 'a') + postfix[i]) % 26;
            result.append((char) (newChar + 'a'));
     }

     return result.toString(); 
    }
}