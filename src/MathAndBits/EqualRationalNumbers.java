package MathAndBits;

/*
https://leetcode.com/problems/equal-rational-numbers/description/
972. Equal Rational Numbers
 */

import java.util.*;

public class EqualRationalNumbers {
    public static void main(String[] args) {
        EqualRationalNumbers sol = new EqualRationalNumbers();
        String [][] nums_string = {{"0.(52)", "0.5(25)"},
                {"0.1666(6)", "0.166(66)"},
                {"0.(9)", "1"},
                        {"0.9(9)", "1."}};
        for (String [] nums : nums_string) {
            boolean res = sol.isRationalEqual(nums[0], nums[1]);
            System.out.println(Arrays.toString(nums) + " " + res);
        }

    }

    public boolean isRationalEqual(String S, String T) {
        return f(S) == f(T);
    }

    public double f(String S) {
        int i = S.indexOf('(');
        if (i > 0) {
            String base = S.substring(0, i);
            String rep = S.substring(i + 1, S.length() - 1);
            for (int j = 0; j < 20; j++) {
                base += rep;
            }
            return Double.valueOf(base);
        }
        return Double.valueOf(S);
    }
}
