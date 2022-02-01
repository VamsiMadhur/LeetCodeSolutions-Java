class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
       TreeSet<Integer> visited = new TreeSet<>();
        
        int day = 1;
        for(int bulb : bulbs) {
            visited.add(bulb);
            Integer down = visited.lower(bulb);
            Integer up = visited.higher(bulb);
            
            if(down !=null && bulb - down -1 == k) return day;
            else if(up !=null &&  up - bulb -1 == k) return day;
            day++;
        }
        return -1;
    }
    
   
}