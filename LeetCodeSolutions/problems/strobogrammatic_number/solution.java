class Solution {
    public boolean isStrobogrammatic(String nums) {
        
        int i=0;
        int j=nums.length()-1;
        
        while(i<=j) {
            if(nums.charAt(i) == '0') {
                if(nums.charAt(j) != '0') return false;
            } else if(nums.charAt(i) == '1') {
                if(nums.charAt(j) != '1') return false;
            } else if(nums.charAt(i) == '6') {
                if(nums.charAt(j) != '9') return false;
            } else if(nums.charAt(i) == '9') {
                if(nums.charAt(j) != '6') return false;
            } else if(nums.charAt(i) == '8') {
                if(nums.charAt(j) != '8') return false;
            } else {
                return false;
            }
            i++;
            j--;
        }
   
        return true;
    }
    
}