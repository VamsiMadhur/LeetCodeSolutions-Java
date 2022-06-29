class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        char[] sa = s.toCharArray();
        for(char i=sa[0]; i<=sa[3]; i++) {
            for(char j=sa[1]; j<=sa[4]; j++) {
                temp.append(i).append(j);
                result.add(temp.toString());
                temp.setLength(0);
            }
        }
        return result;
    }
}