package pat1101_1155;

import java.util.Scanner;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;

// date: 3/14 score : 14/20  超时问题
//6
//1111
//6666
//8888
//1234
//5555
//0001
//6
//8888
//0001
//1111
//2222
//8888
//2222
public class P1116 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Map<String, String> map = new HashMap<>();
		int nums = Integer.parseInt(scanner.nextLine());
		for (int i = 1; i <= nums; i++) {
			String id = scanner.nextLine().trim();
			if (i == 1) {
				map.put(id, "Mystery Award");

			} else if (Isprime(i)) {
				map.put(id, "Minion");

			} else
				map.put(id, "Chocolate");
		}

		int quryNum = Integer.parseInt(scanner.nextLine());
		Set<String> history = new HashSet<>();
		for (int k = 0; k < quryNum; k++) {
			String quryId = scanner.nextLine().trim();
			if (!map.containsKey(quryId))
				System.out.printf("%s: Are you kidding?", quryId);
			else if (history.contains(quryId))
				System.out.printf("%s: Checked", quryId);
			else {
				System.out.printf("%s: %s", quryId, map.get(quryId));
				history.add(quryId);
			}
			if (k != quryNum - 1)
				System.out.println();
		}
		long end = System.nanoTime() ;

	}

	static boolean Isprime(int num) {
		if (num == 1)
			return false;
		if (num == 2)
			return true;
		for (int k = 2; k <= (int) Math.sqrt(num); k++)
			if (num % k == 0)
				return false;
		return true;
	}

}
