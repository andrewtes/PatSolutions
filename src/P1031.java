package pat01_35;

import java.util.Scanner;

// 时间： 2020年3月8日
// k 找的不对 ， 得分16 如果修改条件得分14
public class P1031 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();

		int k;
		int n2;

		for (k = 1; k <= s.length() / 3; k++) {

			n2 = s.length() + 2 - 2 * k;
			if (k > n2)
				break;
		}
		int n1 = k - 1;
		n2 = s.length() + 2 - 2 * k;

		for (int i = 0; i < n1; i++) {

			System.out.print(s.charAt(i));
			for( int p = 0 ; p< n2-2 ; p++)
				System.out.print(" ");
			System.out.print(s.charAt(s.length()-1-i) + "\n");
		}
		for (int j = n1; j < n1 + n2; j++) {

			System.out.print(s.charAt(j));
		}
	}
}
