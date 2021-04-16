class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        List<int[]> result = new ArrayList<>();
        int i=0, j=0;
        
        while(i<intervals.length) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            int endTime = intervals[i][1];
            
            
            while(i<intervals.length && intervals[i][0] <= endTime) {
                if(endTime < intervals[i][1])
                    endTime = intervals[i][1];
                i++;
            }
            temp[1] = endTime;
            result.add(temp);
        }
        return result.toArray(new int[result.size()][]);
    }
}