class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[]indegree = new int[numCourses];
        makeAdjList(adjList, numCourses,indegree,prerequisites);
        courseSchedule(adjList,numCourses,indegree);

        for(int x: indegree)
            if(x!=0)
                return false;
       return true;         
    }

    private static void courseSchedule(List<List<Integer>> adjList, int numCourses, int[]indegree) {
        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            for(int neighBour: adjList.get(course)) {
                indegree[neighBour]--;
                if(indegree[neighBour]==0) {
                    queue.add(neighBour);
                }
            }
        }
    }

    private static void makeAdjList(List<List<Integer>> adjList, int numCourses,int[]indegree, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());

        for(int[]course: prerequisites) {
            adjList.get(course[0]).add(course[1]);
            indegree[course[1]]++;
        }
    }
}