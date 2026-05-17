class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int originalColor = image[sr][sc];
       dfs(image,sr,sc,originalColor,color);
       return image; 
    }

    private static void dfs(int[][]image, int sr, int sc, int oC, int nC) {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length|| image[sr][sc] != oC || image[sr][sc]==nC) {
            return;
        }
        image[sr][sc]=nC;
        dfs(image,sr-1,sc,oC,nC);
        dfs(image,sr+1,sc,oC,nC);
        dfs(image,sr,sc-1,oC,nC);
        dfs(image,sr,sc+1,oC,nC);
    }
}