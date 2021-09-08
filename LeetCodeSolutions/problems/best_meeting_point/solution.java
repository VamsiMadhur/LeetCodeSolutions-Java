class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows =  new ArrayList<>();
        List<Integer> columns =  new ArrayList<>();
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 1) {
                    rows.add(row);
                }
            }
        }
        
        for(int column = 0; column < grid[0].length; column++) {
            for(int row = 0; row < grid.length; row++) {
                if(grid[row][column] == 1) {
                    columns.add(column);
                }
            }
        }
        
        return calculateDistance1D(rows) + calculateDistance1D(columns);
    }
    
     private List<int[]> getAllHouses(int[][] grid) {
        List<int[]> houses = new ArrayList<>();
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid[0].length; column++){
                if(grid[row][column] == 1) {
                    houses.add(new int[]{row, column});
                }
            }
        }
        return houses;
    }
    
    private int calculateDistance1D(List<Integer> points) {
        int distance = 0;
        int i=0;
        int j= points.size() - 1;
        while(i<j) {
            distance += points.get(j) - points.get(i);
            j--;
            i++;
        }
        return distance;
    }
}