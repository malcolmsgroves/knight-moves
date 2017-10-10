package search;

import java.util.Scanner;
import java.util.ArrayList;

public class KnightTest {

	public static void main(String[] args) {
		int[] start = new int[2];
		int[] target = new int[2];

		//		Scanner scan = new Scanner(System.in);
		//		System.out.println("Enter begining x coordinate: ");
		//		start[0] = scan.nextInt();
		//		System.out.println("Enter begining y coordinate: ");
		//		start[1] = scan.nextInt();
		//		System.out.println("Enter target x coordinate: ");
		//		target[0] = scan.nextInt();
		//		System.out.println("Enter target y coordinate: ");
		//		target[1] = scan.nextInt();

		start[0] = 3;
		start[1] = 7;
		target[0] = 6;
		target[1] = 4;

		try {
			KnightSearch search = new KnightSearch(start, target);
			ArrayList<KnightMove> path = search.knight_BFS();

			for(int i = 0; i < path.size(); ++i) {
				System.out.print(" >> " + path.get(i).to_string());
			}
		}

		catch(Exception e) {
			System.out.println("Error: Index out of bounds");
		}




	}

}

