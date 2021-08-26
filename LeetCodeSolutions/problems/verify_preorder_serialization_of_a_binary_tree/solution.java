class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] preorde = preorder.split(",");
        int index = 0;
        int total = preorde.length;
        int noOfNodesInLevel = 1;
        
        while(noOfNodesInLevel != 0) {
            int nextLevelNodes = 0;
            for(int i=0; i<noOfNodesInLevel; i++) {
                if(total <= index) return false;
               
                if(!"#".equals(preorde[index++])) {
                    nextLevelNodes += 2;
                }
            }
            noOfNodesInLevel = nextLevelNodes;
         }
        return total == index;
    }
}