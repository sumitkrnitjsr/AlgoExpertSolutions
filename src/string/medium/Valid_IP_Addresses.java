package string.medium;
import java.util.*;

public class Valid_IP_Addresses {
	
	 public ArrayList<String> validIPAddresses(String string) {
		    // Write your code here.
				ArrayList<String> ips = new ArrayList<>();
		    validIPAddresses(string, ips, 0, "","","","");
				return ips;
		  }
			
			private  void validIPAddresses(String string, ArrayList<String> ips, int idx,String first,String second,String third, String fourth) {
					if(fourth.length() > 0){
						System.out.println(first + "." + second + "." + third + "." + fourth);
						if(idx == string.length()
							&& validate(first, second,third,fourth)) {
							String ip = first + "." + second + "."
													+ third + "." + fourth;
							ips.add(ip);
						}
						return;
					}
					if(idx > string.length() - 1) {
							return;
					}
				
					HashMap<Integer,Integer> masks = createPin(string, idx);
					for(Map.Entry<Integer,Integer> entry: masks.entrySet()) {
							String mask = Integer.toString(entry.getKey());
							int index = entry.getValue();
							if(first.length() == 0){
								validIPAddresses(string, ips, index, mask,second,third,fourth);
							}else if(second.length() == 0){ 	
								validIPAddresses(string, ips, index, first,mask,third, fourth);
							}else if(third.length() == 0) {
								validIPAddresses(string, ips, index, first,second,mask, fourth);
							}else{
								validIPAddresses(string, ips, index, first,second,third, mask);
							}
					}
					
					
			}
			
			private HashMap<Integer,Integer> createPin(String str,int idx) {
					HashMap<Integer,Integer> maskList = new HashMap<Integer,Integer>();	
					if(str.charAt(idx) == '0') {
							maskList.put(0, idx + 1);
							return maskList;
					}
					for(int i = idx + 1;(i < idx + 4) && i <= str.length();i++) { // Wrong check case i < str.length()
							String integer = str.substring(idx, i);
							Integer mask = Integer.parseInt(integer);
							if(mask > 0 && mask < 256) {
									maskList.put(mask, i);
							}
					}
				
					return maskList;
			}
			private  boolean validate(String first, String second, String third, String fourth) {
					int fs = Integer.parseInt(first);
					int s = Integer.parseInt(second);
					int t = Integer.parseInt(third);
					int fh = Integer.parseInt(fourth);
				
				return range(fs) && range(s) && range(t) && range(fh);
			}
			
			private  boolean range(int num) {
					return num >= 0 && num < 256;
			}

}
