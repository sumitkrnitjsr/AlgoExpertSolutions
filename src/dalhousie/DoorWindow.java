package dalhousie;
import java.util.Scanner;

public class DoorWindow {
	
	
	
	public static void main(String[] args) {
			Entrance[] windows = new Window[6];
			Entrance[] doors = new Door[5];
		
			for(int i = 0;i < 6;i++) {
				windows[i] = new Window(i, 0);
			}
			
			for(int i = 0;i < 5;i++) {
				doors[i] = new Door(i, 0);
			}
			
			Scanner sc = new Scanner(System.in);
			String entr = sc.next();
			String id = sc.next();
			String operation = sc.next();
			while(entr.equals("d") || entr.equals("w")){
				Integer eid = Integer.parseInt(id);
				Integer op = Integer.parseInt(operation);
				String result;
				switch(entr) {
				case "d" :
						if(eid > 4) {
							System.out.print("Invalid ID");
							break;
						}
						result = doors[eid].operate(op);
						if(result.contains("Invalid"))
							System.out.print(result);
						else
						System.out.print("Door " + id + " time = " + doors[eid].time);
					break;
					
				case "w" :
					if(eid > 5) {
						System.out.print("Invalid ID");
						break;
					}
					result = windows[eid].operate(op);
					if(result.contains("Invalid"))
						System.out.print(result);
					else
					System.out.print("Window " + id + " time = " + windows[eid].time);
					
					break;
				}
				sc.nextLine();
				entr = sc.next();
				id = sc.next();
				operation = sc.next();
			}
	}


}


abstract class Entrance {
	
	private static int totalTime = 0;
	public int ID;
	// Enum STATE
	public int STATE; // 0 for CLOSE and 1  for open
	public int time = 0;
	public int operationTime;
	
	public Entrance(int id, int state,int operationTime) {
		ID = id;
		STATE = state;
		this.operationTime = operationTime;
	}
	
	// Enum Action
	public String operate(int action) {
		if(STATE == action) {
			return "Already in this state, Invalid Operation";
		}
		STATE = action;
		time += operationTime;
		totalTime += operationTime;
		return "Successfull " + ID;
	}
}

class Window extends Entrance{
	
	public Window(int id, int state) {
		super(id, state, 60);
	}
}

class Door extends Entrance{
	
	public Door(int id, int state) {
		super(id, state, 50);
	}
}