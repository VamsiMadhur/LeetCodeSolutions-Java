class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        	double answer = 0;
		int totalLength = nums1.length + nums2.length;
		int finalIndex1 = 0;
		int finalIndex2 = 0;
		double ans1 = 0;
		double ans2 = 0;
		boolean found = false;
		if (totalLength % 2 == 1) {
			finalIndex1 = (totalLength) / 2;
			finalIndex2 = -1;
		} else {
			finalIndex1 = ((totalLength) / 2) - 1;
			finalIndex2 = finalIndex1 + 1;
		}
		int i = 0, j = 0, indexCount = 0;
		while (i < nums1.length && j < nums2.length) {
			int currentNum = 0;
			if (nums1[i] <= nums2[j]) {
				currentNum = nums1[i];
				i++;
			} else if (j < nums2.length) {
				currentNum = nums2[j];
				j++;
			}
			if (finalIndex1 == indexCount) {
				ans1 = currentNum;
				if (finalIndex2 == -1) {
					found = true;
					break;
				}
			} else if (finalIndex2 == indexCount) {
				ans2 = currentNum;
				found = true;
				break;
			}

			indexCount++;
		}
		if (!found) {
			while (i < nums1.length) {
				if (finalIndex1 < indexCount) {
					if (i<nums1.length && finalIndex2 != -1) {
						ans2 = nums1[i];
						found = true;
						break;
					}
				} else if (finalIndex1 == indexCount) {
					ans1 = nums1[i];
					if (finalIndex2 != -1) {
						ans2 = nums1[i + 1];
					}
					found = true;
					break;
				}
				i++;
				indexCount++;
			}
		}
		if (!found) {
			while (j < nums2.length) {
				if (j<nums2.length && finalIndex1 < indexCount) {
					if (finalIndex2 != -1) {
						ans2 = nums2[j];
						found = true;
						break;
					}
				} else if (finalIndex1 == indexCount) {
					ans1 = nums2[j];
					if (finalIndex2 == -1) {
					} else {
						ans2 = nums2[j + 1];
					}
					found = true;
					break;
				}
				j++;
				indexCount++;
			}
		}
		if (finalIndex2 == -1) {
			answer = ans1;
		} else {
			answer = (ans1 + ans2) / 2;
		}
		return answer;
    }
}