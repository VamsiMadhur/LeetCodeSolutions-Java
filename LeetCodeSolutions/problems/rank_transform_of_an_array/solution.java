class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if(arr == null || arr.length==0) {
            return new int[0];
        }
        int[] temp = arr.clone();
        Arrays.sort(temp);
        
        Map<Integer, Integer> mapper = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            mapper.putIfAbsent(temp[i], mapper.size()+1);
        }
        
        for(int i=0; i<arr.length; i++) {
            temp[i] = mapper.get(arr[i]);
        }
        return temp;
    }
}