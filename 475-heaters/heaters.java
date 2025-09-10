
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0; // pointer for houses
        int j = 0; // pointer for heaters
        int radius = 0;

        // go through each house
        for (int house : houses) {
            // move heater pointer forward if the next heater is closer
            while (j + 1 < heaters.length &&
                   Math.abs(heaters[j + 1] - house) <= Math.abs(heaters[j] - house)) {
                j++;
            }
            // nearest heater is at heaters[j]
            radius = Math.max(radius, Math.abs(heaters[j] - house));
        }

        return radius;
    }
}

    
