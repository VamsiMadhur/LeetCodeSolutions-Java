class Solution {
    public int minMeetingRooms(int[][] intervals) {        
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        int i=0;
        for(int[] interval : intervals) {
            start[i] = interval[0];
            end[i++] = interval[1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int start_pointer = 0, end_pointer=0;
        int usedRooms = 0;
        while(start_pointer<n) {
            
            if(start[start_pointer] < end[end_pointer]) {
                usedRooms += 1;
            } else {
                end_pointer++;
            }
            start_pointer ++;
            
        }
        
        return usedRooms;
    }
}