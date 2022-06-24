class Solution {
    public boolean isPossible(int[] target) {
        int totalSum = 0;
        int n = target.length, x=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]-a[0]));
        for(int i=0; i<n; i++) {
            totalSum += target[i];
            pq.offer(new int[]{target[i], i});
        }
        while(pq.peek()[0]!=1) {
            int[] temp = pq. poll();
            totalSum -= temp[0];
            if(totalSum <= 0) return false;
            if(totalSum == 1) return true;
            x = temp[0] % totalSum;
            totalSum += x;
            if(x<=0 || totalSum < n || x == temp[0]) return false;
            pq.offer(new int[]{x, temp[1]});
        }
        return true;
    }
}