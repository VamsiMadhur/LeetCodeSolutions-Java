/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>(); 
    
    @Override
    public boolean knows(int a, int b) {
        if (!cache.containsKey(new Pair(a, b))) {
            cache.put(new Pair(a, b), super.knows(a, b));
        }
        return cache.get(new Pair(a, b));
    }
    
    public int findCelebrity(int n) {
        
        int candidate = 0;
        
        for(int i=0; i<n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        
        if(isCelebrity(candidate, n)) return candidate;
        return -1;
    }
    
    private boolean isCelebrity(int i, int n) {
        for (int j = 0; j < n; j++) {
            if(i!=j) {
                if (knows(i, j) || !knows(j, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}