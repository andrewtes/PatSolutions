package pat71_100;

import java.util.Scanner;

public class P1100 {

	static String[] mars1 = {"tret", "jan", "feb", "mar", "apr", "may", "jun", "jly"
			, "aug", "sep", "oct", "nov", "dec"};
	static String[] mars2 = {"tret","tam", "hel", "maa", "huh",
			"tou", "kes", "hei", "elo", "syy", "lok", "mer", "jou"};


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nums = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < nums; i++) {

			String[] line = scanner.nextLine().split(" ");
			if (line[0].charAt(0) >= '0' && line[0].charAt(0) <= '9') { //地球数字

				String s = getRadix(line[0]) ;
				if (s.length() == 1)
					System.out.print(mars1[Integer.valueOf(s)]);
				else
					System.out.print(mars2[s.charAt(0) -'0'] + " " +
							mars1[s.charAt(1) - '0']);
				if (i != nums - 1)
					System.out.println();

			} else { // mars nums
				if (line.length == 1) {
					int k;
					for (k = 0; k < mars1.length; k++) {

						if (mars1[k].equals(line[0]))
							break;
					}

					System.out.print(k);
					if (i != nums - 1)
						System.out.println();
				} else {
					int index1 = 0;
					int index2 = 0;
					for (int j = 0; j < mars2.length; j++) {
						if (mars2[j].equals(line[0])) {
							index1 = j ;
							break;
						}
					}

					for (int k = 0; k < mars1.length; k++) {
						if (mars1[k].equals(line[1])) {
							index2 = k;
							break;
						}
					}

					System.out.print(index1 * 13 + index2);
					if (i != nums - 1)
						System.out.println();
				}
			}
		}
	}

	public static String getRadix(String nums) {
		int num = Integer.parseInt(nums);
		StringBuilder s = new StringBuilder();
		do {
			int temp = num % 13;
			s.append(temp);
			num = num / 13;
		} while (num != 0);

		return s.reverse().toString();
	}


}
