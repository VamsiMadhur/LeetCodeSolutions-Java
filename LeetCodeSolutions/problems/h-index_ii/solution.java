class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int index = 1;
        while(index <= n) {
            if(citations[n-index] < index) break;
            index++;
        }
        return index==1 ? 0:index-1;
    }
}