class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->(b[1]-a[1]));
        int i=0, n=boxTypes.length, result=0;
        while(i<n && truckSize >= boxTypes[i][0]) {
            result += (boxTypes[i][0] * boxTypes[i][1]);
            truckSize -= boxTypes[i++][0];
        }
        if(i<n) 
            result += (truckSize* boxTypes[i][1]);
        return result;
    }
}