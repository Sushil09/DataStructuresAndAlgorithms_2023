class Solution {
    public int swimInWater(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] time = new int[row][col];
        for (int[] rowArr : time) {
            Arrays.fill(rowArr, Integer.MAX_VALUE);
        }

        PriorityQueue<Triple> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);
        pq.add(new Triple(0, 0, grid[0][0]));
        time[0][0] = grid[0][0];

        int[] X = {0, 0, 1, -1};
        int[] Y = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Triple polled = pq.poll();
            int x = polled.x, y = polled.y, weight = polled.weight;

            if (x == row - 1 && y == col - 1) return weight;

            for (int i = 0; i < 4; i++) {
                int newX = X[i] + x;
                int newY = Y[i] + y;
                if (newX >= 0 && newY >= 0 && newX < row && newY < col) {
                    int newWeight = Math.max(weight, grid[newX][newY]);
                    if (newWeight < time[newX][newY]) {
                        time[newX][newY] = newWeight;
                        pq.add(new Triple(newX, newY, newWeight));
                    }
                }
            }
        }

        return -1; // unreachable, should not happen for valid input
    }

    static class Triple {
        int x, y, weight;
        Triple(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
