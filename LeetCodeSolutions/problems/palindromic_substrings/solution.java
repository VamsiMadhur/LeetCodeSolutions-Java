class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), count=0;
        char[] sa = s.toCharArray();
        
        for(int i=0; i<n; i++) {
            int j=i-1, k=i;
            while(k<n-1 && sa[k] == sa[k+1]) k++;
            count += (((k-j) * (k-j+1)) / 2);
            i=k;
            k++;
            while(j>=0 && k<n && sa[j--] == sa[k++]) count++;
        }
        return count;
    }
    
   
}