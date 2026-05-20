class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] inDegree = new int[V];
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjList(graph,inDegree,V,adjList);
        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(inDegree[i]==0)
                queue.add(i);
        }

        while(!queue.isEmpty()) {
            int polled = queue.poll();
            ans.add(polled);
            for(int neigh: adjList.get(polled)) {
                inDegree[neigh]--;
                if(inDegree[neigh]==0)
                    queue.add(neigh);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    private static void createAdjList(int[][] graph, int[] inDegree, int V, List<List<Integer>> adjList) {
       for(int i=0;i<V;i++)
          adjList.add(new ArrayList<>());

        for(int i=0;i<V;i++) {
            for(int neigh: graph[i]) {
                adjList.get(neigh).add(i);
                inDegree[i]++;
            }
        }       
    }
}