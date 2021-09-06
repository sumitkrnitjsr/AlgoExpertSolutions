package mIcrosoft;

public class ReverseWordSpaceOptimized {
	
	public void reverseWords(char[] s) {
        reverseString(s, 0, s.length - 1);
        for(int i = 0;i < s.length;i++) {
            if(s[i] != ' ') {
                int startIdx = i;
                while(i < s.length && s[i] != ' ') i++;
                int endIdx = i - 1;
                reverseString(s, startIdx, endIdx);
            }
        }
        
    }
    
    
    private void reverseString(char[] s,int startIdx,int endIdx) {
       while(startIdx < endIdx) {
           char temp = s[startIdx];
           s[startIdx] = s[endIdx];
           s[endIdx] = temp;
           startIdx++;
           endIdx--;
       }
    }

}
