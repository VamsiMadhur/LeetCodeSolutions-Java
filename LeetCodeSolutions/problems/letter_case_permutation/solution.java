class Solution {
    public List<String> letterCasePermutation(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        
        int count = 0;
        for(char c : sa) {
            if (Character.isLetter(c))
                count++;
        }
        
        List<String> result = new ArrayList<>();
        int rSize = 1<<count;
        for(int i=0; i<rSize; i++) {
            int curr = i;
            StringBuilder word = new StringBuilder();
            for(int j=0; j<n; j++) {
                if (Character.isLetter(sa[j])) {
                    if((curr & 1) == 0) {
                        word.append(Character.toLowerCase(sa[j]));  
                    } else {
                        word.append(Character.toUpperCase(sa[j]));  
                    }
                    curr = curr>>1;
                } else {
                    word.append(sa[j]);
                }
            }
            
            result.add(word.toString());
        }
        return result;
    }
}