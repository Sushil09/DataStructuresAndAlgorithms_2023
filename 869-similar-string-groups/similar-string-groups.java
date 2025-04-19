class Solution {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>> adjList = new ArrayList<>(strs.length);
        for(int i=0;i<strs.length;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<strs.length-1;i++) {
            for(int j=i+1;j<strs.length;j++){
                if(isSimilar(strs[i],strs[j])){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int ans = 0;
        boolean[] vis = new boolean[strs.length];       
        for(int i=0;i<adjList.size();i++){
            if(!vis[i]) {
                dfs(i,adjList,vis);
                    ans++;
            }
        }
        return ans;
    }

    private void dfs(int src, List<List<Integer>> adjList, boolean []vis) {
        if(vis[src])
            return;

        vis[src] = true;

        for(int neighBour: adjList.get(src)) {
            if(!vis[neighBour])
                dfs(neighBour,adjList,vis);
        }    
    }

    private static boolean isSimilar(String s1, String s2) {
        int diff =0;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i)!=s2.charAt(i))
               diff++; 
        }

        return diff == 2 || diff ==0;
    }
}