class Solution {
    public int heightChecker(int[] heights) {
       int[] different = new int[101];
        for(int n : heights) different[n]++;
        
        int h=0, n=heights.length;
        int count =0;
        for(int i=0; i<n; i++) {
            while(different[h] == 0) h++;
            if(heights[i] != h) count++;
            different[h]--;
        }
        return count;
    }
}