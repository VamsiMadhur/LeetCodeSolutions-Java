class Solution {
    public int slidingPuzzle(int[][] board) {
        int finalHash = 123450;
        Set<Integer> cache = new HashSet<>();
        
        int initialHash = getHash(board);
        if(initialHash == finalHash) return 0;
        
        Queue<int[][]> queue = new LinkedList<>();
        queue.offer(board);
        cache.add(initialHash);
        
        int noOfSteps=0, size=1;
        while(!queue.isEmpty()) {
            int nextSize = 0;
            for(int i=0; i<size; i++) {
                int[][] temp = queue.poll();
                List<int[][]> next = possibleSlides(temp);
                for(int[][] n : next) {
                    int hash = getHash(n);
                    if(hash == finalHash) return noOfSteps+1;
                    if(!cache.contains(hash)) {
                        queue.offer(n);
                        cache.add(hash);
                        nextSize++;
                    }
                }
            }
            noOfSteps++;
            size = nextSize;
        }
        return -1;
    }
    
    public int getHash(int[][] board) {
        int number = 0,m=2,n=3;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                number = (number*10) + board[i][j];
            }
        }
        return number;
    }
    
    public List<int[][]> possibleSlides(int[][] board) {
        List<int[][]> result = new ArrayList<>();
        int m=2,n=3, i=0, j=0;
        for(int ii=0; ii<m; ii++) {
            for(int jj=0; jj<n; jj++) {
                if(board[ii][jj] == 0) {
                    i = ii; j = jj;
                    break;
                }
            }
        }
        
        //Case 1:
        int [ ][ ] arr1 = new int[board.length][];
        for(int k=0; k<m; k++) arr1[k] = board[k].clone();
        int temp = arr1[i][j];
        arr1[i][j] = arr1[1-i][j];
        arr1[1-i][j] = temp;
        result.add(arr1);
        
        //Case 2:
        if(j!=0) {
            int [ ][ ] arr = new int[board.length][];
            for(int k=0; k<m; k++) arr[k] = board[k].clone();
        
            temp = arr[i][j-1];
            arr[i][j-1] = arr[i][j];
            arr[i][j] = temp;
            result.add(arr);
        }
        
        if(j!=n-1) {
            int [ ][ ] arr = new int[board.length][];
            for(int k=0; k<m; k++) arr[k] = board[k].clone();
        
            temp = arr[i][j+1];
            arr[i][j+1] = arr[i][j];
            arr[i][j] = temp;
            result.add(arr);
        }
        return result;

    }
}