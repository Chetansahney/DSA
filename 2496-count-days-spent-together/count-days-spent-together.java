class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int start = Math.max(dayOfYear(arriveAlice), dayOfYear(arriveBob));
        int end = Math.min(dayOfYear(leaveAlice), dayOfYear(leaveBob));
        return Math.max(0, end - start + 1);
    }

    private int dayOfYear(String date) {
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int m = Integer.parseInt(date.substring(0, 2));
        int d = Integer.parseInt(date.substring(3, 5));
        int days = d;
        for (int i = 0; i < m - 1; i++) days += month[i];
        return days;
    }
}