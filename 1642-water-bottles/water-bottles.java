class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = numBottles; // start by drinking all
        
        int empties = numBottles;
        while (empties >= numExchange) {
            int newBottles = empties / numExchange;  // exchange
            totalDrank += newBottles;                // drink them
            empties = newBottles + (empties % numExchange); // new + leftover
        }
        
        return totalDrank;
    }
}
