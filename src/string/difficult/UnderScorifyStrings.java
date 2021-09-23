package string.difficult;
import java.util.*;

public class UnderScorifyStrings {
	
	 public static String underscorifySubstring(String str, String substring) {
		    // Write your code here.
				List<Integer[]> locations = merge(getLocations(str, substring));
		    return addChar(str, locations);
		  }
			
			private static List<Integer[]> getLocations(String str, String substr) {
					List<Integer[]> locations = new ArrayList<>();
					int idx = 0;
					while(idx < str.length()) {
							int nextIdx = str.indexOf(substr, idx);
							if(nextIdx != -1) {
									locations.add(new Integer[] {nextIdx, nextIdx + substr.length()});
									idx = nextIdx + 1;
							}else{
									break;
							}
					}
					return locations;
			}
			
			private static List<Integer[]> merge(List<Integer[]>  list) {
						if(list.size() == 0) return list;
						List<Integer[]> mergedList = new ArrayList<>();
						mergedList.add(list.get(0));
						Integer[] previous = list.get(0);
				
						for(int i = 1;i < list.size();i++) {
								Integer[] current = list.get(i);
								if(current[0] <= previous[1]) {
										previous[1] = current[1];
								}else{
										mergedList.add(current);
										previous = current;
								}
						}
				
				return mergedList;
			}
			
			private static String addChar(String str, List<Integer[]> positions) {
						int locationsIdx = 0;
						int strIdx = 0;
						boolean betweenScores = false;
						List<String> finalChars = new ArrayList<>();
						int i = 0;
						while(strIdx < str.length() && locationsIdx < positions.size()) {
									if(strIdx == positions.get(locationsIdx)[i]) {
											finalChars.add("_");
											betweenScores = !betweenScores;
											if(!betweenScores) {
													locationsIdx++;
											}
											i = i == 1 ? 0 : 1;
									}
									finalChars.add(String.valueOf(str.charAt(strIdx)));
									strIdx++;
						}
						if(locationsIdx < positions.size()) {
								finalChars.add("_");
						} else if(strIdx < str.length()) {
								finalChars.add(str.substring(strIdx));
						}
						return String.join("", finalChars);
			}

}
