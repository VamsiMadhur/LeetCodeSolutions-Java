/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = 0;
        List<int[]> cache = new ArrayList<>();
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        
        int size = nestedList.size();
        while(!queue.isEmpty()) {
            depth++;
            int nextSize = 0;
            for(int i=0; i<size; i++) {
                NestedInteger curr = queue.poll();
                if(curr.isInteger()) {
                    cache.add(new int[]{curr.getInteger(), depth});
                } else {
                    queue.addAll(curr.getList());
                    nextSize += curr.getList().size();
                }
            }
            size = nextSize;
        }
        
        int result = 0;
        for(int[] curr : cache) {
            result += (curr[0] * (depth - curr[1] + 1));
        }
        return result;
    }
}