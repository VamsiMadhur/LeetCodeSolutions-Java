class Solution {
    public void setZeroes(int[][] input) {
    	int m = input.length;
		int n = input[0].length;
		
		boolean isFirstRow = false, isFirstColumn = false;
		
		for(int i=0; i<m; i++) {
			if(input[i][0] == 0) {
				isFirstColumn = true;
				break;
			}
		}
		
		for(int i=0; i<n; i++) {
			if(input[0][i] == 0) {
				isFirstRow = true;
				break;
			}
		}
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				if(input[i][j] == 0) {
					input[i][0] = 0;
					input[0][j] = 0;
				}
			}
		}
		
		for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
			    if(input[i][0] == 0 || input[0][j]==0) {
					input[i][j] = 0;
				}
			}
		}
        
		if(isFirstRow) {
			for(int j=0; j<n; j++) {
				input[0][j] = 0;
			}
		}
		
		if(isFirstColumn) {
			for(int i=0; i<m; i++) {
				input[i][0] = 0;
			}
		}
		
        
    }
}