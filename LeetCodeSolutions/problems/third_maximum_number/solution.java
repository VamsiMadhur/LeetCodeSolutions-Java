class Solution {
    public int thirdMax(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            if(nums[0] > nums[1]) {
                return nums[0];
            } else {
                return nums[1];
            }
        }
        int third = nums[0];
        boolean flag = false;
        int second = 0;
        int i=1;
        for(i=1; i<nums.length; i++) {
            if(third>nums[i]) {
                second = third;
                third = nums[i];
                flag = true;
                break;
            } else if(third<nums[i]) {
                second = nums[i];
                flag = true;
                break;
            }
        }
        if(!flag) {
            return third;
        }
        i++;
        flag = false;
        int first = 0;
        for(; i<nums.length; i++) {
            if(third != nums[i] && second != nums[i]) {
                if(nums[i] > second) {
                    first = nums[i];
                    flag = true;
                    break;
                } else if (nums[i] < second && nums[i] > third) {
                    first = second;
                    second = nums[i];
                    flag = true;
                    break;
                } else if(nums[i] < third) {
                    first = second;
                    second = third;
                    third = nums[i];
                    flag = true;
                    break;
                }
            }
        }
        if(!flag) {
            return second;
        }
        i++;
        for(; i<nums.length; i++) {
            if(first != nums[i] && second != nums[i] && third != nums[i]) {
                if(nums[i] < third) {
                    continue;
                } else if(nums[i] > third && nums[i] < second) {
                    third = nums[i];
                } else if(nums[i] > second && nums[i] < first) {
                    third = second;
                    second = nums[i];
                } else if (nums[i] > first) {
                    third = second;
                    second = first;
                    first = nums[i];
                }
            }
        }
        return third;
    }
}