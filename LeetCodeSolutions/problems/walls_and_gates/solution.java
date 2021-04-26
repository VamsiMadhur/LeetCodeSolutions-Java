class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(rooms[i][j]==0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int distance) {
        if(rooms[i][j] == -1) return;
        
        int currDist = distance+1;
        if(i>0 && rooms[i-1][j] > currDist) {
            rooms[i-1][j] = currDist;
            dfs(rooms, i-1, j, currDist);
        }
        if(i<rooms.length-1 && rooms[i+1][j] > currDist) {
            rooms[i+1][j] = currDist;
            dfs(rooms, i+1, j, currDist);
        }
        if(j>0 && rooms[i][j-1] > currDist) {
            rooms[i][j-1] = currDist;
            dfs(rooms, i, j-1, currDist);
        }
        if(j<rooms[0].length-1 && rooms[i][j+1] > currDist) {
            rooms[i][j+1] = currDist;
            dfs(rooms, i, j+1, currDist);
        }
    } 
}