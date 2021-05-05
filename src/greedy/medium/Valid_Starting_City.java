package greedy.medium;

public class Valid_Starting_City {
	
	 public int validStartingCity(int[] distances, int[] fuel, int mpg) {
		    // Write your code here.
				boolean isValid = false;
				int currentIndex = 0;
				for(int i = 0;i < fuel.length;i++){
					fuel[i] = fuel[i] * mpg;
				}
				while(!isValid){
					isValid = checkIndex(distances, fuel,currentIndex);
					if(isValid){
						return currentIndex;
					}
					currentIndex++;
				}
		    return -1;
		  }
			
			public boolean checkIndex(int[] distances,int[] fuel,int index){
						int currentLocation = index;
						int additionalFuel = 0;
						int countLocation = 0;
						while(countLocation < distances.length){
									int currentFuel = fuel[currentLocation] + additionalFuel;
									if(currentFuel < distances[currentLocation]){
											return false;
									}
									additionalFuel = currentFuel - distances[currentLocation];
									countLocation++;
									currentLocation = (currentLocation + 1)%distances.length;
						}
				
					return true;
			}
			
			public int validStartingCity2(int[] distance, int[] fuel, int mpg) {
					int numOfCities = distance.length;
					for(int startCityIdx = 0;startCityIdx < numOfCities;startCityIdx++) {
							int milesRemaining = 0;
							
							for(int currentCityIdx = startCityIdx; currentCityIdx < startCityIdx + numOfCities; currentCityIdx++) {
									if(milesRemaining < 0) {
										continue;
									}
									
									int currentCityIdxRotated = currentCityIdx%numOfCities;
									int fuelFromCurrentCity = fuel[currentCityIdxRotated];
									int distanceToNextCity = distance[currentCityIdxRotated];
									milesRemaining += (fuelFromCurrentCity * mpg) - distanceToNextCity; 
							}
							
							if(milesRemaining >= 0) {
								return startCityIdx;
							}
					}
					
					return -1;
			}
			
			 public int validStartingCityBest(int[] distances, int[] fuel, int mpg) {
				    // Write your code here.
						int arrivedFuel = 0;
						int minFuel = 0;
						int minFuelIndex = 0;
						
						for(int i = 1;i < fuel.length;i++){
								int pastIndexFuel = fuel[i - 1];
								int pastFuelSpent = (pastIndexFuel * mpg) - distances[i - 1];
								arrivedFuel += pastFuelSpent;
								if(arrivedFuel < minFuel){
									minFuel = arrivedFuel;
									minFuelIndex = i;
								}
								
						}
						
				    return minFuelIndex;
			}
			 
			public int validStartingCityBest2(int[] distance, int[] fuel, int mpg) {
						int numOfCities = distance.length;
						int milesRemaining = 0;
						
						int indexOfStartingCityCandidate = 0;
						int milesRemainingAtStartingCityIndex = 0;
						
						for(int cityIdx = 1;cityIdx < numOfCities;cityIdx++) {
							int distanceFromPreviousCity = distance[cityIdx - 1];
							int fuelFromPreviousCity = fuel[cityIdx - 1];
							milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity;
							
							if(milesRemaining < milesRemainingAtStartingCityIndex) {
								milesRemainingAtStartingCityIndex = milesRemaining;
								indexOfStartingCityCandidate = cityIdx;
							}
						}
						
						return indexOfStartingCityCandidate;
			}

}
