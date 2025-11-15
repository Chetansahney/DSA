class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int x : deck) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        int g = 0;
        for (int count : freq.values()) {
            g = gcd(g, count);
        }

        return g >= 2;
    }
}
