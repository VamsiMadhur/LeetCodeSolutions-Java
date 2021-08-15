class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();

        for(int i : arr) {
            count.put(i, count.getOrDefault(i, 0)+1);
        }
    
        for(int x : count.keySet()) {
            if(count.get(x) == 0) continue;
            int want = x<0 ? x/2 : 2*x;
            if((x<0 && x%2!=0) || count.get(x) > count.getOrDefault(want, 0)) {
                return false;
            }
            
            count.put(want, count.get(want)-count.get(x));
            count.put(x,0);
        }
        
        return true;
    }
}