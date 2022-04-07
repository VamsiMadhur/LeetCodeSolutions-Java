class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b-a;
        });
        
        for(int stone:stones) pq.offer(stone);
        int size = stones.length;
        while(size > 1) {
            int a = pq.poll();
            int b = pq.poll();
            size -= 2;
            if(a != b) {
                pq.offer(a-b);
                size++;
            }
        }
        return size==0 ? 0:pq.poll();
    }
}