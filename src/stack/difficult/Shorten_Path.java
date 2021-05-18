package stack.difficult;
import java.util.*;
import java.util.stream.Collectors;


public class Shorten_Path {
	
	 public static String shortenPath(String path) {
		    // Write your code here;
				Stack<String> stack = new Stack<>();
				int idx = 0;
				String beginString = path.charAt(0) == '/'?"/":"..";
				
				while(idx < path.length()) {
						while(idx < path.length() - 1 && 
									path.substring(idx, idx + 2).equals("./")){
								idx += 2;
						}
						char ch = path.charAt(idx);
						switch(ch) {
							case '/' :
								if(stack.isEmpty() || !stack.peek().equals("/"))
								stack.push("/");
								idx++;
								break;
							case '.' :
								 if(idx < path.length() - 1 && path.charAt(idx + 1) == '.') {
										while(!stack.isEmpty() && stack.peek().equals("/")){
												stack.pop();
										}
										if(!stack.isEmpty() && !stack.peek().equals("..")) {
											stack.pop();
										}else{
											if(!stack.isEmpty()){
													stack.push("/");
													stack.push("..");
											}else {
													stack.push(beginString);
											}
										}
										idx += 2;
								}else {
										idx++;
								}
								
								break;
								default :
									String folder = "";
									while(idx < path.length() && 
												checkSymbol(path.charAt(idx))){
												folder = folder + Character.toString(path.charAt(idx));
												idx++;
									}
									stack.push(folder);
								break;
						}

				}
				
				if(stack.size() > 1 && stack.peek().equals("/")) 
									 stack.pop();
									 
				String finalString = "";
				while(!stack.isEmpty()) {
						String str = stack.pop();
						finalString = str + finalString;
				}
				
				if(finalString.length() == 0) finalString = beginString;
			
		    return finalString;
		  }
			
			private static boolean checkSymbol(char ch) {
					return (ch != '/' && ch != '.');
			}
			
		public static String shortenPathBest(String path) {
			boolean startsWithPath = path.charAt(0) == '/';
			String[] tokensArr = path.split("/");
			List<String> tokensList = Arrays.asList(tokensArr);
			List<String> filteredTokens = (List<String>) tokensList.stream().filter(token -> isImportantToken(token)).collect(Collectors.toList());
			List<String> stack = new ArrayList<>();
			if(startsWithPath) stack.add("");
			for(String token: filteredTokens) {
				if(token.equals("..")) {
					if((stack.size() == 0) || stack.get(stack.size() - 1).equals("..")) {
						stack.add(token);
					}else if(!stack.get(stack.size() - 1).equals("")) {
						stack.remove(stack.size() - 1);
					}
				}else {
					stack.add(token);
				}
			}
			
			if(stack.size() == 1 && stack.get(0).equals("")) return "/";
			return String.join("/", stack);
			
		}
		
		private static boolean isImportantToken(String token) {
				return token.length() > 0 && !token.equals(".");
		}

}
