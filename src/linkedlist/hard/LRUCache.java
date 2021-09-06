package linkedlist.hard;

public class LRUCache {
	
	 static class LRUCache extends LinkedHashMap<String,Integer>{
		    int maxSize;
				String mostRecent;
				
		    public LRUCache(int maxSize) {
		      super(maxSize > 1 ? maxSize : 1, 0.75f, true);
					this.maxSize = maxSize > 1 ? maxSize : 1;
		    }

		    public void insertKeyValuePair(String key, int value) {
		      // Write your code here.
					super.put(key, value);
					mostRecent = key;
		    }

		    public LRUResult getValueFromKey(String key) {
		      // Write your code here.
		      Integer result =  super.getOrDefault(key, null);
					if(result == null) return null;
					mostRecent = key;
					return new LRUResult(result != null,
																result);
		    }

		    public String getMostRecentKey() {
		      // Write your code here.
		      return mostRecent;
		    }
				
				@Override
				protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
						return size() > maxSize;
				}
				
	}
	 
	 
	 

}
