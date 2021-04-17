package arrays.easy;
import java.util.*;


public class Tournament_Winner {
	
	 public String tournamentWinner(
		      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
		    	HashMap<String, Integer> score = new HashMap<>();
					int maxScore = 0;
					String win = "";
					for(int i = 0;i < results.size();i++){
							ArrayList<String> teams = competitions.get(i);
							int winner = results.get(i);
							winner = 1 - winner;
							String winnerTeam = teams.get(winner);
							Integer count = score.get(winnerTeam);
							if(count == null){
								count = 0;
							}
							count++;
							score.put(winnerTeam, count);
							if(count > maxScore){
									maxScore = count;
									win = winnerTeam;
							}
					}
		    return win;
		  }

}
