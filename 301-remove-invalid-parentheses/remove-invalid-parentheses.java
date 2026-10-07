import java.util.*;

class Solution {
    int n, maxlen;
    Set<String> set = new HashSet<>();

    public void solve(String s, int i, String curr, int count) {
        if (count < 0) return;                     

        if (i == n) {
            if (count == 0) {                      
                if (curr.length() > maxlen) { maxlen = curr.length(); set.clear(); }
                if (curr.length() == maxlen) set.add(curr);
            }
            return;
        }

        char c = s.charAt(i);
        if (c != '(' && c != ')') {                
            solve(s, i + 1, curr + c, count);
            return;
        }

        solve(s, i + 1, curr + c, count + (c == '(' ? 1 : -1));  
        solve(s, i + 1, curr, count);                             
    }

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        set.clear();
        maxlen = 0;
        solve(s, 0, "", 0);
        return new ArrayList<>(set);
    }
}