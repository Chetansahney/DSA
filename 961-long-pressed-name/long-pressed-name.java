class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0; // pointer for name
        int j = 0; // pointer for typed

        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                // same character → move both
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                // current typed char is a long press → move typed pointer
                j++;
            } else {
                // mismatch that isn't long press
                return false;
            }
        }

        // If name still has characters left → typed is too short
        if (i < name.length()) return false;

        // Check remaining typed characters → must be long presses of last char
        while (j < typed.length()) {
            if (typed.charAt(j) != name.charAt(name.length() - 1)) return false;
            j++;
        }

        return true;
    }
}
