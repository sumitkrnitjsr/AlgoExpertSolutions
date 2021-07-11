package recursion.difficult;
import java.util.*;


public class Lowest_Common_Manager {
	
	 public static OrgChart getLowestCommonManager(
		      OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		    // Write your code here.
		    return traverseTopToBottom(topManager, reportOne, reportTwo).node; // Replace this line.
		  }
			
			private static Result traverseTopToBottom(OrgChart parent, OrgChart first, OrgChart second) {
					  
					Result result = new Result();
					result.first = false;
					result.second = false;
					Result childResult;
				
					if(parent == null) {
							return result;
					}
				
					if(parent == first) {
										result.first = true;
										if(second == null) return result;
										for(OrgChart child:parent.directReports) {
												childResult = traverseTopToBottom(child, null, second);
												result.second = result.second || childResult.second;
												if(result.second) break;
										}
										
										result.node = (result.second)?parent:null;
										return result;
					}
				
					if(parent == second) {
										result.second = true;
										if(first == null) return result;				
										for(OrgChart child:parent.directReports) {
												childResult = traverseTopToBottom(child, first, null);
												result.first = result.first || childResult.first;
												if(result.first) break;
										}
										result.node = (result.first)?parent:null;
										return result;
					}
				
					for(OrgChart child:parent.directReports) {
							childResult = traverseTopToBottom(child, first, second);
							result.first = result.first || childResult.first;
							result.second = result.second || childResult.second;
							if(result.first && result.second) {
									result.node = childResult.node == null ? parent : childResult.node;
									return result;
							}
					}
				
					return result;
			}
			
			static class Result {
					Boolean first;
					Boolean second;
					OrgChart node;
			}

		  static class OrgChart {
		    public char name;
		    public List<OrgChart> directReports;

		    OrgChart(char name) {
		      this.name = name;
		      this.directReports = new ArrayList<OrgChart>();
		    }

		    // This method is for testing only.
		    public void addDirectReports(OrgChart[] directReports) {
		      for (OrgChart directReport : directReports) {
		        this.directReports.add(directReport);
		      }
		    }
		  }
		  
		  
		  
		  static class OrgInfo {
			  public OrgChart lowestCommonManager;
			  int numImportantReports;
			  
			  OrgInfo(OrgChart lowestCommonManager, int numImportantReports) {
				  this.lowestCommonManager = lowestCommonManager;
				  this.numImportantReports = numImportantReports;
			  }
		  }
		  
		  
		  private static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
			  int numImportantReports = 0;
			  
			  for(OrgChart directReport: manager.directReports) {
				  OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
				  if(orgInfo.lowestCommonManager != null) return orgInfo;
				  numImportantReports += orgInfo.numImportantReports;
			  }
			  
			  if(manager == reportOne || manager == reportTwo) numImportantReports++;
			  
			  OrgChart lowestCommonManager = numImportantReports == 2 ? manager : null;
			  OrgInfo newOrgInfo = new OrgInfo(lowestCommonManager, numImportantReports);
			  return newOrgInfo;
		  }

}
