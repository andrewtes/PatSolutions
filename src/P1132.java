package pat1101_1155;

import java.util.Scanner;

//date ; 3/13  score 20/20
// 3
//167334
//2333
//12345678
public class P1132 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < num; i++) {
			String number = scanner.nextLine().trim();
			if (IScut(number)) {
				System.out.print("Yes");
			} else
				System.out.print("No");
			if (i != num)
				System.out.println();
		}
	}

	static boolean IScut(String s) {
		int num = Integer.parseInt(s);
		int subnum1 = Integer.parseInt(s.substring(0, s.length() / 2));
		int subNum2 = Integer.parseInt(s.substring(s.length() / 2));
		if (subnum1 * subNum2 == 0)  // 对于除数为0 需要特殊考虑
			return false;

		if (num % (subnum1 * subNum2) == 0)
			return true;
		return false;
	}
}
