class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) -> (a[0] == b[0]) ? b[1]-a[1] : a[0]-b[0]);
        int result = 0;
        int[] dp = new int[envelopes.length];
        for(int[] env : envelopes) {
            int insertPoint = binarySearch(dp, 0, result-1, env[1]);
            if(insertPoint == result) result++;
            dp[insertPoint] = env[1];
        }
        return result;
    }
    
    public int binarySearch(int[] arr, int low, int high, int key) {
        int mid=low + (high-low)/2;
        while(low <= high) {
            if(arr[mid] == key) return mid;
            else if(arr[mid] < key) low = mid+1;
            else high = mid-1;
            mid = low + (high-low)/2;
        }
        //Returns the mid value, in terms of last value, it will return high+1 value only
        return mid; 
        
    }
}