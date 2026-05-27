class Solution {

    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // collect rotten oranges and count fresh oranges
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // no fresh oranges already
        if (fresh == 0)
            return 0;

        int minutes = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {

            int size = queue.size();

            boolean rotted = false;

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();

                int x = curr[0];
                int y = curr[1];

                for (int d = 0; d < 4; d++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < n &&
                        ny >= 0 && ny < m &&
                        grid[nx][ny] == 1) {

                        grid[nx][ny] = 2;

                        fresh--;

                        queue.offer(new int[]{nx, ny});

                        rotted = true;
                    }
                }
            }

            if (rotted)
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}