class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // boolean[] vis = new boolean[numCourses];
        int[]inDegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = makeAdjList(prerequisites,inDegree,numCourses);
        return findOrderUtil(adjList,inDegree,numCourses);
    }

    private static int[] findOrderUtil(ArrayList<ArrayList<Integer>> adjList,int[]inDegree, int V) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                 queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int polled = queue.poll();
            ans.add(polled);
            for(int neighbor: adjList.get(polled)) {
                    inDegree[neighbor]--;
                    if(inDegree[neighbor] ==0)
                        queue.add(neighbor);
                }
            }
        

        int[] orders = new int[V]; 

        for(int i=0;i<V;i++) {
            if(inDegree[i]!=0)
                return new int[]{};
        }

        for(int i=0;i<V;i++) {
            orders[i]=ans.get(V-i-1);
        }
        
        return orders; 
    }

    private static ArrayList<ArrayList<Integer>>  makeAdjList(int[][] prerequisites,int[]inDegree,int N) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<N;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }

        return adjList;
    } 
}