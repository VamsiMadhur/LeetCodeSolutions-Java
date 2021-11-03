class Solution {
    int m=0, n=0;
    int INF = Integer.MAX_VALUE;
    
    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        
        int nv = (m*n);
        
        List<int[]>[] outedges = new List[nv];
        for(int i=0; i<nv; i++) {
            outedges[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n-1; j++) {
                int weight = Math.abs(heights[i][j] - heights[i][j+1]);
                outedges[val(i,j)].add(new int[]{val(i,j), val(i, j+1), weight});
                outedges[val(i,j+1)].add(new int[]{val(i,j+1), val(i, j), weight});
            }
        }
        
        for(int j=0; j<n; j++) {
            for(int i=0; i<m-1; i++) {
                int weight = Math.abs(heights[i][j] - heights[i+1][j]);
                outedges[val(i,j)].add(new int[]{val(i,j), val(i+1,j), weight});
                outedges[val(i+1,j)].add(new int[]{val(i+1,j), val(i, j), weight});
            }
        }
        
        int src = 0;
        int dst = nv-1;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] queueHas = new boolean[nv];
        queue.offer(src);
        queueHas[src]=true;
        
        int[] result = new int[nv];
        Arrays.fill(result, INF);
        result[src]=0;
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            queueHas[curr] = false;
            List<int[]> edges = outedges[curr];
            
            for(int[] edge : edges) {
                int newWeight = Math.max(result[edge[0]], edge[2]);
                if(result[edge[1]] > newWeight) {
                    result[edge[1]] = newWeight;
                    if(!queueHas[edge[1]]) {
                        queue.offer(edge[1]);
                        queueHas[edge[1]] = true;
                    }
                }
            }
        }
        return result[dst];
        
    }
    
    public int val(int i, int j) {
        return (i*n)+j;
    } 
}