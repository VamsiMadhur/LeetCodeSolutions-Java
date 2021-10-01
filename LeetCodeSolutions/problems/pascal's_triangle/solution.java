class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        List<Integer> firstLevel = new ArrayList<>();
        firstLevel.add(1);
        result.add(firstLevel);
        
        for(int i=1; i<numRows; i++) {
            List<Integer> prev = result.get(i-1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1; j<i; j++) {
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}