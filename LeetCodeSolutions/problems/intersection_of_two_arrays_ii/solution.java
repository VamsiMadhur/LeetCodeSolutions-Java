class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0; int m = nums1.length; 
        int j=0; int n = nums2.length;
        while(i<m && j<n) {
            if(nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] resultArray = new int[result.size()];
        i=0;
        for(int p : result) {
            resultArray[i] = p;
            i++;
        }
        return resultArray;
    }
}