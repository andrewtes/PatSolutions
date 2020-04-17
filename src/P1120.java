package pat1101_1155;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// date: 3/14  score: 20 /20
// 8
//123 899 51 998 27 33 36 12
public class P1120 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Set<Integer> set = new TreeSet<>();
		int cnts = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < cnts; i++) {
			set.add(getFriend(scanner.nextInt()));
		}
		System.out.println(set.size());
		int k = 0;
		for (Integer id : set) {
			k++;
			System.out.print(id);
			if (k != set.size())
				System.out.print(" ");
		}
	}
	static int getFriend(int num) {
		int res = 0;
		do {
			res += num % 10;
			num = num / 10;
		} while (num != 0);
		return res;
	}
}
