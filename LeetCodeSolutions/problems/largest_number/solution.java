class Solution {
    public String largestNumber(int[] nums) {
        if(nums.length==1) {
            return ""+nums[0];
        }
        String[] result = sort(nums, 0 , nums.length-1);
        String answer = "";
        
        if("0".equals(result[0])) {
            return "0";
        }
        for(int i=0; i<result.length; i++) {
            answer += result[i];
        }
        
        return answer;
    }
    
    
    public String[] sort(int[] nums, int low, int high) {
        if(low==high) {
            String[] result = new String[1];
            result[0] = String.valueOf(nums[low]);
            return result;
        }
        int mid = (low+high)/2;
        String[] a = sort(nums, low, mid);
        String[] b =sort(nums, mid+1, high);
        String[] result = merge(a,b);
        return result;
    }
    
    public boolean isHigher(String a, String b) {
        String c1 = a+b;
        String c2 = b+a;
        int i=0;
        while(i<c1.length()) {
            if(c1.charAt(i)>c2.charAt(i)) {
                return true;
            } else if(c1.charAt(i)<c2.charAt(i)) {
                return false;
            } else {
                i++;
            }
        }
        return false;
    }
    
    public String[] merge(String[] a, String[] b) {
        String[] result = new String[a.length+b.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<a.length && j<b.length) {
            if(isHigher(a[i], b[j])) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        if(i>=a.length) {
            while(j<b.length) {
                result[k++] = b[j++];
            }
        } else if(j>=b.length) {
            while(i<a.length) {
                result[k++] = a[i++];
            }
        }
        return result;
    }
}