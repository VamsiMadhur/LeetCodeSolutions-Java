class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> cache = new HashSet<>();
        for(String num : nums) {
            cache.add(num);
        }
        
        StringBuilder init = new StringBuilder();
        for(int i=0; i<n; i++) {
            init.append("0");
        }
        String curr = init.toString();

        int i=0;
        while(true) {
              if(!cache.contains(curr)) {
                return curr;
            }
            int j = curr.length()-1;
            while(j>=0 && curr.charAt(j) == '1') {
                j--;
            }
            if(j==-1) return "";

            StringBuffer temp = new StringBuffer(curr.substring(0, j));
            temp.append("1");
            for(int k=j+1; k<curr.length(); k++) {
                temp.append("0");
            }
            curr = temp.toString();
          
            i++;
        }
    }
}