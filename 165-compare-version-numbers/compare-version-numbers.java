class Solution {
    public int compareVersion(String v1, String v2) {
        int i = 0, j = 0, n1 = v1.length(), n2 = v2.length();
        while (i < n1 || j < n2) {
            // read next chunk from v1
            int iStart = i;
            while (i < n1 && v1.charAt(i) != '.') i++;
            // trim leading zeros for v1 chunk
            int iZero = iStart;
            while (iZero < i && v1.charAt(iZero) == '0') iZero++;
            int len1 = i - iZero;

            // read next chunk from v2
            int jStart = j;
            while (j < n2 && v2.charAt(j) != '.') j++;
            int jZero = jStart;
            while (jZero < j && v2.charAt(jZero) == '0') jZero++;
            int len2 = j - jZero;

            // compare by length first (avoids overflow)
            if (len1 != len2) return len1 > len2 ? 1 : -1;

            // if same length, lexicographically
            for (int k = 0; k < len1; k++) {
                char c1 = (len1 == 0) ? '0' : v1.charAt(iZero + k);
                char c2 = (len2 == 0) ? '0' : v2.charAt(jZero + k);
                if (c1 != c2) return c1 > c2 ? 1 : -1;
            }

            // skip dots
            i++; j++;
        }
        return 0;
    }
}
