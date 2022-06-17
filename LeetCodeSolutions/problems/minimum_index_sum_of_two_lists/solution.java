class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> cache = new HashMap<>();
        for(int i=0; i<list1.length; i++) {
            cache.put(list1[i], i);
        }
        
        int sum=3000;
        int idx=0;
        for(int i=0; i<list2.length; i++) {
            int temp = i + cache.getOrDefault(list2[i], 2000);
            if(temp < sum) {
                sum = temp;
                idx=0;
                list1[idx++] = list2[i];
            } else if(temp == sum) {
                list1[idx++] = list2[i];
            }
        }
        return Arrays.copyOf(list1, idx);
    }
}