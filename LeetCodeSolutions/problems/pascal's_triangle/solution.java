class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0) {
            return result;
        }
        List<Integer> firstLevel = new ArrayList<Integer>();
        firstLevel.add(1);
        result.add(firstLevel);
        for(int i=1; i<numRows; i++) {
            List<Integer> previousLevel = result.get(i-1);
            List<Integer> currentLevel = new ArrayList<Integer>();
            currentLevel.add(1);
            for(int j=1; j<previousLevel.size(); j++) {
                currentLevel.add(previousLevel.get(j-1)+previousLevel.get(j));
            }
            currentLevel.add(1);
            result.add(currentLevel);
        }
        return result;
        
    }
}