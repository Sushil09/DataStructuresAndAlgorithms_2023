class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();

        int[][] dp = new int[N][N];

        for(int[] arr : dp)
            Arrays.fill(arr, Integer.MAX_VALUE);

        return minTotal(triangle, 0, 0, N - 1, dp);
    }

    private static int minTotal(List<List<Integer>> triangle,
                                int N,
                                int M,
                                int size,
                                int[][] dp) {

        if(N == size)
            return triangle.get(N).get(M);

        if(dp[N][M] != Integer.MAX_VALUE)
            return dp[N][M];

        int down =
            triangle.get(N).get(M)
            + minTotal(triangle, N + 1, M, size, dp);

        int diagonal =
            triangle.get(N).get(M)
            + minTotal(triangle, N + 1, M + 1, size, dp);

        return dp[N][M] = Math.min(down, diagonal);
    }
}