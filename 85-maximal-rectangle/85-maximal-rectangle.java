class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j]-'0';
                if (dp[i][j] > 0 && i>0) dp[i][j] += dp[i - 1][j];
            }
        }
        // System.out.print(Arrays.deepToString(dp));
        int max = 0;
        for (int[] a : dp) {
            // System.out.print(Arrays.toString(a));
            max=Math.max(largestRectangleArea(a), max);
        }

        return max;
    }
    
    // copied "Largest Rectangle in Histogram" solution
    public int largestRectangleArea(int[] a) {
        LinkedList<Integer> stack = new LinkedList<>();
        int max = 0;

        for (int i = 0; i <= a.length; i++) {
            while (!stack.isEmpty() && (i == a.length || a[stack.peek()] > a[i])) {
                int height = a[stack.pop()];
                int width = (!stack.isEmpty()) ? i - stack.peek() - 1 : i;
                max = Math.max(max, height * width);
            }

            stack.push(i);

        }

        return max;
    }
}