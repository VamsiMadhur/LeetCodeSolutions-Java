class Solution {
    public int distributeCandies(int[] candyType) {
        int noOfCandies = candyType.length/2;
        boolean[] cache = new boolean[200001];
        int candyCount = 0;
        for(int candy : candyType) {
            if(!cache[candy+100000]) {
                cache[candy+100000] = true;
                candyCount++;
                if(candyCount == noOfCandies) break;
            }
        }
        return Math.min(noOfCandies, candyCount);
    }
}