class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        boolean[]vis =new boolean[V];
        int prov = 0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                prov++;
                dfs(isConnected,vis,i);
            }
        }
        return prov;
    }

    private static void dfs(int[][] isConnected, boolean[]vis,int src) {
        if(vis[src])
            return;
vis[src]=true;

        for(int j=0;j<isConnected[0].length;j++){
            if(isConnected[src][j] == 1 && !vis[j]){
                dfs(isConnected,vis,j);
            }
        }    
    }
}