package mIcrosoft.random;

public class IsRectangleOverlap {
	
	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int leftmost1 = rec1[0];
        int rightmost1 = rec1[2];
        int top1 = rec1[3];
        int bottom1 = rec1[1];
        
        int leftmost2 = rec2[0];
        int rightmost2 = rec2[2];
        int top2 = rec2[3];
        int bottom2 = rec2[1];
        
        if(leftmost1 == rightmost1 || leftmost2 == rightmost2 
          || top1 == bottom1 || top2 == bottom2)
            return false;
        
        // return !(rightmost1 <= leftmost2 || top1 <= bottom2 || leftmost1 >= rightmost2 || bottom1 >= top2);
         return (leftmost2 < rightmost1 && rightmost2 > leftmost1 && top2 > bottom1 && bottom2 < top1);
            
        
    }

}
