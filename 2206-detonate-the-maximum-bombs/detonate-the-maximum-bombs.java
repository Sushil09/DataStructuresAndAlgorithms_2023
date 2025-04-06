class Solution {
    public int maximumDetonation(int[][] bombs) {
        int maxBombs = 0;
        int size= bombs.length;
        for(int i=0;i<size;i++) {
            boolean[] vis = new boolean[size];
            maxBombs = Math.max(maxBombs,detonateBombsBFS(bombs,i,vis));
        }
        return maxBombs;
    }
    // private int detonateBombs(int[][] bombs, int src, boolean[]vis) {
    //     if(vis[src])
    //         return 1;
    //     vis[src] = true;

    //     for(int i=0;i<bombs.length;i++) {
    //         if(inRange(src,bombs[i])){
    //             return 
    //         }
    //     }    
    // }

    private static int detonateBombsBFS(int[][] bombs, int src, boolean[]vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis[src]=true;

        int maxBombs=1;
        
        while(!q.isEmpty()) {
            int bomb = q.poll();
            
            for(int i=0;i<bombs.length;i++) {
                if(!vis[i] && inRange(bombs[bomb],bombs[i]) ){
                    vis[i]=true;
                    maxBombs++;
                    q.add(i);
                }
            }
        }
        return maxBombs;
    }

    private static boolean inRange(int[] src, int[] des) {
        long disX =  des[0]-src[0], disY= des[1]-src[1];
        long r = src[2]; 
        return r*r>=disX*disX + disY*disY;
    }

}