class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length;
        int oc = nums[0].length;
        if((or*oc)!=(r*c)) {
            return nums;
        }
        int[][] result = new int[r][c];
        int pi = 0;
        int pj = 0;
        for(int i=0; i<or; i++) {
            for(int j=0; j<oc; j++) {
                result[pi][pj++] = nums[i][j];
                if(pj == c) {
                    pi++;
                    pj=0;
                }
            }
        }
        return result;
    }
}