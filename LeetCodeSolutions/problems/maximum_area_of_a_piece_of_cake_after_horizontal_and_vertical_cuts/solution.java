class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxH=0, maxV=0, preH=0, preV=0;
        for(int num:horizontalCuts) {
            maxH = Math.max(maxH, num-preH);
            preH = num;
        }
        maxH = Math.max(maxH, h-preH);
        for(int num:verticalCuts) {
            maxV = Math.max(maxV, num-preV);
            preV = num;
        }
        maxV = Math.max(maxV, w-preV);
        long a = maxH, b = maxV;
        return (int)((a*b)%1000000007);
        
    }
}