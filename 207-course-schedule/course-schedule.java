class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
            adjList.add(new ArrayList<>());

        makeAdjGraph(adjList,numCourses,prerequisites);

        int[]indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int x=q.poll();
            for(int i:adjList.get(x)){
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }
        boolean ans = true;

        for(int i=0;i<indegree.length;i++){
            if(indegree[i]!=0)
                ans=false;
        }
return ans;
      }

      private static void makeAdjGraph(ArrayList<ArrayList<Integer>> adjList, int V, int[][] edge ){
          for(int i=0;i<edge.length;i++){
              adjList.get(edge[i][1]).add(edge[i][0]);
          }
      }
}

