class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int nodes = isConnected.length;
        boolean[]vis=new boolean[nodes];

        for(int i=0;i<nodes;i++) {
            if(!vis[i]){
                dfs(isConnected,i,vis);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][] isConnected, int src, boolean[]vis) {
        if(vis[src])
            return;
        vis[src]=true;

        for(int j=0;j<isConnected[src].length;j++) {
            if(isConnected[src][j]==1){
                if(!vis[j]){
                dfs(isConnected,j,vis);
            }
            }
        }    
    }
}