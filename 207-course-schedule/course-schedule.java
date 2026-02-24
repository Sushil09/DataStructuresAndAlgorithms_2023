class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        // boolean[] visited = new boolean[numCourses];
        List<List<Integer>> adjList =new ArrayList<>(numCourses);
        
        makeAdjList(prerequisites,numCourses, adjList);

        for(int i=0;i<prerequisites.length;i++) {
            inDegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<inDegrees.length;i++) {
            if(inDegrees[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int courseId = queue.poll();
            
            for(int neighbour : adjList.get(courseId)) {
                inDegrees[neighbour]--;
                 if(inDegrees[neighbour]==0){
                    queue.add(neighbour);
                     
                 }   
            } 
        }
        return !Arrays.stream(inDegrees)
                      .anyMatch(x->x>0);  
    }

    private void makeAdjList(int[][] prerequisites, int size, List<List<Integer>> adjList) {
        for(int i=0;i<size;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
    }
}