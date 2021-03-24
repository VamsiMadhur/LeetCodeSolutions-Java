class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        TreeMap<Integer, Integer> mapper = new TreeMap<>();
        for(int i=0; i<n; i++) {
            mapper.put(score[i], i);
        }
        
        String[] res = new String[score.length];
        
        Iterator<Integer> it=mapper.descendingKeySet().iterator();
        if(n>=1) {
            res[mapper.get(it.next())]="Gold Medal";
        }
        if(n>=2) {
            res[mapper.get(it.next())]="Silver Medal";
        }
        if(n>=3) {
            res[mapper.get(it.next())]="Bronze Medal";
        }
        
        int i=4;
        while(it.hasNext()) {
            res[mapper.get(it.next())]=i+"";
            i++;
        }
        return res;
    }
}