class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for(int num : nums) cache.add(num);
        
        int result = 0, currentNum=0;
        for(int num : nums) {
            if(!cache.contains(num-1)) {
                currentNum = num;
                while(cache.remove(++currentNum));
                result = Math.max(result, (currentNum-num));
            }
        }
        return result;
        
    }
}