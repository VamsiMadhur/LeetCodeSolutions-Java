class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        if(rowIndex == 0) {
            return result;
        }
        Map<Integer, Integer> ncrSet = new HashMap<Integer, Integer>();
        for(int i=1; i<rowIndex; i++) {
            int val = 0;
            if(ncrSet.containsKey(rowIndex-i)) {
                val = ncrSet.get(rowIndex-i);
            }else {
                val = nCr(rowIndex,i);    
                ncrSet.put(i, val);
            }
            result.add(val);
        }
        result.add(1);
        return result;
    }
    
    private int nCr(int n, int r) {
        long result = (n-r+1);
        int i=(n-r+1);
        int j=2;
        int k=2;
        while(j<=r) {
            i++;
            result *= i;
            j++;
            while(k<=r && result%k == 0) {
                result /= k;
                k++;
            }
        }
        while(k<=r && result%k == 0) {
            result /= k;
            k++;
        }
        return (int)result;
    }
}