class Solution {
    public boolean isBipartite(int[][] graph) {
       int V = graph.length;
       int[] vis= new int[V];
       Arrays.fill(vis,-1);

       for(int i=0;i<graph.length;i++){
        if(vis[i]==-1) {
            if(bfs(i,vis,graph) ==false)
                return false;
       }
       }
    return true;
      
    }

    public boolean bfs(int src,int[]vis, int[][] graph){
    Queue<Integer> q = new LinkedList<>();
       vis[src]=0;
       q.add(src);

       while(!q.isEmpty()) {
        int polled = q.poll();
        for(int neighbor: graph[polled]) {
            if(vis[neighbor]==-1) {
                vis[neighbor] = 1-vis[polled];
                q.add(neighbor);
            }else{
                if(1-vis[polled]!=vis[neighbor])
                    return false;
            }
        }
       }
        return true;
    }
}