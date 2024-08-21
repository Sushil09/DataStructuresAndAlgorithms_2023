class Solution {
    public int numIslands(char[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        boolean[][]  visited = new boolean[M][N];
        int ans =0;

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(grid[i][j]=='1') {
                    ans++;
                    numIslandsUtil(grid,i,j,M,N);
                }
            }
        }
        return ans;
    }

    private static void numIslandsUtil(char[][]grid,int i, int j, int M, int N) {
        int[]x = {0,1,-1,0};
        int[]y = {1,0,0,-1};
        Queue<Pair> q = new LinkedList<>();
        grid[i][j]='0';
        q.add(new Pair(i,j));
        while(!q.isEmpty()) {
        Pair p = q.poll();
        int pickX = p.x;
        int pickY = p.y;
        for(int neigh=0;neigh<4;neigh++) {   
        int leftSide = x[neigh]+pickX;
        int rightSide = y[neigh]+pickY;
           if(isValid(grid,leftSide,rightSide,M,N)) {
                q.add(new Pair(leftSide,rightSide));
                grid[leftSide][rightSide]='0';
           } 
        }
    }    
}
    private static boolean isValid(char[][]grid,int i,int j,int M, int N){
        return i<M && j<N && i>=0 && j>=0 && grid[i][j]=='1';
    }
}

class Pair {
   int x,y;
   Pair(int x, int y){
    this.x=x;
    this.y=y;
   }             
}