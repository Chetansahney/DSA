class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count = new int[10];  // for digits 0–9

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls++;
            } else {
                // if count[s] < 0, that means g had extra s earlier → cow found
                if (count[s] < 0) cows++;
                // if count[g] > 0, that means s had extra g earlier → cow found
                if (count[g] > 0) cows++;

                // update counts
                count[s]++;
                count[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
