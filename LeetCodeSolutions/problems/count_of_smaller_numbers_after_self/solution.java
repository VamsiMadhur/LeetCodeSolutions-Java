class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        
        int[] fenwickTree = new int[20002];
        LinkedList<Integer> result = new LinkedList<>();
        
        for(int i=n-1; i>=0; i--) {
            //Index of that number
           int index = nums[i]+10000;
            
            //Calculate how many low numbers are present till now
            //If index = 7(111), we need values at 7(111), 6(110) and 4(100)
            int sum = 0;
            while(index > 0){
                sum += fenwickTree[index];
                index -= (index & -index); //go to the child
            }
            result.addFirst(sum);
            
            //Now add that this element exist and increase the count
            index = nums[i]+10001;
            while(index < fenwickTree.length){
                fenwickTree[index] += 1;
                //Go to Parent
                index += (index & -index);
            }
        }
        return result;
    }
}