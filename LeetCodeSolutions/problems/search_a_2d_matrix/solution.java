class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if(rows == 0) {
            return false;
        }
        int columns = matrix[0].length;
        if(columns == 0) {
            return false;
        }
        
        int start = 0, end = (rows*columns)-1;
        while(start<=end) {
            int mid = (start + end)/2;
            int row = mid/columns;
            int column = mid%columns;
            if(target == matrix[row][column]) {
                return true;
            } else if(target > matrix[row][column]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return false;
        
    }
}