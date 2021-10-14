class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        long sum = 0;
        for(int pile : piles) {
            sum += pile;
        }
        int k = (int)(1 + (sum-1)/h);
        
        while(true) {
            int next = isValid(piles, k, h);
            if(next == 0) return k;
            else k = next;
        }
    }
    
    public int isValid(int[] piles, int speed, int h) {
        int increase = Integer.MAX_VALUE;
        
        int sum = 0;
        for(int pile : piles) {
            int eh = 1 + ((pile-1)/speed);
            if(eh > 1) {
                int nextH = eh - 1;
                int nextK = 1 + ((pile-1)/nextH);
                increase = Math.min(increase, nextK);
            }
            sum += eh;
        }
        if (sum <= h) return 0;
        else return increase;
    }
}