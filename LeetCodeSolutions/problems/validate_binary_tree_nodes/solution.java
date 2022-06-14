class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int[] parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        int noOfLinks=0;
        for(int i=0; i<n; i++) {
            int iParent = parent[i], leftNode = leftChild[i], rightNode = rightChild[i];
            
            if(leftNode != -1) {
                if(parent[leftNode] == iParent || parent[leftNode] != leftNode) return false;
                parent[leftNode] = iParent;
                noOfLinks++;
            } 
        
            if(rightNode != -1) {
                if(parent[rightNode] == iParent || parent[rightNode] != rightNode) return false;
                parent[rightNode] = iParent;
                noOfLinks++;
            } 
        }
        
        int count=0;
        for(int i=0; i<n; i++) {
            if(parent[i] == i) count++;
        }
        
        return noOfLinks == n-1 && count==1;
    }
}