class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return b-a;
        });
        
        for(int stone : stones) {
            pq.offer(stone);
        }
        int size = stones.length;
        
        while(size != 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a-b);
            size -= 1;
        }
        return pq.poll();
        
    }
}