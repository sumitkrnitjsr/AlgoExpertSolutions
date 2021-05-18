package string.medium;
import java.util.*;

public class Valid_IP_Addresses2 {
	
	public ArrayList<String> validIPAddresses(String string) {
			ArrayList<String> ipAddressesFound = new ArrayList<>();
			for(int i = 1;i < Math.min(string.length(), 4);i++) {
				String[] currentIpAddressesParts = new String[] {"", "", "", ""};
				currentIpAddressesParts[0] = string.substring(0, i);
				
				if(!isValidPart(currentIpAddressesParts[0])) {
					continue;
				}
				
				for(int j = i + 1;j < i + Math.min(string.length() - i, 4);j++) {
					currentIpAddressesParts[1] = string.substring(i,j);
					if(!isValidPart(currentIpAddressesParts[1])) {
						continue;
					}
					
					for(int k = j + 1;k < j + Math.min(string.length() - j, 4);k++) {
						currentIpAddressesParts[2] = string.substring(j,k);
						currentIpAddressesParts[3] = string.substring(k);
						
						if(isValidPart(currentIpAddressesParts[2]) && 
								isValidPart(currentIpAddressesParts[3])) {
							ipAddressesFound.add(join(currentIpAddressesParts));
						}
					}
				}
			}
			return ipAddressesFound;
	}
	
	private boolean isValidPart(String string) {
			int stringAsInt = Integer.parseInt(string);
			if(stringAsInt > 255) return false;
			
			return string.length() == Integer.toString(stringAsInt).length();
	}
	
	public String join(String[] strings) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int l = 0;l < strings.length;l++) {
			stringBuilder.append(strings[l]);
			if(l < strings.length - 1) {
				stringBuilder.append(".");
			}
		}
		
		return stringBuilder.toString();
	}

}
