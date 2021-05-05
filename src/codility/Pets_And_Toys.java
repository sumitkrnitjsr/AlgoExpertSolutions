package codility;
import java.util.*;

/*

During an Animal Day event, N people (numbered from 0 to N−1) showed up. Each of them had either a dog or a cat. The organizers decided to give them a wonderful gift: a toy for each animal.

After the event, it turned out that some people who owned a dog had received a cat-toy, and some people who owned a cat received a dog-toy. People may exchange toys, but only if they know each other (otherwise they have no way to contact the other person). The pair of people can exchange toys multiple times.

Knowing who knows who, who owns which animal, and what kind of toy he or she received, can you determine whether it is possible for people to exchange toys in such a way that every dog ends up with a dog-toy and every cat gets a cat-toy?

Write a function:

class Solution { public boolean solution(int[] P, int[] T, int[] A, int[] B); }

that returns true if it is possible to exchange toys in such a way that every animal receives an appropriate toy, or false otherwise. First two arrays describe the pets (array P) and toys (array T) that every person owns. The J-th person owns pet P[J] and toy T[J] (1 means dog or dog-toy and 2 means cat or cat-toy). The next two arrays, A and B, both of length M, describe the relationships between people. For each integer K from 0 to M−1, person A[K] knows person B[K].

*/



public class Pets_And_Toys {
	
	 private int getParent(int index, int[] set) {
	        if(set[index] == index) {
	            return index;
	        }

	        int parent = getParent(set[index], set);
	        set[index] = parent;
	        return parent;
	    }

	    private void setParent(int child, int parent, int[] set) {
	            int max = (child > parent)?child:parent;
	            int min = (max == child)?parent:child;
	            int pMin = getParent(min, set);
	            int pMax = getParent(max, set);
	            if(pMin == pMax) {
	                return;
	            }else {
	                int maxParent = (pMin > pMax)?pMin:pMax;
	                int minParent = (maxParent == pMin)?pMax:pMin;
	                set[minParent] = maxParent;
	            }
	    }

	    private void createSet(int[] set,int[] A,int[] B) {
	        for(int i = 0;i < A.length;i++) {
	            setParent(A[i], B[i], set);
	        }
	    }


	    public boolean solution(int[] P, int[] T, int[] A, int[] B) {
	        // write your code in Java SE 8
	        int length = P.length;
	        int[] set = new int[length];
	        boolean[] visited = new boolean[length];
	        for(int i = 0;i < length;i++){
	            set[i] = i;
	        }
	        createSet(set, A, B);

	        HashMap<Integer, HashSet<Integer>> sets = new HashMap<Integer, HashSet<Integer>>();

	        for(int i = 0;i < length;i++) {
	            int parent = getParent(i, set);
	            HashSet<Integer> children = sets.get(parent);
	            if(children == null) {
	                children = new HashSet<Integer>();
	            }
	            children.add(i);
	            sets.put(parent, children);
	        }

	        for(int i = 0;i < sets.size();i++) {
	            if(visited[i]){
	                continue;
	            }
	            HashSet<Integer> list = sets.get(getParent(i, set));
	            int dogCount = 0;
	            int catCount = 0;
	            int dToy = 0;
	            int cToy = 0;
	            for(Integer itr: list) {
	                if(P[itr] == 1){
	                    dogCount++;
	                }else{
	                    catCount++;
	                }

	                if(T[itr] == 1) {
	                    dToy++;
	                }else{
	                    cToy++;
	                }
	                visited[itr] = true;
	            }
	            if(dogCount != dToy || catCount != cToy) {
	                return false;
	            }

	        }

	        return true;
	    }

}
