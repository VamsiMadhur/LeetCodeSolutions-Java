class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int[] len = new int[n];
        for(int i=0; i<n; i++) {
            len[i] = words[i].length();
        }
        List<String> result = new ArrayList<String>();
        
        int i=0;
        while(i<n) {
            StringBuilder temp = new StringBuilder();
            int start = i;
            int currlen = 0;
            int nextlen = len[start];
            
             while(currlen+nextlen <= maxWidth) {
                 currlen += nextlen + 1;
                 i++;
                 if(i>=n) break;
                 nextlen = len[i];
             }
            int end = i-1;
            
            int morespaces = maxWidth - currlen + 1;
            int noOfWords = end - start;
            
            if(end == n-1) {
                for(int k=start; k<end; k++) {
                    temp.append(words[k]).append(" ");
                }
                temp.append(words[end]);
                for(int k=0; k<morespaces; k++) temp.append(" ");
            } else {
                if(noOfWords != 0) {
                    int eachSpaceWidth = morespaces/noOfWords;
                    int extraSpaces = morespaces%noOfWords;
                    for(int j=start; j<end; j++) {
                        temp.append(words[j]).append(" ");
                        for(int k=0; k<eachSpaceWidth; k++) {
                                temp.append(" ");
                        }
                        if(extraSpaces>=1) {
                            temp.append(" ");
                            extraSpaces--;
                        }
                    }
                    temp.append(words[end]);
                } else {
                    temp.append(words[end]);
                     for(int k=0; k<morespaces; k++) {
                        temp.append(" ");   
                     }
                }
            }
            
            result.add(temp.toString());
        }
        return result;
    }
}