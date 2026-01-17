class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int result = 0;
        int i = 1;
        ListNode curr = head;

        while (curr != null) {
            if (rand.nextInt(i) == 0) {  // probability = 1/i
                result = curr.val;
            }
            i++;
            curr = curr.next;
        }
        return result;
    }
}
