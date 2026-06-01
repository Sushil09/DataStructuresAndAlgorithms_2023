class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer,List<Integer>> adjList = new HashMap<>();
        createAdjList(adjList,routes);
        return minBuses(adjList,source,target,routes);
    }

    private static int minBuses(Map<Integer,List<Integer>> adjList, int src, int dst, int[][] routes) {
        if(src==dst)
            return 0;
        int busCount = 1;
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();

        if(adjList.containsKey(src)){
for(int stops: adjList.get(src)) {
            queue.add(stops);
            visited.add(stops);
        }
        }     

        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int polled = queue.poll();
                for(int stop: routes[polled]) {
                    if(stop == dst) {
                        return busCount;
                    }
                    for(int road: adjList.get(stop)) {
                    if(!visited.contains(road)){
                        queue.add(road);
                        visited.add(road);
                    }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }

    private static void createAdjList(Map<Integer,List<Integer>> adjList, int[][] routes) {
        for(int i=0;i<routes.length;i++) {
            for(int j=0;j<routes[i].length;j++) {
                adjList.computeIfAbsent(routes[i][j],a->new ArrayList<>()).add(i);
            }
        }
    }
}