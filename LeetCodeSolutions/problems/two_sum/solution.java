class Solution {
    public int[] twoSum(int[] nums, int target) {
        		int[] result = new int[2];
		Map<Integer, Integer> mapa = new HashMap<Integer, Integer>();

		for (int i = 0; i <= nums.length; i++) {
			int y = target - nums[i];
			int j = mapa.getOrDefault(y, -1);
			if (j != i && j != -1) {
				result[0] = i;
				result[1] = j;
				return result;
			}
			mapa.put(nums[i], i);
		}

		return result;
    }
}