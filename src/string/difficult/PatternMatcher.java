package string.difficult;
import java.util.*;

public class PatternMatcher {
	
	 public static String[] patternMatcher(String pattern, String str) {
		    // Write your code here.
				
				String[] xy = new String[]{};
				if(pattern.length() > str.length()) return xy;
				String newPattern = getPattern(pattern);
				int xCount = 0;
				int yCount = 0;
				int firstIdx = -1;
				boolean reverse = !newPattern.equals(pattern);
				
				for(int i = 0;i < newPattern.length();i++) {
						if(newPattern.charAt(i) == 'x') {
								xCount++;
						} else {
								yCount++;
								if(firstIdx == -1) firstIdx = i;
						}
				}
				
				
				for(int len = 1;len <= str.length();len++) {
					
						StringBuilder strB = new StringBuilder();
						String firstString = str.substring(0, len);
						double secondStringLength = 0;
						String secondString = "";
						if(firstIdx != -1) {
								secondStringLength = (str.length() - (len * xCount)) / yCount;
								if(Math.floor(secondStringLength) != Math.ceil(secondStringLength)) continue;
								int secondIdx = (firstIdx * len);
								System.out.println(secondIdx + " " + secondStringLength);
								if(secondStringLength < 0 || secondIdx + secondStringLength > str.length()) break;
								secondString = str.substring(secondIdx, secondIdx + (int)secondStringLength);
						}
						
						
						for(int j = 0;j < newPattern.length();j++) {
								if(newPattern.charAt(j) == 'x') {
										strB.append(firstString);
								}else{
										strB.append(secondString);
								}
						}
						
						if(strB.toString().equals(str)) {
								xy = new String[2];
								xy[0] = firstString;
								xy[1] = secondString;
								if(reverse) Collections.reverse(Arrays.asList(xy));
								return xy;
						}
				}
				
				if(reverse) Collections.reverse(Arrays.asList(xy));
				
		    return xy;
		  }
			
			private static String getPattern(String str) {
					if(str.charAt(0) == 'x') return str;
					StringBuilder sb = new StringBuilder();
					for(int i = 0;i < str.length();i++) {
							if(str.charAt(i) == 'x') {
									sb.append('y');
							}else{
									sb.append('x');
							}
					}
					return sb.toString();
			}

}
