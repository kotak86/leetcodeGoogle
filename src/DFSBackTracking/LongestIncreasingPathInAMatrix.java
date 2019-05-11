package DFSBackTracking;

public class LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        int [][] nums = {
                          {9,9,4},
                          {6,6,8},
                          {2,1,1}
                        };


        LongestIncreasingPathInAMatrix sol = new LongestIncreasingPathInAMatrix();
        int res = sol.longestIncreasingPath(nums);
        System.out.println("Longest Path " + res);

        int [][] nums1 = {{3,4,5}, {3,2,6}, {2,2,1}};
        res = sol.longestIncreasingPath(nums1);
        System.out.println("Longest Path " + res);

    }

    public int longestIncreasingPath(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int [][] dp = new int [matrix.length][matrix[0].length];
        int max = 1;
        for (int row = 0 ; row < matrix.length; row++) {
            for (int col = 0 ; col < matrix[0].length; col++) {
                int curMax = longestIncreasingPath(row, col, matrix, dp, Integer.MAX_VALUE);
                max = Math.max(max, curMax);
            }
        }
        return max;
    }

    public int longestIncreasingPath (int row , int col , int [][] matrix, int[][] dp, int pre) {
        if (row < 0 || row >=  matrix.length) {
            return 0;
        }
        if (col < 0 || col >= matrix[0].length) {
            return 0;
        }

        if (matrix[row][col] >= pre) {
            return 0;
        }

        if (dp[row][col] > 0) {
            return dp[row][col];
        }

        else {
            int cur = matrix[row][col];
            int curMax = 0;
            curMax = Math.max(longestIncreasingPath(row + 1, col, matrix, dp, cur) + 1, curMax);
            curMax = Math.max(longestIncreasingPath(row - 1, col, matrix, dp, cur) + 1, curMax);
            curMax = Math.max(longestIncreasingPath(row, col + 1, matrix, dp, cur) + 1, curMax);
            curMax = Math.max(longestIncreasingPath(row, col - 1, matrix, dp, cur) + 1, curMax);
            dp[row][col] = curMax;
            return curMax;
        }
    }
}
