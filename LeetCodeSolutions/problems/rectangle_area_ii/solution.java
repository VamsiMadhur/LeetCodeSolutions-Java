class Solution {
    public int rectangleArea(int[][] rectangles) {
        int N = rectangles.length;
        
        Set<Integer> Xvals = new HashSet<>();
        Set<Integer> Yvals = new HashSet<>();
        
        for(int[] rectangle : rectangles) {
            Xvals.add(rectangle[0]);
            Yvals.add(rectangle[1]);
            
            Xvals.add(rectangle[2]);
            Yvals.add(rectangle[3]);
        }
        
        Integer[] xValList = Xvals.toArray(new Integer[0]);
        Arrays.sort(xValList);
        Integer[] yValList = Yvals.toArray(new Integer[0]);
        Arrays.sort(yValList);
        
        Map<Integer, Integer> mapx = new HashMap<>();
        Map<Integer, Integer> mapy = new HashMap<>();
        for(int i=0; i<xValList.length; i++) {
            mapx.put(xValList[i], i);
        }
        for(int i=0; i<yValList.length; i++) {
            mapy.put(yValList[i], i);
        }
        
        boolean[][] grid = new boolean[xValList.length][yValList.length];
        
        for(int[] rectangle : rectangles) {
            for(int x = mapx.get(rectangle[0]); x<mapx.get(rectangle[2]); x++) {
                for(int y = mapy.get(rectangle[1]); y<mapy.get(rectangle[3]); y++) {
                    grid[x][y] = true;
                }
            }    
        }
        
        long ans = 0;
        for(int x=0; x<grid.length; x++) {
            for(int y=0; y<grid[0].length; y++) {
                if(grid[x][y]) {
                    ans += (long) (xValList[x+1] - xValList[x]) * (yValList[y+1] - yValList[y]); 
                }
            }
        }
        
        ans %= 1000000007;
        return (int)ans;
    }
        
        
}