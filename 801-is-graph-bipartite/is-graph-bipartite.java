class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[]vis = new int[N];
        Arrays.fill(vis,-1);
        
        for(int i=0;i<N;i++) {
            if(vis[i]==-1){
                if(bipartiteCheck(graph,vis,i) == false)
                    return false;
            }
        }
        return true;
    }

    private static boolean bipartiteCheck(int[][] graph, int[]vis,int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
         vis[src]=0;
        while(!queue.isEmpty()) {
            int popped = queue.poll();
            for(int neighbour : graph[popped]) {
                if(vis[neighbour]==-1) {
                    vis[neighbour] = 1-vis[popped];
                    queue.add(neighbour);
                }else{
                    if(vis[neighbour]==vis[popped])
                        return false;
                }
            }
        }
        return true;
    } 
}


/*
vis = [0,-1,-1,-1]


*/