package mIcrosoft;

public class StringToInteger {
	
	public int myAtoi(String s) {
        
        int sign = 1, base = 0, i = 0;
        while(i < s.length() && s.charAt(i) == ' ') i++;
        
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = 1 - 2 * (s.charAt(i++) == '-' ? 1 : 0);
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if(base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > 7)) {
                    if(sign == 1) {
                        return Integer.MAX_VALUE;
                    }else {
                        return Integer.MIN_VALUE;
                    }
                }
            base = (base * 10) + (s.charAt(i++) - '0');
        }
        
        return base * sign;
    }

}
