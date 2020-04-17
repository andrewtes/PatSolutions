package pat01_35;
// 错了一半

import java.math.BigInteger;
import java.util.Scanner;

public class P1024 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String num = scanner.next();
		int k = scanner.nextInt();


		for (int cnt = 0; cnt < k; cnt++) {

			if (Isphi(num)) {

				System.out.println(num);
				System.out.print(cnt);
				return;
			}

			num = getOper(num);

		}

		System.out.println(num);
		System.out.print(k);

	}

	static String getOper(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		BigInteger num1 = new BigInteger(stringBuilder.append(s).toString());
		BigInteger num2 = new BigInteger(stringBuilder.reverse().toString());

		return num1.add(num2).toString();
	}


	static boolean Isphi(String s) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s);
		return s.equals(stringBuilder.reverse().toString());

	}

}
