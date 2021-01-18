class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int total = m+n;
        while(i<m && j<n) {
            if(nums1[i] > nums2[j]) {
                for(int k=m-1; k>=i; k--) {
                    nums1[k+1] = nums1[k];    
                }
                nums1[i] = nums2[j];
                m=m+1;
                j++;
            } else {
                i++;
            }
        }
        while(j<n) {
            nums1[m] = nums2[j];
            j++;
            m++;
        }
    }
}