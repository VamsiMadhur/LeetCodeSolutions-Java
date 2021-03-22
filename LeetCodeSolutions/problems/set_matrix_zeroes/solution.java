class Solution {
    public void setZeroes(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfColumns = matrix[0].length;
    
        int [] rows = new int[noOfRows];
        int [] columns = new int[noOfColumns];
        
        for(int i=0; i<noOfRows; i++) {
            for(int j=0; j<noOfColumns; j++) {
                if(matrix[i][j]==0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }
        
        for(int k=0; k<noOfRows; k++) {
            if(rows[k]==1) {
                for(int i=0; i<noOfColumns; i++) {
                    matrix[k][i]=0;
                }
            }
        }

        for(int k=0; k<noOfColumns; k++) {
            if(columns[k]==1) {
                for(int i=0; i<matrix.length; i++) {
                    matrix[i][k]=0;
                }
            }
        }
    }
}