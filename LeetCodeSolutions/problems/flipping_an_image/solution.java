class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int mid = n>>1;
        boolean flag = ((n&1)==1);
        for(int i=0; i<n; i++) {
            for(int j=0; j<mid; j++) {
                int temp = image[i][j];
                image[i][j] = 1-image[i][n-j-1];
                image[i][n-j-1] = 1-temp;
            }
            if(flag) {
                image[i][mid] = 1-image[i][mid];
            }
        }
        
        return image;
    }
}