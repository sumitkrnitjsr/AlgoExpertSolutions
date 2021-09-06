package mIcrosoft;

public class FIndCelebrity {
	
	public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1;i < n;i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }
        
        for(int i = 0;i < n;i++) {
            if(i != candidate) {
                if(knows(candidate, i)) return -1;
            }
        }
        
        for(int i = 0;i < n;i++) {
            if(i != candidate) {
                if(!knows(i, candidate)) return -1;
            }
        }
        
        
        return candidate;
    }
	
	
	public class Solution extends Relation {
	    
	    private int numberOfPeople;
	    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>(); 
	    
	    @Override
	    public boolean knows(int a, int b) {
	        if (!cache.containsKey(new Pair(a, b))) {
	            cache.put(new Pair(a, b), super.knows(a, b));
	        }
	        return cache.get(new Pair(a, b));
	    }
	    
	    public int findCelebrity(int n) {
	        numberOfPeople = n;
	        int celebrityCandidate = 0;
	        for (int i = 0; i < n; i++) {
	            if (knows(celebrityCandidate, i)) {
	                celebrityCandidate = i;
	            }
	        }
	        if (isCelebrity(celebrityCandidate)) {
	            return celebrityCandidate;
	        }
	        return -1;
	    }
	    
	    private boolean isCelebrity(int i) {
	        for (int j = 0; j < numberOfPeople; j++) {
	            if (i == j) continue; // Don't ask if they know themselves.
	            if (knows(i, j) || !knows(j, i)) {
	                return false;
	            }
	        }
	        return true;
	    }
	}

}
