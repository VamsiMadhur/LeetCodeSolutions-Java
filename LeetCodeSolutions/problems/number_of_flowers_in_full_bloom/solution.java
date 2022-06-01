class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int nf = flowers.length, np = persons.length;
        int[] opens = new int[nf], closes = new int[nf];
        
        for(int i=0; i<nf; i++) {
            opens[i] = flowers[i][0];
            closes[i] = flowers[i][1];
        }
        
        Arrays.sort(opens); Arrays.sort(closes);
        
        long[] temp = new long[np];
        for(int i=0; i<np; i++) {
            temp[i] = ((long) persons[i] << 32) | i;
        }
        Arrays.sort(temp);
        
        int[] result = new int[np];
        int openIdx=0, closeIdx=0;
        
        for(long t : temp) {
            int idx = (int)t;
            int time = persons[idx];
            
            while(openIdx < nf && opens[openIdx]<=time ) openIdx++;
            while(closeIdx < nf && closes[closeIdx]<time ) closeIdx++;
            
            result[idx] = openIdx - closeIdx;
        }
        return result;
    }
}