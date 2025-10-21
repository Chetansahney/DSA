class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = new HashSet<>(Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> row2 = new HashSet<>(Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> row3 = new HashSet<>(Arrays.asList('z','x','c','v','b','n','m'));

        List<String> result = new ArrayList<>();Set<Character> row=new HashSet<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            char first = lower.charAt(0);
            if(row1.contains(first))
            {
                row=row1;
            }
            else if(row2.contains(first))
            {
                row=row2;
            }
            else
            {row=row3;

            }
            

            boolean valid = true;
            for (char c : lower.toCharArray()) {
                if (!row.contains(c)) {
                    valid = false;
                    break;
                }
            }

            if (valid) result.add(word);
        }

        return result.toArray(new String[0]);
    }
}