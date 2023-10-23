class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = -1;
        int[] xi={0,1,0,-1};
        int[] yi={1,0,-1,0};

        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2)
                    q.add(new Pair(i,j));
            }
        }

        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            for(int x=0;x<size;x++){
                Pair p = q.poll();
            for(int i=0;i<4;i++){
                if(isSafe(grid,p.x+xi[i],p.y+yi[i])){
                    q.add(new Pair(p.x+xi[i],p.y+yi[i]));
                    grid[p.x+xi[i]][p.y+yi[i]]=2;
                }        
              }       
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return ans==-1?0:ans;
    }

    private static boolean isSafe(int[][]grid,int x, int y){
        return x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1;
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}