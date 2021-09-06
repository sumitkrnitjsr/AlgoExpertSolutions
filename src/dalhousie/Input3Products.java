package dalhousie;
import java.util.*;

public class Input3Products {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0;i < 3;i++) {
			String name = sc.next();
			Integer price = sc.nextInt();
			System.out.println(name + " Price : " + price);
			sc.nextLine();
		}
	}

}
