class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i=0;
        for(i=0; i<n-1; i++) {
            int jump = heights[i+1] - heights[i];
            if(jump <= 0) continue;
            bricks -= jump;
            pq.add(jump);
            
            while(bricks < 0 && !pq.isEmpty()) {
                bricks += pq.poll();
                if(ladders > 0) ladders--;
                else return i;
            }
        }
        return i;
    }
}