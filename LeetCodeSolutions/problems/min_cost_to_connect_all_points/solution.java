class Solution {
    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n<=1) return 0;
        
        int count = n-1;
        int result = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        boolean[] visited = new boolean[n];
        
        int[] firstPoint = points[0];
        
        for(int j=1; j<n; j++) {
            int[] y = points[j];
            int dist = Math.abs(firstPoint[0]-y[0]) + Math.abs(firstPoint[1]-y[1]);
            pq.add(new int[]{0,j,dist});
        }
        visited[0] = true;
        
        while(!pq.isEmpty() && count>0) {
            int[] edge = pq.poll();
            int point1 = edge[0];
            int point2 = edge[1];
            int cost = edge[2];
            
            if(!visited[point2]) {
                result += cost;
                visited[point2] = true;
                
                    for(int j=0; j<n; j++) {
                        if(!visited[j]) {
                            int[] x = points[point2];
                            int[] y = points[j];
                            int dist = Math.abs(x[0]-y[0]) + Math.abs(x[1]-y[1]);
                            pq.add(new int[]{0,j,dist});
                        }
                    }
                count--;
            }
        }
        return result;
    }
}