class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adjList = new ArrayList<>(); //node,cost
        createAdjList(adjList,flights,n);
        return calcCheapestPrice(n,adjList,src,dst,k);
    }

    private static int calcCheapestPrice(int n, List<List<int[]>> adjList, int src, int dst, int k) {
        int[]dis= new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src,0,0}); //node,cost,hops
        dis[src]=0;

        while(!queue.isEmpty()) {
            int[]node = queue.poll();
            for(int[] neigh: adjList.get(node[0])) {
               if(neigh[1]+node[1]<dis[neigh[0]] && node[2]<=k) {
                    dis[neigh[0]] = neigh[1]+node[1];
                    queue.add(new int[]{neigh[0],dis[neigh[0]],node[2]+1});
               } 
            }
        }
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
    }

    private static void createAdjList(List<List<int[]>> adjList,int[][] flights,int n) {
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[]arr: flights) {
            adjList.get(arr[0]).add(new int[]{arr[1],arr[2]});
        }
    }
}