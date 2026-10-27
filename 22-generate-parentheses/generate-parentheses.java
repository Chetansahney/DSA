class Solution {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n-- ==1) return List.of("()");
        generate(n,n,"(");
        return res;
    }

    private void generate(int open,int close,String s)
    {
        if(open==0 && close==0)
        {
            res.add(s + ")");
            return;
        }

        if(open>0)
        generate(open-1,close,s + "(");

        if(close>0 && close>=open)
        generate(open,close-1,s + ")");
    }
}