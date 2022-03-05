class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] index = new Integer[n];
        for(int i=0; i<n; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> (growTime[b] - growTime[a]));
        
        int maxTime = 0, idx=0;
        int result = 0;
        for(int i=0; i<n; i++) {
            idx = index[i];
            maxTime += plantTime[idx];
            result = Math.max(result, maxTime + growTime[idx]);
        }
        return result;
    }
}