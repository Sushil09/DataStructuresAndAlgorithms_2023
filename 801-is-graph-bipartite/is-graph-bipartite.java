class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
            adjList.add(new ArrayList<>());
        makeAdjList(adjList, graph);
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);

        boolean ans = true;

       for(int i=0;i<graph.length;i++){
           if(colors[i]==-1){
               ans=ans && checkGraph(i,adjList,colors);
           }
       }
    
    return ans;
    
    }

    private static boolean checkGraph(int start, ArrayList<ArrayList<Integer>> adjList,int[]colors){
    Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start]=0;
        
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int x: adjList.get(temp)){
                if(colors[x]==-1){
                    colors[x]=1-colors[temp];
                    q.add(x);
                }
                else{
                    if(colors[x]==colors[temp])
                        return false;
                }
            }
        }

        return true;
    }

    private static void makeAdjList(ArrayList<ArrayList<Integer>> adjList,int[][] graph ){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                adjList.get(i).add(graph[i][j]);    
            }
            
        }
    }
}