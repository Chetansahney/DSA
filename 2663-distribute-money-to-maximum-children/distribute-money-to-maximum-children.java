class Solution {
    public int distMoney(int money, int children) {
        money -= children;  // give each child $1
        if (money < 0) return -1; // not enough money for even $1 per child

        int count8 = money / 7;
        int remaining = money % 7;

        if (count8 > children) return children - 1;
        if (count8 == children && remaining > 0) return children - 1;
        if (count8 == children - 1 && remaining == 3) return count8 - 1;

        return count8;
    }
}
