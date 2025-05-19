class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = -1;

        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) {
                    queue.add(new Pair(i,j));
                }
            }
        }

        int[]dx = {0,0,1,-1};
        int[]dy = {1,-1,0,0};

        while(!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for(int i=0;i<size;i++) {
                Pair orange = queue.poll();
                grid[orange.x][orange.y]=2;
                for(int j=0;j<4;j++) {
                    int newX = dx[j]+orange.x;
                    int newY = dy[j]+orange.y;
                    if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && grid[newX][newY] ==1){
                        grid[newX][newY]=2;
                        queue.add(new Pair(newX,newY));
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) {
                    return -1;
                }
            }
        }
        return minutes==-1?0:minutes;
    }
    static class Pair{
        int x,y;
        Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
}