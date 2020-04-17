package pat71_100;
// date:3/11  score 20/20
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1092 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String beads1 = scanner.nextLine().trim();
		String beads2 = scanner.nextLine().trim();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < beads2.length(); i++) {
			if (!map.containsKey(beads2.charAt(i)))
				map.put(beads2.charAt(i), 1);
			else {
				int cnts = map.get(beads2.charAt(i));
				cnts++;
				map.put(beads2.charAt(i), cnts);
			}
		}

		for (int j = 0; j < beads1.length(); j++) {
			if (map.containsKey(beads1.charAt(j))) {
				int cnts = map.get(beads1.charAt(j));
				cnts--;
				if (cnts == 0)
					map.remove(beads1.charAt(j));
				else
					map.put(beads1.charAt(j), cnts);

			}

		}

		if (map.size() == 0) {
			System.out.print("Yes" + " " + (beads1.length() - beads2.length()));
		} else {
			System.out.print("No ");

			int res = 0;
			for (Integer cnt : map.values())
				res += cnt;
			System.out.print(res);
		}
	}


}
