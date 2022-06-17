class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int prev=-1, result=0;
        for(int num : timeSeries) {
            result += (prev < num ? duration : (num+duration-1-prev));
            prev = num+duration-1;
        }
        return result;
    }
}