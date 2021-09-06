package mIcrosoft;
import java.util.*;

public class GroupAnagrams {
	
	public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> setAnagrams = new ArrayList<>();
        HashMap<String, Integer> stringMap = new HashMap<>();
        
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);    
            Integer idx = stringMap.get(sortedString);
            List<String> listString = new ArrayList<>();
            if(idx == null) {
                idx = stringMap.size();
                listString.add(str);
                setAnagrams.add(listString);
                stringMap.put(sortedString, idx);
            }else {
                listString = setAnagrams.get(idx);
                listString.add(str);
            }
            
        }

        return setAnagrams;
    }
	
	
	public List<List<String>> groupAnagrams2(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        int[] count = new int[26];
	        for (String s : strs) {
	            Arrays.fill(count, 0);
	            for (char c : s.toCharArray()) count[c - 'a']++;

	            StringBuilder sb = new StringBuilder("");
	            for (int i = 0; i < 26; i++) {
	                sb.append('#');
	                sb.append(count[i]);
	            }
	            String key = sb.toString();
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	  }
	

}
