package DFSBackTracking;
/*
https://leetcode.com/problems/24-game/description/
679. 24 Game
*/

import java.util.*;

public class Game24 {
    public static void main(String[] args) {
        Game24 sol = new Game24();
        int [][] inputs = {{4, 1, 8, 7}, {1, 2, 1, 2}};
        for (int [] data : inputs) {
            boolean res = sol.judgePoint24(data);
            System.out.println(Arrays.toString(data) + "  " + res);
        }
    }

    public boolean judgePoint24(int[] nums) {
        List<Double> digit = new ArrayList<>();
        for (int v: nums) {
            digit.add((double) v);
        }
        return solve(digit);
    }
    private boolean solve(List<Double> nums) {
        if (nums.size() == 0) return false;
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    List<Double> nums2 = new ArrayList<>();
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nums2.add(nums.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && j > i) continue;
                        if (k == 0) {
                            nums2.add(nums.get(i) + nums.get(j));
                        }
                        if (k == 1) {
                            nums2.add(nums.get(i) * nums.get(j));
                        }
                        if (k == 2) {
                            nums2.add(nums.get(i) - nums.get(j));
                        }
                        if (k == 3) {
                            if (nums.get(j) != 0) {
                                nums2.add(nums.get(i) / nums.get(j));
                            } else {
                                continue;
                            }
                        }
                        if (solve(nums2)) return true;
                        nums2.remove(nums2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
