import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        // case 1: x greater than last element
        if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return list;
        }

        // case 2: x smaller than first element
        else if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
            return list;
        }

        // case 3: x is in between
        else {
            int i = 0, j = 0;

            // find first index greater than x
            for (i = 0; i < arr.length; i++) {
                if (arr[i] >= x) {
                    break;
                }
            }

            j = i - 1; // left pointer
            List<Integer> temp = new ArrayList<>();

            while (k > 0) {
                if (j < 0) {
                    temp.add(arr[i]);
                    i++;
                } else if (i >= arr.length) {
                    temp.add(arr[j]);
                    j--;
                } else if (Math.abs(arr[j] - x) <= Math.abs(arr[i] - x)) {
                    temp.add(arr[j]);
                    j--;
                } else {
                    temp.add(arr[i]);
                    i++;
                }
                k--;
            }

            // since we might have added left side elements in reverse order
            Collections.sort(temp);
            return temp;
        }
    }
}
