class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
     
        int ax1 = rec1[0];
        int ay1 = rec1[1];
        
        int ax2 = rec1[2];
        int ay2 = rec1[3];
        
        int bx1 = rec2[0];
        int by1 = rec2[1];
        
        int bx2 = rec2[2];
        int by2 = rec2[3];
        
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
        
        return l*b != 0;
    }
}