package graph.medium;

public class Youngest_Common_Ancestor {
	
	// backtrackAncestraltree(Ancestraltree lowerdescendant, ANcestralTree higherDescendant, int diff)
	
	 public static AncestralTree getYoungestCommonAncestor(
		      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
		    // Write your code here.
				int depthOne = 0;
				AncestralTree temp = descendantOne;
				while(temp != topAncestor) {
						temp = temp.ancestor;
						depthOne++;
				}
				temp = descendantTwo;
				int depthTwo = 0;
				while(temp != topAncestor) {
						temp =temp.ancestor;
						depthTwo++;
				}
				AncestralTree old = (depthTwo > depthOne) ? descendantTwo : descendantOne;
				AncestralTree young = (old == descendantTwo) ? descendantOne :descendantTwo;
				int deepest = (depthOne > depthTwo) ? depthOne : depthTwo;
				int youngest = deepest == depthTwo ? depthOne : depthTwo;
				while(youngest != deepest) {
						old = old.ancestor;
						deepest--;
				}
				
				while(old != young) {
					old = old.ancestor;
					young = young.ancestor;
				}
				
		    return old;
		  }

		  static class AncestralTree {
		    public char name;
		    public AncestralTree ancestor;

		    AncestralTree(char name) {
		      this.name = name;
		      this.ancestor = null;
		    }

		    // This method is for testing only.
		    void addAsAncestor(AncestralTree[] descendants) {
		      for (AncestralTree descendant : descendants) {
		        descendant.ancestor = this;
		      }
		    }
		  }

}
