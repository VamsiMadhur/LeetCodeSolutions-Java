class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        
         int l = 0;
        if(ax1<=bx1 && bx1<=ax2 && ax2<=bx2) {
            l = ax2 - bx1;
        } else if(bx1<=ax1 && ax1<=bx2 && bx2<=ax2) {
            l = bx2 - ax1;
        } else if(ax1 <= bx1 && bx1 <= bx2 && bx2 <= ax2) {
            l = bx2 - bx1;
        } else if(bx1 <= ax1 && ax1 <= ax2 && ax2 <= bx2) {
            l = ax2 - ax1;
        }
        
        int b = 0;
        if(ay1<=by1 && by1<=ay2 && ay2<=by2) {
            b = ay2 - by1;
        } else if(by1<=ay1 && ay1<=by2 && by2<=ay2) {
            b = by2 - ay1;
        } else if(ay1 <= by1 && by1 <= by2 && by2 <= ay2) {
            b = by2 - by1;
        } else if(by1 <= ay1 && ay1 <= ay2 && ay2 <= by2) {
            b = ay2 - ay1;
        }
        
        int result = Math.abs(area1) + Math.abs(area2) - Math.abs((l*b));
        return result;
    }
}