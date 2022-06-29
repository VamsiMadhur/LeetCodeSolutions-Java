class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        
        int[] cache = new int[101];
        for(int num : nums1) cache[num] |= 1;
        for(int num : nums2) cache[num] |= 2;
        for(int num : nums3) cache[num] |= 4;
        
        for(int i=1; i<=100; i++) {
            if(cache[i] == 3 || cache[i] == 5 || cache[i] == 6 || cache[i] == 7)
                result.add(i);
        }
        return result;
    }
}