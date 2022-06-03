class Solution {
    static Map<Integer, Integer> cache = new HashMap<>();
    static {
        cache.put(0, 1); cache.put(1, 1); cache.put(2, 2);
        cache.put(3, 6); cache.put(4, 24); cache.put(5, 120);
        cache.put(6, 720); cache.put(7, 5040); cache.put(8, 40320);
        cache.put(9, 362880);
    }
    public String getPermutation(int n, int k) {
        boolean[] flag = new boolean[n];
        int noOfDigits = 0, prevFact=0, numb =0, i=0;
        StringBuilder result = new StringBuilder();
        int na = n, count=0;
        do {
            prevFact  = cache.get(na-1);
            numb = (k-1)/prevFact;
            count=0;
            for(i=0; i<n; i++) {
                if(!flag[i]) {
                    if(count == numb) break;
                    count++;
                }
            }
            flag[i] = true;
            result.append((i+1));
            noOfDigits++;
            na--;
            k -= (numb*prevFact);
        } while(noOfDigits != n);
        return result.toString();
    }
}