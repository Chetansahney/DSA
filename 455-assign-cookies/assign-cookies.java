import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); // sort greed factors
        Arrays.sort(s); // sort cookie sizes
        
        int i = 0; // child pointer
        int j = 0; // cookie pointer
        int count = 0;
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {  
                // cookie j can satisfy child i
                count++;
                i++; // move to next child
                j++; // move to next cookie
            } else {
                j++; // try next larger cookie
            }
        }
        return count;
    }
}
