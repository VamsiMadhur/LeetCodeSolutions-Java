class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }
    
    public void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        if(sr<0 || sr >= m || sc<0 || sc >= n || image[sr][sc] != oldColor) return;
        
        image[sr][sc] = newColor;
        
        dfs(image, sr-1, sc, oldColor, newColor);
        dfs(image, sr+1, sc, oldColor, newColor);
        dfs(image, sr, sc-1, oldColor, newColor);
        dfs(image, sr, sc+1, oldColor, newColor);
            
    }
}