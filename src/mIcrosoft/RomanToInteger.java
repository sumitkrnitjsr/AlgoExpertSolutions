package mIcrosoft;

public class RomanToInteger {
	
	private int map(char ch) {
        switch(ch){
            case 'M': return 1000;
            case 'D' : return 500;
            case 'C' : return 100;
            case 'L' : return 50;
            case 'X' : return 10;
            case 'V' : return 5;
            case 'I' : return 1;
        }
        
        return 0;
    }
    public int romanToInt(String s) {
        int sum = map(s.charAt(s.length() - 1));
        for(int i = s.length() - 2;i > -1;i--) {
            if(map(s.charAt(i)) < map(s.charAt(i + 1))) sum -= map(s.charAt(i));
            else sum += map(s.charAt(i));
        }
        
        return sum;
    }

}
