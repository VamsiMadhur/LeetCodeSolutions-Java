class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        
        if(flowerbed.length==0) return false;
        
        if(flowerbed.length==1) {
            if(flowerbed[0]==0) {
                flowerbed[0]=1;
                n--;
                if(n==0) return true;
            }
        }
        
        if(flowerbed[0]==0 && flowerbed[1]==0) {
            flowerbed[0]=1;
            n--;
            if(n==0) return true;
        }
        
        int len = flowerbed.length;
        for(int i=1; i<len-1; i++) {
            if(flowerbed[i-1]==0 && flowerbed[i+1]==0 && flowerbed[i]==0) {
                flowerbed[i]=1;
                n--;
                if(n==0) return true;
            }
        }
        
        if(flowerbed[len-1]==0 && flowerbed[len-2]==0) {
            flowerbed[len-1]=1;
            n--;
            if(n==0) return true;
        }
        
        return n==0;
    }
}