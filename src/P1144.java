package pat1101_1155;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// date: 3/13
//10
//5 -25 9 6 1 3 4 2 5 17
public class P1144 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnts = scanner.nextInt();
		scanner.nextLine();
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < cnts; i++) {
			int  data = scanner.nextInt() ;
			if(data > 0)
				map.put(data , true) ;
		}
		for (int i = 1; i < map.size(); i++) {

			if (!map.containsKey(i)) {
				System.out.print(i);
				return;
			}
		}
	}
}
