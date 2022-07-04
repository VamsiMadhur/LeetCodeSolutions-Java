class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n==1) return 1;
        
        int[] left = new int[n];
        int[] right = new int[n];
       
        left[0] = 1;
        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                left[i] = left[i-1] + 1;
            } else {
                left[i] = 1;
            }
        }
        
        right[n-1] = 1;
        for(int i=n-1; i>0; i--) {
            if(ratings[i-1] > ratings[i]) {
                right[i-1] = right[i] + 1;
            } else {
                right[i-1] = 1;
            }
        }
        
        int result = 0;
        for(int i=0; i<n; i++) {
            result += Math.max(left[i], right[i]);
        }
        
        return result;
    }
}