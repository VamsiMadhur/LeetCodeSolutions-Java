class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candies = new HashSet<>();
        for(int type : candyType) {
            candies.add(type);
        }
        int n = candyType.length/2;
        return candies.size() >= n ? n : candies.size();
    }
}