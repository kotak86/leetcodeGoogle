package String;

import java.util.*;

/*
https://leetcode.com/problems/next-closest-time/description/

 */

public class NextClosestTime {

    public static void main(String[] args) {
        NextClosestTime sol = new NextClosestTime();
        String time = "19:34";
        String res = sol.nextClosestTime(time);
        System.out.println(time + " next Closet time " + res);

        time = "23:59";
        res = sol.nextClosestTime(time);
        System.out.println(time + " next Closet time " + res);

    }
    public String nextClosestTime(String time) {
        char[] res = time.toCharArray();
        Character[] digits = new Character[]{res[0],res[1],res[3],res[4]};
        TreeSet<Character> set = new TreeSet<Character>(Arrays.asList(digits));

        res[4] = next(set,res[4],'9');
        if(time.charAt(4) < res[4]) {
            return new String(res);
        }

        res[3] = next(set,res[3],'5');
        if(time.charAt(3) < res[3]) {
            return new String(res);
        }

        int limitForFirst = res[0] == 2 ? 3 : 9;
        res[1] = next(set,res[1],  (char) limitForFirst);
        if(time.charAt(1) < res[1]) {
            return new String(res);
        }

        res[0] = next(set,res[0],'2');

        return new String(res);
    }

    private char next(TreeSet<Character> set, char curChar, char limit){
        Character nextFromCurChar = set.higher(curChar);
        return (nextFromCurChar == null || nextFromCurChar > limit) ?
                set.first() : nextFromCurChar;
    }
}