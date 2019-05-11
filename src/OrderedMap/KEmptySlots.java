package OrderedMap;
/*
https://leetcode.com/problems/k-empty-slots/submissions/1
LC: 683
 */

import java.util.TreeSet;

public class KEmptySlots {
    public static void main(String[] args) {

    }
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> bloomedFlower = new TreeSet<>();

        int day = 0;
        for (int flower : flowers) {
            day++;
            bloomedFlower.add(flower);

            Integer previousNeigh = bloomedFlower.lower(flower);
            Integer nextNeigh = bloomedFlower.higher(flower);

            if (previousNeigh != null && flower - previousNeigh - 1 == k) {
                return day;
            }

            if (nextNeigh != null && nextNeigh - flower - 1 == k) {
                return day;
            }
        }

        return -1;
    }

    public int kEmptySlots_Fast(int[] flowers, int k) {
        //Order N
        int[] days = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i] - 1] = i + 1;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0, right = k+1;

        search: while (right < days.length) {
            for (int i = left+1; i < right; ++i) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    continue search;
                }
            }
            ans = Math.min(ans, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}