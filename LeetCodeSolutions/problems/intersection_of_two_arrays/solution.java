class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {  
        Set<Integer> set1 = new HashSet<>();
        for(int n : nums1) {
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int k = 0;
        for(Integer num : set1) {
                result[k++] = num;
        }
        return result;
    }
}