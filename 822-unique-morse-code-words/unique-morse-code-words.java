import java.util.*;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", 
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };
        
        HashSet<String> set = new HashSet<>();
        
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray()) {
                code.append(morse[c - 'a']);
            }
            set.add(code.toString());
        }
        
        return set.size();
    }
}
