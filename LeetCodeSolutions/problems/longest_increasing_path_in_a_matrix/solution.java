class Solution {

    public int longestIncreasingPath(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] distance = new int[m][n];
        int result = 0;
		for(int i=0; i<m; i++) 
			for(int j=0; j<n; j++)
                if(distance[i][j] == 0)
				    result = Math.max(result, dfs(i,j, matrix, distance));
        return result;
	}

	public int dfs(int i, int j, int[][] matrix, int[][] distance) {
		if (distance[i][j] != 0) return distance[i][j];
        int m = matrix.length;
		int n = matrix[0].length;
		
		int prev = 0;
		if (j<(n-1) && matrix[i][j + 1] > matrix[i][j])
			prev = dfs(i, j + 1, matrix, distance);
		if (j>0 && matrix[i][j - 1] > matrix[i][j])
			prev = Math.max(prev, dfs(i, j - 1, matrix, distance));
		if (i<(m-1) && matrix[i + 1][j] > matrix[i][j])
			prev = Math.max(prev, dfs(i + 1, j, matrix, distance));
		if (i>0 && matrix[i - 1][j] > matrix[i][j])
			prev = Math.max(prev, dfs(i - 1, j, matrix, distance));
		distance[i][j] = prev + 1;
		return distance[i][j];
	}
}