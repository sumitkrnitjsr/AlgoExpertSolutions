package graph.difficult;
import java.util.*;

public class DetectArbitrage {
	
	 public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
		    // Write your code here.
				ArrayList<ArrayList<Double>> logRates = new ArrayList<>();
				for(int row = 0;row < exchangeRates.size();row++) {
						ArrayList<Double> rates =  exchangeRates.get(row);
						logRates.add(new ArrayList<Double>());
						for(Double rate: rates)
								logRates.get(row).add(-Math.log10(rate));
				}
				
				double[] distanceFromStart = new double[logRates.size()];
				Arrays.fill(distanceFromStart, Double.MAX_VALUE);
				distanceFromStart[0] = 0;
				
				boolean updated = false;
				for(int unused = 0;unused < logRates.size();unused++) {
						updated = false;
						for(int srcIdx = 0;srcIdx < logRates.size();srcIdx++) {
								ArrayList<Double> edges = logRates.get(srcIdx);
								for(int destIdx = 0;destIdx < edges.size();destIdx++) {
										double edgeWeight = edges.get(destIdx);
										double newDist = distanceFromStart[srcIdx] + edgeWeight;
										if(newDist < distanceFromStart[destIdx]) {
												updated = true;
												distanceFromStart[destIdx] = newDist;
										}
								}
						}
						if(!updated) return false;		
				}
				
				
				
				updated = false; 
						for(int srcIdx = 0;srcIdx < logRates.size();srcIdx++) {
								ArrayList<Double> edges = logRates.get(srcIdx);
								for(int destIdx = 0;destIdx < edges.size();destIdx++) {
										double edgeWeight = edges.get(destIdx);
										double newDist = distanceFromStart[srcIdx] + edgeWeight;
										if(newDist < distanceFromStart[destIdx]) {
												updated = true;
												distanceFromStart[destIdx] = newDist;
										}
								}
						}
				
		    return updated;
		  }

}
