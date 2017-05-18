package DynamicProgramming.MinimumPathSum;

/**
 * https://leetcode.com/problems/minimum-path-sum/#/description
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int elemStore = grid[i][j];
                if (i > 0 && j > 0) {
                    elemStore += Math.min(minSum[i - 1][j], minSum[i][j - 1]);
                } else if (i > 0) {
                    elemStore += minSum[i - 1][j];
                } else if (j > 0) {
                    elemStore += minSum[i][j - 1];
                }
                minSum[i][j] = elemStore;
            }
        }
        return minSum[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{1, 2}, {1, 3}};
        System.out.println(solution.minPathSum(arr));
    }
}
