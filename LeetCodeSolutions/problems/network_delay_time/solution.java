class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[] result = new int[n+1];
        for(int i=0; i<=n; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[k] = 0;
        
        boolean[] visited = new boolean[n+1];
        boolean[] queueHas = new boolean[n+1];
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> (result[a]-result[b]));
        queue.offer(k);
        
        List<int[]>[] outedges = new List[n+1];
        for(int i=0; i<=n; i++) {
            outedges[i] = new ArrayList<int[]>();
        }
        
        for(int[] time : times) {
            outedges[time[0]].add(time);
        }
            
        while(!queue.isEmpty()) {
            int temp = queue.poll();
            List<int[]> out = outedges[temp];
            
            for(int[] edge : out) {
                if(!visited[edge[1]]) {
                    if(result[edge[1]] > result[edge[0]] + edge[2]) {
                        result[edge[1]] = result[edge[0]] + edge[2];
                        if(queue.contains(edge[1])) {
                            queue.remove(edge[1]);
                        }
                        queue.add(edge[1]);
                    }
                }
            }
            visited[temp] = true;
        }
        
        int totalTime = -1;
        for(int i=1; i<=n; i++) {
            totalTime = Math.max(totalTime, result[i]);
        }
        return totalTime==Integer.MAX_VALUE? -1 : totalTime;
    }
}