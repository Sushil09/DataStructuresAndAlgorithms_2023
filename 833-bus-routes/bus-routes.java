class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> busStops = new HashMap<>();
        int stops =routes.length;
        int hops=1;
        if(source==target)
            return 0;

        for(int i=0; i<routes.length;i++) {
            for(int j=0;j<routes[i].length;j++) {
                busStops.computeIfAbsent(routes[i][j],k->new ArrayList<>()).add(i);
            }
        }
        if(!busStops.containsKey(source))
            return -1;

        Set<Integer> isVisited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int stop: busStops.get(source)) {
            queue.offer(stop);
            isVisited.add(stop);
        }

        while(!queue.isEmpty()) {
         
            int size = queue.size();
            for(int i=0;i<size;i++) {
            int stop = queue.poll();
            // isVisited.add(stop);
            
            for(int bus: routes[stop]) {
                if(bus == target){
                    return hops;
                }
                for(int middleStop: busStops.get(bus)){
                    if(!isVisited.contains(middleStop)){
                        queue.add(middleStop);
                        isVisited.add(middleStop);
                    }
                }
            }
        }
           hops++;
        }
        return -1;
    }
}